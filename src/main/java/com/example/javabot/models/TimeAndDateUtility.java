package com.example.javabot.models;

import com.example.javabot.emoji.Emoji;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeAndDateUtility {

    public static SendMessage getCurrentTimeAndDate(Message message) {
        SendMessage response = new SendMessage();
        response.setText("Time:[" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))+"] "
                + "Date:[" +LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))+ "] " +
                Emoji.GRINNING_FACE_WITH_SMILING_EYES);
        response.setChatId(String.valueOf(message.getChatId()));

        return response;
    }
}
