package com.lao.apifirstapp.controller;


import com.lao.apifirstapp.model.Response;
import com.lslao.af.api.UsersApi;
import com.lslao.af.models.ResponseSchema;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UsersApi {



    @Override
    public ResponseEntity<ResponseSchema> getAllUsers() {
        Response response = new Response();
        response.status("200");
        response.setTitle("Request Accepted.");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity<?> testResponse(){
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
