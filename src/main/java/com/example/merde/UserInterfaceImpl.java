package com.example.merde;

import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@Transactional
public class UserInterfaceImpl implements UserInterface {


   UserRepository userRepository;
    RoleRepository roleRepository;
    PasswordEncoder passwordEncoder;

    public UserInterfaceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<RoleEntity> listallrole() {
        return roleRepository.findAll();
    }

    @Override
    public List<UserEntity> listalluser(){
        return userRepository.findAll();
    }


    @Override
    public UserEntity saveuser(UserEntity user) {
        String password=user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        return userRepository.save(user);
    }




    @Override
    public RoleEntity saverole(RoleEntity role) {
        return roleRepository.save(role);
    }




    @Override
    public void saveroleanduser(String username, String rolename) {
        UserEntity user=userRepository.findByUsername(username);
        RoleEntity role=roleRepository.findByrolename(rolename);
        user.getRoleapp().add(role);
    }

}
