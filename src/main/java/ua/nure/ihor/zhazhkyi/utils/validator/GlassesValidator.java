package ua.nure.ihor.zhazhkyi.utils.validator;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ua.nure.ihor.zhazhkyi.dto.glasses.GlassesDto;
import ua.nure.ihor.zhazhkyi.exception.user.UserValidationException;

@Component
@Qualifier("GlassesValidator")
public class GlassesValidator extends Validator<GlassesDto> {

    private static final String REGEX_FOR_STRING_FIELD = "([a-zA-Zа-яА-Яё]){2,64}";
    private static final String REGEX_FOR_PRICE = "\\d{2,4}";

    private static final String NAME_VALIDATION_ERROR_MESSAGE = "Such glasses name is not valid: %s";
    private static final String TYPE_VALIDATION_ERROR_MESSAGE = "Such type is not valid: %s";
    private static final String MATERIAL_VALIDATION_ERROR_MESSAGE = "Such material is not valid: %s";
    private static final String PRICE_VALIDATION_ERROR_MESSAGE = "Such price is not valid: %s";

    @Override
    public void validate(GlassesDto glassesDto) {
        if (!matchesPattern(glassesDto.getName(), REGEX_FOR_STRING_FIELD)) {
            throw new UserValidationException(String.format(NAME_VALIDATION_ERROR_MESSAGE, glassesDto.getName()));
        }
        if (!matchesPattern(glassesDto.getType(), REGEX_FOR_STRING_FIELD)) {
            throw new UserValidationException(String.format(TYPE_VALIDATION_ERROR_MESSAGE, glassesDto.getType()));
        }
        if (!matchesPattern(glassesDto.getColor(), REGEX_FOR_STRING_FIELD)) {
            throw new UserValidationException(String.format(MATERIAL_VALIDATION_ERROR_MESSAGE, glassesDto.getColor()));
        }
        if (!matchesPattern(String.valueOf(glassesDto.getPrice()), REGEX_FOR_PRICE)) {
            throw new UserValidationException(String.format(PRICE_VALIDATION_ERROR_MESSAGE, glassesDto.getPrice()));
        }
    }


}
