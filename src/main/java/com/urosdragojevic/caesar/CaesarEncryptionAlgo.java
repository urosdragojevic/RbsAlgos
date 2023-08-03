package com.urosdragojevic.caesar;

import com.urosdragojevic.encrypt.EncryptionAlgo;

import java.util.function.BiFunction;

public class CaesarEncryptionAlgo implements EncryptionAlgo {

    private String message;
    private String key;
    private final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Override
    public String encrypt() {
        return use(Integer::sum);
    }

    @Override
    public String decrypt() {
        return use((lidx, k) -> {
            int shift = lidx - k;
            if (shift < 0) {
                shift += ALPHABET.length();
            }
            return shift;
        });
    }

    private String use(BiFunction<Integer, Integer, Integer> shiftFn) {
        StringBuilder cypher = new StringBuilder();
        int k = Integer.parseInt(key);
        if (message != null) {
            for (int i = 0; i < message.length(); i++) {
                char x = message.charAt(i);
                if (x == ' ') {
                    cypher.append(x);
                    continue;
                }
                int lidx = ALPHABET.indexOf(x);
                int key = k % ALPHABET.length();
                int shift = shiftFn.apply(lidx, key);
                char c = ALPHABET.charAt(shift % ALPHABET.length());
                cypher.append(c);
            }
        }
        return cypher.toString();
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void setKey(String key) {
        this.key = key;
    }
}
