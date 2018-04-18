package ua.nure.ihor.zhazhkyi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ua.nure.ihor.zhazhkyi.dto.glasses.FavoriteGlassesDto;
import ua.nure.ihor.zhazhkyi.dto.glasses.FavoriteGlassesResponseDto;
import ua.nure.ihor.zhazhkyi.dto.user.UserDto;
import ua.nure.ihor.zhazhkyi.entity.FavoriteGlasses;
import ua.nure.ihor.zhazhkyi.entity.PageArguments;
import ua.nure.ihor.zhazhkyi.entity.User;
import ua.nure.ihor.zhazhkyi.exception.user.NoItemExistsException;
import ua.nure.ihor.zhazhkyi.exception.user.NoSuchUserException;
import ua.nure.ihor.zhazhkyi.exception.user.UserAlreadyExistsException;
import ua.nure.ihor.zhazhkyi.persistence.FavoriteGlassesRepository;
import ua.nure.ihor.zhazhkyi.persistence.UserRepository;
import ua.nure.ihor.zhazhkyi.service.UserService;
import ua.nure.ihor.zhazhkyi.utils.SortingConstructor;
import ua.nure.ihor.zhazhkyi.utils.converter.FavoriteGlassesConverter;
import ua.nure.ihor.zhazhkyi.utils.converter.UserConverter;
import ua.nure.ihor.zhazhkyi.utils.validator.PageArgumentValidator;
import ua.nure.ihor.zhazhkyi.utils.validator.UserValidator;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FavoriteGlassesRepository favoriteGlassesRepository;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private FavoriteGlassesConverter favoriteGlassesConverter;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private PageArgumentValidator pageArgumentValidator;

    @Autowired
    private SortingConstructor sortingConstructor;

    @Override
    public void registerUser(UserDto userDto) {
        userValidator.validate(userDto);
        if (Objects.nonNull(userRepository.findOneByEmail(userDto.getEmail()))) {
            throw new UserAlreadyExistsException("User with such email already exists");
        }
        User user = userConverter.userDtoToUser(userDto);
        userRepository.save(user);
    }

    @Override
    public User getUser(Long userId) {
        return  Optional.ofNullable(userRepository.findOne(userId))
                .orElseThrow(() -> new NoSuchUserException("No user with such id"));
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        return Optional.ofNullable(userRepository.findOneByEmail(email))
                .filter(gotUser -> gotUser.getPassword().equals(password))
                .orElseThrow(() -> new NoSuchUserException("User with such email and password does not exist."));
    }

    @Override
    public List<FavoriteGlassesDto> getFavoriteGlasses(Long userId, int page, int
            pageSize, String orderBy, String direction) {
        pageArgumentValidator.validate(new PageArguments(page, pageSize));
        PageRequest pageRequest = new PageRequest(page, pageSize,
                sortingConstructor.getValidSort(orderBy, direction));
        Page<FavoriteGlasses> favoriteGlasses = Optional.ofNullable(favoriteGlassesRepository.
                findByUserId(userId, pageRequest)).
                filter(s -> s.getTotalElements() > 0).orElseThrow(() ->
                new NoItemExistsException("No any favorite glasses for specified user with id: " + userId + "."));
        return favoriteGlasses.getContent().stream().map(entryFavoriteGlasses ->
                favoriteGlassesConverter.favoriteGlassesToFavoriteGlassesDto(entryFavoriteGlasses)).collect(toList());
    }

    @Override
    public FavoriteGlassesDto getFavouriteGlasses(Long userId, Long favoriteGlassesId) {
        return favoriteGlassesConverter.favoriteGlassesToFavoriteGlassesDto(Optional.ofNullable(favoriteGlassesRepository
                .findByUserIdAndId(userId, favoriteGlassesId))
                .orElseThrow(() ->
                        new NoItemExistsException(
                                "No any user or favorite glasses with following ids: " + userId + " " + favoriteGlassesId + ".")));
    }

    @Override
    public FavoriteGlassesResponseDto addFavoriteGlasses(FavoriteGlassesDto favoriteGlassesDto, Long userId) {
        User user = getUser(userId);
        FavoriteGlasses favoriteGlasses = favoriteGlassesConverter.favoriteGlassesDtoToFavoriteGlasses(favoriteGlassesDto);
        favoriteGlasses.setUserId(userId);
        FavoriteGlasses savedGlasses = favoriteGlassesRepository.save(favoriteGlasses);
        return favoriteGlassesConverter.favoriteGlassesToFavoriteGlassesResponseDto(savedGlasses, user);
    }

    @Override
    public void deleteFavoriteGlasses(Long userId, Long favoriteGlassesId) {
        if (favoriteGlassesRepository.deleteByIdAndUserId(favoriteGlassesId, userId) == 0) {
            throw new NoItemExistsException("No such favorite glasses for user with id "
                    + userId + ".");
        }
    }
}
