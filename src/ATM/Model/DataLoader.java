package Model;

/**
 * DataLoader
 */

import java.net.*;
import java.io.*;
import java.util.stream.*;
import com.google.gson.Gson;
import org.json.*;

public class DataLoader {
    protected DataLoader() {

    }

    protected static DataLoader loadData(String urlStr) { //Class<DataLoader> class1
        try {
            
            // URL url = new URL(urlStr);
            // URLConnection urlConnection = url.openConnection();
            // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            // Gson gson = new Gson();
            // var dl = gson.fromJson(bufferedReader, DataLoader.class);
            // DataLoader data = (DataLoader)dl;
            // bufferedReader.close();
            // return data;

            // String str = "";
            // JSONObject obj = new JSONObject(source)
        } catch (Exception e) {
            System.out.println("error with loading data");
        }
        return null;
    }
}