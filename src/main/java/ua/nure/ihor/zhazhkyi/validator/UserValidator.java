package ua.nure.ihor.zhazhkyi.validator;

import ua.nure.ihor.zhazhkyi.constants.WebConstants;
import ua.nure.ihor.zhazhkyi.dto.UserDto;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {

    private static final Pattern PATTERN_FOR_EMAIL = Pattern.compile(WebConstants.REGEX_FOR_EMAIL);
    private static final Pattern PATTERN_FOR_NAME = Pattern.compile(WebConstants.REGEX_FOR_NAME);

    public Map<String, String> validate(UserDto userDto) {
        Map<String, String> errors = new HashMap<>();
        if (userDto.getEmail() == null || !matchPattern(PATTERN_FOR_EMAIL, userDto.getEmail())) {
//            errors.put(WebConstants.EMAIL, ErrorMessages.EMAIL_VALIDATION_EXCEPTION);
        }
        if (userDto.getFirstName() == null || userDto.getSurname() == null ||
                !matchPattern(PATTERN_FOR_NAME, userDto.getFirstName()) ||
                !matchPattern(PATTERN_FOR_NAME, userDto.getSurname())) {
//            errors.put(WebConstants.NAME, ErrorMessages.NAME_VALIDATION_EXCEPTION);
        }
//        if (userDto.getPassword() == null || !ValidatorUtil.matchPattern(PATTERN_FOR_PASSWORD, userDto.getPassword())) {
//            errors.put(WebConstants.PASSWORD, ErrorMessages.PASSWORD_VALIDATION_EXCEPTION);
//        }
//        if (!userDto.getPassword().equals(userDto.getPasswordRepeat())) {
//            errors.put(WebConstants.PASSWORD_REPEAT, ErrorMessages.PASSWORD_REPEAT_EXCEPTION);
//        }
        return errors;
    }

    private boolean matchPattern(Pattern pattern, String value) {
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }
}
