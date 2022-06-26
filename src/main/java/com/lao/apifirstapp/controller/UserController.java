package com.lao.apifirstapp.controller;


import com.lao.apifirstapp.model.Response;
import com.lslao.af.api.UsersApi;
import com.lslao.af.models.ResponseSchema;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@RestController
public class UserController implements UsersApi {

    private final HttpServletRequest request;

    public UserController(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public ResponseEntity<ResponseSchema> getAllUsers() {
        Response response = new Response();
        response.status(200);
        response.setTitle("Request Accepted.");

        Enumeration headers = request.getHeaderNames();
        while (headers.hasMoreElements()){
            String key = (String) headers.nextElement();
            if(key.equalsIgnoreCase("authorization")){
                System.out.println(request.getHeader(key).substring(7));
            }
        }

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
