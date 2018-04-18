package BorisShindlerBot.BorisShindlerBot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;


public class App {
    public static void main(String[] args) {
        UserSet userSet = new UserSet();
        // create connection
        userSet.setConnection(args[1]);
        // copy from database to Set<>
        userSet.copyFromDataBase();

        ApiContextInitializer.init();

        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
            botsApi.registerBot(new MyBot(args[0], userSet, args[2]));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
