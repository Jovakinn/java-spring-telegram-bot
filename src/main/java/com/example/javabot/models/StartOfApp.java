package com.example.javabot.models;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import static com.example.javabot.view.MainMenuKeyboard.getMainMenu;

public class StartOfApp {
    public static SendMessage getStartFunctionalResponse(Message message) {
        SendMessage response = new SendMessage();
        String text = "Welcome to Recipe bot! Please choose the functional of the day!\n";
        response.enableMarkdown(true);
        response.setReplyMarkup(getMainMenu());
        response.setText(text);
        response.setChatId(String.valueOf(message.getChatId()));

        return response;
    }
}
