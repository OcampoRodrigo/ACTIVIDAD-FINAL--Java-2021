package com.informatorio.ACTIVIDAD.FINAL.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "¡ El tag no puede estar vacio! ")
    private String name;
    @ManyToMany(mappedBy = "tags")
    private List<Startup> startups = new ArrayList<>();
    @JsonIgnore
    public List<Startup> getStartups() {
        return startups;
    }

    public void setStartups(List<Startup> startups) {
        this.startups = startups;
    }

    public Tag(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tag(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startups=" + startups +
                '}';
    }
}
