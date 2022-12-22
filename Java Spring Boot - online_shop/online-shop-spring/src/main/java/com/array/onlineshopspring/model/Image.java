package com.array.onlineshopspring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Image implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id", nullable = false)
    private Integer imageId;

    @Column(name = "image_name")
    private String imageName;
	
    @Column(name = "image_type")
    private String imageType;
	
    @Lob
    private byte[] imageByte;

    @ManyToMany(mappedBy = "imageList")
    private List<Product> productList = new ArrayList<>();

    public Image(String imageName, String imageType, byte[] imageByte) {
        this.imageName = imageName;
        this.imageType = imageType;
        this.imageByte = imageByte;
    }
}
