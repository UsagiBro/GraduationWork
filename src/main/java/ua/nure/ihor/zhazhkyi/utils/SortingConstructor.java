package ua.nure.ihor.zhazhkyi.utils;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

@Component
public class SortingConstructor {
    public Sort getValidSort(final String orderBy, final String direction) {
//        if (Objects.nonNull(direction)) {
//            if (Arrays.stream(FavoritePlaceSearchFields.values()).noneMatch(e -> e.getUiField().equals(orderBy)))
//                throw new CustomerServiceValidationException("No such sort field.");
//        }
//        String validOrderBy = String.valueOf(Arrays.stream(FavoritePlaceSearchFields.values())
//                .filter(element -> element.getUiField().equals(orderBy))
//                .findAny()
//                .orElse(FavoritePlaceSearchFields.CREATION_DATE).getUiField());
//        String validDirection = String.valueOf(Arrays.stream(SortDirection.values())
//                .filter(element -> element.name().equalsIgnoreCase(direction))
//                .findAny()
//                .orElse(SortDirection.DESC));
        return new Sort(Sort.Direction.valueOf("validDirection"), "validOrderBy");
    }
}
