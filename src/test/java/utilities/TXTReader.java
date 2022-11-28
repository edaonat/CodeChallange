package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
public class TXTReader {

    public static String readFile(String filepath) {
        String file = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            String st;
            while ((st = br.readLine()) != null) {
                file = file + st + "\n";
                System.out.println(st);

            }
        } catch (Exception e) {

        }
        return file;
    }
    public static String readFileCardId(String filepath,String cardName) {
        String file = "";
        String cardId="";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            String st;
            while ((st = br.readLine()) != null) {
                if (st.contains(cardName)) {
                    file = file + st + "\n";
                   String [] str= st.split("=");
                    cardId=str[1].trim();
                   System.out.println(cardId);
                }
            }
        } catch (Exception e) {

        }
        return cardId;
    }

}
