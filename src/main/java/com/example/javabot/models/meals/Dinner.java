package com.example.javabot.models.meals;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class Dinner {
    public static SendMessage getDinnerResponse(Message message){
        SendMessage response = new SendMessage();
        String dinnerMenu = "Dinner menu!\n";
        dinnerMenu += "1. Creamy Lemon Chicken Pasta\n";
        dinnerMenu += "2. Turkey Tacos\n";
        dinnerMenu += "3. Vegetarian Lasagna\n";

        response.setChatId(String.valueOf(message.getChatId()));
        response.setText(dinnerMenu);

        return response;
    }
}
