/**
 * Repository interface for performing CRUD operations on User entities.
 * Provides a custom query method to find user by a specific query.
 */


package com.App.Yogesh.Repository;

import com.App.Yogesh.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByEmail(String email);

    @Query("select u from User u where u.firstName LIKE %:query% OR u.lastName LIKE %:query% OR u.email LIKE %:query%")
    public List<User> searchUser(@Param("query") String query);

}
