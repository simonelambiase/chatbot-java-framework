package entities;

import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface Action extends EventListener {
    public void performAction ( GenericEvent e );
    public void performAction ( Update update );
}
