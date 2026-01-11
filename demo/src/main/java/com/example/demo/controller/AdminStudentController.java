package com.example.demo.controller;


import com.example.demo.dto.StudentCreateRequest;
import com.example.demo.dto.StudentResponse;
import com.example.demo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Students")
public class AdminStudentController {

    private final StudentService service;

    public AdminStudentController(StudentService service){
        this.service = service;
    }

    @PostMapping
    public StudentResponse create(@Valid @RequestBody StudentCreateRequest request){
        return service.createStudent(request);
    }

    @GetMapping
    public List<StudentResponse> getAllStudent(){
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentResponse getById(@PathVariable Long id){
        return service.getStudentById(id);
    }

    @PutMapping("/{id}")
    public StudentResponse update(@PathVariable Long id, @Valid @RequestBody StudentCreateRequest request){
        return service.updateStudent(id,request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.deleteStudent(id);
    }

}

