package com.example.customermanager;

import com.example.customermanager.commons.security.aes.AESSecurity;
import com.example.customermanager.commons.utils.SecretUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class SecretTest {

    @Test
    void givenString_whenEncrypt_thenSuccessFail()
            throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException,
            BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException, InvalidKeySpecException {

//        String input = "baeldung";
//        SecretKey key = AESSecurity.getKeyFromPassword("customermanager", "123");
//        IvParameterSpec ivParameterSpec = AESSecurity.generateIv();
//        String algorithm = "AES/CBC/PKCS5Padding";
//
//        String cipherText = AESSecurity.encrypt(algorithm, input, key, ivParameterSpec);
//        String plainText = AESSecurity.decrypt(algorithm, cipherText, key, ivParameterSpec);
//        Assertions.assertEquals(input, plainText);
    }

    @Test
    void givenString_whenEncrypt_thenSuccess()
            throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException,
            BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException, InvalidKeySpecException {

        String input = "baeldung";
        SecretKey key = SecretUtils.getKeyFromPassword("customermanager","128");
        IvParameterSpec ivParameterSpec = SecretUtils.generateIv();
        String algorithm = "AES/CBC/PKCS5Padding";
        String cipherText = SecretUtils.encrypt(algorithm, input, key, ivParameterSpec);
        String plainText = SecretUtils.decrypt(algorithm, cipherText, key, ivParameterSpec);
        Assertions.assertEquals(input, plainText);
    }
}
