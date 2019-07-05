package polinema.ac.id.dtsdesigntolayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ResetPassword extends AppCompatActivity {

    // Deklarasi EditText
    EditText editTextResetCode, editTextPassword, editTextPasswordConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        // Binding EditText
        editTextResetCode = findViewById(R.id.edt_txt_code);
        editTextPassword = findViewById(R.id.edt_new_password);
        editTextPasswordConfirm = findViewById(R.id.edt_confirm_password);
    }

    public void postChangePassword(View view) {
        // Validasi kosong
        if(TextUtils.isEmpty(editTextResetCode.getText().toString().trim()) || TextUtils.isEmpty(editTextPassword.getText().toString().trim()) || TextUtils.isEmpty(editTextPasswordConfirm.getText().toString().trim())){
            Toast.makeText(this,"Inputan tidak boleh ada yang kosong", Toast.LENGTH_SHORT).show();
        }else if(editTextPassword.length() > 15 || editTextPasswordConfirm.length() > 15){
            Toast.makeText(this, "Password tidak boleh melebihi 15 karakter", Toast.LENGTH_SHORT).show();
        }
        // Cek inputan new dan confirm
        else if(!TextUtils.equals(editTextPassword.getText().toString().trim(), editTextPasswordConfirm.getText().toString().trim())){
            Toast.makeText(this, "Confirm Password harus sama", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent i = new Intent(ResetPassword.this, SuccessActivity.class);
            startActivity(i);
        }

    }
}
