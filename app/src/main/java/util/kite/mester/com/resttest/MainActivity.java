package util.kite.mester.com.resttest;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tvHello = (TextView) findViewById(R.id.textView);
        EditText etNev = (EditText) findViewById(R.id.editText);
        Button btnGreeting = (Button) findViewById(R.id.btnGreeting);

        HelloRestClient.get().getGreeting(etNev.getText().toString(),new Callback<HelloResponse>() {
            @Override
            public void success(HelloResponse helloResponse, Response response) {
                tvHello.setText(helloResponse.getGreeting());
            }

            @Override
            public void failure(RetrofitError error) {
                tvHello.setText("Nem kaptam üdvözletet");
            }
        });
    }

}
