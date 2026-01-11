package com.example.demo.service;

import com.example.demo.dto.StudentCreateRequest;
import com.example.demo.dto.StudentResponse;
import com.example.demo.entity.Student;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository){
        this.repository = repository;
    }

    public StudentResponse createStudent(StudentCreateRequest request){
        Student student = new Student();
        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setAge(request.getAge());
        student.setCourse(request.getCourse());

        Student saved = repository.save(student);

        return new StudentResponse(
                saved.getId(),
                saved.getName(),
                saved.getEmail(),
                saved.getAge(),
                saved.getCourse()
        );
    }

public List<StudentResponse> getAllStudents(){
       return repository.findAll()
                .stream()
                .map(s -> new StudentResponse(
                        s.getId(),
                        s.getName(),
                        s.getAge(),
                        s.getEmail(),
                        s.getCourse()
                ))
                .toList();

}

public StudentResponse getStudentById(Long id){
      Student student =  repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student Not Found"));
        return new StudentResponse(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getAge(),
                student.getCourse()
        );

}
public StudentResponse updateStudent(Long id, StudentCreateRequest request){
        Student student = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student Not Found"));

        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setAge(request.getAge());
        student.setCourse(request.getCourse());

        Student updated = repository.save(student);

        return new StudentResponse(
                updated.getId(),
                updated.getName(),
                updated.getEmail(),
                updated.getAge(),
                updated.getCourse()
        );

}

public void deleteStudent(Long id) {
    Student student = repository.findById(id)
            .orElseThrow(()-> new StudentNotFoundException("Student Not Found"));
    repository.deleteById(id);
}

}
