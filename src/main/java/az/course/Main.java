package az.course;

import az.course.model.Student;
import az.course.repository.StudentRepository;
import az.course.repository.StudentRepositoryImpl;
import java.time.LocalDate;

public class Main {


    public static void main(String[] args) {
        StudentRepository st= new StudentRepositoryImpl();
        Student studentDb = st.getStudentById(1);
        System.out.println(studentDb);
//        studentDb.setYas(34);
//        studentDb.setDogumTarixi(LocalDate.of(1994,12,10));
//        boolean b = st.updateStudent(studentDb);
//
////        st.getAllStudent().stream().forEach(System.out::println);
//
////        Student student= new Student();
////        student.setAd("Samir");
////        student.setSoyad("Salamov");
////        student.setYas(17);
//        if(b)
//            System.out.println("telebe elave olundu");
//        else
//            System.out.println("olunmadi");

    }
}
