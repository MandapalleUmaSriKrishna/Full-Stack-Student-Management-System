package com.studenthub.controller;

import com.studenthub.model.Student; import com.studenthub.repository.StudentRepository; import jakarta.validation.Valid; import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/api/students")
public class StudentController {
    private final StudentRepository students; public StudentController(StudentRepository students){this.students=students;}
    @GetMapping public List<Student> all(@RequestParam(required=false,defaultValue="") String search){return search.isBlank()?students.findAll():students.search(search);}
    @PostMapping public ResponseEntity<Student> create(@Valid @RequestBody Student student){return ResponseEntity.status(HttpStatus.CREATED).body(students.save(student));}
    @PutMapping("/{id}") public Student update(@PathVariable Long id,@Valid @RequestBody Student input){Student s=students.findById(id).orElseThrow(); s.setName(input.getName());s.setEmail(input.getEmail());s.setDepartment(input.getDepartment());s.setYear(input.getYear());s.setGpa(input.getGpa());s.setStatus(input.getStatus());return students.save(s);}
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id){students.deleteById(id);return ResponseEntity.noContent().build();}
}
