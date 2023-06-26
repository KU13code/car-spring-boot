package ru.car.buycar.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="cars")
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, unique = true)
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "ls")
    private int ls;

    @Column(name = "toplivo")
    private String toplivo;

    @Column(name = "price")
    private int price;

    @JoinColumn(name = "image_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Image image;


    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
