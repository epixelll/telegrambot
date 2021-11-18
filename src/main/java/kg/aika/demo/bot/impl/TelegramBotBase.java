package kg.aika.demo.bot.impl;

import kg.aika.demo.bot.TelegramBot;
import kg.aika.demo.exception.FailedSendMessageException;
import kg.aika.demo.model.InlineQuerySend;
import kg.aika.demo.model.MessageEdit;
import kg.aika.demo.model.MessageSend;
import kg.aika.demo.service.NotificationConfigService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.AnswerInlineQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
public abstract class TelegramBotBase extends TelegramLongPollingBot implements TelegramBot {

    @Autowired
    private NotificationConfigService notificationConfigService;

    @Override
    public String getBotUsername() {
        return this.notificationConfigService.getNotificationConfig(getMessageType()).getBotUsername();
    }

    @Override
    public String getBotToken() {
        return this.notificationConfigService.getNotificationConfig(getMessageType()).getToken();
    }

    @Override
    public void sendMessage(MessageSend message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());
        sendMessage.setText(message.getText());
        sendMessage.setParseMode("HTML");
        if (message.getKeyboard() != null) {
            sendMessage.setReplyMarkup(message.getKeyboard());
        }
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new FailedSendMessageException("Failed send text message " + message, e);
        }
    }

    @Override
    public void editMessageText(MessageEdit message) {
        EditMessageText editMessageText = new EditMessageText();
        if (message.getMessageId() != null) {
            editMessageText.setChatId(message.getChatId());
            editMessageText.setMessageId(message.getMessageId());
        } else {
            editMessageText.setInlineMessageId(message.getInlineMessageId());
        }
        editMessageText.setText(message.getText());
        editMessageText.setParseMode("HTML");
        if (message.getKeyboard() != null) {
            editMessageText.setReplyMarkup(message.getKeyboard());
        }
        try {
            execute(editMessageText);
        } catch (TelegramApiException e) {
            throw new FailedSendMessageException("Failed edit text message " + message, e);
        }
    }


    @Override
    public void sendAnswerCallbackQuery(String callbackId, String text) {
        AnswerCallbackQuery answerCallbackQuery = new AnswerCallbackQuery();
        answerCallbackQuery.setCallbackQueryId(callbackId);
        answerCallbackQuery.setText(text);
        answerCallbackQuery.setShowAlert(false);
        try {
            execute(answerCallbackQuery);
        } catch (TelegramApiException e) {
            throw new FailedSendMessageException("Failed send callback query " + callbackId, e);
        }
    }

    @Override
    public void sendInlineQuery(InlineQuerySend inlineQuery) {
        AnswerInlineQuery answerInlineQuery = new AnswerInlineQuery();
        answerInlineQuery.setInlineQueryId(inlineQuery.getInlineQueryId());
        answerInlineQuery.setResults(inlineQuery.getInlineQueryResults());
        answerInlineQuery.setCacheTime(1);
        if (inlineQuery.getOffset() != null) {
            answerInlineQuery.setNextOffset(Integer.toString(inlineQuery.getOffset()));
        }
        try {
            execute(answerInlineQuery);
        } catch (TelegramApiException e) {
            throw new FailedSendMessageException("Failed send inline query " + inlineQuery, e);
        }
    }

}
