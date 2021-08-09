package com.example.javabot.models;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import static com.example.javabot.view.MainMenuKeyboard.getMainMenu;

public class StandardResponse {
    public static SendMessage doStandardResponseForNoRequest(Message message) {
        String firstName = message.getFrom().getFirstName();
        String lastName = message.getFrom().getLastName();
        Long chatId = message.getChatId();

        String responseToUserForANonCommandRequest = "Hello "+ firstName + " " + lastName+ "! I received your message: "
                + message.getText() +"; " + " However I don't understand such a command" +
                " ;( Try again! Or contact @Jovakinn " +
                "for a personal special service!";
        SendMessage response = new SendMessage();
        response.setText(responseToUserForANonCommandRequest);
        response.setChatId(String.valueOf(chatId));
        response.setReplyMarkup(getMainMenu());

        return response;
    }
}
