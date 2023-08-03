package com.urosdragojevic.encrypt;

import java.util.Scanner;

public class Encrypt {

    private final EncryptionAlgo encryptionAlgo;

    public Encrypt(EncryptionAlgo encryptionAlgo) {
        this.encryptionAlgo = encryptionAlgo;
    }

    public String encryptMessage() {
        System.out.println("Enter message to encrypt:");
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        this.encryptionAlgo.setMessage(message);
        System.out.println("Enter key to encrypt:");
        String key = scanner.nextLine();
        this.encryptionAlgo.setKey(key);
        return this.encryptionAlgo.encrypt();
    }

    public String decryptMessage() {
        System.out.println("Enter message to decrypt:");
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        this.encryptionAlgo.setMessage(message);
        System.out.println("Enter key to decrypt:");
        String key = scanner.nextLine();
        this.encryptionAlgo.setKey(key);
        return this.encryptionAlgo.decrypt();
    }

}
