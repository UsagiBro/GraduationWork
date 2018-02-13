package ua.nure.ihor.zhazhkyi.utils;

import org.springframework.core.convert.converter.Converter;
import ua.nure.ihor.zhazhkyi.dto.UserDto;
import ua.nure.ihor.zhazhkyi.entity.User;

public class UserDtoToUserConverter implements Converter<UserDto, User> {

    @Override
    public User convert(UserDto dto) {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        return user;
    }
}
