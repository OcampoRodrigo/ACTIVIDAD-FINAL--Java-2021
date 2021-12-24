package com.informatorio.ACTIVIDAD.FINAL.repository;

import com.informatorio.ACTIVIDAD.FINAL.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findByCreationDateAfter(LocalDateTime creationDate);
    List<User> findByCity(String city);
}
