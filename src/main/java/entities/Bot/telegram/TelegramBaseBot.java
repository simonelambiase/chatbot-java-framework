package entities.Bot.telegram;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TelegramBaseBot extends TelegramLongPollingCommandBot {

    private String token;

    public TelegramBaseBot( String token ) {
        this.token = token;
    }

    @Override
    public String getBotUsername() {
        return "";
    }

    @Override
    public void processNonCommandUpdate(Update update) {
    }

    @Override
    public String getBotToken() {
        return token;
    }
}
