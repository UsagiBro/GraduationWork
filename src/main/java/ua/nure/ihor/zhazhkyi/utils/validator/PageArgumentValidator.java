package ua.nure.ihor.zhazhkyi.utils.validator;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ua.nure.ihor.zhazhkyi.entity.PageArguments;
import ua.nure.ihor.zhazhkyi.exception.PageValidationException;

@Component
@Qualifier("PageArgumentValidator")
public class PageArgumentValidator extends Validator<PageArguments> {

    private static final String PAGE_VALIDATION_ERROR = "page argument is incorrect.";
    private static final String PAGE_SIZE_VALIDATION_ERROR = "pageSize argument is incorrect.";

    @Override
    public void validate(PageArguments pageArguments) {
        if (pageArguments.getPage() < 0) {
            throw new PageValidationException(PAGE_VALIDATION_ERROR);
        }
        if (pageArguments.getPageSize() <= 0) {
            throw new PageValidationException(PAGE_SIZE_VALIDATION_ERROR);
        }
    }
}