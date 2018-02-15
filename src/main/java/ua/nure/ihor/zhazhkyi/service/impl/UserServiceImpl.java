package ua.nure.ihor.zhazhkyi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.ihor.zhazhkyi.dao.UserDao;
import ua.nure.ihor.zhazhkyi.dto.UserDto;
import ua.nure.ihor.zhazhkyi.entity.User;
import ua.nure.ihor.zhazhkyi.service.UserService;
import ua.nure.ihor.zhazhkyi.utils.UserDtoToUserConverter;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserDtoToUserConverter userDtoToUserConverter;

    @Override
    public void registerUser(UserDto userDto) {
        User user = userDtoToUserConverter.convert(userDto);
        userDao.save(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.findOneByEmail(email);
    }
}
