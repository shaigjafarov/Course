package az.course.repository;

import az.course.config.DBConfig;
import az.course.model.Student;
import az.course.util.DateChange;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {

    @Override
    public List<Student> getAllStudent() {
        Connection connection = null;
        try {
            List<Student> studentList = new ArrayList<>();
            String sql = "SELECT id, name ,surname, age ,create_date FROM course.student";
            connection = DBConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
//                LocalDate create_date = LocalDate.parse(rs.getString("create_date"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                Student student = new Student(rs.getInt(1), rs.getString(2), rs.getString("surname"), rs.getInt(4), DateChange.dateToLocal(rs.getDate(5)));
                studentList.add(student);
            }
            DBConfig.closeConnection(connection);
            return studentList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    @Override
    public boolean addStudent(Student student) {
        Connection connection = null;
        try {
            String sql = "insert into course.student (name,surname,age) values(?,?,?)";
            connection = DBConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getAd());
            preparedStatement.setString(2, student.getSoyad());
            preparedStatement.setInt(3, student.getYas());
            int i = preparedStatement.executeUpdate();
            DBConfig.closeConnection(connection);
            if (i > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateStudent(Student student) {
        Connection connection = null;
        try {
            String sql = "update  course.student set name= ? , surname=? ,age = ?, create_date= ? where id=?";
            connection = DBConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getAd());
            preparedStatement.setString(2, student.getSoyad());
            preparedStatement.setInt(3, student.getYas());
            preparedStatement.setDate(4, java.sql.Date.valueOf(student.getDogumTarixi()));
            preparedStatement.setInt(5, student.getId());
            int i = preparedStatement.executeUpdate();
            DBConfig.closeConnection(connection);
            if (i > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Student getStudentById(Integer id) {
        Connection connection = null;
        try {
            Student student = null;
            String sql = "SELECT id, name ,surname, age ,create_date FROM course.student where id=?";
            connection = DBConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                student = new Student(rs.getInt(1), rs.getString(2), rs.getString("surname"), rs.getInt(4), DateChange.dateToLocal(rs.getDate(5)));
            }
            DBConfig.closeConnection(connection);
            return student;
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    @Override
    public boolean deleteStudentById(Integer id) {
        Connection connection = null;
        try {
            String sql = "delete  from  course.student where   id=?";
            connection = DBConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int i = preparedStatement.executeUpdate();
            DBConfig.closeConnection(connection);
            if (i > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean insertAllStudent(List<Student> studentList) {
        Connection connection = null;
        try {
            String sql = "insert into course.student (name,surname,age) values(?,?,?)";
            connection = DBConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            for (Student student : studentList) {
                preparedStatement.setString(1, student.getAd());
                preparedStatement.setString(2, student.getSoyad());
                preparedStatement.setInt(3, student.getYas());
                preparedStatement.addBatch();
            }
            int[] result = preparedStatement.executeBatch();
            DBConfig.closeConnection(connection);
            if (result.length > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addStudentWithProcedure(Student student) {

//         var sql = "{call read_names_by_letter(?)}";
//         26: try (var cs = conn.prepareCall(sql)) {

//cs.setString("prefix", "Z");
        Connection connection = null;
        try {
            connection = DBConfig.getConnection();
            CallableStatement cstmt = connection.prepareCall("{? = call course.updatest(?)}");

            cstmt.registerOutParameter(1, Types.JAVA_OBJECT);
            cstmt.setInt(2, 3);
            cstmt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
