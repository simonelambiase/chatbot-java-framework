package entities.Bot.telegram;

import entities.Bot.BotAbstract;
import enums.Platform;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;

public class TelegramBot extends BotAbstract {

    private TelegramBotsApi telegramApi;

    public TelegramBot(String token, Platform platform) {
        super(token, platform);
    }

    @Override
    public boolean startBot() {
        return false;
    }

    @Override
    public void buildBot() {
        ApiContextInitializer.init();
        telegramApi = new TelegramBotsApi();
    }
}
