package entities.Bot;

import enums.Platform;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Simone Lambiase
 *
 * This class represent a bot astraction.
 * The fields are the same for the most parts of bots.
 +*/

public abstract class BotAbstract {

    private String token;
    private Platform platform;
    private boolean alive = false;
    private Thread botThread;

    public BotAbstract(String token, Platform platform) {
        this.token = token;
        this.platform = platform;
    }

    public boolean startBot() {
        // Overrided from the child classes
        return false;
    }

    public boolean stopBot() {
        // Overrided from the child classes
        return false;
    }

    public void buildBot() {
        // Overrided from the child classes
    }

    public void addCommand ( String commandName, String commandString, String commandDescription, BotAction a ) {
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

}