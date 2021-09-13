package entities.Bot.discord;


import net.dv8tion.jda.api.hooks.EventListener;

public class DiscordCommand {

    private String commandName;
    private String commandString;
    private String commandDescription;
    private EventListener action;

    public DiscordCommand(String commandName, String commandString, String commandDescription) {
        this.commandName = commandName;
        this.commandString = commandString;
        this.commandDescription = commandDescription;
    }

    public DiscordCommand(String commandName, String commandString, String commandDescription, EventListener action) {
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

    public EventListener getAction() {
        return action;
    }

    public void setAction(EventListener action) {
        this.action = action;
    }

}
