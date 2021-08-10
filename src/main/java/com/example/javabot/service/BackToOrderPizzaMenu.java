package com.example.javabot.service;

import com.example.javabot.emoji.Emoji;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import static com.example.javabot.view.ChoosePizzaMenuKeyboard.createChoosePizzaMenu;

public class BackToOrderPizzaMenu {
    public static SendMessage getBackToOrderPizzaMenuResponse(Message message) {
        SendMessage response = new SendMessage();
        response.setChatId(String.valueOf(message.getChatId()));
        response.setReplyMarkup(createChoosePizzaMenu());
        response.setText("Back to order pizza menu)" + Emoji.SMILING_FACE_WITH_OPEN_MOUTH_AND_SMILING_EYES);

        return response;
    }
}
