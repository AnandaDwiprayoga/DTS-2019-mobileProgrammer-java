package polinema.ac.id.dtsdesigntolayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class WelcomeBack extends AppCompatActivity {

    // Deklarasi variabel editTextEmail dengan tipe EditText
    EditText editTextEmail;
    // Deklarasi variabel editTextPassword dengan tipe EditText
    EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_back);

        // Binding edt_txt_email ke variabel editTextEmail
        editTextEmail = findViewById(R.id.edt_txt_email);
        // Binding edt_txt_password ke variabel editTextPassword
        editTextPassword = findViewById(R.id.edt_txt_password);

    }

    public void clickForgot(View view) {
        Intent i = new Intent(WelcomeBack.this, ForgotPassword.class);
        startActivity(i);
    }

    public void postLogin(View view) {
        // Validasi input email dan password kosong
        if(TextUtils.isEmpty(editTextEmail.getText().toString().trim()) && TextUtils.isEmpty(editTextPassword.getText().toString().trim())){
            Toast.makeText(this,"Password dan Email tidak boleh kosong",Toast.LENGTH_SHORT).show();
        }
        // Validasi input email kosong
        else if(TextUtils.isEmpty(editTextEmail.getText().toString().trim())){
            Toast.makeText(this,"Email tidak boleh kosong", Toast.LENGTH_LONG).show();
        }

        // Validasi inputan tipe email
        else if(!isValidEmail(editTextEmail.getText().toString().trim())){
            Toast.makeText(this,"Format email tidak valid", Toast.LENGTH_SHORT).show();
        }
        // Validasi password kosong
        else if(TextUtils.isEmpty(editTextPassword.getText().toString().trim())){
            Toast.makeText(this, "Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent i = new Intent(WelcomeBack.this, SuccessActivity.class);
            startActivity(i);
        }

    }

    public void clickSignUp(View view) {
        // Panggil intent sign up
        Intent i = new Intent(WelcomeBack.this, RegisterActivity.class);
        startActivity(i);
    }

    public  static boolean isValidEmail(String email){
        return (Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

}
