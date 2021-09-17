package entities.Bot.discord;


import entities.Bot.BotAction;
import entities.Bot.BotCommand;

public class DiscordCommand extends BotCommand {

    private String commandName;
    private String commandString;
    private String commandDescription;
    private BotAction botAction;

    public DiscordCommand() {
        //
    }


    public DiscordCommand(String commandName, String commandString, String commandDescription) {
        super(commandName, commandString, commandDescription);
    }

    @Override
    public String getCommandName() {
        return commandName;
    }

    @Override
    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    @Override
    public String getCommandString() {
        return commandString;
    }

    @Override
    public void setCommandString(String commandString) {
        this.commandString = commandString;
    }

    @Override
    public String getCommandDescription() {
        return commandDescription;
    }

    @Override
    public void setCommandDescription(String commandDescription) {
        this.commandDescription = commandDescription;
    }

    public BotAction getBotAction() {
        return botAction;
    }

    public void setBotAction(BotAction botAction) {
        this.botAction = botAction;
    }
}
