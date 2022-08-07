package uli.nick.telegram.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import uli.nick.telegram.enumclass.BotCom;
import uli.nick.telegram.enumclass.Send;

@Component
public class Bot extends TelegramLongPollingBot {

    @Value("${bot.name}")
    private String botUsername;

    @Value("${bot.token}")
    private String botToken;

    @Override
    public void onUpdateReceived(Update update) {
        Send send = new Send();
        String text = update.getMessage().getText().trim();
        System.out.println(update.getMessage().toString());
        if (text.codePointAt(0) == '/') {
            text = BotCom.valueOf(text.substring(1).toUpperCase()).apply(update);

            try {
                execute(SendMessage
                        .builder()
                        .chatId(update.getMessage().getChatId().toString())
                        .text(send.getText())
                        .entities(send.getMessageEntities())
                        .build()
                );
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
}
