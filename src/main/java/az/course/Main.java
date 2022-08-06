package az.course;


import az.course.service.FileIO;

public class Main {


    public static void main(String[] args) {
        FileIO fileIO= new FileIO();
//        fileIO.readFromFile();
        fileIO.flush();

    }
}
