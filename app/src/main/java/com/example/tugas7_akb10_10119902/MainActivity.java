package com.example.tugas7_akb10_10119902;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.tugas7_akb10_10119902.API.ApiEndPoint;
import com.example.tugas7_akb10_10119902.API.ApiService;
import com.example.tugas7_akb10_10119902.Adapter.AgentAdapter;
import com.example.tugas7_akb10_10119902.Model.AgentModel;
import com.example.tugas7_akb10_10119902.Model.ResponseModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private AgentAdapter viewAdapter;
    private List<AgentModel> mItems = new ArrayList<>();

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.recycleAgent)
    RecyclerView recyclerView;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        viewAdapter = new AgentAdapter(this, mItems);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(viewAdapter);

        loadDataAgent();
    }

    private void loadDataAgent() {
        ApiService api = ApiEndPoint.getClient().create(ApiService.class);

        Call<ResponseModel> call = api.getAgent();
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(@NonNull Call<ResponseModel> call, @NonNull Response<ResponseModel> response) {
                assert response.body() != null;
                String statusCode = response.body().getStatus();
                progressBar.setVisibility(View.GONE);

                if(statusCode.equals("200")) {
                    mItems = response.body().agentList;
                    System.out.println("Status Data " + mItems);
                    viewAdapter = new AgentAdapter(MainActivity.this, mItems);
                    recyclerView.setAdapter(viewAdapter);
                }

            }

            @Override
            public void onFailure(@NonNull Call<ResponseModel> call, @NonNull Throwable t) {
                progressBar.setVisibility(View.GONE);
                Log.e("Error", "Error msg: ", t);
                Toast.makeText(MainActivity.this, "Oops, your connection is Bad!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}