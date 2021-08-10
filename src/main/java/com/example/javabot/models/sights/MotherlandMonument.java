package com.example.javabot.models.sights;

import com.example.javabot.emoji.Emoji;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class MotherlandMonument {
    public static SendMessage getMotherlandResponse(Message message) {
        SendMessage response = new SendMessage();
        response.setChatId(String.valueOf(message.getChatId()));
        String firstName = message.getFrom().getFirstName();
        String lastName = message.getFrom().getLastName();
        String text = "Dear " + firstName + " " + lastName + "! There are a list of links for you to explore" +
                Emoji.SMILING_FACE_WITH_OPEN_MOUTH_AND_COLD_SWEAT + "\n";
        text += "https://en.wikipedia.org/wiki/Motherland_Monument\n";
        text += "https://www.warmuseum.kiev.ua/_eng/museum/monument/\n";
        text += "https://ukraine-kiev-tour.com/ukraine_kiev_sights_mother_motherland.html\n";
        text += "Enjoy new knowledge!" + Emoji.SMILING_FACE_WITH_OPEN_MOUTH;
        response.setText(text);

        return response;
    }
}
