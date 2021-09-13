package entities;

import net.dv8tion.jda.api.events.GenericEvent;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface Action {
    public void performAction ( GenericEvent e );
    public void performAction ( Update update );
}
