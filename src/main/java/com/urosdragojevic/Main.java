package com.urosdragojevic;

import com.urosdragojevic.caesar.BruteForceDecryptionAlgo;
import com.urosdragojevic.caesar.CaesarEncryptionAlgo;
import com.urosdragojevic.decrypt.Decrypt;
import com.urosdragojevic.encrypt.Encrypt;
import com.urosdragojevic.keyword.KeywordEncryptionAlgo;

public class Main {
    public static void main(String[] args) {
        var caesar = new CaesarEncryptionAlgo();
        var brute = new BruteForceDecryptionAlgo();
        var keyword = new KeywordEncryptionAlgo();

        var encrypt = new Encrypt(keyword);
        var decrypt = new Decrypt(brute);

        System.out.println(encrypt.encryptMessage());
        System.out.println(encrypt.decryptMessage());

    }
}