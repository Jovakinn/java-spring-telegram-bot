package com.example.javabot.models;

import com.example.javabot.emoji.Emoji;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import static com.example.javabot.view.ChoosePizzaMenuKeyboard.createChoosePizzaMenu;

public class Pizza {

    public static SendMessage getOrderPizzaResponse(Message message) {
        SendMessage response = new SendMessage();
        String textResponse = "PLease make your completely independent choice :)";
        response.setText(textResponse + Emoji.FACE_SAVOURING_DELICIOUS_FOOD);
        response.setReplyMarkup(createChoosePizzaMenu());
        response.setChatId(String.valueOf(message.getChatId()));

        return response;
    }

}
