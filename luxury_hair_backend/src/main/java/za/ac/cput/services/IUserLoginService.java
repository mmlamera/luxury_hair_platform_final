package za.ac.cput.services;

import za.ac.cput.domain.UserLogin;

import java.util.List;

public interface IUserLoginService extends IService<UserLogin,Long>{
    List<UserLogin> getall();
}