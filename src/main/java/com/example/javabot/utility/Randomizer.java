package com.example.javabot.utility;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Randomizer {

    public static String getRandomMeal() {
        List<String> optionsOfMenu = Arrays.asList("breakfast", "dinner", "lunch", "supper");
        Random random = new Random();
        int randomIndex = random.nextInt(optionsOfMenu.size());

        return optionsOfMenu.get(randomIndex);
    }
}
