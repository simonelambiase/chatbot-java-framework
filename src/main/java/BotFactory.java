import entities.Bot.BotAbstract;
import entities.Bot.discord.DiscordBot;
import entities.Bot.telegram.TelegramBot;
import enums.Platform;

public class BotFactory {

    public static BotAbstract createBot (String token, Platform platform ) {
        BotAbstract bot = null;
        if ( token != null ) {
            switch ( platform ) {
                case DISCORD:
                    bot = new DiscordBot(token,platform);
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
