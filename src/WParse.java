import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.StringTokenizer;

public class WParse {

    String searchCallResponse;
    String searchUrl;
    String dealUrl;

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    WParse(String key){
        this.dealUrl = "http://api.walmartlabs.com/v1/vod?format=json&apiKey=" + key;
    }
    WParse(String key, String object) {
        this.searchUrl = "http://api.walmartlabs.com/v1/search?" +
                "query=" + object + "&format=json&apiKey=" + key;
        this.dealUrl = "http://api.walmartlabs.com/v1/vod?format=json&apiKey=" + key;
    }
}
