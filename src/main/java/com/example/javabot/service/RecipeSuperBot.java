package com.example.javabot.service;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.util.logging.Logger;
import static com.example.javabot.utility.SelectorFunctional.getResponseMessage;

@Component
public class RecipeSuperBot extends TelegramLongPollingBot {

    private static final Logger LOGGER = Logger.getLogger(RecipeSuperBot.class.getName());

    @Override
    public String getBotUsername() {
        return "recipe_by_mkhodakov_bot";
    }

    @Override
    public String getBotToken() {
        return "1909387568:AAH6FDhvqJy8eoERRLqABM8kMWX3R2CNA0o";
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        String username = message.getFrom().getUserName();
        String firstName = message.getFrom().getFirstName();
        String lastName = message.getFrom().getLastName();
        Long ChatId = message.getFrom().getId();
        String loggerInfoAboutUserRequest = "Chat id: " + "[" + ChatId +"] " + "User: "+ firstName + " " + lastName +
                " (@" + username + ")" + " entered message: " + message.getText();
        LOGGER.info(loggerInfoAboutUserRequest);

        try {
            execute(getResponseMessage(message));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
