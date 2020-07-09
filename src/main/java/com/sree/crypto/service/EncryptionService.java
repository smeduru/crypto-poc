package com.sree.crypto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.stereotype.Service;

@Service
public class EncryptionService {
    private String secret;
    private String salt;

    @Autowired
    public EncryptionService(@Value("${aes.secret}") final String secret,
                             @Value("${aes.salt}") final String salt) {
        this.secret = String.valueOf(Hex.encode(secret.getBytes()));
        this.salt = String.valueOf(Hex.encode(salt.getBytes()));
    }

    public String encryptMessage(String message)
    {
        return Encryptors.text(secret, salt).encrypt(message);
    }

    public String decryptMessage(String message)
    {
        return Encryptors.text(secret, salt).decrypt(message);
    }
}