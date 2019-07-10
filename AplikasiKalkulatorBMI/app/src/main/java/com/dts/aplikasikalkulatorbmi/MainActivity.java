package com.dts.aplikasikalkulatorbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.dts.aplikasikalkulatorbmi.models.Info;

public class MainActivity extends AppCompatActivity {

    private EditText tinggi,bobot,umur;
    private RadioGroup rgGender;
    private RadioButton rdGender;


    int tampilBerat, tampilTinggi, tampilUmur;
    public static final String key_MainActivity = "key_MainActivity" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tinggi = (EditText) findViewById(R.id.inputTinggi);
        bobot = (EditText) findViewById(R.id.inputBobot);
        umur = (EditText) findViewById(R.id.inputUmur);

        rgGender= (RadioGroup) findViewById(R.id.buttonGender);



    }

    public void tmbBerat(View view) {
        tampilBerat = tampilBerat + 1;
        displayBerat(tampilBerat);
    }

    public void krgBerat(View view) {
        if(tampilBerat > 0){
            tampilBerat-= 1;
        }
        displayBerat(tampilBerat);
    }

    public void krgTinggi(View view) {
        if(tampilTinggi > 0){
            tampilTinggi-= 1;
        }
        displayTinggi(tampilTinggi);
    }

    public void tmbTinggi(View view) {
        tampilTinggi+=1;
        displayTinggi(tampilTinggi);
    }

    public void tmbUmur(View view) {
        tampilUmur+=1;
        displayUmur(tampilUmur);
    }

    public void krgUmur(View view) {
        if(tampilUmur > 0){
            tampilUmur-= 1;
        }
        displayUmur(tampilUmur);
    }

    public void displayBerat(int number){
        EditText inputBerat = (EditText) findViewById(R.id.inputBobot);
        inputBerat.setText("" + number);
    }

    public void displayTinggi(int number){
        EditText inputTinggi = (EditText) findViewById(R.id.inputTinggi);
        inputTinggi.setText("" + number);
    }

    public void displayUmur(int number){
        EditText inputUmur = (EditText) findViewById(R.id.inputUmur);
        inputUmur.setText("" + number);
    }

    public void calculateBMI(View view) {
        String tinggiStr = tinggi.getText().toString();
        String bobotStr = bobot.getText().toString();

        if(tinggiStr != null && !"".equals(tinggiStr) && bobotStr != null && !"".equals(bobotStr)){
            float tinggiValue = Float.parseFloat(tinggiStr)/100;
            float bobotValue = Float.parseFloat(bobotStr);

            float bmi = bobotValue/ (tinggiValue*tinggiValue);

            displayBMI(bmi);
        }
    }

    private void displayBMI(float bmi) {
        String bmiLabel = "";
        String infoUmur = umur.getText().toString();

        if(Float.compare(bmi, 15f) <= 0){
            bmiLabel = getString(R.string.terlalu_sangat_kurus);
        }else if(Float.compare(bmi, 15f) > 0 && Float.compare(bmi, 16f) <= 0){
            bmiLabel = getString(R.string.sangat_kurus);
        }else if(Float.compare(bmi,16f) > 0 && Float.compare(bmi, 18.5f) <= 0){
            bmiLabel = getString(R.string.kurus);
        }else if(Float.compare(bmi, 18.5f) > 0 && Float.compare(bmi, 25f) <= 0){
            bmiLabel = getString(R.string.normal);
        }else if(Float.compare(bmi,25f) > 0 && Float.compare(bmi,30f) <=0 ){
            bmiLabel = getString(R.string.gemuk);
        }else if(Float.compare(bmi, 30f) > 0 && Float.compare(bmi, 35f) <= 0){
            bmiLabel = getString(R.string.cukup_gemuk);
        }else if(Float.compare(bmi, 35f) > 0 && Float.compare(bmi, 40f) <= 0) {
            bmiLabel = getString(R.string.sangat_gemuk);
        }else{
            bmiLabel = getString(R.string.terlalu_sangat_gemuk);
        }
        Integer pilihGender = rgGender.getCheckedRadioButtonId();
        rdGender = (RadioButton) findViewById(pilihGender);

        String jKelamin = rdGender.getText().toString();
        String hasilBmi = bmi + "";
        String kategori = bmiLabel;
        String umur = infoUmur;

        Info info = new Info(jKelamin,hasilBmi,kategori,umur);
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        intent.putExtra(key_MainActivity, info);
        startActivity(intent);
    }
}
