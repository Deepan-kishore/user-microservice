package com.ecommerce.user.service;

import com.ecommerce.user.model.User;
import com.ecommerce.user.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
//    ArrayList<User> userList = new ArrayList<>();
    private  final UserRepository userRepository;


    public User createUser(User user){
//        boolean status = userList.add(user);
//        if (status){
//            return user;
//        }
//        else {
//            throw new RuntimeException("User Creation Failed");
//        }

       try {
           userRepository.save(user);
       } catch (Exception e) {
            throw new RuntimeException("User Creation Failed");
       }
return user;
    }

    public User getUser( String id){
        return userRepository.findById(id).orElseThrow(()->new RuntimeException("User Not Found"));
    }

    public boolean updateUser( String id, User updatedUser){
       return userRepository.findById(id).map(e->{
            e.setFirstName(updatedUser.getFirstName());
            e.setLastName(updatedUser.getLastName());
            return true;
        }).orElseThrow(()->new RuntimeException(""));

    }


    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void deleteUser( String id){
       userRepository.deleteById(id);

    }
}
