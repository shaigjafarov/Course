package az.course.service;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;

public class FileIO {

    public void writeToFile(String str) {

        try (FileWriter fw = new FileWriter("output.txt", true)) {
            fw.write(str);
            Writer as = fw.append("AS");
            System.out.println(as.toString());
            fw.flush();
            Writer w = fw.append("W");
            System.out.println("Writing successful");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void readFromFile() {
//        char[] array = new char[100];
//        byte[] array = new byte[100];

        try (var fw = new BufferedReader(new FileReader("output.txt"), 1)) {

            String line;
            while ((line = fw.readLine()) != null) {

                System.out.println(line);
            }

//            System.out.println( fw.getEncoding());
//           fw.read(array);
//            for (char a:array
//                 ) {
//                System.out.println(a);

                   }
         catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readData() {
        try(var is = new BufferedInputStream(new FileInputStream("output.txt"))) {
            System.out.println((char) is.read()); // L
            if (is.markSupported()) {
                System.out.println("mark  support");
                is.mark(100); // Marks up to 100 bytes
                 System.out.println((char) is.read()); // I
                long skip = is.skip(5);
                System.out.println((char) is.read()); // O
                System.out.println((char) is.read()); // O
                System.out.println((char) is.read()); // O
                is.reset(); // Resets stream to position before I
            }

            System.out.println((char) is.read());
            System.out.println((char) is.read());
            System.out.println((char) is.read());
        }catch (Exception e){
            e.printStackTrace();
        }
        }


        public void flush() {
        try(var is =new FileOutputStream("output.txt")) {
                for(int i=0; i<1000; i++) {
                    is.write((char) i);
                    if(i % 100 == 0) {
                        is.flush(); }
                }
        }catch (Exception e){
            e.printStackTrace();
        }
        }


}