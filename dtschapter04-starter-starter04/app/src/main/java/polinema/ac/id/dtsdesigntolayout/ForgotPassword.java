package polinema.ac.id.dtsdesigntolayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {

    // Deklarasi EditText
    EditText editTextEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        // Binding EditText
        editTextEmail = findViewById(R.id.edt_txt_email);
    }

    public void postSendRequest(View view) {
        // Validasi email kosong
        if(TextUtils.isEmpty(editTextEmail.getText().toString().trim())){
            Toast.makeText(this, "Email tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }
        // Validasi format email
        else if (!isValid(editTextEmail.getText().toString().trim())) {
            Toast.makeText(this,"Format Email tidak valid", Toast.LENGTH_SHORT).show();
        }else {
            Intent i = new Intent(ForgotPassword.this, ResetPassword.class);
            startActivity(i);
        }
    }

    /**
     * Email validation
     *
     * @param email : email input from editText
     * @return
     */

    public boolean isValid(CharSequence email){
        return(Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

}
