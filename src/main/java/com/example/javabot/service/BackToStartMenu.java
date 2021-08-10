package com.example.javabot.service;

import com.example.javabot.emoji.Emoji;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import static com.example.javabot.view.MainMenuKeyboard.getMainMenu;

public class BackToStartMenu {
    public static SendMessage getBackToStartMenuResponse(Message message) {
        SendMessage response = new SendMessage();
        response.setChatId(String.valueOf(message.getChatId()));
        response.setReplyMarkup(getMainMenu());
        response.setText("Back to main menu)" + Emoji.SMILING_FACE_WITH_OPEN_MOUTH_AND_SMILING_EYES);

        return response;
    }
}
