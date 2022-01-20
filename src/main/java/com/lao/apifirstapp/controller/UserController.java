package com.lao.apifirstapp.controller;



import com.lao.apifirstapp.model.Response;
import com.lslao.af.api.UsersApi;
import com.lslao.af.models.ResponseSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@RestController
public class UserController implements UsersApi {

    @Autowired
    private HttpServletRequest request;

    @Override
    public ResponseEntity<ResponseSchema> getAllUsers() {
        Response response = new Response();
        response.status("200");
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

    @GetMapping("/test")
    public ResponseEntity<?> testResponse(){
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PostMapping(value ="/checkraw")
    public ResponseEntity<String>  getPostResp() {

        return ResponseEntity.ok("test");
    }

}
