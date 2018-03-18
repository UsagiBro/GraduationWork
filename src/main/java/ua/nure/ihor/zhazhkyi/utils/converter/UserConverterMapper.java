package ua.nure.ihor.zhazhkyi.utils.converter;

import org.mapstruct.Mapper;
import ua.nure.ihor.zhazhkyi.dto.UserDto;
import ua.nure.ihor.zhazhkyi.entity.User;

@Mapper(componentModel = "spring")
public interface UserConverterMapper {

    User userDtoToUser(UserDto userDto);

    UserDto userToUserDto(User user);
}