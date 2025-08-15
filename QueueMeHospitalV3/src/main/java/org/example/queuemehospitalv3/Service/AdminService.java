package org.example.queuemehospitalv3.Service;

import lombok.RequiredArgsConstructor;
import org.example.queuemehospitalv3.Api.ApiException;
import org.example.queuemehospitalv3.DTO.AdminDTO;
import org.example.queuemehospitalv3.Model.Admin;
import org.example.queuemehospitalv3.Model.User;
import org.example.queuemehospitalv3.Repository.AdminRepository;
import org.example.queuemehospitalv3.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;
    //other repo
    private final UserRepository userRepository;


    public List<Admin> getAllAdmins(){
        List<Admin> admins = adminRepository.findAll();
        if (admins.isEmpty()){
            throw new ApiException("admins not found");
        }
        return admins;
    }

    public void addNewAdmin(AdminDTO adminDTO){
        User user = userRepository.findUserById(adminDTO.getUserId());
        if (user == null){
            throw new ApiException("user not found");
        }
        Admin admin = new Admin(null, user.getUsername(), user.getPassword(), adminDTO.getRole(), user);
        adminRepository.save(admin);
    }

    public void deleteAdmin(Integer adminId){
        Admin admin = adminRepository.findAdminById(adminId);
        if (admin == null){
            throw new ApiException("admin not found");
        }
        User user = userRepository.findUserById(adminId);
        user.setAdmin(null);
        userRepository.save(user);
        adminRepository.delete(admin);
    }



}
