package kg.aika.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class MessageSend {
    private final String chatId;
    private final String text;
    private ReplyKeyboard keyboard = null;
}
