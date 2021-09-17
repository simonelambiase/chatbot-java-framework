package entities.Bot;

import entities.Bot.discord.DiscordAction;
import entities.Bot.telegram.TelegramAction;
import net.dv8tion.jda.api.hooks.EventListener;
import org.telegram.telegrambots.meta.api.objects.Update;


public class BotAction {

    private DiscordAction dAction;
    private TelegramAction tAction;

    public BotAction( DiscordAction listener ) {
        this.dAction = listener;
    }
    public BotAction ( TelegramAction action ) {
        this.tAction = action;
    }

    public Object getAction() {
           if ( dAction != null ) {
            return dAction;
        }
        if ( tAction != null ) {
            return tAction;
        }
        return null;
    }

    public EventListener getDiscordAction() {
        return dAction;
    }

    public TelegramAction getTelegramAction() {
        return tAction;
    }
}
