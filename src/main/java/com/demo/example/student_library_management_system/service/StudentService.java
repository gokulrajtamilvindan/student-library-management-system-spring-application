package com.demo.example.student_library_management_system.service;

import com.demo.example.student_library_management_system.converter.StudentConverter;
import com.demo.example.student_library_management_system.enums.CardStatus;
import com.demo.example.student_library_management_system.model.Card;
import com.demo.example.student_library_management_system.model.Student;
import com.demo.example.student_library_management_system.repository.StudentRepository;
import com.demo.example.student_library_management_system.requestdto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
          throw new RuntimeException("Student with id [" + id + "] does not exist!");
        }
    }

    public List<Student> getAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    /*
         pagination - fetching or getting the records or data in the form of pages

         page-number - the number of a page we want to see(0, 1, 2, 3, 4,...)
         page-size - total number of records in each page (fixes for all pages)

         total number of records - 28, page size - 5
         0th page - 1-5
         1st page - 6-10
         2nd page - 11-15
         3rd page - 16-20
         4th page - 21-25
         5th page - 26-28
         6th page - 0

         total number of records - 11, page size - 3
         0th page - 1-3
         1st page - 4-6
         2nd page - 7-9
         3rd page - 10-11
         4th page - 0

         sorting - ascending the records based on ascending order or descending order

         only pagination use:
            public List<Student> getAllStudentsByPage(int pageNo, int pageSize){
                List<Student> studentList = studentRepository.findAll(PageRequest.of(pageNo, pageSize)).getContent();
                return studentList;
            }

        perform pagination and sorting together:
            public List<Student> getAllStudentsByPage(int pageNo, int pageSize){
                List<Student> studentList = studentRepository.findAll(PageRequest.of(pageNo, pageSize, Sort.by("name").ascending())).getContent();
                return studentList;
            }



    */

    //pagination and sorting together
    public List<Student> getAllStudentsByPage(int pageNo, int pageSize){
        List<Student> studentList = studentRepository.findAll(PageRequest.of(pageNo, pageSize, Sort.by("name").ascending())).getContent();
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
