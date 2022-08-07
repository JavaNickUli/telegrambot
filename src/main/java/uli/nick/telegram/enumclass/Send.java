package uli.nick.telegram.enumclass;

import org.telegram.telegrambots.meta.api.objects.MessageEntity;

import java.util.List;

public class Send {
    private final String text = "I can help you create and manage Telegram bots. If you're new to the Bot API, please see the manual.\n" +
            "\n" +
            "You can control me by sending these commands:\n" +
            "\n" +
            "/newbot - create a new bot\n" +
            "/mybots - edit your bots [beta]";

    private final List<MessageEntity> messageEntities = List.of(
            new MessageEntity("text_link", 85, 14, "https://core.telegram.org/bots", null, null, "see the manual"),
            new MessageEntity("bot_command", 149, 7, null, null, null, "/newbot"),
            new MessageEntity("bot_command", 176, 7, null, null, null, "/mybots")
            );

    public String getText() {
        return text;
    }

    public List<MessageEntity> getMessageEntities() {
        return messageEntities;
    }
}
