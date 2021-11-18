package kg.aika.demo.service;

import kg.aika.demo.bot.TelegramBot;
import kg.aika.demo.enums.MessageType;
import kg.aika.demo.model.MessageSend;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CrossBotUserService {

    //This way of using beans should be done only if you have some common logic service who should call different types of Telegram bot
    private final Map<MessageType, TelegramBot> telegramBotMap;

    public void sendMessageToChat(String chatId, MessageType messageType) {
        //some common logic here,
        telegramBotMap.get(messageType).sendMessage(new MessageSend(chatId, "Message from Hello bot"));
    }

    public void sendMessageToChat(String chatId) {
        telegramBotMap.get(MessageType.LAZY).sendMessage(new MessageSend(chatId, "this is LAAAZY message"));
    }
}
