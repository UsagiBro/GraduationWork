package ua.nure.ihor.zhazhkyi.utils.converter;

import org.springframework.stereotype.Component;
import ua.nure.ihor.zhazhkyi.dto.UserDto;
import ua.nure.ihor.zhazhkyi.entity.User;

@Component
public class UserConverter extends AbstractConverter {

    public UserDto userToUserDto(User user) {
        UserDto userDto = new UserDto();
        convert(user, userDto);
        return userDto;
    }

    public User userDtoToUser(UserDto userDto) {
        User user = new User();
        convert(userDto, user);
        return user;
    }
}
