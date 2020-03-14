package Model;

/**
 * LoginManager
 * 
 * Connects with the server of the bank using pin an cartnumber. 
 */
import org.json.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.io.*;

public class LoginManager {

    // Test method for loginManager
    public static void main(String[] args) {
        LoginManager loginManager = LoginManager.tryLogin(1, 1);
    }

    private final int acountid;
    private final String accountname;
    private final int balance;

    // Private default constructor
    private LoginManager(int acountid, String accountname, int balance) {
        this.acountid = acountid;
        this.accountname = accountname;
        this.balance = balance;
    }

    // Returns an loginManager when succeeded, else null
    public final static LoginManager tryLogin(int cardNumber, int pincode) {
        try {
            JSONObject obj = loadData("http://LAPTOP-JACO/bankautomaat/src/JSON_API/getbalance.php");
            return new LoginManager(obj.getInt("id"), obj.getString("accountname"), obj.getInt("balance"));

        } catch (Exception e) {
            System.err.println("error while initialising login");
            System.err.println(e.toString());
        }
        return null;
    }

    // Loads JSONobjest with a post request from the given url 
    private static JSONObject loadData(String urlStr) {
        try {

            URL url = new URL(urlStr);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setDoOutput(true);
            http.setRequestMethod("POST");
            byte[] out = "pin=1&cartnumber=1".getBytes(StandardCharsets.UTF_8);
            int length = out.length;

            http.setFixedLengthStreamingMode(length);
            http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            http.connect();
            try (OutputStream os = http.getOutputStream()) {
                os.write(out);
            }
            InputStream stream = http.getInputStream();
            String str = new String(stream.readAllBytes());
            System.out.println(str);
            return new JSONObject(str);

        } catch (MalformedURLException e) {
            System.out.println("malformed URL");
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println(e.getMessage());
            System.out.println("error with loading data");
        }
        return null;
    }

    // Returns balance
    public int getBalance() {
        return balance;
    }

    // returns account name 
    public String getAccountname() {
        return accountname;
    }

}