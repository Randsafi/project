package com.Online_Recruitment_System.web.services;

import com.Online_Recruitment_System.web.dtos.RegisterDto;
import com.Online_Recruitment_System.web.dtos.UserDto;
import com.Online_Recruitment_System.web.models.User;
import com.Online_Recruitment_System.web.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    public List<UserDto> getAll() {
        List<User> users = this.userRepository.findAll();

        return users.stream().map(u -> this.modelMapper.map(u, UserDto.class)).collect(Collectors.toList());
    }


    public void saveUser(RegisterDto registerDto){
        User user=new User(registerDto.ussername
                ,registerDto.email
                ,registerDto.password) ;
        this.userRepository.save(user);
    }

    public User findByUsername(String username){
        Optional<User> user= this.userRepository.findByUsername(username);
        if (user.isPresent())
            return user.get();
        return null;
    }
}
