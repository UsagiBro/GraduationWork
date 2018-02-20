package ua.nure.ihor.zhazhkyi.service;

import org.springframework.stereotype.Service;
import ua.nure.ihor.zhazhkyi.dto.UserDto;
import ua.nure.ihor.zhazhkyi.entity.User;

@Service
public interface UserService {

    void registerUser(UserDto userDto);

    User getUserByEmailAndPassword(String email, String password);
}
