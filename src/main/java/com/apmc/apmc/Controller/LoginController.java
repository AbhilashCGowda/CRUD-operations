package com.apmc.apmc.Controller;

import com.apmc.apmc.Entity.Admin;
import com.apmc.apmc.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/LoginVerify")
    public ResponseEntity<String> LoginUser(@RequestBody Admin obj){
        return new ResponseEntity<>(loginService.LoginVerify(obj) , HttpStatus.OK);

    }
}
