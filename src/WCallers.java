import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class WCallers {

    String searchCallResponse;
    String valueCallResponse;
    private String searchUrl;
    private String valueUrl;

    /**
     * @param key Create a caller that is only capable of calling value of the day with the API key
     */
    WCallers(String key) {
        this.valueUrl = "http://api.walmartlabs.com/v1/vod?format=json&apiKey=" + key;
    }

    /**
     * @param key    Create a caller that use this key
     * @param object This is the object that will be searched with this particular caller
     */
    WCallers(String key, String object) {
        this.searchUrl = "http://api.walmartlabs.com/v1/search?" +
                "query=" + object + "&format=json&apiKey=" + key;
        this.valueUrl = "http://api.walmartlabs.com/v1/vod?format=json&apiKey=" + key;
    }

    /**
     * @param args Here only for testing purposes
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    /**
     * Due to the high performance cost, we run these calls only if the user ask for them
     */
    public void doSearchCall() {

        URL url = null;

        try {
            url = new URL(searchUrl);
        } catch (MalformedURLException e) {
            System.out.println("The URL was not created right");
        }

        BufferedReader in = null;
        try {
            assert url != null;
            in = new BufferedReader(new InputStreamReader(url.openStream()));
        } catch (IOException e) {
            System.out.println("Can not reach WalMart Servers");
        }
        String temp;
        String accumulator = "";

        try {
            assert in != null;
            while ((temp = in.readLine()) != null) {
                accumulator += temp;
            }
        } catch (IOException e) {
            System.out.println("There was something wrong with the response from WalMart");
        }

        searchCallResponse = accumulator;
    }


    /**
     * Due to the high performance cost, we run these calls only if the user ask for them
     */
    public void doValueCall() {

        URL url = null;

        try {
            url = new URL(valueUrl);
        } catch (MalformedURLException e) {
            System.out.println("The URL was not created right");
        }
        assert url != null;
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(url.openStream()));
        } catch (IOException e) {
            System.out.println("Can not reach WalMart Servers");
        }

        String temp;
        String accumulator = "";

        try {
            assert in != null;
            while ((temp = in.readLine()) != null) {
                accumulator += temp;
            }
        } catch (IOException e) {
            System.out.println("There was something wrong with the response from WalMart");
        }
        valueCallResponse = accumulator;
    }
}
