package com.example.javabot.models.drinks;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import static com.example.javabot.view.ChooseDrinkMenu.createChooseDrinksMenu;

public class StartMenuOfDrinks {
    public static SendMessage getStartOfDrinksMenu(Message message) {
        SendMessage response = new SendMessage();
        String text = "Please choose the drink you'd like to taste!\n";
        response.enableMarkdown(true);
        response.setReplyMarkup(createChooseDrinksMenu());
        response.setText(text);
        response.setChatId(String.valueOf(message.getChatId()));

        return response;
    }
}
