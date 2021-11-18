package kg.aika.demo.bot;

import kg.aika.demo.enums.MessageType;
import kg.aika.demo.model.InlineQuerySend;
import kg.aika.demo.model.MessageEdit;
import kg.aika.demo.model.MessageSend;

public interface TelegramBot {
    MessageType getMessageType();
    void sendMessage(MessageSend message);
    void editMessageText(MessageEdit message);
    void sendAnswerCallbackQuery(String callbackId, String text);
    void sendInlineQuery(InlineQuerySend inlineQuery);
}
