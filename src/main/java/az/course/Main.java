package az.course;

import az.course.model.Student;
import az.course.repository.StudentRepository;
import az.course.repository.StudentRepositoryImpl;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        StudentRepository st= new StudentRepositoryImpl();
//        boolean b = st.insertAllStudent(List.of( new Student("qwe", "asd", 16)));
//        boolean studentDb = st.deleteStudentById(3);
        System.out.println(st.addStudentWithProcedure(new Student("wxvz", "aaaaa", 9)));

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
