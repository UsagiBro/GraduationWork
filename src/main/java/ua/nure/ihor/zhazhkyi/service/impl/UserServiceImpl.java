package ua.nure.ihor.zhazhkyi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.ihor.zhazhkyi.repository.UserRepository;
import ua.nure.ihor.zhazhkyi.dto.UserDto;
import ua.nure.ihor.zhazhkyi.entity.User;
import ua.nure.ihor.zhazhkyi.service.UserService;
import ua.nure.ihor.zhazhkyi.utils.UserConverter;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public void registerUser(UserDto userDto) {
        User user = userConverter.userDtoToUser(userDto);
        userRepository.save(user);
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        User receivedUser = userRepository.findOneByEmail(email);
        if (Objects.nonNull(receivedUser)) {
            return (receivedUser.getPassword().equals(password)) ?  receivedUser : null;
        }
        return null;
    }
}
