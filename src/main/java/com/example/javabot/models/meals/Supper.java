package com.example.javabot.models.meals;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class Supper {
    public static SendMessage getSupperResponse(Message message) {
        SendMessage response = new SendMessage();
        String supperMenu = "Supper menu!\n";
        supperMenu += "1. Caesar salad\n";
        supperMenu += "2. Milk shake\n";
        supperMenu += "3. Fish and chips\n";

        response.setChatId(String.valueOf(message.getChatId()));
        response.setText(supperMenu);

        return response;
    }
}
