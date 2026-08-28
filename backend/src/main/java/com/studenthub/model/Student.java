package com.studenthub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "students", indexes = { @Index(name = "idx_student_status", columnList = "status"), @Index(name = "idx_student_department", columnList = "department") })
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank private String name;
    @Email @NotBlank @Column(unique = true) private String email;
    @NotBlank private String department;
    @NotBlank @Column(name = "academic_year") private String year;
    @NotNull @Min(0) @Max(4) private Double gpa;
    @Enumerated(EnumType.STRING) private Status status = Status.ACTIVE;
    public enum Status { ACTIVE, ON_LEAVE, GRADUATED }
    public Student() {}
    public Student(String name, String email, String department, String year, Double gpa, Status status) { this.name=name; this.email=email; this.department=department; this.year=year; this.gpa=gpa; this.status=status; }
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getName(){return name;} public void setName(String v){name=v;}
    public String getEmail(){return email;} public void setEmail(String v){email=v;}
    public String getDepartment(){return department;} public void setDepartment(String v){department=v;}
    public String getYear(){return year;} public void setYear(String v){year=v;}
    public Double getGpa(){return gpa;} public void setGpa(Double v){gpa=v;}
    public Status getStatus(){return status;} public void setStatus(Status v){status=v;}
}
