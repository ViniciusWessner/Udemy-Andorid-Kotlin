package com.devmasterteam.custoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.devmasterteam.custoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    // Função responsável por fazer a criação da Activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Faz com que o ViewBinding identifique os elementos e mapeie para 'binding'
        binding = ActivityMainBinding.inflate(layoutInflater)

        // Faz a atribuição do layout
        setContentView(binding.root)

        // Acesso aos elementos de interface via 'binding'
        binding.buttonCalculate.setOnClickListener(this)
    }

    // Função responsável por tratar qualquer evento de click nos elementos
    override fun onClick(view: View) {
        // Obtém o Id do elemento clicado
        val id: Int = view.id

        // Verifica se o elemento é o que nos interessa
        if (id == R.id.buttonCalculate) {
            calculate()
        }
    }

    // Função responsável por realizar o cálculo dos gastos com a viagem
    // Baseado na distância percorrida * preço médio do combustível / pela autonomia do veículo
    private fun calculate() {
        if (isValidationOk()) {
            try {

                // Realiza o cálculo ((distancia * preço) / autonomia)
                val total =
                    ((binding.editDistance.text.toString()
                        .toFloat() * binding.editPrice.text.toString().toFloat())
                            / binding.editAutonomy.text.toString().toFloat())


                // Seta o valor calculado na tela - Formatado com duas casas
                binding.textResult.text = "R$ ${"%.2f".format(total)}"

            } catch (nfe: NumberFormatException) {
                // Caso ocorra erro de conversão numérica, solicita ao usuário para preencher com valores válidos
                Toast.makeText(
                    this,
                    getString(R.string.preenche_valores_validos),
                    Toast.LENGTH_SHORT
                ).show()
            }
        } else {
            // Caso não tenha preenchido todos os campos, solicita o preenchimento
            Toast.makeText(this, getString(R.string.preencha_campos), Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Verifica se todos os campos foram preenchidos
     */
    private fun isValidationOk(): Boolean = (
            binding.editDistance.text.toString() != "" &&
                    binding.editPrice.text.toString() != "" &&
                    binding.editAutonomy.text.toString() != "" &&
                    binding.editAutonomy.text.toString() != "0"
            )
}