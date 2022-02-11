package entities.Bot;

import entities.Bot.discord.DiscordBot;
import entities.Bot.telegram.TelegramBot;
import enums.Platform;
import org.slf4j.Logger;
import utils.LoggerUtils;

public class BotFactory {

    private static final Logger log = LoggerUtils.createLogger(BotFactory.class);

    public static BotAbstract createDiscordBot (String token ) throws Exception {
        BotAbstract bot = null;
        if ( token != null ) {
            bot = new DiscordBot(token);
            log.info("Creating Discord Bot with token " + token + "...");
        } else {
            throw new Exception("Some data are missing");
        }
        return bot;
    }

    public static BotAbstract createTelegramBot (String token, String username ) throws Exception {
        BotAbstract bot = null;
        if ( token != null && username != null ) {
            bot = new TelegramBot(token, username);
            log.info("Creating Telegram Bot with token " + token + "...");
        } else {
            throw new Exception("Some data are missing");
        }
        return bot;
    }

}
