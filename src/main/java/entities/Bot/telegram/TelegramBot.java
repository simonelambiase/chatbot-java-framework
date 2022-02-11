package entities.Bot.telegram;

import entities.Bot.BotAbstract;
import entities.Bot.BotCommand;
import enums.Platform;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import utils.LoggerUtils;

import java.util.ArrayList;
import java.util.List;

public class TelegramBot extends BotAbstract {

    private static final Logger log = LoggerUtils.createLogger(TelegramBot.class);
    private TelegramBotsApi telegramApi;
    private TelegramBaseBot baseBot = null;
    private List<BotCommand> commands = new ArrayList<>();

    public TelegramBot(String token,String username) {
        super(token,Platform.TELEGRAM,username);
        startBot();
    }

    @Override
    public boolean startBot() {
        if (baseBot == null) {
            this.baseBot = buildBot();
            log.info("Starting Telegram Bot...");
            setAlive(true);
        }
        return isAlive();

    }

    @Override
    public boolean stopBot() {
        return isAlive();
    }

    @Override
    public TelegramBaseBot buildBot() {
        TelegramBaseBot baseTelegramBot = null;
        TelegramBotsApi telegramApi = null;
        try {
            telegramApi = new TelegramBotsApi(DefaultBotSession.class);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        baseTelegramBot = new TelegramBaseBot(super.getToken(),super.getBotName());
            try {
                telegramApi.registerBot(baseTelegramBot);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
            if (commands.size() > 0) {
                for (BotCommand c : commands) {
                    log.info("Registering command with name " + c.getCommandName() + " and string " + c.getCommandString());
                    baseTelegramBot.register(c.getAction().getTelegramAction());
                }
            }
        return baseTelegramBot;
    }

    @Override
    public void addCommand(BotCommand command) {
        baseBot.register(command.getAction().getTelegramAction());
        log.info("Registering command with name " + command.getCommandName() + " and string /" + command.getCommandString());
    }

    @Override
    public String getToken() {
        return super.getToken();
    }

    @Override
    public void setToken(String token) {
        super.setToken(token);
    }

    @Override
    public Platform getPlatform() {
        return super.getPlatform();
    }

    @Override
    public void setPlatform(Platform platform) {
        super.setPlatform(platform);
    }

    @Override
    public boolean isAlive() {
        return super.isAlive();
    }

    @Override
    public void setAlive(boolean alive) {
        super.setAlive(alive);
    }

    @Override
    public Thread getBotThread() {
        return super.getBotThread();
    }

    @Override
    public void setBotThread(Thread botThread) {
        super.setBotThread(botThread);
    }

    @Override
    public String getBotName() {
        return baseBot.getBotUsername();
    }
}
