package com.example.customermanager.commons.security.aes;

import com.example.customermanager.commons.utils.SecretUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

@Service
public class AESSecurity {

    @Value("${security.secret}")
    private String secret;

    @Value("${security.salt}")
    private String salt;

    @Value("${security.algorithm}")
    private String algorithm;

    public String encrypt(String input) throws NoSuchPaddingException, NoSuchAlgorithmException,
            BadPaddingException, IllegalBlockSizeException, InvalidKeySpecException, InvalidAlgorithmParameterException, InvalidKeyException {

        SecretKey key = this.getKeyFromPassword(secret, salt);
        IvParameterSpec ivParameterSpec = this.generateIv();
        String algorithm = "AES/CBC/PKCS5Padding";

        return SecretUtils.encrypt(input, algorithm, key, ivParameterSpec);
    }

    public String decrypt(String cipherText) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidAlgorithmParameterException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException, InvalidKeySpecException {

        SecretKey key = this.getKeyFromPassword(secret,salt);
        IvParameterSpec ivParameterSpec = this.generateIv();
        String algorithm = "AES/CBC/PKCS5Padding";

        return SecretUtils.decrypt(cipherText, algorithm, key, ivParameterSpec);
    }

    public SecretKey getKeyFromPassword(String password, String salt)
            throws NoSuchAlgorithmException, InvalidKeySpecException {

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, 256);
        return new SecretKeySpec(factory.generateSecret(spec)
                .getEncoded(), "AES");
    }

    public IvParameterSpec generateIv() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    public SecretKey generateKey(int n) throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(n);
        return keyGenerator.generateKey();
    }
}
