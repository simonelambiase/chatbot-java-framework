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

public class DiscordBot extends BotAbstract {

    private JDA jda;
    private List<BotCommand> commands = new ArrayList<>();

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
        if (isAlive()) {
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
                if (commands != null && commands.size() > 0) {
                    for ( BotCommand c : commands) {
                        jda.addEventListener(c.getAction().getDiscordAction());
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
    public void addCommand( BotCommand command ) {
        commands.add(command);
        jda.addEventListener(command.getAction().getDiscordAction());
    }

    public JDA getJda() {
        return jda;
    }

    public void setJda(JDA jda) {
        this.jda = jda;
    }

}
