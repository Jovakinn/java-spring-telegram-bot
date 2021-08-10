package com.example.javabot.models.sights;

import com.example.javabot.emoji.Emoji;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class PecherskLavra {
    public static SendMessage getLavraResponse(Message message) {
        SendMessage response = new SendMessage();
        response.setChatId(String.valueOf(message.getChatId()));
        String firstName = message.getFrom().getFirstName();
        String lastName = message.getFrom().getLastName();
        String text = "Dear " + firstName + " " + lastName + "! There are a list of links for you to explore" +
                Emoji.SMILING_FACE_WITH_OPEN_MOUTH_AND_COLD_SWEAT + "\n";
        text += "https://en.wikipedia.org/wiki/Kyiv_Pechersk_Lavra\n";
        text += "https://lavra.ua/en/\n";
        text += "https://www.lonelyplanet.com/ukraine/kyiv/attractions/kyevo-pecherska-lavra/a/poi-sig/421329/360928\n";
        text += "Enjoy new knowledge!" + Emoji.SMILING_FACE_WITH_OPEN_MOUTH;
        response.setText(text);

        return response;
    }
}
