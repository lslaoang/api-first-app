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

        if (fileAsString == null || fileAsString.equals("")) {
            LOGGER.error("Uploaded file cannot be null.");
            return false;
        }

        try {
            byte[] data = decoder.decode(fileAsString);
            return isValidPdfFile(data);
        } catch (RuntimeException e) {
            LOGGER.error("File is not Base64 encoded. {}", e.getMessage());
            return false;
        }
    }

    public boolean isValidPdfFile(byte[] base64Encoded) {
        final byte[] PDF_HEADER = new byte[]{0x25, 0x50, 0x44, 0x46, 0x2D};
        final int PDF_MINIMUM_SIZE = 300;

        if (base64Encoded.length > PDF_MINIMUM_SIZE) {

            int count = 0;
            for (int i = 0; i < 5; i++) {
                if (base64Encoded[i] == PDF_HEADER[i]) {
                    count++;
                }
            }
            if (count == 5) {
                LOGGER.info("File is valid PDF.");
                return true;
            }

        }
        LOGGER.error("Uploaded file is not a PDF or invalid PDF file.");
        return false;
    }
}
