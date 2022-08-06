package uli.nick.telegram;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

//    @Autowired
//    private static Bot bot;

    public static void main(String[] args) {
//        try {
//            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
//            telegramBotsApi.registerBot(bot);
//        } catch (TelegramApiException e) {
//            throw new RuntimeException(e);
//        }

        SpringApplication.run(Application.class, args);
    }
}
