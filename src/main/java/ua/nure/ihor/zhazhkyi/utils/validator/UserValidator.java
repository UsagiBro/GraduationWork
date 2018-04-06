package ua.nure.ihor.zhazhkyi.utils.validator;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ua.nure.ihor.zhazhkyi.dto.UserDto;
import ua.nure.ihor.zhazhkyi.exception.user.UserValidationException;

import java.util.Objects;

@Component
@Qualifier("UserValidator")
public class UserValidator extends Validator<UserDto> {

    private static final String REGEX_FOR_NAME = "([a-zA-Zа-яА-Яё]){2,64}";
    private static final String REGEX_FOR_EMAIL = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
    private static final String REGEX_FOR_PASSWORD = "[\\d|\\w]{6,}";

    private static final String EMAIL_VALIDATION_ERROR_MESSAGE = "Such user email is not valid: %s";
    private static final String NAME_VALIDATION_ERROR_MESSAGE = "Such user name is not valid: %s";
    private static final String SURNAME_VALIDATION_ERROR_MESSAGE = "Such user surname is not valid: %s";
    private static final String PASSWORD_VALIDATION_ERROR_MESSAGE = "User password is not valid";
    private static final String PASSWORD_NOT_MATCH_MESSAGE = "Repeated password not match";

    public void validate(UserDto userDto) {
        if (!matchesPattern(userDto.getEmail(), REGEX_FOR_EMAIL)) {
            throw new UserValidationException(String.format(EMAIL_VALIDATION_ERROR_MESSAGE, userDto.getEmail()));
        }
        if (!matchesPattern(userDto.getFirstName(), REGEX_FOR_NAME)) {
            throw new UserValidationException(String.format(NAME_VALIDATION_ERROR_MESSAGE, userDto.getFirstName()));
        }
        if (!matchesPattern(userDto.getLastName(), REGEX_FOR_NAME)) {
            throw new UserValidationException(String.format(SURNAME_VALIDATION_ERROR_MESSAGE, userDto.getLastName()));
        }
        if (!matchesPattern(userDto.getPassword(), REGEX_FOR_PASSWORD)) {
            throw new UserValidationException(PASSWORD_VALIDATION_ERROR_MESSAGE);
        }
        if (!matchesPattern(userDto.getRepeatPassword(), REGEX_FOR_PASSWORD) ||
                !Objects.equals(userDto.getPassword(), userDto.getRepeatPassword())) {
            throw new UserValidationException(PASSWORD_NOT_MATCH_MESSAGE);
        }
    }
}
