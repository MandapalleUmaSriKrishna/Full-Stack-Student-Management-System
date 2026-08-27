package com.studenthub.repository;

import com.studenthub.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("select s from Student s where lower(s.name) like lower(concat('%', :q, '%')) or lower(s.email) like lower(concat('%', :q, '%')) or lower(s.department) like lower(concat('%', :q, '%'))")
    List<Student> search(String q);
}
