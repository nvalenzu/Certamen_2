package com.multimedios.proyecto.certamen2_2016.Presenters;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import com.multimedios.proyecto.certamen2_2016.GitListActivity;
import com.multimedios.proyecto.certamen2_2016.Model.HttpServerConnection;
import com.multimedios.proyecto.certamen2_2016.Model.MyAdapter;
import com.multimedios.proyecto.certamen2_2016.Model.Repos;
import com.multimedios.proyecto.certamen2_2016.Presenters.contract.GitListInt;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicolas on 31-10-2016.
 */
public class GitList implements GitListInt {

    private GitListActivity mActivity;
    private List<Repos> lista_repos;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView mRecyclerView;

    public GitList(GitListActivity gitListActivity) {

        mActivity = gitListActivity;
        lista_repos = new ArrayList<>();
    }


    @Override
    public void showInfo() {

        AsyncTask<Void, Void, String> task = new AsyncTask<Void, Void, String>() {

            @Override
            protected void onPreExecute(){
                super.onPreExecute();
            }

            @Override
            protected String doInBackground(Void... params) {

                String resultado = new HttpServerConnection().connectToServer(
                        "http://www.mocky.io/v2/57eee3822600009324111202", 5000);
                return resultado;
            }

            @Override
            protected void onPostExecute(String resultado) {
                if(resultado != null){
                    try {
                        JSONArray list_repos = new JSONArray(resultado);

                        for(int i = 0; i < list_repos.length(); i++)
                        {

                            String name = list_repos.getJSONObject(i).getString("name");
                            String descrip = list_repos.getJSONObject(i).getString("description");
                            String fecha = list_repos.getJSONObject(i).getString("updated_at");
                            Repos repo = new Repos(name, descrip, fecha);

                            lista_repos.add(repo);
                        }

                        mAdapter = new MyAdapter(lista_repos);
                        mRecyclerView.setAdapter(mAdapter);



                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }
        };

        task.execute();
    }

}


