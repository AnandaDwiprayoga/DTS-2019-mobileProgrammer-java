package polinema.ac.id.dtsdesigntolayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = RegisterActivity.class.getName();
    public static final String key_RegisterActivity = "Key_RegisterActivity";
    // Tambahkan variabel di sini
    EditText editTextNama, editTextUserName,editTextTtl, editTextPswd;
    RadioButton laki, peremuan;
    RadioGroup Rgender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // Inisialisasi variabel
        editTextNama = findViewById(R.id.inputNama);
        editTextUserName = findViewById(R.id.inputUser);
        editTextTtl = findViewById(R.id.inputTanggal);
        editTextPswd = findViewById(R.id.inputPassword);
        Rgender = findViewById(R.id.inputGender);

        laki = findViewById(R.id.lakilaki);
        peremuan = findViewById(R.id.perempuan);
    }

    public void clickDaftar(View view) {
        // Tambahkan kode untuk proses sign up
        String nama = editTextNama.getText().toString().trim();
        String username = editTextUserName.getText().toString().trim();
        String tanggalLahir = editTextTtl.getText().toString().trim();
        String password = editTextPswd.getText().toString().trim();
        String gender = laki.isChecked() ? "Laki-Laki" : "Perempuan";
        Log.d(TAG, "post nama : " + nama);
        Log.d(TAG, "post Username : " + username);
        Log.d(TAG, "tanggalLahir : " + tanggalLahir);
        Log.d(TAG, "password : " + password);
        Log.d(TAG, "gender : " +gender);



        Log.d(TAG, "input type " + editTextTtl.getInputType());

        if (TextUtils.isEmpty(nama) ||TextUtils.isEmpty(username) || TextUtils.isEmpty(tanggalLahir) || TextUtils.isEmpty(password) || (!laki.isChecked() && !peremuan.isChecked())) {
            Toast.makeText(this, "Inputan tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }
//        else if(editTextTtl.getInputType() != 14){
//            Toast.makeText(this, "Format tanggal yang anda masukkan salah", Toast.LENGTH_SHORT).show();
//
//        }
        else {
            Intent intent = new Intent(RegisterActivity.this, RegisterResultActivity.class);
            intent.putExtra(key_RegisterActivity, new String[]{nama, username, tanggalLahir, gender, password});
            startActivity(intent);
        }
    }
}
