package entities.Bot.discord.commands;

import entities.Bot.BotAction;
import entities.Bot.discord.DiscordCommand;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import org.jetbrains.annotations.NotNull;

public class ReplyCommand extends DiscordCommand {
    public ReplyCommand(String commandName, String commandString, String commandDescription) {
        super(commandName, commandString, commandDescription);
    }

    public ReplyCommand(String commandName, String commandString, String commandDescription, String replyMessage) {
        super(commandName, commandString, commandDescription, new BotAction(genericEvent -> {

        }));
    }
}