package ua.nure.ihor.zhazhkyi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.nure.ihor.zhazhkyi.entity.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {

    User findOneByEmail(String email);
}
