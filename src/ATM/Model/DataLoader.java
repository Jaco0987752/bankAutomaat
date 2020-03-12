package Model;

/**
 * DataLoader
 * https://www.baeldung.com/java-org-json
 */

import java.net.*;
import java.io.*;
import org.json.*;

public class DataLoader {

    // public static void main(String[] args) {
    //     DataLoader dl = new DataLoader();
    //     dl.loadData("");
    // }

    public static JSONObject loadData(String urlStr) {
        try {   
            URL url = new URL(urlStr);
            URLConnection urlConnection = url.openConnection();
            String str = getString(new InputStreamReader(urlConnection.getInputStream()) );
            str = "{ \"balance\":\"2\" }";// testcode
            return new JSONObject(str);     

        }catch(MalformedURLException e){
            System.out.println("malformed URL");
        } 
        catch (Exception e) {
            System.out.println(e.toString());
            System.out.println(e.getMessage());
            System.out.println("error with loading data");
        }
        return null;
    }

    private static String getString(Reader reader) throws IOException{
        int intValueOfChar;
        String targetString = "";
        while ((intValueOfChar = reader.read()) != -1) {
            targetString += (char) intValueOfChar;
        }
        reader.close();
        return targetString;
    }
}