package entities.Bot.discord;


import entities.Bot.BotAction;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.hooks.EventListener;

    public interface DiscordAction extends EventListener {

    @Override
    void onEvent( GenericEvent genericEvent);
}
