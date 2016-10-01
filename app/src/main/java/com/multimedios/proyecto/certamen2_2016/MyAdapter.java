package com.multimedios.proyecto.certamen2_2016;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by nicolas on 30-09-2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private ArrayList<Repos> mData = new ArrayList<>();

    private LayoutInflater layoutInflater;

    public MyAdapter(ArrayList<Repos> list) {
        this.mData = list;
    }

    public MyAdapter(Context context)
    {
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.fragment_list, parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Repos currentPost = mData.get(position);
        holder.texto_titulo.setText(currentPost.getTitulo());
        holder.texto_descrp.setText(currentPost.getDescripcion());
        holder.texto_fecha.setText(currentPost.getFecha_actualizacion());
    }

    @Override
    public int getItemCount() {

        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView texto_titulo;
        private TextView texto_descrp;
        private TextView texto_fecha;

        public ViewHolder(View itemView)
        {
            super(itemView);
            texto_titulo = (TextView) itemView.findViewById(R.id.editText2_titulo);
            texto_descrp = (TextView) itemView.findViewById(R.id.editText3_descripcion);
            texto_fecha = (TextView) itemView.findViewById(R.id.editText4_date);
        }
    }
}
