package com.urosdragojevic.encrypt;

public interface EncryptionAlgo {

    String encrypt();
    String decrypt();
    void setMessage(String message);
    void setKey(String key);

}
