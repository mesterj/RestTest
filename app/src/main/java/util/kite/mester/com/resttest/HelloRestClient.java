package util.kite.mester.com.resttest;

import com.squareup.okhttp.OkHttpClient;

import retrofit.RestAdapter;
import retrofit.client.OkClient;


/**
 * Created by mester on 2015.02.12..
 */
public class HelloRestClient {

    private static HelloAPI HELLO_REST_CLIENT;
    private static String ROOT="http://192.168.86.1:8080/RestP2-1.0-SNAPSHOT/webresources/generic/";
    private static String openRoot="http://szervizserv-tabletek.rhcloud.com/RestP1-1.0-SNAPSHOT/webresources/generic/";

    static {
        setupRestClient();
    }

    private HelloRestClient() {}

    public static HelloAPI get() {
        return HELLO_REST_CLIENT;
    }

    private static void setupRestClient() {
        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(openRoot)
                .setClient(new OkClient(new OkHttpClient()))
                .setLogLevel(RestAdapter.LogLevel.FULL);

        RestAdapter restAdapter = builder.build();
        HELLO_REST_CLIENT = restAdapter.create(HelloAPI.class);
    }
}
