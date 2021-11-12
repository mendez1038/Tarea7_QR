package com.example.tarea7_qr;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.text.CollationElementIterator;

public class Menu extends AppCompatActivity {

    CollationElementIterator txtResultado = null;
    //Método para escanearQR
    public void escanearQR() {
        IntentIntegrator integrador = new IntentIntegrator(Menu.this);
        integrador.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
        //PRODUCT_CODE_TYPES)
        integrador.setPrompt("Escanear Código");
        integrador.setCameraId(0);integrador.setBeepEnabled(true);
        integrador.setBarcodeImageEnabled(true);
        integrador.initiateScan();
    }

    //Método para escanearBarras
    public void escanearBarras() {
        IntentIntegrator integrador = new IntentIntegrator(Menu.this);
        integrador.setDesiredBarcodeFormats(IntentIntegrator.CODE_128);
        //PRODUCT_CODE_TYPES)
        integrador.setPrompt("Escanear Código");
        integrador.setCameraId(0);
        integrador.setBeepEnabled(true);
        integrador.setBarcodeImageEnabled(true);
        integrador.initiateScan();
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult resultado = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (resultado != null) {
            if (resultado.getContents() == null) {
                Toast.makeText(this, "Cancelado", Toast.LENGTH_LONG).show();
            } else {
                txtResultado.setText(resultado.getContents());
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
}