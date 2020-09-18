package com.example.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<User,Long> {
    @Query("SELECT u FROM User u WHERE u.def = :def")
    List<User> findUserByDefQuery(@Param("def") Integer def);

//    @Query(nativeQuery=true,value = "SELECT * FROM User WHERE def = ?")
//    List<User> findUserByDefQuery(Long def);

}
