package entities.Bot.discord;


import entities.Bot.BotAction;
import entities.Bot.BotCommand;
import net.dv8tion.jda.api.hooks.EventListener;

public class DiscordCommand extends BotCommand {

    private String commandName;
    private String commandString;
    private String commandDescription;
    private BotAction botAction;
    private EventListener action;

    public DiscordCommand(String commandName, String commandString, String commandDescription) {
        super(commandName, commandString, commandDescription);
    }

    public DiscordCommand(String commandName, String commandString, String commandDescription, BotAction action) {
        super(commandName, commandString, commandDescription, action);
        this.action = (EventListener) botAction.getAction();
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
        return new BotAction(action);
    }

    public void setAction(EventListener action) {
        this.action = action;
    }

}
