package com.example.new_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    String L = "my_logs";
//to do !!!SINGLETON!!!!!!

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button);
        final TextView t1 = (TextView) findViewById(R.id.editText2);
        final TextView txt = findViewById(R.id.textView);

        Log.d("my_logs", "i'm here!!!!");



        btn.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       try {
                                           NetService nt = new NetService();
                                           Call<List<User>> msg = nt
                                                   .getMsgApi()
                                                   .messages(Integer.parseInt(t1.getText().toString()));

                                           Log.d("my_logs", "i'm h!!!!");
                                           msg.enqueue(new Callback<List<User>>() {
                                               @Override
                                               public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                                                   Log.d("my_logs", "in responce");
                                                   Log.d(L, response.isSuccessful() + "");
                                                   if (response.isSuccessful()) {
                                                       //Log.d("my_logs", response.body().get(0).getFirstName() + " - responce");
                                                       txt.setText(response.body().get(0).toString());
                                                       //txt.setText(response.body().toString());
                                                   }
                                                   else {
                                                       Log.d("my_logs", "unsuccessfully _ " + response.message());
                                                       Log.d(L, "code = " + response.code());
                                                       Log.d("my_logs", response.errorBody().toString());
                                                   }
                                               }

                                               @Override
                                               public void onFailure(Call<List<User>> call, Throwable t) {
                                                   Log.d("my_logs", "fail - " + t.toString());
                                               }
                                           });
                                       } catch (Exception e) {
                                           Log.d("my_logs", e.toString());
                                       }
                                   }

                               }
        );



    }
}
