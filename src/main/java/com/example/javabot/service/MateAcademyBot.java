package com.example.javabot.service;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component
public class MateAcademyBot extends TelegramLongPollingBot {
    private static final Logger LOGGER = Logger.getLogger(MateAcademyBot.class.getName());

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
        String responseToUserForANonCommandRequest = "Hello user! I received your message: " + message.getText() +"; " +
                " However I don't understand such a command ;( Try again! or contact @Jovakinn " +
                "for a personal special service!";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(responseToUserForANonCommandRequest);
        sendMessage.setChatId(String.valueOf(message.getChatId()));

        if (message.getText().equals("/start")){
            String text = "Welcome to Recipe bot! Please choose the meal of the day!\n";

            sendMessage.enableMarkdown(true);
            ReplyKeyboardMarkup keyboardMarkup = getMenuKeyboard();
            sendMessage.setReplyMarkup(keyboardMarkup);
            sendMessage.setText(text);
        }

        if (message.getText().equals("breakfast")) {
            String menu = "Breakfast menu!\n";
            menu += "1. Blueberry-Banana-Nut Smoothie\n";
            menu += "2. Classic Omelet and Greens\n";
            menu += "3. Curry-Avocado Crispy Egg Toast\n";

            sendMessage.setText(menu);
        }
        if (message.getText().equals("dinner")) {
            String menu = "Dinner menu!\n";
            menu += "1. Creamy Lemon Chicken Pasta\n";
            menu += "2. Turkey Tacos\n";
            menu += "3. Vegetarian Lasagna\n";

            sendMessage.setText(menu);
        }

        if (message.getText().equals("lunch")) {
            String menu = "Lunch menu!\n";
            menu += "1. Borsch with onions\n";
            menu += "2. Fried potatoes\n";
            menu += "3. Nuka cola\n";

            sendMessage.setText(menu);
        }
        if (message.getText().equals("supper")) {
            String menu = "Supper menu!\n";
            menu += "1. Caesar salad\n";
            menu += "2. Milk shake\n";
            menu += "3. Fish and chips\n";

            sendMessage.setText(menu);
        }
        // TODO random choice of menu setup
        if (message.getText().equals("surprise me")) {

        }

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private ReplyKeyboardMarkup getMenuKeyboard() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add("breakfast");
        keyboardRow1.add("dinner");

        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add("lunch");
        keyboardRow2.add("supper");

        KeyboardRow keyboardRow3 = new KeyboardRow();
        keyboardRow3.add("surprise me");

        keyboardRows.add(keyboardRow1);
        keyboardRows.add(keyboardRow2);
        keyboardRows.add(keyboardRow3);
        replyKeyboardMarkup.setKeyboard(keyboardRows);

        return replyKeyboardMarkup;
    }
}