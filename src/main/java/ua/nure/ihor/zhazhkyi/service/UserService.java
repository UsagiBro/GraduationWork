package ua.nure.ihor.zhazhkyi.service;

import org.springframework.stereotype.Service;
import ua.nure.ihor.zhazhkyi.dto.glasses.FavoriteGlassesDto;
import ua.nure.ihor.zhazhkyi.dto.glasses.FavoriteGlassesResponseDto;
import ua.nure.ihor.zhazhkyi.dto.user.UserDto;
import ua.nure.ihor.zhazhkyi.entity.User;

import java.util.List;

@Service
public interface UserService {

    void registerUser(UserDto userDto);

    User getUser(Long userId);

    User getUserByEmailAndPassword(String email, String password);

    List<FavoriteGlassesDto> getFavoriteGlasses(Long userId, int page, int
            pageSize, String orderBy, String direction);

    FavoriteGlassesDto getFavouriteGlasses(Long userId, Long favoriteGlassesId);

    FavoriteGlassesResponseDto addFavoriteGlasses(FavoriteGlassesDto favoriteGlassesDto, Long userId);

    void deleteFavoriteGlasses(Long userId, Long favoriteGlassesId);
}
