package com.apmc.apmc.Controller;

import com.apmc.apmc.Entity.Admin;
import com.apmc.apmc.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/Admin/AddAdmin")
    public ResponseEntity<?> Admin(@RequestBody Admin admin){
        return adminService.AddAdmin(admin);
    }

    @GetMapping("/Admin/GetData")
    public ResponseEntity<List<Admin>> GetAdmin(){
        return adminService.GetAdmin();
    }

}
