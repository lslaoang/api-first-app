package com.lao.apifirstapp.service;

import com.lslao.af.models.UploadedFile;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileUploadedService {

    boolean isBase64EncodedFile(UploadedFile file);

}
