package com.example.calculadorabasica;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tv1;
    private EditText et1, et2;
    private RadioButton r1, r2, r3, r4, r5, r6, r7, r8, r9;
    private RadioGroup grupo1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicialización de vistas
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        tv1 = findViewById(R.id.xtv1);
        grupo1 = findViewById(R.id.grupo1);

        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
        r3 = findViewById(R.id.r3);
        r4 = findViewById(R.id.r4);
        r5 = findViewById(R.id.r5);
        r6 = findViewById(R.id.r6);
        r7 = findViewById(R.id.r7);
        r8 = findViewById(R.id.r8);
        r9 = findViewById(R.id.r9);

        // Botón de cálculo
        Button calcularBtn = findViewById(R.id.xbn);
        calcularBtn.setOnClickListener(this::calcular);
    }

    public void calcular(View v) {
        String a = et1.getText().toString();
        String b = et2.getText().toString();

        // Validación de entrada
        if (a.isEmpty() || (grupo1.getCheckedRadioButtonId() != R.id.r6 && b.isEmpty())) {
            tv1.setText("Por favor, ingrese los valores necesarios.");
            return;
        }

        double x = Double.parseDouble(a);
        double y = b.isEmpty() ? 0 : Double.parseDouble(b); // Para operaciones de un solo número
        String resultado;

        // Verificar qué RadioButton está seleccionado
        if (r1.isChecked()) {
            double suma = x + y;
            resultado = String.format("Solución: %.2f + %.2f = %.2f", x, y, suma);
        } else if (r2.isChecked()) {
            double resta = x - y;
            resultado = String.format("Solución: %.2f - %.2f = %.2f", x, y, resta);
        } else if (r3.isChecked()) {
            double producto = x * y;
            resultado = String.format("Solución: %.2f * %.2f = %.2f", x, y, producto);
        } else if (r4.isChecked()) {
            if (y == 0) {
                resultado = "Error: División entre cero.";
            } else {
                double cociente = x / y;
                resultado = String.format("Solución: %.2f ÷ %.2f = %.2f", x, y, cociente);
            }
        } else if (r5.isChecked()) {
            double potencia = Math.pow(x, y);
            resultado = String.format("Solución: %.2f ^ %.2f = %.2f", x, y, potencia);
        } else if (r6.isChecked()) {
            if (x < 0) {
                resultado = "Error: Raíz cuadrada de un número negativo.";
            } else {
                double raiz = Math.sqrt(x);
                resultado = String.format("Solución: √%.2f = %.2f", x, raiz);
            }
        } else if (r7.isChecked()) {
            double seno = Math.sin(Math.toRadians(x));
            resultado = String.format("Solución: sen(%.2f) = %.2f", x, seno);
        } else if (r8.isChecked()) {
            double coseno = Math.cos(Math.toRadians(x));
            resultado = String.format("Solución: cos(%.2f) = %.2f", x, coseno);
        } else if (r9.isChecked()) {
            double tangente = Math.tan(Math.toRadians(x));
            resultado = String.format("Solución: tan(%.2f) = %.2f", x, tangente);
        } else {
            resultado = "Seleccione una operación.";
        }

        // Mostrar resultado
        tv1.setText(resultado);
    }
}
