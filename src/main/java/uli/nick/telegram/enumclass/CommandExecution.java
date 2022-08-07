package uli.nick.telegram.enumclass;

import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.function.Function;

public enum CommandExecution {
    UPDATEID(update -> {
        return update.getUpdateId().toString();
    }),
    MESSAGEID(update -> {
        return update.getMessage().getMessageId().toString();
    });

    private final Function<Update, String> function;

    CommandExecution(Function<Update, String> function) {
        this.function = function;
    }

    public String apply(Update update) {
        return function.apply(update);
    }
}
