package com.shagihan.example.eventdrivensample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SJPA_ORDER")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private User user;
    private String itemName;
    private State state;
    private LocalDate orderDate;
    private LocalDate eta;
    public enum State {
       CREATED,
       PROCESSING,
       UPDATED,
       DISPATCHED
    }

}
