package com.example.javabot.models;

import com.example.javabot.emoji.Emoji;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private static final String CARBONARA_36_AS_USUAL_REQUEST = "Carbonara 36 as usual";
    private static final String MARGARITA_REQUEST = "Margarita";
    private static final String PAPERONNI_REQUEST = "Paperonni";
    private static final String DRINKS_REQUEST = "Drinks";

    private static ReplyKeyboardMarkup createChoosePizzaMenu() {
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

    public static SendMessage getOrderPizzaResponse(Message message) {
        SendMessage response = new SendMessage();
        String textResponse = "PLease make your completely independent choice :)";
        response.setText(textResponse + Emoji.FACE_SAVOURING_DELICIOUS_FOOD);
        response.setReplyMarkup(createChoosePizzaMenu());
        response.setChatId(String.valueOf(message.getChatId()));

        return response;
    }

}
