import entities.Bot.BotAbstract;
import entities.Bot.discord.DiscordBot;
import entities.Bot.telegram.TelegramBot;
import enums.Platform;
import org.slf4j.Logger;
import utils.LoggerUtils;

public class BotFactory {

    private static final Logger log = LoggerUtils.createLogger(BotFactory.class);

    public static BotAbstract createBot (String token, Platform platform ) {
        BotAbstract bot = null;
        if ( token != null ) {
            switch ( platform ) {
                case DISCORD:
                    bot = new DiscordBot(token,platform);
                    log.trace("Creating Discord Bot with token " + token + "...");
                    break;
                case TELEGRAM:
                    bot = new TelegramBot(token,platform);
                    break;
                default:
                    break;
            }
        }
        return bot;
    }

}
