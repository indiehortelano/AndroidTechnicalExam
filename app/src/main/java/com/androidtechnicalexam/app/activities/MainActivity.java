package com.androidtechnicalexam.app.activities;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.androidtechnicalexam.app.adapters.MyArrayAdapter;
import com.androidtechnicalexam.app.models.MyModel;
import com.androidtechnicalexam.app.retrofit.MyService;
import com.androidtechnicalexam.app.retrofit.Retrofit;

import java.util.ArrayList;

import coloryourcalendar.indie.com.androidtechnicalexam.R;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MyArrayAdapter myArrayAdapter = new MyArrayAdapter(this, new ArrayList<MyModel>());
        setListAdapter(myArrayAdapter);
        MyService myService = Retrofit.getService(MyService.class);

        myService.getUsers(new Callback<ArrayList<MyModel>>() {
            @Override
            public void success(ArrayList<MyModel> myModels, Response response) {
                myArrayAdapter.addAll(myModels);
                myArrayAdapter.notifyDataSetChanged();
                Log.i("Test", "response size: " + myModels.size());
                Toast.makeText(MainActivity.this, "successfull", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("RetrofitError", error.getMessage());
                error.printStackTrace();
                Toast.makeText(MainActivity.this, R.string.error_message, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
