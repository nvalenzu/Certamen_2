package com.multimedios.proyecto.certamen2_2016;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.multimedios.proyecto.certamen2_2016.Model.MyAdapter;
import com.multimedios.proyecto.certamen2_2016.Model.Repos;
import com.multimedios.proyecto.certamen2_2016.Presenters.GitList;

import java.util.List;

/**
 * Created by nicolas on 31-10-2016.
 */
public class GitListActivity extends AppCompatActivity{

    private GitList mPresenter;
    private MyAdapter repoAdapter;
    private List<Repos> repoList;
    private RecyclerView recyclerView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.listview);
        Bundle b= getIntent().getExtras();
        mPresenter = new GitList(this);

        RecyclerView mRecyclerView;
        RecyclerView.Adapter mAdapter;
        RecyclerView.LayoutManager mLayoutManager;


        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

    }
}
