package com.github.DinY.service;

import com.github.DinY.bot.JavaRushTelegramBot;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * Implementation of {@link SendBotMessageService} interface.
 */
@Service
public class SendBotMessageServiceImpl implements SendBotMessageService{

    private final JavaRushTelegramBot javarushBot;

    @Autowired
    public SendBotMessageServiceImpl(JavaRushTelegramBot javarushBot){
        this.javarushBot = javarushBot;
    }

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sm = new SendMessage();
        sm.setChatId(chatId);
        sm.enableHtml(true);
        sm.setText(message);

        try {
            javarushBot.execute(sm);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}
