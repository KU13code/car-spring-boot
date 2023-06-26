package ru.car.buycar.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "images")
@Data
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "original_file_name")
    private String originalFileName;

    @Column(name = "size")
    private Long size;

    @Column(name = "content_type")
    private String contentType;

    @Lob
    @Column(name = "bytes")
    private byte[] bytes;

}
