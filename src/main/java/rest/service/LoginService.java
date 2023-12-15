
package rest.service;

import rest.persistence.entity.User;
import rest.persistence.repository.UserRepository;

public class LoginService {
    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
/*
    public checkAuth(User user){

    }*/

}