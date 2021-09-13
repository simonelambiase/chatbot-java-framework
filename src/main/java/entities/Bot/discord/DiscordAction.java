package entities.Bot.discord;


import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import org.jetbrains.annotations.NotNull;

public interface DiscordAction extends EventListener {

    @Override
    void onEvent(@NotNull GenericEvent genericEvent);
}
