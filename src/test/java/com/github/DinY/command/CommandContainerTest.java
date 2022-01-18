package com.github.DinY.command;


import com.github.DinY.service.SendBotMessageService;
import com.github.DinY.service.TelegramUserService;
import com.github.DinY.service.TelegramUserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

@DisplayName("Unit-level testing for CommandContainer ")
public class CommandContainerTest {

    private CommandContainer commandContainer;

    @BeforeEach
    public void init(){
        SendBotMessageService sendBotMessageService = Mockito.mock(SendBotMessageService.class);
        TelegramUserService telegramUserService = Mockito.mock(TelegramUserService.class);
        commandContainer = new CommandContainer(sendBotMessageService, telegramUserService);
    }

    @Test
    public void shouldGetAllTheExistingCommands() {
        //when-then
        Arrays.stream(CommandName.values())
                .forEach(commandName -> {
                    Command command = commandContainer.retrieveCommand(commandName.getCommandName());
                    Assertions.assertNotEquals(UnknownCommand.class, command.getClass());
                });
    }

    @Test
    public void shouldGetUnknownCommand(){
        //given
        String wrongRequest = "/rqwer";

        //when
        Command wrongCommand = commandContainer.retrieveCommand(wrongRequest);

        //then
        Assertions.assertEquals(UnknownCommand.class,wrongCommand.getClass());
    }
}
