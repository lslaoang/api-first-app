package com.lao.apifirstapp.service;

import com.lao.apifirstapp.model.upload.UploadRequest;
import com.lslao.af.models.UploadedFile;

public interface FileUploadedService {

    boolean isBase64EncodedFile(UploadedFile file);

    void sendToEndpoint(UploadRequest uploadRequest);

}
