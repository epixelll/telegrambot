package kg.aika.demo.bot.impl;

import kg.aika.demo.enums.MessageType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
@Component
public class HelloTelegramBot extends TelegramBotBase {
    @Override
    public MessageType getMessageType() {
        return MessageType.HELLO;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();

            SendMessage message = SendMessage.builder()
                    .chatId(String.valueOf(chat_id))
                    .text("Hello " + message_text)
                    .build();
            try {
                execute(message);
            } catch (TelegramApiException e) {
                log.error("Error on sending repeat message to: {} bot", this.getMessageType(), e);
                e.printStackTrace();
            }
        }
    }
}
