package ua.nure.ihor.zhazhkyi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.nure.ihor.zhazhkyi.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findOneByEmail(String email);
}
