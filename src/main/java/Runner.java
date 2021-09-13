import entities.Bot.BotAbstract;
import entities.Bot.BotAction;
import entities.Bot.discord.DiscordAction;
import enums.Platform;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import utils.LoggerUtils;

public class Runner {

    private static final Logger log = LoggerUtils.createLogger(Runner.class);

    public static void main(String[] args) {
        BotAbstract bot = BotFactory.createBot("ODUyMTEyMjMyNTUyMDcxMTg4.YMCFWw.DUbxLONuNaNCGq5iluXlLeFz8T4",Platform.DISCORD);
        bot.startBot();
    }
}
