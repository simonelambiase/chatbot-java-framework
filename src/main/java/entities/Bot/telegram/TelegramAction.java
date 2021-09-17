package entities.Bot.telegram;

import entities.Bot.BotCommand;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;

public abstract class TelegramAction implements IBotCommand {

    private BotCommand command;

    public TelegramAction( BotCommand command ) {
        this.command = command;
    }

    @Override
    public String getCommandIdentifier() {
        return command.getCommandName();
    }

    @Override
    public String getDescription() {
        return command.getCommandDescription();
    }
}
