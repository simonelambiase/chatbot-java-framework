package entities.Bot.telegram;

import entities.Bot.BotAction;
import entities.Bot.BotCommand;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class TelegramCommand extends BotCommand {

    private BotAction action;

    public TelegramCommand() {

    }


    public TelegramCommand(String commandName, String commandString, String commandDescription ) {
        super(commandName, commandString, commandDescription );
    }

    @Override
    public String getCommandName() {
        return super.getCommandName();
    }

    @Override
    public void setCommandName(String commandName) {
        super.setCommandName(commandName);
    }

    @Override
    public String getCommandString() {
        return super.getCommandString();
    }

    @Override
    public void setCommandString(String commandString) {
        super.setCommandString(commandString);
    }

    @Override
    public String getCommandDescription() {
        return super.getCommandDescription();
    }

    @Override
    public void setCommandDescription(String commandDescription) {
        super.setCommandDescription(commandDescription);
    }

    @Override
    public BotAction getAction() {
        return super.getAction();
    }

    @Override
    public void setAction(BotAction action) {
        this.action = action;
        super.setAction(action);
    }

    public void setAction(TelegramAction action) {
        this.action = new BotAction(action);
        super.setAction(new BotAction(action));
    }
}
