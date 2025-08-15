package org.example.queuemehospitalv3.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.queuemehospitalv3.Api.ApiResponse;
import org.example.queuemehospitalv3.Model.User;
import org.example.queuemehospitalv3.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<ApiResponse> addUser(@Valid @RequestBody User user){
        userService.addNewUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("user added successfully"));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<ApiResponse> updateUser(@PathVariable Integer userId, @Valid@RequestBody User user){
        userService.updateUser(userId,user);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("user updated successfully"));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId){
        userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("user deleted successfully"));
    }



}
