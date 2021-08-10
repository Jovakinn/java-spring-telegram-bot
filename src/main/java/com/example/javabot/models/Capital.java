package com.example.javabot.models;

import com.example.javabot.emoji.Emoji;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import static com.example.javabot.view.ChoosePreferableSight.createChooseSightMenu;

public class Capital {

    public static SendMessage getCapitalResponse(Message message) {
        String firstName = message.getFrom().getFirstName();
        String lastName = message.getFrom().getLastName();
        SendMessage response = new SendMessage();
        response.setChatId(String.valueOf(message.getChatId()));
        response.setReplyMarkup(createChooseSightMenu());
        String textResponse = "Hello there " + firstName + " " + lastName + "!\n " +
                "We are going to have a quick info tour about our capital! Kyiv!\n" +
                "Choose the sight that you'd like to read info about!" +
                Emoji.GRINNING_FACE_WITH_SMILING_EYES;
        response.setText(textResponse);

        return response;
    }
}
