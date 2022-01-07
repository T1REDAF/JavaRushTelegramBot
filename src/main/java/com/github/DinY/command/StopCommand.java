package com.github.DinY.command;

import com.github.DinY.bot.JavaRushTelegramBot;
import com.github.DinY.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StopCommand implements Command{

    private final SendBotMessageService sendBotMessageService;
    public final static String STOP_MESSAGE = "Деактивировал все ваши подписки  \uD83D\uDE1F.";

    public StopCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }


    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(),STOP_MESSAGE);
    }
}
