package ua.genesis.sasha.retrofitumorili;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private static UmoriliApi umoriliApi;
    RecyclerView recyclerView;
    List<PostModel> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        umoriliApi=Controller.getApi();
        posts=new ArrayList<>();

        recyclerView=(RecyclerView) findViewById(R.id.posts_recycle_view);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        PostsAdapter adapter=new PostsAdapter(posts);
        recyclerView.setAdapter(adapter);


        umoriliApi.getData("new anekdot",50).enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                posts.addAll(response.body());
                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"An error occured during networking",Toast.LENGTH_SHORT).show();

            }
        });

    }
}
