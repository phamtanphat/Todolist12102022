package com.example.todolist;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity{

    List<Work> worksData;
    RecyclerView recyclerView;
    WorkAdapter workAdapter;
    FloatingActionButton fbaAdd;
    int REQUEST_CODE_ADD_ACTIVITY = 1;
    int currentRowId = -1;
    boolean isNewDates = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        fbaAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateAddActivity();
            }
        });
    }

    private void init(){
        recyclerView = findViewById(R.id.rcv);
        worksData = WorkUtils.getInstance().getAll();
        fbaAdd = findViewById(R.id.fab_add);
        workAdapter = new WorkAdapter(worksData, itemClickAdapter);
        recyclerView.setAdapter(workAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void navigateAddActivity(){
        startActivityForResult(new Intent(this, AddActivity.class), REQUEST_CODE_ADD_ACTIVITY);
    }

    private WorkAdapter.OnItemClickListener itemClickAdapter = new WorkAdapter.OnItemClickListener() {
        @Override
        public void onDeleteClick(int rowId, int positionView) {
            WorkUtils.getInstance().deleteWork(rowId);
            workAdapter.notifyItemRemoved(positionView);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_time:
                isNewDates = !isNewDates;
                WorkUtils.getInstance().sort(isNewDates);
                workAdapter.updateWorks(WorkUtils.getInstance().getAll());
                break;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_ADD_ACTIVITY && resultCode == RESULT_OK) {
            if (currentRowId != WorkUtils.getInstance().getRowId()) {
                workAdapter.notifyDataSetChanged();
            }
        }
    }
}
