package com.example.merde;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController
{
    UserRepository userRepository;
    RoleRepository roleRepository;
   UserInterfaceImpl userInterfaceimpl;

    public UserController(UserRepository userRepository, RoleRepository roleRepository, UserInterfaceImpl userInterfaceimpl) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userInterfaceimpl = userInterfaceimpl;
    }

    @GetMapping("/listuser")
    public List<UserEntity> listuser(){
        return userInterfaceimpl.listalluser();
    }

    @PostMapping("/saveuser")
    public UserEntity saveuser(@RequestBody UserEntity userEntity){
        UserEntity user=userRepository.findByUsername(userEntity.getUsername());
        UserEntity email=userRepository.findByEmail(userEntity.getEmail());
        if(user!=null){
            throw new MyException("User already exists");
        }if(email!=null){
            throw new MyException("Email already exists");
        }
        else {
            return userInterfaceimpl.saveuser(userEntity);
        }
    }

   @PostMapping("/role")
    public RoleEntity saverole(@RequestBody RoleEntity role){
        return roleRepository.save(role);
    }

    @PostMapping("/saveroletouser")
    void saveusertorole( String username,String rolename) {
        UserEntity user=userRepository.findByUsername(username);
        RoleEntity role=roleRepository.findByrolename(rolename);
       if(user!=null && role!=null){
            userInterfaceimpl.saveroleanduser(username, rolename);
        }
       else {
           throw new MyException("username  not exist");
       }
    }
}
