package utils;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandUtils {

    public static boolean checkCommandStart ( String message, String command ) {
        if ( message.startsWith(command)) {
            return true;
        }
        return false;
    }

    public static boolean checkCommandStart (MessageReceivedEvent e, String command ) {
        if ( e.getMessage().getContentRaw().startsWith(command)) {
            return true;
        }
        return false;
    }

}
