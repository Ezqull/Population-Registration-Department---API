package bazy.projekt.app.service;

import bazy.projekt.app.exception.RecordNotFoundException;
import bazy.projekt.app.model.User;
import bazy.projekt.app.repository.ApplicationRepository;
import bazy.projekt.app.repository.UserRepository;
import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private static final String USER_NOT_FOUND = "User not found!";
    private final UserRepository userRepository;

    @Autowired
    public UserService(@Qualifier("userRepository") UserRepository userRepository, ApplicationRepository applicationRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        try {
            return userRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(USER_NOT_FOUND));
        } catch (RecordNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public User getUserByEmail(String email){
        try {
            return userRepository.findByEmail(email).orElseThrow(() -> new RecordNotFoundException(USER_NOT_FOUND));
        } catch (RecordNotFoundException e) {
            throw new RuntimeException(e);
        }
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
