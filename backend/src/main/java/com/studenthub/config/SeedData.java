package com.studenthub.config;

import com.studenthub.model.*; import com.studenthub.repository.*; import org.springframework.boot.CommandLineRunner; import org.springframework.context.annotation.*; import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration public class SeedData {
 @Bean CommandLineRunner seed(UserRepository users,StudentRepository students,PasswordEncoder encoder){return args->{if(users.count()==0){users.save(new AppUser("admin@campus.edu",encoder.encode("admin123"),"ADMIN"));users.save(new AppUser("staff@campus.edu",encoder.encode("staff123"),"STAFF"));}if(students.count()==0){students.save(new Student("Aarav Sharma","aarav@campus.edu","Computer Science","Senior",3.82,Student.Status.ACTIVE));students.save(new Student("Maya Patel","maya@campus.edu","Business Analytics","Junior",3.64,Student.Status.ACTIVE));students.save(new Student("Noah Williams","noah@campus.edu","Design & Media","Sophomore",3.41,Student.Status.ON_LEAVE));students.save(new Student("Sofia Garcia","sofia@campus.edu","Computer Science","Senior",3.95,Student.Status.ACTIVE));}};}
}
