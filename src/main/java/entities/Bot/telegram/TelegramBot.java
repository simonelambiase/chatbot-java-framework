package entities.Bot.telegram;

import entities.Bot.BotAbstract;
import entities.Bot.BotCommand;
import enums.Platform;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class TelegramBot extends BotAbstract {

    private TelegramBotsApi telegramApi;
    private TelegramBaseBot baseBot = null;
    private List<BotCommand> commands = new ArrayList<>();

    public TelegramBot(String token, Platform platform) {
        super(token, platform);

    }

    @Override
    public boolean startBot() {
        if (baseBot == null) {
            this.baseBot = buildBot();
        }
        setAlive(true);
        return isAlive();
    }

    @Override
    public boolean stopBot() {
        return isAlive();
    }

    @Override
    public TelegramBaseBot buildBot() {
            TelegramBaseBot baseTelegramBot = null;
            ApiContextInitializer.init();
            telegramApi = new TelegramBotsApi();
            baseTelegramBot = new TelegramBaseBot(getToken());
            try {
                telegramApi.registerBot(baseTelegramBot);
            } catch (TelegramApiRequestException e) {
                e.printStackTrace();
            }
            if (commands.size() > 0) {
                for (BotCommand c : commands) {
                    baseTelegramBot.register(c.getAction().getTelegramAction());
                }
            }
        return baseTelegramBot;
    }

    @Override
    public void addCommand(BotCommand command) {
       commands.add(command);
       if ( baseBot != null ) {
           baseBot.register(command.getAction().getTelegramAction());
       }
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

}
