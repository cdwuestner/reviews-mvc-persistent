package org.wuestner.models.data;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wuestner.models.Movie;

@Repository
@Transactional
public interface MovieDao extends CrudRepository<Movie, Integer> {

}