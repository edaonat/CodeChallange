package utilities;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;

public class TXTWriter {
    public static void saveBoardData( HashMap<String,Object> actualData,String path) {

        try {
            FileWriter fw = new FileWriter(path, false);
            BufferedWriter bw = new BufferedWriter(fw);
            Object id=actualData.get("id");
            bw.append(id+"\n");
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void saveListData( HashMap<String,Object> data,String path) {

        try {
            FileWriter fw = new FileWriter(path, false);
            BufferedWriter bw = new BufferedWriter(fw);
            Object id=data.get("id");
            bw.append(id+"\n");
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void saveCardIds( HashMap<String,Object> cardIds,String path) {

        try {
            FileWriter fw = new FileWriter(path, true);
            BufferedWriter bw = new BufferedWriter(fw);
            Object id=cardIds.get("id");
            String name=cardIds.get("name").toString();
            bw.append(name+"="+id+"\n");
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
