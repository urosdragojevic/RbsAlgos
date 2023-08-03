package com.urosdragojevic.decrypt;

public class Decrypt {

    private final DecryptionAlgo decryptionAlgo;

    public Decrypt (DecryptionAlgo decryptionAlgo) {
        this.decryptionAlgo = decryptionAlgo;
    }

    public String decryptCipher(String cipher) {
        return this.decryptionAlgo.breakCipher(cipher);
    }
}
