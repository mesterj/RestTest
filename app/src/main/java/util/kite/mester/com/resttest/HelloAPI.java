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
    Greeting getGreeting(@Path("name") String Name,
                    Callback<HelloResponse> callback);
}