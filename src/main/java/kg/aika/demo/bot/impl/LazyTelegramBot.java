package kg.aika.demo.bot.impl;

import kg.aika.demo.enums.MessageType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
@Component
public class LazyTelegramBot extends TelegramBotBase {
    @Override
    public MessageType getMessageType() {
        return MessageType.LAZY;
    }

    @Override
    public void onUpdateReceived(Update update) {
    }
}
