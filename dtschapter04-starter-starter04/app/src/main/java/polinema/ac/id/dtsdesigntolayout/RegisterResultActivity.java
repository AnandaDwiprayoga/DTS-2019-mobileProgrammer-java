package polinema.ac.id.dtsdesigntolayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RegisterResultActivity extends AppCompatActivity {

    // Tambahkan variabel di sini
    TextView textViewnama, textViewTtl,textViewUsername, textViewGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_result);
        // Inisialisasi variabel
        textViewnama = findViewById(R.id.tvResultNama);
        textViewTtl = findViewById(R.id.tvResultTanggalLahir);
        textViewUsername = findViewById(R.id.tvResultUsername);
        textViewGender = findViewById(R.id.tvResultJenisKelamin);

        String[] result = getIntent().getStringArrayExtra
                (RegisterActivity.key_RegisterActivity);
        textViewnama.setText(result[0]);
        textViewTtl.setText(result[2]);
        textViewUsername.setText(result[3]);
        textViewGender.setText(result[1]);
    }
}
