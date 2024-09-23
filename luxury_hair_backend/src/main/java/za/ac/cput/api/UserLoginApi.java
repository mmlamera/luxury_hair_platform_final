package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.cput.domain.UserLogin;
import za.ac.cput.services.UserLoginService;

import java.util.List;

@Component
public class UserLoginApi {

    private final UserLoginService userLoginService;

    @Autowired
    public UserLoginApi(UserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }

    public List<UserLogin> getAllUsers() {
        return userLoginService.getall();
    }

    public UserLogin createUser(UserLogin userLogin) {
        return userLoginService.create(userLogin);
    }

    public UserLogin getUserById(Long id) {
        return userLoginService.read(id);
    }

    public UserLogin updateUser(UserLogin userLogin) {
        return userLoginService.update(userLogin);
    }

    public UserLogin getUserByEmail(String email) {
        return userLoginService.findByEmail(email);
    }

    public boolean checkIfEmailExists(String email) {
        return userLoginService.checkEmailExists(email);
    }

    public boolean validateUserPassword(String rawPassword, String hashedPassword) {
        return userLoginService.validatePassword(rawPassword, hashedPassword);
    }

    public boolean authenticateUser(String email, String password) {
        return userLoginService.authenticateUser(email, password);
    }
}
