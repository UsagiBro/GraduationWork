package ua.nure.ihor.zhazhkyi.service;

import org.springframework.stereotype.Service;
import ua.nure.ihor.zhazhkyi.dto.UserDto;

@Service
public interface UserService {

    void registerUser(UserDto userDto);

    void authorizeUser(UserDto userDto);
}
