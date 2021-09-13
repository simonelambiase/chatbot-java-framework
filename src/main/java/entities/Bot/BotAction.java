package entities.Bot;

import net.dv8tion.jda.api.hooks.EventListener;
import org.telegram.telegrambots.meta.api.objects.Update;


public class BotAction {

    private EventListener listener;
    private Update update;

    public BotAction( EventListener listener ) {
        this.listener = listener;
    }
    public BotAction (Update update ) {
        this.update = update;
    }

    public Object getAction() {
        if ( listener != null ) {
            return listener;
        }
        if ( update != null ) {
            return update;
        }
        return null;
    }
}
