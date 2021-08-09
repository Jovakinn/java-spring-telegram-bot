package com.example.javabot.utility;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import static com.example.javabot.models.Pizza.getOrderPizzaResponse;
import static com.example.javabot.models.StandardResponse.doStandardResponseForNoRequest;
import static com.example.javabot.models.StartOfApp.getStartFunctionalResponse;
import static com.example.javabot.models.TimeAndDateUtility.getCurrentTimeAndDate;
import static com.example.javabot.models.meals.Breakfast.getBreakfastResponse;
import static com.example.javabot.models.meals.Dinner.getDinnerResponse;
import static com.example.javabot.models.meals.Lunch.getLunchResponse;
import static com.example.javabot.models.meals.Supper.getSupperResponse;
import static com.example.javabot.models.meals.Surprise.getSurpriseResponse;
import static com.example.javabot.models.typesOfPizza.Carbonara.getCarbonaraResponse;

public class SelectorFunctional {
    private static final String START_REQUEST = "/start";
    private static final String DATE_AND_TIME_REQUEST = "DateAndTime";
    private static final String CAPITAL_REQUEST = "Capital?";
    private static final String ORDER_PIZZA_REQUEST = "Order pizza";
    private static final String BREAKFAST_REQUEST = "breakfast";
    private static final String DINNER_REQUEST = "dinner";
    private static final String LUNCH_REQUEST = "lunch";
    private static final String SUPPER_REQUEST = "supper";
    private static final String SURPRISE_REQUEST = "surprise";
    private static final String CARBONARA_36_AS_USUAL_REQUEST = "Carbonara 36 as usual";
    private static final String MARGARITA_REQUEST = "Margarita";
    private static final String PAPERONNI_REQUEST = "Paperonni";
    private static final String DRINKS_REQUEST = "Drinks";

    public static SendMessage getResponseMessage(Message message) {
        switch (message.getText()) {
            case START_REQUEST:
                return getStartFunctionalResponse(message);
            case BREAKFAST_REQUEST:
                return getBreakfastResponse(message);
            case DINNER_REQUEST:
                return getDinnerResponse(message);
            case LUNCH_REQUEST:
                return getLunchResponse(message);
            case SUPPER_REQUEST:
                return getSupperResponse(message);
            case SURPRISE_REQUEST:
                return getSurpriseResponse(message);
            case  DATE_AND_TIME_REQUEST:
                return getCurrentTimeAndDate(message);
            case ORDER_PIZZA_REQUEST:
                return getOrderPizzaResponse(message);
            case CARBONARA_36_AS_USUAL_REQUEST:
                return getCarbonaraResponse(message);
            default:
                return doStandardResponseForNoRequest(message);
        }
    }
}
