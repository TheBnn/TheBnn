package com.example.bagstats

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDateTime

data class Bag(
    val type: String,
    val weight: Double,
    val received: LocalDateTime,
    var processed: LocalDateTime? = null
)

class MainActivity : AppCompatActivity() {
    private val bags = mutableListOf<Bag>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val typeInput = findViewById<EditText>(R.id.typeInput)
        val weightInput = findViewById<EditText>(R.id.weightInput)
        val addButton = findViewById<Button>(R.id.addButton)
        val statsText = findViewById<TextView>(R.id.statsText)

        addButton.setOnClickListener {
            val type = typeInput.text.toString()
            val weight = weightInput.text.toString().toDoubleOrNull() ?: 0.0
            val bag = Bag(type, weight, LocalDateTime.now())
            bags.add(bag)
            updateStats(statsText)
            typeInput.text.clear()
            weightInput.text.clear()
        }
    }

    private fun updateStats(view: TextView) {
        val totalWeight = bags.sumOf { it.weight }
        val counts = bags.groupingBy { it.type }.eachCount()
        val sb = StringBuilder()
        sb.append("Total weight: $totalWeight\n")
        counts.forEach { (type, count) ->
            sb.append("$type: $count\n")
        }
        view.text = sb.toString()
    }
}
