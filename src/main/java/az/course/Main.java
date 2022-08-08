package az.course;


import az.course.service.FileIO;
import az.course.service.task.DateFormatToFile;

public class Main {


    public static void main(String[] args) {
        //FileIO fileIO = new FileIO();
//        fileIO.readFromFile();
//        fileIO.flush();
        //fileIO.readFromFile();
        DateFormatToFile dateFormatToFile = new DateFormatToFile();
        dateFormatToFile.formatDate();
       // dateFormatToFile.writeToFile();
    }
}
