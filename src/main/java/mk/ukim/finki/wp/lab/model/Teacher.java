package mk.ukim.finki.wp.lab.model;

import lombok.Data;

@Data
public class Teacher {
    private Long id;
    private String name;
    private String surnamne;

    public Teacher(Long id, String name, String surnamne) {
        this.id = id;
        this.name = name;
        this.surnamne = surnamne;
    }
}
