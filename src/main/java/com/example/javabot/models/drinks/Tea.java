package com.example.javabot.models.drinks;

import com.example.javabot.emoji.Emoji;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class Tea {
    public static SendMessage getTeaResponse(Message message) {
        SendMessage response = new SendMessage();
        response.setChatId(String.valueOf(message.getChatId()));
        String firstName = message.getFrom().getFirstName();
        String lastName = message.getFrom().getLastName();
        String text = "Dear " + firstName + " " + lastName + "! your Coffee will be in a few minutes!" +
                Emoji.RELIEVED_FACE;
        response.setText(text);

        return response;
    }
}
