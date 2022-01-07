package com.github.DinY.service;

/**
 * Send messages service for telegram bot
 */
public interface SendBotMessageService {

    void sendMessage(String chatId, String message);
}
