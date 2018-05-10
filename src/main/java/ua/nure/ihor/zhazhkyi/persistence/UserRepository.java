package ua.nure.ihor.zhazhkyi.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.nure.ihor.zhazhkyi.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findOneByEmail(String email);

    String findPhotoById(Long id);
}
