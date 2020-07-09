package com.sree.crypto.service;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

@SpringBootTest
public class EncryptionServiceTest {
    private static Logger LOG = LoggerFactory.getLogger(EncryptionServiceTest.class);
    @Autowired
    private EncryptionService encryptionService;

    @Test
    void testEncryption() {
        String message = "this is a long keyword search key";
        String encrypted = encryptionService.encryptMessage(message);
        assertThat(encrypted, not(message));
        LOG.debug(message);
        String decrypted = encryptionService.decryptMessage(encrypted);
        assertThat(decrypted, equalTo(message));
    }
}
