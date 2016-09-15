package id.sch.smktelkom_mlg.tugas01.xiirpl1002.projectrentalmobil.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import id.sch.smktelkom_mlg.tugas01.xiirpl1002.projectrentalmobil.R;
/**
 * Created by Vistapram on 2016-09-09.
 */
public class TipeAdapter extends ArrayAdapter<String> {

    String mMobil = "";

    public TipeAdapter(Context context, ArrayList<String> listTipe) {
        super(context, R.layout.row_spinner_tipe, listTipe);
    }

    public void setMobil(String Mobil) {
        this.mMobil = Mobil;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        return getCustomView(position,view,parent);
    }

    private View getCustomView(int position, View view, ViewGroup parent) {
        if(view == null )
            view = LayoutInflater.from(getContext())
                    .inflate(R.layout.row_spinner_tipe, parent, false);
        TextView tvTitle = (TextView) view.findViewById(R.id.textView8);
        tvTitle.setText(getItem(position).substring(0,1));
        TextView tvKota = (TextView) view.findViewById(R.id.textView9);
        tvKota.setText(getItem(position));
        TextView tvProvinsi =(TextView) view.findViewById(R.id.textView10);
        tvProvinsi.setText(mMobil);
        return view;
    }

    @Override
    public View getDropDownView(int position, View view, ViewGroup parent) {
        return getCustomView(position,view,parent);
    }
}