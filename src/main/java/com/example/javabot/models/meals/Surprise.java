package com.example.javabot.models.meals;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import static com.example.javabot.models.meals.Breakfast.getBreakfastResponse;
import static com.example.javabot.models.meals.Dinner.getDinnerResponse;
import static com.example.javabot.models.meals.Lunch.getLunchResponse;
import static com.example.javabot.models.meals.Supper.getSupperResponse;
import static com.example.javabot.utility.Randomizer.getRandomMeal;

public class Surprise {

    public static SendMessage getSurpriseResponse(Message message) {

    message.setText(getRandomMeal());

    SendMessage response = new SendMessage();
    response.setChatId(String.valueOf(message.getChatId()));
    switch(message.getText()){
        case "breakfast":
            return getBreakfastResponse(message);
        case "dinner":
            return getDinnerResponse(message);
        case "lunch":
            return getLunchResponse(message);
        case "supper":
            return getSupperResponse(message);
    }
    return response;
    }
}