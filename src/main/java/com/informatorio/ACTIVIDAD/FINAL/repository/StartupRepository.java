package com.informatorio.ACTIVIDAD.FINAL.repository;

import com.informatorio.ACTIVIDAD.FINAL.entity.Startup;
import com.informatorio.ACTIVIDAD.FINAL.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StartupRepository extends JpaRepository<Startup,Long> {
    List<Startup> findByPublished(boolean published);
    List<Startup> findByTags(Tag tag);
}
