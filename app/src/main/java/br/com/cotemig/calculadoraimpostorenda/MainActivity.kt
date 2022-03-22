package br.com.cotemig.calculadoraimpostorenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var salario = findViewById<EditText>(R.id.salario)
        var btnCalc = findViewById<Button>(R.id.btncalc)
        var salarioLiquido = findViewById<TextView>(R.id.salarioliquido)
        var imposto = findViewById<TextView>(R.id.imposto)
        var ft = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-br"))

        btnCalc.setOnClickListener {

            var sal = salario.text.toString().toDouble()
            var imp: Double

            if (sal <= 1983.98) {
                imp = 0.0
            } else if (sal <= 2826.65) {
                imp = (sal * 0.075) - 142.8
            } else if (sal <= 3751.05) {
                imp = (sal * 0.15) - 354.8
            } else if (sal <= 4664.68) {
                imp = (sal * 0.225) - 636.13
            } else {
                imp = (sal * 0.275) - 869.36
            }

            var salFinal = sal - imp;

            salarioLiquido.text = ft.format(salFinal)
            imposto.text = ft.format(imp)


        }
    }
}