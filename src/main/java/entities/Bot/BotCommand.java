package entities.Bot;

import net.dv8tion.jda.api.hooks.EventListener;

public abstract class BotCommand {

    private String commandName;
    private String commandString;
    private String commandDescription;
    private BotAction action;

    public BotCommand(String commandName, String commandString, String commandDescription) {
        this.commandName = commandName;
        this.commandString = commandString;
        this.commandDescription = commandDescription;
    }

    public BotCommand(String commandName, String commandString, String commandDescription, BotAction action) {
        this.commandName = commandName;
        this.commandString = commandString;
        this.commandDescription = commandDescription;
        this.action = action;
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandString() {
        return commandString;
    }

    public void setCommandString(String commandString) {
        this.commandString = commandString;
    }

    public String getCommandDescription() {
        return commandDescription;
    }

    public void setCommandDescription(String commandDescription) {
        this.commandDescription = commandDescription;
    }

    public BotAction getAction() {
        return action;
    }
    public void setAction(BotAction action) {
        this.action = action;
    }
}
