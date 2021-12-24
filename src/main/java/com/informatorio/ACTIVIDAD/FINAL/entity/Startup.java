package com.informatorio.ACTIVIDAD.FINAL.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Startup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String content;
    @CreationTimestamp
    private LocalDate creationDate;
    private boolean published;
    private BigDecimal fundraisingGoal;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Tag> tags = new ArrayList<>();

    public void addTag(Tag tag){
        tags.add(tag);
        tag.getStartups().add(this);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public BigDecimal getFundraisingGoal() {
        return fundraisingGoal;
    }

    public void setFundraisingGoal(BigDecimal fundraisingGoal) {
        this.fundraisingGoal = fundraisingGoal;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Startup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", creationDate=" + creationDate +
                ", published=" + published +
                ", fundraisingGoal=" + fundraisingGoal +
                ", tags=" + tags +
                '}';
    }
}
