package com.github.DinY.command;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface Command {

    void execute(Update update);
}
