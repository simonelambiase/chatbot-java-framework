import entities.Bot.BotAbstract;
import entities.Bot.BotAction;
import entities.Bot.telegram.TelegramAction;
import entities.Bot.telegram.TelegramCommand;
import enums.Platform;
import org.slf4j.Logger;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;
import utils.LoggerUtils;

public class Runner {

    private static final Logger log = LoggerUtils.createLogger(Runner.class);

    public static void main(String[] args) {
    }
}
