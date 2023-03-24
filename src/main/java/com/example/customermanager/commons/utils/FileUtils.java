package com.example.customermanager.commons.utils;

import org.springframework.web.multipart.MultipartFile;
import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;
import java.util.Objects;

public class FileUtils {

    private static final String PATH_PARAM = "{0}/{1}";

    public static File createFile(MultipartFile multipartFile) throws IOException {
        File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        FileOutputStream stream = new FileOutputStream(file);

        stream.write(multipartFile.getBytes());
        stream.close();
        return file;
    }

    public static String generateHashFromFile(MultipartFile file) throws NoSuchAlgorithmException, IOException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(file.getBytes());
        byte[] digest = md.digest();
        return DatatypeConverter.printHexBinary(digest).toLowerCase();
    }

    public static String generatePath(String path, String param) {
        Object[] args = {path, param};
        MessageFormat form = new MessageFormat(PATH_PARAM);
        return form.format(args);
    }
}
