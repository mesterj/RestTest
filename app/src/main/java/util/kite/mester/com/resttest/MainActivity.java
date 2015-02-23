package util.kite.mester.com.resttest;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ActionBarActivity {

    public static final String LOGTAG = "RestTest";
    TextView tvHello;
    EditText etNev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvHello = (TextView) findViewById(R.id.textView);
        etNev = (EditText) findViewById(R.id.editText);
        Button btnGreeting = (Button) findViewById(R.id.btnGreeting);


    }

    public void callRest (View v) {
        HelloRestClient.get().getGreeting(etNev.getText().toString(),new Callback<HelloResponse>() {
            @Override
            public void success(HelloResponse helloResponse, Response response) {
                tvHello.setText("Helló "  + helloResponse.getNev());
                Log.i(LOGTAG,"REST success");
            }

            @Override
            public void failure(RetrofitError error) {
                tvHello.setText("Nem kaptam üdvözletet");
            }
        });
    }

}
