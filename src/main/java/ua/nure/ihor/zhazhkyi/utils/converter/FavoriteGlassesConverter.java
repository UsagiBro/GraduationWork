package ua.nure.ihor.zhazhkyi.utils.converter;

import org.springframework.stereotype.Component;
import ua.nure.ihor.zhazhkyi.dto.glasses.FavoriteGlassesDto;
import ua.nure.ihor.zhazhkyi.dto.glasses.FavoriteGlassesResponseDto;
import ua.nure.ihor.zhazhkyi.entity.FavoriteGlasses;
import ua.nure.ihor.zhazhkyi.entity.User;

@Component
public class FavoriteGlassesConverter extends AbstractConverter {

    //todo Complete this
    public FavoriteGlassesDto favoriteGlassesToFavoriteGlassesDto(FavoriteGlasses favoriteGlasses) {
        return new FavoriteGlassesDto();
    }

    public FavoriteGlassesResponseDto favoriteGlassesToFavoriteGlassesResponseDto(FavoriteGlasses favoriteGlasses,
                                                                                  User user) {
        return new FavoriteGlassesResponseDto();
    }

    public FavoriteGlasses favoriteGlassesDtoToFavoriteGlasses(FavoriteGlassesDto favoriteGlassesDto) {
        return new FavoriteGlasses();
    }
}
