package ua.nure.ihor.zhazhkyi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.ihor.zhazhkyi.dao.UserDao;
import ua.nure.ihor.zhazhkyi.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void registerUser(UserDto userDto) {

    }

    @Override
    public void authorizeUser(UserDto userDto) {

    }
}
