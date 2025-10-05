package IO;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

public class Sample{


    public static void reader() throws IOException{
        BufferedReader reader=new BufferedReader(new FileReader("/Users/vengatesh-24414/learnings/IO/Data.txt"));
        String line;
        while ((line=reader.readLine())!=null) {
            System.out.println(line);
        }
        reader.close();
    }
    public static List<String> readAllLines() throws IOException{
        List<String> lines=Files.readAllLines(Paths.get("/Users/vengatesh-24414/learnings/IO/Data.txt"));
        return lines;
    }
    public static void main(String[] args) throws IOException{
        writer(readAllLines());
        copy("/Users/vengatesh-24414/learnings/IO/Output.txt", "/Users/vengatesh-24414/learnings/IO/Copy.txt");
       // delete("/Users/vengatesh-24414/learnings/IO/Output.txt"); // delete
    }

    public static void writer(List<String> input) throws IOException{
        BufferedWriter writer=new BufferedWriter(new FileWriter("/Users/vengatesh-24414/learnings/IO/Output.txt"));
        for(String line:input){
            writer.write(line);
            writer.newLine();
        }
        writer.close();
    }

    public static void delete(String path) throws IOException{
        Files.deleteIfExists(Paths.get(path));
    }

    public static void copy(String source, String destination) throws IOException{
        Path src=Paths.get(source);
        Path dest=Paths.get(destination);
        Files.copy(src,dest,StandardCopyOption.REPLACE_EXISTING);
    }
}
