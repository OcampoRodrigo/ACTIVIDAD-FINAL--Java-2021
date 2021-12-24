package com.informatorio.ACTIVIDAD.FINAL.service;

import com.informatorio.ACTIVIDAD.FINAL.entity.User;
import com.informatorio.ACTIVIDAD.FINAL.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public  List<User>   getUsers(){
        return userRepository.findAll();
    }

    public  User addNewUser(User user){
        return userRepository.save(user);
    }
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public User updateUser(User user, Long id){
        User previousUser = userRepository.findById(id).get();
        previousUser.setName(user.getName());
        previousUser.setLastname(user.getLastname());
        previousUser.setCity(user.getCity());
        previousUser.setUserType(user.getUserType());
        previousUser.setUsername(user.getUsername());
        previousUser.setPassword(user.getPassword());
        previousUser.setState(user.getState());
        previousUser.setCountry(user.getCountry());
        return userRepository.save(previousUser);
    }

    public List<User> findByDateOfCreation(LocalDate fromDate){
        List<User> usersFromDate = userRepository.findByCreationDateAfter(fromDate.atStartOfDay());
        return  usersFromDate;
    }

    public  List<User> findByCity(String city){
        List<User> usersFromCity = userRepository.findByCity(city);
        return  usersFromCity;
    }
}
