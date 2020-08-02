package com.kenany.staticarray;

public class CeasarCipher {

    private StaticArray encoder = new StaticArray(97);
    private StaticArray decoder = new StaticArray(97);

    public CeasarCipher(int rotation) {

        rotation = rotation > 96 ? rotation % 97 : rotation;

        for (int i = 0; i < 97; i++) {
            char encoded = (char) (' ' + (i + rotation) % 97);
            char decoded = (char) (' ' + (i - rotation + 97) % 97);

            encoder.add(encoded);
            decoder.add(decoded);
        }
    }

    public String encrypt(String message) {
        return transform(message, encoder);
    }

    public String decrypt(String message) {
        return transform(message, decoder);
    }

    private String transform(String message, StaticArray code) {

        char[] msg = message.toCharArray();

        for (int i = 0; i < msg.length; i++) {
            int index = msg[i] - ' ';
            msg[i] = (char) code.get(index);
        }

        return new String(msg);
    }
}
