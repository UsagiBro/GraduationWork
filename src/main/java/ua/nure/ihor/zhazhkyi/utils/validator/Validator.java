package ua.nure.ihor.zhazhkyi.utils.validator;

import java.util.Objects;

public abstract class Validator<T> {

    protected abstract void validate(T object);

    protected boolean matchesPattern(String value, String pattern) {
        return Objects.nonNull(value) && value.matches(pattern);
    }
}
