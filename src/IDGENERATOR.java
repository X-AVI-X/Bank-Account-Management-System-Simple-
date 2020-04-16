import java.io.*;
import java.util.Scanner;

public class IDGENERATOR
{
    static String id;
    public static int number = 1;
    public IDGENERATOR(int year, int month) {
        try {
            char num='\0';
            FileReader fr=new FileReader("num.txt");   //Creation of File Reader object
            BufferedReader br=new BufferedReader(fr);           //Creation of BufferedReader object
            int c = 0;
            while((c = br.read()) != -1) {
                num = (char) c;                                 //converting integer to char
            }
            number=(int) num;
            fr.close();

            //System.out.println("After reading num: "+number);
            id=year+"-"+month+"-"+number;
            number++;
            //System.out.println("After incrementation: "+number);
        }
        catch (FileNotFoundException e) {
            System.out.println("File no found.");
            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("Error writing num to num file.");
            e.printStackTrace();
        }
    }
    public static String ID()
    {
        return id;
    }
}
