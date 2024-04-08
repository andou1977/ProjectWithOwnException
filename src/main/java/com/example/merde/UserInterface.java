package com.example.merde;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserInterface  {
    List<UserEntity> listalluser();
    List<RoleEntity>listallrole();
    UserEntity saveuser(UserEntity user);


    RoleEntity saverole(RoleEntity role);


//    void saveroleanduser(String username,String rolename);

    void saveroleanduser(String username,String rolename);
}


