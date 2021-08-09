package com.example.javabot.models.meals;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class Lunch {
    public static SendMessage getLunchResponse(Message message) {
        SendMessage response = new SendMessage();
        String lunchMenu = "Lunch menu!\n";
        lunchMenu += "1. Borsch with onions\n";
        lunchMenu += "2. Fried potatoes\n";
        lunchMenu += "3. Nuka cola\n";

        response.setChatId(String.valueOf(message.getChatId()));
        response.setText(lunchMenu);

        return response;
    }
}
