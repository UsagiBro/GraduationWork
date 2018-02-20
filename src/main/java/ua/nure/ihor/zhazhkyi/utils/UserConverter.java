package ua.nure.ihor.zhazhkyi.utils;

import org.mapstruct.Mapper;
import ua.nure.ihor.zhazhkyi.dto.UserDto;
import ua.nure.ihor.zhazhkyi.entity.User;

@Mapper(componentModel = "spring")
public interface UserConverter {

    User userDtoToUser(UserDto userDto);

    UserDto userToUserDto(User user);
}
