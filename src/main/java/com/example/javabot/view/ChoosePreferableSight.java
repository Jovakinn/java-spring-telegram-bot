package com.example.javabot.view;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class ChoosePreferableSight {

    private static final String PECHERSK_LAVRA_REQUEST = "Pechersk lavra";
    private static final String INDEPENDENCE_SQUARE_REQUEST = "Independence square";
    private static final String MOTHERLAND_MONUMENT_REQUEST = "Motherland monument";
    private static final String KNU_REQUEST = "KNU";

    public static ReplyKeyboardMarkup createChooseSightMenu() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(PECHERSK_LAVRA_REQUEST);
        keyboardRow1.add(INDEPENDENCE_SQUARE_REQUEST);

        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add(MOTHERLAND_MONUMENT_REQUEST);
        keyboardRow2.add(KNU_REQUEST);

        keyboardRows.add(keyboardRow1);
        keyboardRows.add(keyboardRow2);
        replyKeyboardMarkup.setKeyboard(keyboardRows);

        return replyKeyboardMarkup;
    }
}
