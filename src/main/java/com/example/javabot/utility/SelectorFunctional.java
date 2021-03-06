package com.example.javabot.utility;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import static com.example.javabot.models.Capital.getCapitalResponse;
import static com.example.javabot.models.Pizza.getOrderPizzaResponse;
import static com.example.javabot.models.StandardResponse.doStandardResponseForNoRequest;
import static com.example.javabot.models.StartOfApp.getStartFunctionalResponse;
import static com.example.javabot.models.TimeAndDateUtility.getCurrentTimeAndDate;
import static com.example.javabot.models.drinks.Coffee.getCoffeeResponse;
import static com.example.javabot.models.drinks.Cola.getColaResponse;
import static com.example.javabot.models.drinks.Sprite.getSpriteResponse;
import static com.example.javabot.models.drinks.StartMenuOfDrinks.getStartOfDrinksMenu;
import static com.example.javabot.models.drinks.Tea.getTeaResponse;
import static com.example.javabot.models.meals.Breakfast.getBreakfastResponse;
import static com.example.javabot.models.meals.Dinner.getDinnerResponse;
import static com.example.javabot.models.meals.Lunch.getLunchResponse;
import static com.example.javabot.models.meals.Supper.getSupperResponse;
import static com.example.javabot.models.meals.Surprise.getSurpriseResponse;
import static com.example.javabot.models.sights.IndependenceSquare.getIndependenceResponse;
import static com.example.javabot.models.sights.KNU.getKNUResponse;
import static com.example.javabot.models.sights.MotherlandMonument.getMotherlandResponse;
import static com.example.javabot.models.sights.PecherskLavra.getLavraResponse;
import static com.example.javabot.models.typesOfPizza.Carbonara.getCarbonaraResponse;
import static com.example.javabot.models.typesOfPizza.Margarita.getMargaritaResponse;
import static com.example.javabot.models.typesOfPizza.Paperonni.getPaperonniResponse;
import static com.example.javabot.service.BackToOrderPizzaMenu.getBackToOrderPizzaMenuResponse;
import static com.example.javabot.service.BackToStartMenu.getBackToStartMenuResponse;

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
    private static final String COFFEE_REQUEST = "coffee";
    private static final String TEA_REQUEST = "tea";
    private static final String COLA_REQUEST = "Cola";
    private static final String SPRITE_REQUEST = "Sprite";
    private static final String PECHERSK_LAVRA_REQUEST = "Pechersk lavra";
    private static final String INDEPENDENCE_SQUARE_REQUEST = "Independence square";
    private static final String MOTHERLAND_MONUMENT_REQUEST = "Motherland monument";
    private static final String KNU_REQUEST = "KNU";
    private static final String BACK_TO_START_MENU_REQUEST = "Back to start menu";
    private static final String BACK_TO_PIZZA_ORDER_REQUEST = "Back to Pizza order";

    public static SendMessage getResponseMessage(Message message) {
        switch (message.getText()) {
            // recipe realization
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
                // pizza realization
            case ORDER_PIZZA_REQUEST:
                return getOrderPizzaResponse(message);
            case CARBONARA_36_AS_USUAL_REQUEST:
                return getCarbonaraResponse(message);
            case MARGARITA_REQUEST:
                return getMargaritaResponse(message);
            case PAPERONNI_REQUEST:
                return getPaperonniResponse(message);
                // drinks realization
            case DRINKS_REQUEST:
                return getStartOfDrinksMenu(message);
            case COLA_REQUEST:
                return getColaResponse(message);
            case COFFEE_REQUEST:
                return getCoffeeResponse(message);
            case TEA_REQUEST:
                return getTeaResponse(message);
            case SPRITE_REQUEST:
                return getSpriteResponse(message);
                // capital realization
            case CAPITAL_REQUEST:
                return getCapitalResponse(message);
            case PECHERSK_LAVRA_REQUEST:
                return getLavraResponse(message);
            case INDEPENDENCE_SQUARE_REQUEST:
                return getIndependenceResponse(message);
            case MOTHERLAND_MONUMENT_REQUEST:
                return getMotherlandResponse(message);
            case KNU_REQUEST:
                return getKNUResponse(message);
                // back service
            case BACK_TO_START_MENU_REQUEST:
                return getBackToStartMenuResponse(message);
            case BACK_TO_PIZZA_ORDER_REQUEST:
                return getBackToOrderPizzaMenuResponse(message);
            default:
                return doStandardResponseForNoRequest(message);
        }
    }
}
