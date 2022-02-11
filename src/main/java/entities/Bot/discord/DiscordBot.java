package entities.Bot.discord;

import entities.Bot.BotAbstract;
import entities.Bot.BotAction;
import entities.Bot.BotCommand;
import enums.Platform;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.EventListener;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Simone Lambiase
 *
 * A concrete representation for the Bot Abstract class.
 * It's a JDA ( Java Discord API ) wrapper.
 *
 */

public class DiscordBot extends BotAbstract {

    private JDA jda;
    private List<BotCommand> commands = new ArrayList<>();
    private List<EventListener> listeners = new ArrayList<>();

    public DiscordBot(String token) {
        super(token, Platform.DISCORD);
        startBot();
    }

    @Override
    public boolean startBot() {
        if ( this.jda == null ) {
           this.jda = buildBot();
        }
        return isAlive();
    }

    @Override
    public boolean stopBot() {
        jda.shutdown();
        setAlive(false);
        return isAlive();
    }

    @Override
    public JDA buildBot() {
        JDA discordJDA = null;
        try {
            discordJDA = JDABuilder.createDefault(getToken()).build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
        if (commands != null && commands.size() > 0) {
               for ( BotCommand c : commands) {
                discordJDA.addEventListener(c.getAction().getDiscordAction());
            }
        }
        if ( listeners != null && listeners.size() > 0) {
            for ( EventListener e : listeners ) {
                discordJDA.addEventListener(e);
            }
        }
        setAlive(true);
        return discordJDA;
    }

    @Override
    public void addCommand( BotCommand command ) {
        commands.add(command);
        if ( this.jda != null ) {
            jda.addEventListener(command.getAction().getDiscordAction());
        }
    }

    @Override
    public void addAction( BotAction a) {
        listeners.add(a.getDiscordAction());
        if ( this.jda != null ) {
            jda.addEventListener(a);
        }
    }

    public JDA getJda() {
        return jda;
    }

    public void setJda(JDA jda) {
        this.jda = jda;
    }

    @Override
    public String getBotName() {
        return jda.getSelfUser().getName();
    }
}
