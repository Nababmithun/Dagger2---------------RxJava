package com.example.dagger2____app.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.dagger2____app.Adapter.SongAdapter;
import com.example.dagger2____app.Model.Songs;
import com.example.dagger2____app.MyApp.CustomApplication;
import com.example.dagger2____app.Network.RetrofitNetworkInterface;
import com.example.dagger2____app.R;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView gridRecycler;
    @Inject
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridRecycler = findViewById(R.id.song_list);
        GridLayoutManager mGrid = new GridLayoutManager(MainActivity.this, 2);
        gridRecycler.setLayoutManager(mGrid);
        gridRecycler.setHasFixedSize(true);

        ((CustomApplication) getApplication()).getNetworkComponent().inject(MainActivity.this);

        RetrofitNetworkInterface mService = retrofit.create(RetrofitNetworkInterface.class);
        Call<List<Songs>> mSong = mService.allSongs();
        mSong.enqueue(new Callback<List<Songs>>() {
            @Override
            public void onResponse(Call<List<Songs>> call, Response<List<Songs>> response) {
                Log.d(TAG, "Result " + response.body().size());
                SongAdapter mAdapter = new SongAdapter(MainActivity.this, response.body());
                gridRecycler.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<Songs>> call, Throwable t) {
                Log.d(TAG, "Display error code " + t.toString());
            }
        });
    }

}
