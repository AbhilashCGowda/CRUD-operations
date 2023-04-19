package com.apmc.apmc.Service;

import com.apmc.apmc.Entity.Admin;
import com.apmc.apmc.Repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;

//    public ResponseEntity<String> AddAdmin(Admin admin){
//        adminRepo.save(admin);
//        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
//    }

    //can also do this way
    public String AddAdmin(Admin admin){                                //to add
        adminRepo.save(admin);
        return "Added Successfully";
    }

//    public ResponseEntity<List<Admin>> GetAdmin(){
//        var admin=adminRepo.findAll();
//        return new ResponseEntity<>(admin, HttpStatus.OK);
//    }

    //can also do this way
    public List<Admin> GetAdmin(){

        return adminRepo.findAll();
    }

    //if we use path variable in AdminController
    public String UpdateAdmin(Admin obj, Integer userid){

        var admin=adminRepo.findById(userid).orElseThrow(()-> new RuntimeException("Admin not found"));
        admin.setName(obj.getName());
        admin.setMobile(obj.getMobile());
        admin.setPassword(obj.getPassword());
        adminRepo.save(admin);
        return  "Updated Successfully";
    }

    public String DeleteAdmin(Integer userid)
    {
        var admin =adminRepo.findById(userid).orElseThrow(()->new RuntimeException("User not found"));
        adminRepo.delete(admin);
        return "Deleted Successfully";
    }


}
