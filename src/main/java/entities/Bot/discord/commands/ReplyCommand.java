package entities.Bot.discord.commands;

import entities.Bot.BotAction;
import entities.Bot.BotCommand;
import entities.Bot.discord.DiscordCommand;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import org.jetbrains.annotations.NotNull;
import utils.CommandUtils;

public class ReplyCommand extends DiscordCommand {

    private String replyMessage;

    public ReplyCommand(String commandName, String commandString, String commandDescription) {
        super(commandName, commandString, commandDescription);
    }

    public ReplyCommand(String commandName, String commandString, String commandDescription, BotAction action, String replyMessage) {
        super(commandName, commandString, commandDescription, new BotAction(genericEvent -> {
            if ( genericEvent instanceof MessageReceivedEvent) {
                if (CommandUtils.checkCommandStart((MessageReceivedEvent) genericEvent,commandString)) {
                    ((MessageReceivedEvent) genericEvent).getMessage().getChannel().sendMessage(replyMessage);
                }
            }
        }));
    }

}

