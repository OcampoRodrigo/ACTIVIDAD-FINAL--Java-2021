package com.informatorio.ACTIVIDAD.FINAL.entity;

import com.informatorio.ACTIVIDAD.FINAL.clasif.eventState;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String details;
    @CreationTimestamp
    private LocalDate creationDate;
    private String deadline;
    private eventState eventState;
    private BigDecimal prize;
}
