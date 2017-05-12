package org.wuestner.models.data;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wuestner.models.User;

@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Integer> {

}
