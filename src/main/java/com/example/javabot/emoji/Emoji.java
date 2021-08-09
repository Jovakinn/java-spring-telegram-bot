package com.example.javabot.emoji;

public enum Emoji {
    // Emoticones group
    GRINNING_FACE_WITH_SMILING_EYES('\uD83D', '\uDE01'),
    FACE_WITH_TEARS_OF_JOY('\uD83D', '\uDE02'),
    SMILING_FACE_WITH_OPEN_MOUTH('\uD83D', '\uDE03'),
    SMILING_FACE_WITH_OPEN_MOUTH_AND_SMILING_EYES('\uD83D', '\uDE04'),
    SMILING_FACE_WITH_OPEN_MOUTH_AND_COLD_SWEAT('\uD83D', '\uDE05'),
    SMILING_FACE_WITH_OPEN_MOUTH_AND_TIGHTLY_CLOSED_EYES('\uD83D', '\uDE06'),
    WINKING_FACE('\uD83D', '\uDE09'),
    SMILING_FACE_WITH_SMILING_EYES('\uD83D', '\uDE0A'),
    FACE_SAVOURING_DELICIOUS_FOOD('\uD83D', '\uDE0B'),
    RELIEVED_FACE('\uD83D', '\uDE0C'),
    SMILING_FACE_WITH_HEART_SHAPED_EYES('\uD83D', '\uDE0D');

    Character firstChar;
    Character secondChar;

    Emoji(Character firstChar, Character secondChar) {
        this.firstChar = firstChar;
        this.secondChar = secondChar;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (this.firstChar != null) {
            sb.append(this.firstChar);
        }
        if (this.secondChar != null) {
            sb.append(this.secondChar);
        }

        return sb.toString();
    }
}
