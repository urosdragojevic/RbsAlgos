package com.urosdragojevic.keyword;

import com.urosdragojevic.encrypt.EncryptionAlgo;

public class KeywordEncryptionAlgo implements EncryptionAlgo {

    private String message;
    private String key;
    private final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Override
    public String encrypt() {
        var cypher = new StringBuilder();
        int j = 0;
        if (message != null) {
            for (int i = 0; i < message.length(); i++) {
                char x = message.charAt(i);
                if (x == ' ') {
                    cypher.append(x);
                    continue;
                }
                int lidx = ALPHABET.indexOf(x);
                int key = ALPHABET.indexOf(this.key.charAt(j % this.key.length()));
                j++;
                int shift = lidx + key;
                char c = ALPHABET.charAt(shift % ALPHABET.length());
                cypher.append(c);
            }
        }
        return cypher.toString();
    }

    @Override
    public String decrypt() {
        var cypher = new StringBuilder();
        int j = 0;
        if (message != null) {
            for (int i = 0; i < message.length(); i++) {
                char x = message.charAt(i);
                if (x == ' ') {
                    cypher.append(x);
                    continue;
                }
                int lidx = ALPHABET.indexOf(x);
                int key = ALPHABET.indexOf(this.key.charAt(j % this.key.length()));
                j++;
                int shift = lidx - key;
                if (shift < 0) {
                    shift += ALPHABET.length();
                }
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
