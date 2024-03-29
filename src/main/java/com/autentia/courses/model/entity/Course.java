package com.autentia.courses.model.entity;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course")
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "level")
    private String level;
    @Column(name = "hours")
    private Integer hours;
    @Lob
    @Column(name = "fileURL")
    private String fileURL;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "course_professor",
            joinColumns = @JoinColumn(name="course_id"),inverseJoinColumns = @JoinColumn(name="professor_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"course_id","professor_id"})})
    private Professor professor;


    public Course(String title,Boolean active, String level, Integer hours, Professor professorDummy,String fileURL,Professor professor) {
        this.title = title;
        this.active = active;
        this.level = level;
        this.hours = hours;
        this.professor = professorDummy;
        this.fileURL = fileURL;
        this.professor = professor;
    }


}
