package ua.nure.ihor.zhazhkyi.persistence;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ua.nure.ihor.zhazhkyi.entity.Glasses;

@Repository
public interface GlassesRepository extends PagingAndSortingRepository<Glasses, Long> {
}
