package ua.com.springtest.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.springtest.entity.User;

@Repository("userDao")
@Transactional
public class UserDao extends AbstractDao<User, Long> {

}
