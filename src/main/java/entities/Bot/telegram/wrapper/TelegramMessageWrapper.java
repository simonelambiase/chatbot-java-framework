package entities.Bot.telegram.wrapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.telegram.telegrambots.meta.api.objects.Message;

import javax.persistence.*;

@Entity
@Table ( name = "telegram_messages")
public class TelegramMessageWrapper {

    @Id
    @Column ( name = "message_id")
    private Integer messageId;
    @Column ( name = "content")
    private String content;
    @Column ( name = "timestamp")
    private Long timestamp;
    @JsonIgnore
    @ManyToOne
    private TelegramUserWrapper user;

    public TelegramMessageWrapper() {}

    public TelegramMessageWrapper( String content, Long timestamp, Integer messageId ) {
        this.content = content;
        this.timestamp = timestamp;
        this.messageId = messageId;
    }

    public TelegramMessageWrapper( Message message ) {
        this.content = message.getText();
        this.timestamp = message.getDate().longValue();
        this.messageId = message.getMessageId();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public TelegramUserWrapper getUser() {
        return user;
    }

    public void setUser(TelegramUserWrapper user) {
        this.user = user;
    }
}
