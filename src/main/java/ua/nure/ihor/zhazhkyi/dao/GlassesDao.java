package ua.nure.ihor.zhazhkyi.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ua.nure.ihor.zhazhkyi.entity.Glasses;

@Repository
public interface GlassesDao extends PagingAndSortingRepository<Glasses, Long> {
}
