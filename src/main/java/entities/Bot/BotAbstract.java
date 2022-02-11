package entities.Bot;

import enums.Platform;

/**
 * @author Simone Lambiase
 *
 * This class represent a bot astraction.
 * The fields are the same for the most parts of bots.
 +*/

public abstract class BotAbstract {

    private String token;
    private Platform platform;
    private String username;
    private boolean alive = false;
    private Thread botThread;

    public BotAbstract(String token, Platform platform) {
        this.token = token;
        this.platform = platform;
    }

    public BotAbstract(String token, Platform platform, String username) {
        this.token = token;
        this.platform = platform;
        this.username = username;
    }

    public boolean startBot() {
        // Overrided from the child classes
        return false;
    }

    public boolean stopBot() {
        // Overrided from the child classes
        return false;
    }

    public Object buildBot() {
        // Overrided from the child classes
        return null;
    }

    public void addCommand ( BotCommand command ) {
        //
    }

    public void addAction ( BotAction a ) {
        //
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Thread getBotThread() {
        return botThread;
    }

    public void setBotThread(Thread botThread) {
        this.botThread = botThread;
    }

    public String getBotName() {
        return this.username;
    }


}
