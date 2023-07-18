package com.example.catorcekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Toast
import com.example.catorcekotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var saldo=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonOk.setOnClickListener{
            when(binding.radioGroup.checkedRadioButtonId){
                R.id.verSaldo ->
                    binding.monto.setText(saldo.toString())
                R.id.ingresar -> ingresarSaldo()
                R.id.retirar-> retirarSaldo()
                R.id.salir -> salir()
            }
        }

        }

    fun ingresarSaldo() {

        saldo+= binding.monto.text.toString().toInt()
        limpiarMontito()
        crearMensaje("Su deposito ha sido realizado correctamente")

    }
    fun retirarSaldo(){

        val montito = binding.monto.text.toString().toInt()

        if (montito <= saldo) {
            saldo -= montito
            limpiarMontito()
            crearMensaje("Su saldo ha sido ingresado exitosamente")
        }else{
            crearMensaje("El monto supera el saldo inicial intente nuevamente")


        }

    }
    private fun salir() {
        System.exit(0)
    }
    fun limpiarMontito(){
        binding.monto.text.clear()
    }

    fun crearMensaje(s:String){
        Toast.makeText(applicationContext,"",Toast.LENGTH_LONG).show()

    }
}