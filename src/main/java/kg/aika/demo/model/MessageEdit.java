package kg.aika.demo.model;

import lombok.Data;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

@Data
public class MessageEdit {
    private String chatId;
    private Integer messageId;
    private String inlineMessageId;
    private String text;
    private InlineKeyboardMarkup keyboard;
}
