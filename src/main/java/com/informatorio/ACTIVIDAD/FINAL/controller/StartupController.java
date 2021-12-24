package com.informatorio.ACTIVIDAD.FINAL.controller;

import com.informatorio.ACTIVIDAD.FINAL.dto.StartupOperation;
import com.informatorio.ACTIVIDAD.FINAL.entity.Startup;
import com.informatorio.ACTIVIDAD.FINAL.entity.Tag;
import com.informatorio.ACTIVIDAD.FINAL.service.StartupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/startup")
public class StartupController {
    private final StartupService startupService;

    public StartupController(StartupService startupService) {
        this.startupService = startupService;
    }
    @GetMapping
    public ResponseEntity<?> getAllStartups(@RequestParam(required = false) boolean published){
        if (published==false){
            return new ResponseEntity<>(startupService.findByPublished(published),HttpStatus.OK);
        }
        return new ResponseEntity<>(startupService.getStartups(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> registerNewStartup(@RequestBody Startup startup){
        return new ResponseEntity<>(startupService.addNewStartup(startup), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteStartup(@PathVariable Long id){
        startupService.deleteStartup(id);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> modifyStartup(@PathVariable Long id ,@RequestBody Startup startup){
        Startup modifiedStartup = startupService.updateStartup(startup,id);
        return new ResponseEntity<>(modifiedStartup, HttpStatus.ACCEPTED);
    }




}
