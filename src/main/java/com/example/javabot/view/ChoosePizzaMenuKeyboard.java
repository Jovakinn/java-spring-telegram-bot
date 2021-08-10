package com.example.javabot.view;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class ChoosePizzaMenuKeyboard {
    private static final String CARBONARA_36_AS_USUAL_REQUEST = "Carbonara 36 as usual";
    private static final String MARGARITA_REQUEST = "Margarita";
    private static final String PAPERONNI_REQUEST = "Paperonni";
    private static final String DRINKS_REQUEST = "Drinks";
    private static final String BACK_TO_START_MENU_REQUEST = "Back to start menu";

    public static ReplyKeyboardMarkup createChoosePizzaMenu() {
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

        KeyboardRow keyboardRow3 = new KeyboardRow();
        keyboardRow3.add(BACK_TO_START_MENU_REQUEST);

        keyboardRows.add(keyboardRow1);
        keyboardRows.add(keyboardRow2);
        keyboardRows.add(keyboardRow3);
        replyKeyboardMarkup.setKeyboard(keyboardRows);

        return replyKeyboardMarkup;
    }
}
