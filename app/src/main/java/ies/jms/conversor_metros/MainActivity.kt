package ies.jms.conversor_metros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import ies.jms.conversor_metros.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val botonCalcular: Button = binding.botonCalculo
        botonCalcular.setOnClickListener(){
            convertirMetros()
        }
    }

    fun convertirMetros(){
        val metros = binding.importe.text.toString().toDoubleOrNull()
        if (metros == null){
            Toast.makeText(this, "Introduce un valor", Toast.LENGTH_SHORT).show()
            binding.textResult.text = "0.00"
            return
        }
        val opcionSelecionada = binding.opciones.checkedRadioButtonId
        val conversion = when (opcionSelecionada){
            R.id.opcionKm -> 1000.0 * metros
            R.id.opcionDm -> 10.0 / metros
            R.id.opcionCm -> 100.0 / metros
            R.id.opcionMm -> 1000.0 / metros
            else -> 33333.333333333 * metros

        } //onzas liquidas

        val unidadFormateda = NumberFormat.getCurrencyInstance().format(conversion)
        binding.textResult.text = unidadFormateda

    }
}
