package com.shocial.shocial.service;

import com.shocial.shocial.model.UserModel;
import com.shocial.shocial.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // Typically, you'd see @Autowired for repository
    // but for now, we'll write it like this with constructor bec IDE is complaining
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel registerUser(String username, String password, String email) {

        if(username == null && password == null) {
            return null;
        } else {
            if(userRepository.findFirstByUsername(username).isPresent()) {
                System.out.println("Duplicate Login");
                return null;
            }

            UserModel userModel = new UserModel();
            userModel.setUsername(username);
            userModel.setPassword(password);
            userModel.setEmail(email);
            return userRepository.save(userModel);
        }
    }

    public UserModel authenticate(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password).orElse(null);
    }


}
