package com.informatorio.ACTIVIDAD.FINAL.repository;

import com.informatorio.ACTIVIDAD.FINAL.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote,Long> {
}
