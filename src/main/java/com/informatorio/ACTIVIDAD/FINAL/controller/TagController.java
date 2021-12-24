package com.informatorio.ACTIVIDAD.FINAL.controller;

import com.informatorio.ACTIVIDAD.FINAL.entity.Tag;
import com.informatorio.ACTIVIDAD.FINAL.service.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/tag")
public class TagController {
    private TagsService tagsService;

    @Autowired
    public TagController(TagsService tagsService) {
        this.tagsService = tagsService;
    }

    @GetMapping
    public ResponseEntity<?> getAllTags(){
        return new ResponseEntity<>(tagsService.getTags(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createTag(@RequestBody Tag tag) {
        return new ResponseEntity<>(tagsService.createTag(tag),HttpStatus.CREATED);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<?> asignateTagToStartup(@RequestParam("id") Long id, Tag tag){
        return new ResponseEntity<>(tagsService.addTagToStartup(id, tag),HttpStatus.OK);
    }
}
