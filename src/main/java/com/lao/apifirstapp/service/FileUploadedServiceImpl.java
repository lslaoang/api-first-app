package com.lao.apifirstapp.service;

import com.lslao.af.models.UploadedFile;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Base64;


@Service
public class FileUploadedServiceImpl implements FileUploadedService {

    @Override
    public boolean isBase64EncodedFile(UploadedFile file) {

        String fileAsString = file.getFileAsString();
        Base64.Decoder decoder = Base64.getDecoder();

        try{
            byte[] data = decoder.decode(fileAsString);
            System.out.println(data.length);
            return isUploadedStringValidFile(fileAsString);
        } catch (IllegalArgumentException e){
            return false;
        }
    }

    public boolean isUploadedStringValidFile(String base64EncodedString){

        final String PDF_FILE = "JVBER";

        return base64EncodedString.startsWith(PDF_FILE);
    }
}
