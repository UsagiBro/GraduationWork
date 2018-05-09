package ua.nure.ihor.zhazhkyi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import ua.nure.ihor.zhazhkyi.dto.glasses.FavoriteGlassesDto;
import ua.nure.ihor.zhazhkyi.dto.glasses.FavoriteGlassesResponseDto;
import ua.nure.ihor.zhazhkyi.dto.user.UserDto;
import ua.nure.ihor.zhazhkyi.dto.user.UserResponseDto;

import java.util.List;

public interface IUserProfileController {

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    UserDto getUser(@PathVariable("id") Long userId);

    @RequestMapping(value = "", method = RequestMethod.POST)
    UserResponseDto addNewUser(@RequestBody UserDto userDto);

    @RequestMapping(value = "{id}/favoriteGlasses", method = RequestMethod.GET)
    List<FavoriteGlassesDto> getFavoriteGlasses(@PathVariable("id") Long customerId,
                                                @RequestParam("page") int page,
                                                @RequestParam("pageSize") int pageSize,
                                                @RequestParam(value = "orderBy", required = false) String orderBy,
                                                @RequestParam(value = "direction", required = false) String direction);

    @RequestMapping(value = "{id}/favoriteGlasses/{favoriteGlassesId}", method = RequestMethod.GET)
    FavoriteGlassesDto getFavouriteGlasses(@PathVariable("id") Long userId,
                                           @PathVariable("favoriteGlassesId") Long favoriteGlassesId);

    @RequestMapping(value = "{id}/favoriteGlasses", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    FavoriteGlassesResponseDto addFavoriteGlasses(@PathVariable("id") Long userId,
                                                  @RequestBody FavoriteGlassesDto favoriteGlassesDto);

    @RequestMapping(value = "{id}/favoriteGlasses/{favoriteGlassesId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteFavoriteGlasses(@PathVariable("id") Long userId,
                               @PathVariable("favoriteGlassesId") Long favoriteGlassesId);

    @RequestMapping(value = "{id}/userPhoto", method = RequestMethod.GET)
    String getUserPhoto(@PathVariable("id") Long userId);

    @RequestMapping(value = "{id}/userPhoto", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    String addCustomerCard(@PathVariable("id") Long customerId,
                           @RequestParam("file") MultipartFile file);
}
