package com.informatorio.ACTIVIDAD.FINAL.service;

import com.informatorio.ACTIVIDAD.FINAL.dto.StartupOperation;
import com.informatorio.ACTIVIDAD.FINAL.entity.Startup;
import com.informatorio.ACTIVIDAD.FINAL.entity.Tag;
import com.informatorio.ACTIVIDAD.FINAL.repository.StartupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StartupService {
    private final StartupRepository startupRepository;
    @Autowired
    public StartupService(StartupRepository startupRepository) {
        this.startupRepository = startupRepository;
    }

    public Startup addNewStartup(Startup startup){
        return startupRepository.save(startup);
    }

    public List<Startup> getStartups(){
        return startupRepository.findAll();
    }

    public void deleteStartup(Long id){
        startupRepository.deleteById(id);
    }
    public Startup updateStartup(Startup startup, Long id){
        Startup previousStartup = startupRepository.findById(id).get();
        previousStartup.setName(startup.getName());
        previousStartup.setDescription(startup.getDescription());
        previousStartup.setContent(startup.getContent());
        previousStartup.setFundraisingGoal(startup.getFundraisingGoal());
        return startupRepository.save(previousStartup);
    }

    public List<Startup> findByPublished(boolean published){
               List<Startup> notPublishedStartups = startupRepository.findByPublished(published);
        return notPublishedStartups;
    }

    public List<Startup> findByTag(Tag tag){
        List<Startup> startupsByTag = startupRepository.findByTags(tag);
        return startupsByTag;
    }

    public Startup addTagToStartup(StartupOperation startupOperation){
        Startup StartupToAddTag = startupRepository.findById(startupOperation.getIdStartup()).get();
        StartupToAddTag.addTag(startupOperation.getTag());
        return  StartupToAddTag;
    }
}
