package entities.Bot.discord;

import entities.Bot.BotAbstract;
import entities.Bot.BotAction;
import enums.Platform;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.EventListener;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.List;

public class DiscordBot extends BotAbstract {

    private JDA jda;
    private List<DiscordCommand> commands = new ArrayList<>();

    public DiscordBot(String token, Platform platform) {
        super(token, platform);
    }

    @Override
    public boolean startBot() {
        if (!isAlive()) {
            buildBot();
        }
        return isAlive();
    }

    @Override
    public boolean stopBot() {
        if ( isAlive() ) {
            jda.shutdown();
            setAlive(false);
            getBotThread().stop();
        }
        return isAlive();
    }

    @Override
    public void buildBot() {
        Thread botThread = new Thread(() -> {
            try {
                jda = JDABuilder.createDefault(getToken()).build();
                if ( commands != null && commands.size() > 0 ) {
                    for ( DiscordCommand c : commands ) {
                        jda.addEventListener(c.getAction());
                    }
                }
                setAlive(true);
            } catch (LoginException e) {
                e.printStackTrace();
            }
        });
        botThread.setName("Discord " + getToken());
        setBotThread(botThread);
        getBotThread().start();
    }

    @Override
    public void addCommand(String commandName, String commandString, String commandDescription, BotAction a ) {
        super.addCommand(commandName, commandString, commandDescription,a);
        if ( !isAlive() ) {
            if (a.getAction() instanceof EventListener) {
                commands.add(new DiscordCommand(commandName, commandString, commandDescription, (EventListener) a.getAction()));
            }
        }
        if ( isAlive() ) {
            if (a.getAction() instanceof EventListener) {
                jda.addEventListener(a.getAction());
            }
        }
    }

    public JDA getJda() {
        return jda;
    }

    public void setJda(JDA jda) {
        this.jda = jda;
    }

}
