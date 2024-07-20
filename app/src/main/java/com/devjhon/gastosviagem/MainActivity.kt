package com.devjhon.gastosviagem

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.devjhon.gastosviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_calcular){
            calcular()
        }
    }

    private fun isValid(): Boolean{
        return(binding.editDistacia.text.toString() != ""
                && binding.edtPreco.text.toString()!= ""
                && binding.edtKmLitro.text.toString() != ""
                &&binding.edtKmLitro.text.toString().toFloat() != 0f)
    }

    private fun calcular(){
        if (isValid()) {
            val distancia = binding.editDistacia.text.toString().toFloat()
            val preco = binding.edtPreco.text.toString().toFloat()
            val kmPorLitro = binding.edtKmLitro.text.toString().toFloat()

            val valorTotal = (distancia * preco) / kmPorLitro
            binding.txtResultado.text = "R$ ${"%.2f".format(valorTotal)}"
        }else {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
        }
    }
}