package id.sch.smktelkom_mlg.tugas01.xiirpl1002.projectrentalmobil;

import android.provider.MediaStore;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import id.sch.smktelkom_mlg.tugas01.xiirpl1002.projectrentalmobil.adapter.TipeAdapter;

import static id.sch.smktelkom_mlg.tugas01.xiirpl1002.projectrentalmobil.R.*;

public class MainActivity extends AppCompatActivity {

    RadioGroup rgStatus;
    Spinner spMobil, spTipe;
    TextView tvHasil,tvjk;
    Button bPinjam;
    EditText eNama, eAlamat, eJumhari;
    CheckBox ck1,ck2,ck3;
    String gender=null;

    String[][] arTipe = {{"Kijang Innova","Avanza"},{"Xenia","Ayla"},{"Jazz","Mobilio"},{"APV","Ertiga"}};
    ArrayList<String> listTipe = new ArrayList<>();
    TipeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        eNama = (EditText) findViewById(id.editTextNama);
        eAlamat = (EditText) findViewById(id.editTextAlamat);
        eJumhari = (EditText) findViewById(id.editTextJumlahHari);
        rgStatus = (RadioGroup) findViewById(R.id.radioGroupStatus);
        spMobil = (Spinner) findViewById(id.spinnerMobil);
        spTipe = (Spinner) findViewById(id.spinnerTipe);
        ck1 = (CheckBox) findViewById(id.checkBox);
        ck2 = (CheckBox) findViewById(id.checkBox2);
        ck3 = (CheckBox) findViewById(id.checkBox3);
        tvHasil = (TextView) findViewById(id.textViewHasil);
        tvjk = (TextView) findViewById(id.textView3);
        bPinjam = (Button) findViewById(id.buttonPinjam);

        findViewById(id.buttonPinjam).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
        adapter = new TipeAdapter(this, listTipe);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTipe.setAdapter(adapter);

        spMobil.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                listTipe.clear();
                listTipe.addAll(Arrays.asList(arTipe[pos]));
                adapter.setMobil((String)spMobil.getItemAtPosition(pos));
                adapter.notifyDataSetChanged();
                spTipe.setSelection(0);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void doClick() {
        if(isValid())
        {
            String nama = eNama.getText().toString();
            String alamat = eAlamat.getText().toString();
            String hari = eJumhari.getText().toString();
            String mobil = spMobil.getSelectedItem().toString();
            String tipe = spTipe.getSelectedItem().toString();
            String tambahan = "";


            if (rgStatus.getCheckedRadioButtonId() != -1) {
                RadioButton rb = (RadioButton) findViewById(rgStatus.getCheckedRadioButtonId());
                gender = rb.getText().toString();
            }
            if(gender==null)
            {
                gender = "Jenis Kelamin Belum Diisi";
            }

            if (ck1.isChecked()) tambahan +=  ck1.getText() + ", ";
            if (ck2.isChecked()) tambahan +=  ck2.getText() + ", ";
            if (ck3.isChecked()) tambahan +=  ck3.getText() + "";

            if (ck1.isChecked() || ck2.isChecked() || ck3.isChecked()) {
                tvHasil.setText("Nama Anda: " + "\n"  + nama + "\n" +
                        "Beralamat: " + "\n" + alamat + "\n" +
                        "Gender: " + "\n" + gender + "\n" +
                        "Anda memilih mobil: " + "\n" + mobil + " " + tipe + "\n" +
                        "Dengan waktu pinjam: " + "\n" + hari + " hari\n" +
                        "Dan tambahan: "+ "\n" + tambahan);
            } else {
                tvHasil.setText("Nama Anda: " + "\n" + nama + "\n" +
                        "Beralamat: " + "\n" + alamat + "\n" +
                        "Gender: " + "\n" + gender + "\n" +
                        "Anda memilih mobil: " + "\n" + mobil + " " + tipe + "\n" +
                        "Dengan waktu pinjam: "  + "\n" + hari + " hari");
            }
        }
    }

    private boolean isValid()
    {
        boolean valid = true;

        String nama = eNama.getText().toString();
        String alamat = eAlamat.getText().toString();
        String hari = eJumhari.getText().toString();

        if(nama.isEmpty())
        {
            eNama.setError("Nama belum diisi");
            valid = false;
        }
        if(alamat.isEmpty())
        {
            eAlamat.setError("Alamat belum diisi");
            valid = false;
        }
        if(hari.isEmpty())
        {
            eJumhari.setError("Jumlah hari belum diisi");
            valid = false;
        }

        return valid;
    }

}

