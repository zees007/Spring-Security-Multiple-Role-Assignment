package com.example.role.repositories;

import com.example.role.models.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Nov 27, 2020
 */
public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Query(value = "select * from PROJECTS " +
            "where id=:id "
            , nativeQuery = true)
    Project findAllValid(@Param("id") Long id);

    @Query(value = "select * from PROJECTS "+
            "ORDER by id asc", nativeQuery = true)
    List<Project> findByValidSortedCreated();
}
