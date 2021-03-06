package com.example.javabot.models.drinks;

import com.example.javabot.emoji.Emoji;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class Cola {
    public static SendMessage getColaResponse(Message message) {
        SendMessage response = new SendMessage();
        response.setChatId(String.valueOf(message.getChatId()));
        String firstName = message.getFrom().getFirstName();
        String lastName = message.getFrom().getLastName();
        String text = "Dear " + firstName + " " + lastName + "! your Cola will be in a few minutes!" +
                Emoji.SMILING_FACE_WITH_HEART_SHAPED_EYES;
        response.setText(text);

        return response;
    }
}
