package org.wuestner.models.data;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wuestner.models.Genre;

@Repository
@Transactional
public interface GenreDao extends CrudRepository<Genre, Integer> {

}
