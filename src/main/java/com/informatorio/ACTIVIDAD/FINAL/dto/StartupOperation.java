package com.informatorio.ACTIVIDAD.FINAL.dto;

import com.informatorio.ACTIVIDAD.FINAL.entity.Tag;

public class StartupOperation {
    private Long idStartup;
    private Tag name;

    public StartupOperation(){}

    public StartupOperation(Long idStartup, Tag name) {
        this.idStartup = idStartup;
        this.name = name;
    }

    public Long getIdStartup() {
        return idStartup;
    }

    public void setIdStartup(Long idStartup) {
        this.idStartup = idStartup;
    }

    public Tag getTag() {
        return name;
    }

    public void setName(Tag name) {
        this.name = name;
    }
}
