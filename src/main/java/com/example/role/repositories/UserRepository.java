package com.example.role.repositories;

import com.example.role.models.Project;
import com.example.role.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Nov 27, 2020
 */
public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "select * from USERS " +
            "where username=:username "
            , nativeQuery = true)
    public User getUserByUsername1(@Param("username") String username);

    @Query(value = "select * from USERS " +
            "where id=:id "
            , nativeQuery = true)
    User findAllValid(@Param("id") Long id);
}
