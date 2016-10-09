package id.sch.smktelkom_mlg.xirpl3011.intent2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;

public class InputActivity extends AppCompatActivity {

    public static final String NAMA = "Nama";
    public static final String TAHUN_LAHIR = "TahunLahir";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        findViewById(R.id.buttonFinish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etNama = (EditText) findViewById(R.id.editText);
                EditText etTL = (EditText) findViewById(R.id.editText2);

                String nama = etNama.getText().toString();
                String TLstr = etTL.getText().toString();

                int TL = TLstr.isEmpty() ?
                        Calendar.getInstance().get(Calendar.YEAR) :
                        Integer.parseInt(TLstr);

                Intent intent = new Intent();
                intent.putExtra(NAMA,nama);
                intent.putExtra(TAHUN_LAHIR, TL);

                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
