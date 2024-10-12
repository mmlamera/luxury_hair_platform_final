package za.ac.cput.factory;

import za.ac.cput.domain.UserLogin;
import za.ac.cput.util.Helper;

public class UserLoginFactory {

    public static UserLogin buildUserLogin(Long userId, String email, String password, String fullName,String userType) {
        if(Helper.isNullOrEmpty(String.valueOf(userId)) || Helper.isNullOrEmpty(email)|| Helper.isNullOrEmpty(password) || Helper.isNullOrEmpty(fullName) || Helper.isNullOrEmpty(userType)) {
            return null;
        }
        return new UserLogin.Builder()
                .setUserId(userId)
                .setEmail(email)
                .setPassword(password)
                .setFullName(fullName)
                .setUserType(userType)
                .build();
    }
}