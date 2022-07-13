package com.app.movie.model.movie;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@Table(name = "oscar_won_list")
public class OscarWonList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "year")
    @NotBlank
    private int year;

    @Column(name = "category")
    @NotBlank
    @Size(min = 3, max = 100)
    private String category;

    @Column(name = "nominee")
    @NotBlank
    @Size(min = 3, max = 100)
    private String nominee;

    @Column(name = "won")
    @NotBlank
    @Size(min = 1, max = 10)
    private String won;


}
