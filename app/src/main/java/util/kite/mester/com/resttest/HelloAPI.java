package util.kite.mester.com.resttest;





import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by mester on 2015.02.12..
 */
public interface HelloAPI {


    @GET("/{name}")
    void getGreeting(@Path("name") String nev,
                    Callback<HelloResponse> callback);
}