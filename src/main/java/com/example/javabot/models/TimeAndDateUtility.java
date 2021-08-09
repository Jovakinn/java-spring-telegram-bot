package com.example.javabot.models;

import com.example.javabot.emoji.Emoji;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeAndDateUtility {

    public static SendMessage getCurrentTimeResponse(Message message) {
        SendMessage response = new SendMessage();
        response.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) +
                Emoji.SMILING_FACE_WITH_OPEN_MOUTH_AND_SMILING_EYES);
        response.setChatId(String.valueOf(message.getChatId()));

        return response;
    }


    public static SendMessage getCurrentDateResponse(Message message) {
        SendMessage response = new SendMessage();
        response.setChatId(String.valueOf(message.getChatId()));
        response.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) +
                Emoji.RELIEVED_FACE);

        return response;
    }
}
