package br.edu.fateczl.numeros;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    /*
     *@author:<JOÃO VITOR LIMA COSTA>
     */

    private EditText etN;
    private TextView tvC;
    private TextView tvD;
    private TextView tvU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etN = findViewById(R.id.etN);
        etN.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);

        tvC = findViewById(R.id.tvC);
        tvC.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);

        tvC = findViewById(R.id.tvC);
        tvC.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);

        tvD = findViewById(R.id.tvD);
        tvD.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);

        tvU = findViewById(R.id.tvU);
        tvU.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);

        Button btEx = findViewById(R.id.btEx);
        btEx.setOnClickListener(op -> separar());

    }

    private void separar(){
        int n = Integer.parseInt(etN.getText().toString());
        if(n < 100 || n > 999){
            tvC.setText(R.string.erro);
            tvD.setText("");
            tvU.setText("");
        } else {
            int centena = (int)(n / 100);
            int dezena = (int)((n % 100)/10);
            int unidade = (int)((n % 10));

            String resC = getString(R.string.centena) + " = " + centena;
            String resD = getString(R.string.dezena) + " = " + dezena;
            String resU = getString(R.string.unidade) + " = " + unidade;

            tvC.setText(resC);
            tvD.setText(resD);
            tvU.setText(resU);
        }
    }
}