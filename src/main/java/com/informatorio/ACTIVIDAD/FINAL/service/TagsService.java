package com.informatorio.ACTIVIDAD.FINAL.service;

import com.informatorio.ACTIVIDAD.FINAL.entity.Startup;
import com.informatorio.ACTIVIDAD.FINAL.entity.Tag;
import com.informatorio.ACTIVIDAD.FINAL.repository.StartupRepository;
import com.informatorio.ACTIVIDAD.FINAL.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagsService {
    private final TagRepository tagsRepository;
    private final StartupRepository startupRepository;

    public TagsService(TagRepository tagsRepository, StartupRepository startupRepository) {
        this.tagsRepository = tagsRepository;
        this.startupRepository = startupRepository;
    }


    public List<Tag> getTags(){
        return tagsRepository.findAll();
    }

    public Tag createTag(Tag tag){
        return tagsRepository.save(tag);
    }

    public Tag addTagToStartup(Long id,Tag tag){
        Startup startupToAddTag = startupRepository.findById(id).get();
        startupToAddTag.addTag(tag);
        return tag;
    }
}
