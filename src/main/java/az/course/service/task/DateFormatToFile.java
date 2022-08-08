package az.course.service.task;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class DateFormatToFile {

    public void formatDate() {
        List<String> oldDateList = readFromFile();
        System.out.println(oldDateList);
        List<String> newDateList = dateChange(oldDateList);

        writeToFile(newDateList);
    }

    public List<String> readFromFile() {
        List<String> dateList = new ArrayList<>();
        String dateStr;
        try (var br = new BufferedReader(new FileReader("/Users/005035_mac/IdeaProjects/Course/output.txt"))) {
            while ((dateStr = br.readLine()) != null) {
                dateList.add(dateStr);
            }
        } catch (IOException e) {
            System.out.println("File oxuyarken xeta bas verdi");
            e.printStackTrace();
        }
        return dateList;
    }

    public void writeToFile(List<String> newDateList) {
        {
            try (var bufferedWriter = new BufferedWriter(new FileWriter("date.txt"))) {
                for (String newDate : newDateList) {
                    bufferedWriter.append(newDate + "\n");
                }
            } catch (IOException e) {
                System.out.println("File-a yazarken xeta bas verdi");
                e.printStackTrace();
            }
        }

    }

    List<String> dateChange(List<String> oldDateList) {
        List<String> newDateList = new ArrayList<>();
        for (String oldDate : oldDateList) {
        try {
                LocalDate localDate = LocalDate.parse(oldDate, DateTimeFormatter.ofPattern("yyyy-dd-MM"));
                newDateList.add(localDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));

        } catch (DateTimeParseException e) {
            System.out.println("Filedaki datelerin (yyyy-dd-MM) formata uygun deyil.");
            try {
                LocalDate localDate = LocalDate.parse(oldDate, DateTimeFormatter.ofPattern("yyyy/dd/MM"));
                newDateList.add(localDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
            }
            catch (DateTimeParseException ex){
            System.out.println("Filedaki datelerin (yyyy/dd/MM) formata uygun deyil.");
            e.printStackTrace();}
        } catch (Exception e) {
            System.out.println("Date change zamani xeta bas verdi");
            e.printStackTrace();
        }}
        return newDateList;
    }
}
