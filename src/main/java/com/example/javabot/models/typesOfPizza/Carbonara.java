package com.example.javabot.models.typesOfPizza;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class Carbonara {

    public static SendMessage getCarbonaraResponse(Message message) {
        SendMessage response = new SendMessage();
        response.setChatId(String.valueOf(message.getChatId()));
        String firstName = message.getFrom().getFirstName();
        String lastName = message.getFrom().getLastName();
        String text = "Dear " + firstName + " " + lastName + "! your Carbonara will be in a few minutes!\n ";
        response.setText(text);
        response.setChatId(String.valueOf(message.getChatId()));

        return response;
    }
}
