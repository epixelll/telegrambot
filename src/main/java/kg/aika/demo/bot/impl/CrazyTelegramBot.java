package kg.aika.demo.bot.impl;

import kg.aika.demo.enums.MessageType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
@Component
public class CrazyTelegramBot extends TelegramBotBase {
    @Override
    public MessageType getMessageType() {
        return MessageType.CRAZY;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            long chat_id = update.getMessage().getChatId();

            SendMessage message = SendMessage.builder()
                    .chatId(String.valueOf(chat_id))
                    .text("You are an Idiot")
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
