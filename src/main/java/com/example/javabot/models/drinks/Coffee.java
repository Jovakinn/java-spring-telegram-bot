package com.example.javabot.models.drinks;

import com.example.javabot.emoji.Emoji;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class Coffee {
    public static SendMessage getCoffeeResponse(Message message) {
        SendMessage response = new SendMessage();
        response.setChatId(String.valueOf(message.getChatId()));
        String firstName = message.getFrom().getFirstName();
        String lastName = message.getFrom().getLastName();
        String text = "Dear " + firstName + " " + lastName + "! your Coffee will be in a few minutes!" +
                Emoji.SMILING_FACE_WITH_OPEN_MOUTH_AND_TIGHTLY_CLOSED_EYES;
        response.setText(text);

        return response;
    }
}
