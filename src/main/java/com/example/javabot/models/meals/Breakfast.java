package com.example.javabot.models.meals;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class Breakfast {

    public static SendMessage getBreakfastResponse(Message message) {
        SendMessage response = new SendMessage();
        String breakfastMenu = "Breakfast menu!\n";
        breakfastMenu += "1. Blueberry-Banana-Nut Smoothie\n";
        breakfastMenu += "2. Classic Omelet and Greens\n";
        breakfastMenu += "3. Curry-Avocado Crispy Egg Toast\n";

        response.setChatId(String.valueOf(message.getChatId()));
        response.setText(breakfastMenu);

        return response;
    }
}
