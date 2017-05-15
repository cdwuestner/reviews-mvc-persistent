package org.wuestner.models.data;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wuestner.models.Director;

@Repository
@Transactional
public interface DirectorDao extends CrudRepository<Director, Integer> {

}
