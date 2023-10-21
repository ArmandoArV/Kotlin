/*
*
*   Made by: Armando Arredondo Valle | A01424709
*   Date: 25/08/2023
* */

package mx.tec.calculadoradivisas

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import mx.tec.calculadoradivisas.databinding.ActivityMainBinding

data class Currency(val name: String, val conversionRate: Double)

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val currencies = listOf(
        Currency("USD", 1.0),
        Currency("EUR", 0.85),
        Currency("MXN", 20.0),
        Currency("GBP", 0.76),
        Currency("JPY", 109.33),
        Currency("CAD", 1.14),
        Currency("AUD", 1.22),
        Currency("CHF", 0.92),
        Currency("CNY", 6.47),
        Currency("HKD", 7.78)
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val currencyNames = currencies.map { it.name }
        val adapter = ArrayAdapter(this, R.layout.simple_spinner_item, currencyNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spBase.adapter = adapter
        binding.spTarget.adapter = adapter

        binding.btnConvertir.setOnClickListener {
            val baseCurrency = currencies[binding.spBase.selectedItemPosition]
            val targetCurrency = currencies[binding.spTarget.selectedItemPosition]

            val amountToConvert = binding.edtCantidad.text.toString().toDoubleOrNull()
            if (amountToConvert != null) {
                val conversionRate = targetCurrency.conversionRate / baseCurrency.conversionRate
                val convertedAmount = amountToConvert * conversionRate
                val formattedConvertedAmount = String.format("%.2f", convertedAmount)

                binding.txtResult.text =
                    "$amountToConvert ${baseCurrency.name} = $formattedConvertedAmount ${targetCurrency.name}"
            } else {
                binding.txtResult.text = "Invalid amount"
            }
        }

    }

    private fun convertCurrency(
        amount: Double, fromCurrency: Currency, toCurrency: Currency
    ): Double {
        val conversionRate = toCurrency.conversionRate / fromCurrency.conversionRate
        return amount * conversionRate
    }
}
