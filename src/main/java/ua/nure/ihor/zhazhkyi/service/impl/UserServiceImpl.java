package ua.nure.ihor.zhazhkyi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.ihor.zhazhkyi.dto.UserDto;
import ua.nure.ihor.zhazhkyi.entity.User;
import ua.nure.ihor.zhazhkyi.exception.user.NoSuchUserException;
import ua.nure.ihor.zhazhkyi.persistence.UserRepository;
import ua.nure.ihor.zhazhkyi.service.UserService;
import ua.nure.ihor.zhazhkyi.utils.converter.UserConverter;
import ua.nure.ihor.zhazhkyi.utils.validator.UserValidator;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private UserValidator userValidator;

    @Override
    public void registerUser(UserDto userDto) {
        userValidator.validate(userDto);
        User user = userConverter.userDtoToUser(userDto);
        userRepository.save(user);
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        return Optional.ofNullable(userRepository.findOneByEmail(email))
                .filter(gotUser -> gotUser.getPassword().equals(password))
                .orElseThrow(() -> new NoSuchUserException("User with such email and password does not exist."));
    }
}
