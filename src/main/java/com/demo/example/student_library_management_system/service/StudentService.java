package com.demo.example.student_library_management_system.service;

import com.demo.example.student_library_management_system.converter.StudentConverter;
import com.demo.example.student_library_management_system.enums.CardStatus;
import com.demo.example.student_library_management_system.model.Card;
import com.demo.example.student_library_management_system.model.Student;
import com.demo.example.student_library_management_system.repository.StudentRepository;
import com.demo.example.student_library_management_system.requestdto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String addStudent(StudentRequestDto studentRequestDto) {

        //Convert the RequestDto into the model class.
        Student student = StudentConverter.convertStudentRequestDtoToStudent(studentRequestDto);

        //whenever a student is saved, a card should be created for that student.
        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVE);
        student.setCard(card);

        card.setStudent(student);

        studentRepository.save(student);

        return "Student and Card Saved Successfully!";

    }

    public Student getStudentById(int id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return student.get();
        } else {
            return null;
        }
    }

    public List<Student> getAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    public String deleteStudentById(int id){
        studentRepository.deleteById(id);
        return "Student [" + id + "] Deleted Successfully along with its card!";
    }

    public String updateStudent(int id, StudentRequestDto studentRequestDto){
        //check if a student exists or not.
        Student student = getStudentById(id);

        if (student != null) {

            student.setName(studentRequestDto.getName());
            student.setEmail(studentRequestDto.getEmail());
            student.setMobile(studentRequestDto.getMobile());
            student.setDepartment(studentRequestDto.getDepartment());
            student.setSemester(studentRequestDto.getSemester());
            student.setGender(studentRequestDto.getGender());
            student.setDob(studentRequestDto.getDob());

            studentRepository.save(student);

            return "Student with id [" + id +"] Updated Successfully!";

        } else {

            return "Student with id [" + id + "] does not exist!";

        }
    }

}
