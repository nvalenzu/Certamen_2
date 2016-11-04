package com.multimedios.proyecto.certamen2_2016.Model;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.multimedios.proyecto.certamen2_2016.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by nicolas on 30-09-2016.
 */
public class ListFragment extends Activity{

    // nos permite asociarle la id del recyclerview creado en el layout
    private RecyclerView mRecyclerView;

    // se crea un adaptador para manejar los elementos de la lista
    private RecyclerView.Adapter mAdapter;

    //nos permite manejar el posicionamiento de los elementos del recycler
    private RecyclerView.LayoutManager mLayoutManager;

    private ArrayList<Repos> lista = new ArrayList<>();
    private MyAdapter adaptador;
    ProgressDialog dialog = null;

    ArrayList<Repos> lista_respos = new ArrayList<>();

    private String User;

    public static ListFragment newInstance() {
        ListFragment fragment = new ListFragment();
        return fragment;
    }


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState){

        View mainView = inflater.inflate(R.layout.fragment_list, null);

        mRecyclerView = (RecyclerView) mainView.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(mainView.getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);



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
                            Repos repo = new Repos();
                            String name = list_repos.getJSONObject(i).getString("name");
                            String descrip = list_repos.getJSONObject(i).getString("description");                            String descr = list_repos.getJSONObject(i).getString("description");
                            String fecha = list_repos.getJSONObject(i).getString("updated_at");

                            repo.setTitulo(name);
                            repo.setDescripcion(descrip);
                            repo.setFecha_actualizacion(fecha);
                            lista_respos.add(repo);
                        }

                        mAdapter = new MyAdapter(lista_respos);
                        mRecyclerView.setAdapter(mAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }
        };

        task.execute();

        return mainView;
    }

}
