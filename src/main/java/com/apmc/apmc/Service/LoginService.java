package com.apmc.apmc.Service;

import com.apmc.apmc.Controller.LoginController;
import com.apmc.apmc.Entity.Admin;
import com.apmc.apmc.Repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private AdminRepo adminRepo;

    public String LoginVerify(Admin admin){

        var existingadmin= adminRepo.findById(admin.getUserid()).orElseThrow(() -> new RuntimeException("Admin not found"));
         if (existingadmin.getPassword().equals(admin.getPassword())){
             return "Login Successfull";
         }
         else{
             throw new RuntimeException("Invalid Password");
         }
    }
}
