package com.example.javabot.view;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import java.util.ArrayList;
import java.util.List;

public class MainMenuKeyboard {
    private static final String DATE_AND_TIME_REQUEST = "DateAndTime";
    private static final String CAPITAL_REQUEST = "Capital?";
    private static final String ORDER_PIZZA_REQUEST = "Order pizza";
    private static final String BREAKFAST_REQUEST = "breakfast";
    private static final String DINNER_REQUEST = "dinner";
    private static final String LUNCH_REQUEST = "lunch";
    private static final String SUPPER_REQUEST = "supper";
    private static final String SURPRISE_REQUEST = "surprise";

    public static ReplyKeyboardMarkup getMainMenu() {
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
        keyboardRow4.add(DATE_AND_TIME_REQUEST);

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
}
