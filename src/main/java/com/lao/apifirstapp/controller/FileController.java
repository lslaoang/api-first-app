package com.lao.apifirstapp.controller;


import com.lao.apifirstapp.service.FileUploadedService;
import com.lslao.af.api.AddApi;
import com.lslao.af.models.ResponseSchema;
import com.lslao.af.models.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class FileController implements AddApi {

    @Autowired
    FileUploadedService fileUploadedService;

    @Override
    public ResponseEntity<ResponseSchema> addFile(@RequestBody UploadedFile body) throws IOException {
        ResponseSchema response = new ResponseSchema();
        response.setTitle("Accepted.");
        response.setStatus("200");

        if(!fileUploadedService.isBase64EncodedFile(body)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
