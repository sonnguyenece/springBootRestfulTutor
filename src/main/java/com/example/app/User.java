package com.example.app;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user")
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="hp")
    private int hp;

    @Column(name="stamina")
    private int stamina;
    private int atk;
    private int def;
    private int agi;
}
