package com.example.javabot.service;

import com.example.javabot.emoji.Emoji;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

@Component
public class RecipeSuperBot extends TelegramLongPollingBot {

    private static final Logger LOGGER = Logger.getLogger(RecipeSuperBot.class.getName());
    private static final String START_REQUEST = "/start";
    private static final String TIME_REQUEST = "Time";
    private static final String DATE_REQUEST = "Date";
    private static final String CAPITAL_REQUEST = "Capital?";
    private static final String ORDER_PIZZA_REQUEST = "Order pizza";
    private static final String CARBONARA_36_AS_USUAL_REQUEST = "Carbonara 36 as usual";
    private static final String MARGARITA_REQUEST = "Margarita";
    private static final String PAPERONNI_REQUEST = "Paperonni";
    private static final String DRINKS_REQUEST = "Drinks";
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

    // design of keyboard
    private ReplyKeyboardMarkup getMainMenu() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(BREAKFAST_REQUEST);
        keyboardRow1.add(DINNER_REQUEST);

        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add(LUNCH_REQUEST);
        keyboardRow2.add(SUPPER_REQUEST);

        KeyboardRow keyboardRow3 = new KeyboardRow();
        keyboardRow3.add(SURPRISE_REQUEST);

        KeyboardRow keyboardRow4 = new KeyboardRow();
        keyboardRow2.add(TIME_REQUEST);
        keyboardRow2.add(DATE_REQUEST);

        KeyboardRow keyboardRow5 = new KeyboardRow();
        keyboardRow2.add(CAPITAL_REQUEST);
        keyboardRow2.add(ORDER_PIZZA_REQUEST);

        keyboardRows.add(keyboardRow1);
        keyboardRows.add(keyboardRow2);
        keyboardRows.add(keyboardRow3);
        keyboardRows.add(keyboardRow4);
        keyboardRows.add(keyboardRow5);
        replyKeyboardMarkup.setKeyboard(keyboardRows);

        return replyKeyboardMarkup;
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
                return  getCurrentTimeResponse(message);
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

    // surprise functionality
    private SendMessage getSurpriseResponse(Message message) {
        List<String> optionsOfMenu = Arrays.asList("breakfast", "dinner", "lunch", "supper");
        Random random = new Random();

        int randomIndex = random.nextInt(optionsOfMenu.size());
        message.setText(optionsOfMenu.get(randomIndex));

        SendMessage response = new SendMessage();
        response.setChatId(String.valueOf(message.getChatId()));
        switch(message.getText()){
            case "breakfast":
                return getBreakfastResponse(message);
            case "dinner":
                return getDinnerResponse(message);
            case "lunch":
                return getLunchResponse(message);
            case "supper":
                return getSupperResponse(message);
        }
        return response;
    }

    // breakfast response
    private SendMessage getBreakfastResponse(Message message) {
        SendMessage response = new SendMessage();
        String breakfastMenu = "Breakfast menu!\n";
        breakfastMenu += "1. Blueberry-Banana-Nut Smoothie\n";
        breakfastMenu += "2. Classic Omelet and Greens\n";
        breakfastMenu += "3. Curry-Avocado Crispy Egg Toast\n";

        response.setChatId(String.valueOf(message.getChatId()));
        response.setText(breakfastMenu);

        return response;
    }

    // dinner response
    private SendMessage getDinnerResponse(Message message){
        SendMessage response = new SendMessage();
        String dinnerMenu = "Dinner menu!\n";
        dinnerMenu += "1. Creamy Lemon Chicken Pasta\n";
        dinnerMenu += "2. Turkey Tacos\n";
        dinnerMenu += "3. Vegetarian Lasagna\n";

        response.setChatId(String.valueOf(message.getChatId()));
        response.setText(dinnerMenu);

        return response;
    }

    // lunch response
    private SendMessage getLunchResponse(Message message) {
        SendMessage response = new SendMessage();
        String lunchMenu = "Lunch menu!\n";
        lunchMenu += "1. Borsch with onions\n";
        lunchMenu += "2. Fried potatoes\n";
        lunchMenu += "3. Nuka cola\n";

        response.setChatId(String.valueOf(message.getChatId()));
        response.setText(lunchMenu);

        return response;
    }

    // supper response
    private SendMessage getSupperResponse(Message message) {
        SendMessage response = new SendMessage();
        String supperMenu = "Supper menu!\n";
        supperMenu += "1. Caesar salad\n";
        supperMenu += "2. Milk shake\n";
        supperMenu += "3. Fish and chips\n";

        response.setChatId(String.valueOf(message.getChatId()));
        response.setText(supperMenu);

        return response;
    }

    // get time
    private SendMessage getCurrentTimeResponse(Message message) {
        SendMessage response = new SendMessage();
        response.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH::mm::ss")));
        response.setChatId(String.valueOf(message.getChatId()));
        response.setReplyMarkup(getMainMenu());

        return response;
    }

    // get date
    private SendMessage getCurrentDateResponse(Message message) {
        SendMessage response = new SendMessage();
        response.setChatId(String.valueOf(message.getChatId()));
        response.setReplyMarkup(getMainMenu());
        response.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));

        return response;
    }
    // pizza
    private ReplyKeyboardMarkup createChoosePizzaMenu() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(CARBONARA_36_AS_USUAL_REQUEST);
        keyboardRow1.add(MARGARITA_REQUEST);

        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add(PAPERONNI_REQUEST);
        keyboardRow2.add(DRINKS_REQUEST);

        keyboardRows.add(keyboardRow1);
        keyboardRows.add(keyboardRow2);
        replyKeyboardMarkup.setKeyboard(keyboardRows);

        return replyKeyboardMarkup;
    }

    private SendMessage getOrderPizzaResponse(Message message) {
        SendMessage response = new SendMessage();
        String textResponse = "PLease make your completely independent choice :)";
        response.setText(textResponse + Emoji.GRINNING_FACE_WITH_SMILING_EYES);
        response.setReplyMarkup(createChoosePizzaMenu());
        response.setChatId(String.valueOf(message.getChatId()));

        return response;
    }
}
