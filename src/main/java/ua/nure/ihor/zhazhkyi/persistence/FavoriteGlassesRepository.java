package ua.nure.ihor.zhazhkyi.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import ua.nure.ihor.zhazhkyi.entity.FavoriteGlasses;

public interface FavoriteGlassesRepository extends PagingAndSortingRepository<FavoriteGlasses, Long> {

    int deleteByIdAndUserId(Long favoriteGlassesId, Long userId);

    FavoriteGlasses findByUserIdAndId(Long userId, Long id);

    Page<FavoriteGlasses> findByUserId(Long userId, Pageable pageable);
}
