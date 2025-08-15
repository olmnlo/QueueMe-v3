package org.example.queuemehospitalv3.Service;

import lombok.RequiredArgsConstructor;
import org.example.queuemehospitalv3.Api.ApiException;
import org.example.queuemehospitalv3.Model.User;
import org.example.queuemehospitalv3.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers(){
        List<User> users = userRepository.findAll();
        if (users.isEmpty()){
            throw new ApiException("users not found");
        }
        return users;
    }

    public void addNewUser(User user){
        userRepository.save(user);
    }

    public void updateUser(Integer userId, User user){
        User oldUser = userRepository.findUserById(userId);
        if (oldUser == null){
            throw new ApiException("user not found");
        }

        oldUser.setAge(user.getAge());
        oldUser.setEmail(user.getEmail());
        oldUser.setName(user.getName());
        oldUser.setLatitude(user.getLatitude());
        oldUser.setLongitude(user.getLongitude());
        oldUser.setPassword(user.getPassword());
        oldUser.setBloodType(user.getBloodType());
        oldUser.setUsername(user.getUsername());

        userRepository.save(oldUser);

    }

    public void deleteUser(Integer userId){
        User user = userRepository.findUserById(userId);
        if (user == null){
            throw new ApiException("user not found");
        }
        userRepository.delete(user);
    }
}
