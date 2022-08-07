package uli.nick.telegram.enumclass;

import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.function.Function;

public enum BotCom {
    UPDATEID(update -> {
        return update.getUpdateId().toString();
    }),
    MESSAGEID(update -> {
        return update.getMessage().getMessageId().toString();
    }),
    CHATID(update -> {
        return update.getMessage().getChatId().toString();
    }),
    TEST(update -> {
        return "Test callback";
    }),
    FULLINFO(update -> {
        StringBuilder output = new StringBuilder();
        output.append("UpdateID: ").append(update.getUpdateId());
        output.append("\nChatID: ").append(update.getMessage().getChatId());
        output.append("\nMessageID: ").append(update.getMessage().getMessageId());
        return output.toString();
    });

    private final Function<Update, String> function;

    BotCom(Function<Update, String> function) {
        this.function = function;
    }

    public String apply(Update update) {
        return function.apply(update);
    }
}
