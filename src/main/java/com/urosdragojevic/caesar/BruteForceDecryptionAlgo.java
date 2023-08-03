package com.urosdragojevic.caesar;

import com.urosdragojevic.decrypt.DecryptionAlgo;
import com.urosdragojevic.encrypt.EncryptionAlgo;

import java.util.HashSet;
import java.util.Set;

public class BruteForceDecryptionAlgo implements DecryptionAlgo {

    private EncryptionAlgo caeserEncryptionAlgo = new CaesarEncryptionAlgo();
    private Set<String> WORDS = Set.of("MOVE", "LOW", "QSZI");
    @Override
    public String breakCipher(String cipher) {
        caeserEncryptionAlgo.setMessage(cipher);
        for (int i = 0; i < 26; i++) {
            caeserEncryptionAlgo.setKey(String.valueOf(i));
            String result = caeserEncryptionAlgo.decrypt();
            for (String word : breakWords(result)) {
                if (WORDS.contains(word)) {
                    System.out.println("[key = " + i + "] " + result);
                }
            }
        }
        return null;
    }

    private String[] breakWords(String text) {
        return text.split(" ");
    }
}
