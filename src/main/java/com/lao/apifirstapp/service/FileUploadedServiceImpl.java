package com.lao.apifirstapp.service;

import com.lslao.af.models.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Base64;


@Service
public class FileUploadedServiceImpl implements FileUploadedService {

    final private static Logger LOGGER = LoggerFactory.getLogger(FileUploadedServiceImpl.class);

    @Override
    public boolean isBase64EncodedFile(UploadedFile file) {

        String fileAsString = file.getFileAsString();
        Base64.Decoder decoder = Base64.getDecoder();

        try{
            decoder.decode(fileAsString);
            return isValidPdfFile(fileAsString);
        } catch (IllegalArgumentException e){
            LOGGER.error("File is not a Base64 encoded.");
            return false;
        }
    }

    public boolean isValidPdfFile(String base64EncodedString){
        final String PDF_FILE = "JVBER";
        final int PDF_MINIMUM_SIZE = 300;

        if(Base64.getDecoder().decode(base64EncodedString).length > PDF_MINIMUM_SIZE) {
            LOGGER.info("File is valid PDF.");
            return base64EncodedString.startsWith(PDF_FILE);
        }
        LOGGER.error("Uploaded file is not a PDF or invalid PDF file.");
        return false;
    }
}
