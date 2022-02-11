package entities.Bot.telegram;

import data.DataManager;
import data.sqlite.DataManagerSQLite;
import entities.Bot.telegram.wrapper.TelegramMessageWrapper;
import entities.Bot.telegram.wrapper.TelegramUserWrapper;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.CommandRegistry;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.ICommandRegistry;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Collection;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class TelegramBaseBot extends TelegramLongPollingBot implements ICommandRegistry {

    private String token;
    private String username;
    private final CommandRegistry commandRegistry;
    private DataManager sql = new DataManagerSQLite();

    public TelegramBaseBot(String token,String username) {
        super(new DefaultBotOptions());
        Supplier<String> name = () -> username;
        this.token = token;
        this.username = username;
        this.commandRegistry = new CommandRegistry(true,name);
    }


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            TelegramUserWrapper user = new TelegramUserWrapper(update);
            TelegramMessageWrapper msg = new TelegramMessageWrapper(update.getMessage());
            user.addMessage(msg);
            sql.save(user);
            Message message = update.getMessage();
            if (message.isCommand()) {
                if (!commandRegistry.executeCommand(this, message)) {
                    processInvalidCommandUpdate(update);
                }
                return;
            }
        }
        processNonCommandUpdate(update);
    }

    @Override
    public String getBotUsername() {
        return this.username;
    }

    @Override
    public String getBotToken() {
        return this.token;
    }

    @Override
    public void registerDefaultAction(BiConsumer<AbsSender, Message> biConsumer) {

    }

    @Override
    public boolean register(IBotCommand iBotCommand) {
        return commandRegistry.register(iBotCommand);
    }

    @Override
    public Map<IBotCommand, Boolean> registerAll(IBotCommand... iBotCommands) {
        return commandRegistry.registerAll(iBotCommands);
    }

    @Override
    public boolean deregister(IBotCommand iBotCommand) {
        return commandRegistry.deregister(iBotCommand);
    }

    @Override
    public Map<IBotCommand, Boolean> deregisterAll(IBotCommand... iBotCommands) {
        return commandRegistry.deregisterAll(iBotCommands);
    }

    @Override
    public Collection<IBotCommand> getRegisteredCommands() {
        return commandRegistry.getRegisteredCommands();
    }

    @Override
    public IBotCommand getRegisteredCommand(String s) {
        return commandRegistry.getRegisteredCommand(s);
    }

    protected void processInvalidCommandUpdate(Update update) {
        SendMessage msg = new SendMessage();
        msg.setText("The command is not valid");
        msg.setChatId(String.valueOf(update.getMessage().getChatId()));
        try {
            execute(msg);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    protected void processNonCommandUpdate(Update update){
        // do nothing
    }

}