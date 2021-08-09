package com.example.javabot.service;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.logging.Logger;

import static com.example.javabot.models.Pizza.getOrderPizzaResponse;
import static com.example.javabot.models.TimeAndDateUtility.getCurrentDateResponse;
import static com.example.javabot.models.TimeAndDateUtility.getCurrentTimeResponse;
import static com.example.javabot.models.meals.Breakfast.getBreakfastResponse;
import static com.example.javabot.models.meals.Dinner.getDinnerResponse;
import static com.example.javabot.models.meals.Lunch.getLunchResponse;
import static com.example.javabot.models.meals.Supper.getSupperResponse;
import static com.example.javabot.models.meals.Surprise.getSurpriseResponse;
import static com.example.javabot.view.MainMenuKeyboard.getMainMenu;

@Component
public class RecipeSuperBot extends TelegramLongPollingBot {

    private static final Logger LOGGER = Logger.getLogger(RecipeSuperBot.class.getName());
    private static final String START_REQUEST = "/start";
    private static final String TIME_REQUEST = "Time";
    private static final String DATE_REQUEST = "Date";
    private static final String CAPITAL_REQUEST = "Capital?";
    private static final String ORDER_PIZZA_REQUEST = "Order pizza";
    private static final String BREAKFAST_REQUEST = "breakfast";
    private static final String DINNER_REQUEST = "dinner";
    private static final String LUNCH_REQUEST = "lunch";
    private static final String SUPPER_REQUEST = "supper";
    private static final String SURPRISE_REQUEST = "surprise";

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

    private SendMessage getResponseMessage(Message message) {
        switch (message.getText()) {
            case START_REQUEST:
                return getStartFunctionalResponse(message);
            case BREAKFAST_REQUEST:
                return getBreakfastResponse(message);
            case DINNER_REQUEST:
                return getDinnerResponse(message);
            case LUNCH_REQUEST:
                return getLunchResponse(message);
            case SUPPER_REQUEST:
                return getSupperResponse(message);
            case SURPRISE_REQUEST:
                return getSurpriseResponse(message);
            case TIME_REQUEST:
                return getCurrentTimeResponse(message);
            case DATE_REQUEST:
                return getCurrentDateResponse(message);
            case ORDER_PIZZA_REQUEST:
                return getOrderPizzaResponse(message);
            default:
                return doStandardResponseForNoRequest(message);
        }
    }

    private SendMessage doStandardResponseForNoRequest(Message message) {
        String firstName = message.getFrom().getFirstName();
        String lastName = message.getFrom().getLastName();
        Long chatId = message.getChatId();

        String responseToUserForANonCommandRequest = "Hello "+ firstName + " " + lastName+ "! I received your message: "
                + message.getText() +"; " + " However I don't understand such a command" +
                " ;( Try again! Or contact @Jovakinn " +
                "for a personal special service!";
        SendMessage response = new SendMessage();
        response.setText(responseToUserForANonCommandRequest);
        response.setChatId(String.valueOf(chatId));
        response.setReplyMarkup(getMainMenu());

        return response;
    }

    // /start functionality
    private SendMessage getStartFunctionalResponse(Message message) {
        SendMessage response = new SendMessage();
        String text = "Welcome to Recipe bot! Please choose the functional of the day!\n";
        response.enableMarkdown(true);
        response.setReplyMarkup(getMainMenu());
        response.setText(text);
        response.setChatId(String.valueOf(message.getChatId()));

        return response;
    }
}
