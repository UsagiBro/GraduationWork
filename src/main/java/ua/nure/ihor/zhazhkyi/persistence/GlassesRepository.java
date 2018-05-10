package ua.nure.ihor.zhazhkyi.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ua.nure.ihor.zhazhkyi.entity.Glasses;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface GlassesRepository extends PagingAndSortingRepository<Glasses, Long> {

    Page<Glasses> findAllGlasses(Pageable pageable);
}
