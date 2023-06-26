package WORK;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileClear {
    static String filename = "ВЫИГРАННЫЕ ИГРУШКИ" ;
    public static void fileClear() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(filename);
        writer.print("");
        writer.close();
    }

}
