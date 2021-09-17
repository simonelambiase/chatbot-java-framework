package entities;

import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.bots.AbsSender;


/**
 *
 * @author Simone Lambiase
 * An interface for implement various actions for various platforms.
 */
public interface Action extends EventListener, IBotCommand {
    @Override
    void onEvent(@NotNull GenericEvent genericEvent);

    @Override
    String getCommandIdentifier();

    @Override
    String getDescription();

    @Override
    void processMessage(AbsSender absSender, Message message, String[] strings);
}
