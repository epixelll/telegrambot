package kg.aika.demo.service;

import kg.aika.demo.bot.TelegramBot;
import kg.aika.demo.model.MessageSend;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;

@Service
public class RepeatBotUserService {

    private final TelegramBot repeatTelegramBot;

    public RepeatBotUserService(@Qualifier("repeatTelegramBot") TelegramBot repeatTelegramBot) {
        this.repeatTelegramBot = repeatTelegramBot;
    }

    public void process(String chatId, Message message) {
        sendStopMessage(chatId, message);
    }

    private void sendStopMessage(String chatId, Message telegramMessage) {
        String username = telegramMessage.getFrom().getUserName();
        String message = String.format("До встречи, @%s! \n\nБот остановлен.", username);
        repeatTelegramBot.sendMessage(new MessageSend(chatId, message));
    }
}
