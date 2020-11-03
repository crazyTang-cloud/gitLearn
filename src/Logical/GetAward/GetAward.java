package Logical.GetAward;

import com.sun.org.apache.xml.internal.resolver.helpers.FileURL;
import sun.net.www.protocol.jar.URLJarFile;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class GetAward {
    InputStreamReader in = new InputStreamReader(System.in);

    //String filepath = ;
    public String get(int n) {
//        String str = new String();
//        try {
//            BufferedReader br = new BufferedReader(new FileReader(filepath));
//            while((str= br.readLine())!=null&&n>1){
//                n--;
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String str = new String();
        try {
            InputStream inputStream = this.getClass().getResourceAsStream("/award/awards.txt");
            Scanner s = new Scanner(inputStream);
            str = new String();
            while(n>0&&s.hasNext()){
                str = s.nextLine();
                n--;
            }
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
}
