package entities.Bot.telegram;

import entities.Bot.BotAction;
import entities.Bot.BotCommand;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

public interface TelegramAction extends IBotCommand {

    @Override
    String getCommandIdentifier();

    @Override
    String getDescription();

    @Override
    void processMessage(AbsSender absSender, Message message, String[] strings);
}