package uli.nick.telegram.enumclass;

import org.telegram.telegrambots.meta.api.objects.Update;

import java.time.Instant;
import java.util.Date;
import java.util.function.Function;

public enum BotCom {
    COM(update -> {
        return "UpdateId\nMessageId\nChatId\nIdInfo\nMessageInfo\nUserInfo";
    }),
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
    IDINFO(update -> {
        StringBuilder output = new StringBuilder("ID:");
        output.append("\nUpdateID: ").append(update.getUpdateId());
        output.append("\nChatID: ").append(update.getMessage().getChatId());
        output.append("\nMessageID: ").append(update.getMessage().getMessageId());

        return output.toString();
    }),
    MESSAGEINFO(update -> {
        StringBuilder output = new StringBuilder("Message:");
        output.append("\nChatID: ").append(update.getMessage().getChatId());
        output.append("\nMessageID: ").append(update.getMessage().getMessageId());
        output.append("\nText: ").append(update.getMessage().getText());
        output.append("\nCaption: ").append(update.getMessage().getCaption());
        output.append("\nMediaGroupID: ").append(update.getMessage().getMediaGroupId());
        output.append("\nDate: ").append(Date.from(Instant.ofEpochSecond(update.getMessage().getDate())));
        return output.toString();
    }),
    USERINFO(update -> {
        StringBuilder output = new StringBuilder("User:");
        output.append("\nUserID: ").append(update.getMessage().getFrom().getId());
        output.append("\nFirstName: ").append(update.getMessage().getFrom().getFirstName());
        output.append("\nLastName: ").append(update.getMessage().getFrom().getLastName());
        output.append("\nUserName: ").append(update.getMessage().getFrom().getUserName());
        output.append("\nLanguageCode: ").append(update.getMessage().getFrom().getLanguageCode());
        output.append("\nIsPremium: ").append(update.getMessage().getFrom().getIsPremium());
        output.append("\nIsBot: ").append(update.getMessage().getFrom().getIsBot());
        output.append("\nCanJoinGroup: ").append(update.getMessage().getFrom().getCanJoinGroups());
        output.append("\nCanReadAllGroupMessages: ").append(update.getMessage().getFrom().getCanReadAllGroupMessages());
        output.append("\nAddedToAttachmentMenu: ").append(update.getMessage().getFrom().getAddedToAttachmentMenu());
        output.append("\nSupportInlineQueries: ").append(update.getMessage().getFrom().getSupportInlineQueries());
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
