package bazy.dziala.bazydziala.service;

import bazy.dziala.bazydziala.model.User;
import bazy.dziala.bazydziala.repository.ApplicationRepository;
import bazy.dziala.bazydziala.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private static final String USER_NOT_FOUND = "User with this email does not exist!";
    private final UserRepository userRepository;

    @Autowired
    public UserService(@Qualifier("userRepository") UserRepository userRepository, ApplicationRepository applicationRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow();
    }

    public User getUserByEmail(String email){
        return userRepository.findByEmail(email).orElseThrow();
    }

    public User createUser(User user){
        return userRepository.saveAndFlush(user);
    }

    public User updateUser(User user){
        return userRepository.save(user);
    }

    public String deleteUser(Long id){
        User userToDelete = getUserById(id);
        userRepository.delete(userToDelete);
        return "User with id: " + id + " deleted!";
    }
}
