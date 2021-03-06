package com.example.javabot.view;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class ChooseDrinkMenu {

    private static final String COFFEE_REQUEST = "coffee";
    private static final String TEA_REQUEST = "tea";
    private static final String COLA_REQUEST = "Cola";
    private static final String SPRITE_REQUEST = "Sprite";
    private static final String BACK_TO_PIZZA_ORDER_REQUEST = "Back to Pizza order";
    private static final String BACK_TO_START_MENU_REQUEST = "Back to start menu";

    public static ReplyKeyboardMarkup createChooseDrinksMenu() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(COFFEE_REQUEST);
        keyboardRow1.add(TEA_REQUEST);

        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add(COLA_REQUEST);
        keyboardRow2.add(SPRITE_REQUEST);

        KeyboardRow keyboardRow3 = new KeyboardRow();
        keyboardRow3.add(BACK_TO_PIZZA_ORDER_REQUEST);
        keyboardRow3.add(BACK_TO_START_MENU_REQUEST);

        keyboardRows.add(keyboardRow1);
        keyboardRows.add(keyboardRow2);
        keyboardRows.add(keyboardRow3);
        replyKeyboardMarkup.setKeyboard(keyboardRows);

        return replyKeyboardMarkup;
    }
}
