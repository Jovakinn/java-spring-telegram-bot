package com.example.javabot.models.typesOfPizza;

import com.example.javabot.emoji.Emoji;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class Paperonni {
    public static SendMessage getPaperonniResponse(Message message) {
        SendMessage response = new SendMessage();
        response.setChatId(String.valueOf(message.getChatId()));
        String firstName = message.getFrom().getFirstName();
        String lastName = message.getFrom().getLastName();
        String text = "Dear " + firstName + " " + lastName + "! your Paperonni will be in a few minutes!" +
                Emoji.FACE_WITH_TEARS_OF_JOY;
        response.setText(text);

        return response;
    }
}
