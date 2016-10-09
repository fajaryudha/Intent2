package id.sch.smktelkom_mlg.xirpl3011.intent2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.buttonInput).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivityForResult(new Intent(MainActivity.this, InputActivity.class),REQUEST_CODE);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            if (requestCode == RESULT_OK){
                String nama = data.getStringExtra(InputActivity.NAMA);
                int TL = data.getIntExtra(InputActivity.TAHUN_LAHIR,0);

                TextView tvBio = (TextView) findViewById(R.id.textViewBiodata);
                tvBio.setText("Nama\t\t\t\t: "+ nama + "\nTahun Kelahiran \t"+TL);
            }
        }
    }
}
