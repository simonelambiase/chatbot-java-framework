package entities.Bot.telegram.wrapper;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table ( name = "telegram_users")
public class TelegramUserWrapper {

    @Id
    @Column ( name = "user_id")
    private Long userId;
    @Column ( name = "user_name", nullable = false )
    private String userName;
    @Column ( name = "first_name", nullable = true )
    private String firstName;
    @Column ( name = "last_name", nullable = true )
    private String lastName;
    @Column ( name = "is_bot", nullable = false )
    private boolean isBot;
    @Column ( name = "language_code", nullable = true )
    private String languageCode;
    @OneToMany
    List<TelegramMessageWrapper> messages;

    public TelegramUserWrapper() {}

    public TelegramUserWrapper(Long userId, String userName, String firstName, String lastName, boolean isBot, String languageCode) {
        this.userId = userId;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isBot = isBot;
        this.languageCode = languageCode;
        this.messages = new ArrayList<>();
    }

    public TelegramUserWrapper ( User user ) {
        this.userId = user.getId();
        this.userName = user.getUserName();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.isBot = user.getIsBot();
        this.languageCode = user.getLanguageCode();
        this.messages = new ArrayList<>();
    }

    public TelegramUserWrapper ( Update update ) {
        User user = update.getMessage().getFrom();
        this.userId = user.getId();
        this.userName = user.getUserName();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.isBot = user.getIsBot();
        this.languageCode = user.getLanguageCode();
        this.messages = new ArrayList<>();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isBot() {
        return isBot;
    }

    public void setBot(boolean bot) {
        isBot = bot;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public List<TelegramMessageWrapper> getMessages() {
        return messages;
    }

    public boolean addMessage( TelegramMessageWrapper m ) {
        return messages.add(m);
    }

}
