package com.implementacioneintegracion.Parcial.Event;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "Event")
@Data
public class EventService {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    @Size(min = 1, max = 30)
    private String name;
    @Column(name = "date_time")
    private Date date_time;
    @Column(name = "location")
    @Size(min = 1, max = 50)
    private String location;

}
