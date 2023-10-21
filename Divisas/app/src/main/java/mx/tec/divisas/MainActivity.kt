package mx.tec.divisas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import mx.tec.divisas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Currency names for the spinner
        val currencyNames = listOf("USD", "EUR")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, currencyNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spBase.adapter = adapter
        binding.spTarget.adapter = adapter

        // Conversion map of currency names to conversion rates
        val conversionMap = mapOf(
            "USD" to 17.0,
            "EUR" to 20.0
        )

        binding.btnConvertir.setOnClickListener {
            val baseCurrency = binding.spBase.selectedItem.toString()
            val targetCurrency = binding.spTarget.selectedItem.toString()

            val conversionRate = conversionMap[targetCurrency]!! / conversionMap[baseCurrency]!!
            val amountToConvert = binding.edtCantidad.text.toString().toDouble()
            val convertedAmount = amountToConvert * conversionRate

            binding.txtResult.text = "$amountToConvert $baseCurrency = $convertedAmount $targetCurrency"
        }
    }
}
