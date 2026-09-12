package com.example.a4670506assignment2.ui.details

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.a4670506assignment2.R

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val nameTextView = findViewById<TextView>(R.id.tvDetailName)
        val cultureTextView = findViewById<TextView>(R.id.tvDetailCulture)
        val domainTextView = findViewById<TextView>(R.id.tvDetailDomain)
        val symbolTextView = findViewById<TextView>(R.id.tvDetailSymbol)
        val parentageTextView = findViewById<TextView>(R.id.tvDetailParentage)
        val romanEquivalentTextView =
            findViewById<TextView>(R.id.tvDetailRomanEquivalent)
        val descriptionTextView =
            findViewById<TextView>(R.id.tvDetailDescription)

        nameTextView.text = intent.getStringExtra("name").orEmpty()
        cultureTextView.text =
            getString(R.string.culture_format, intent.getStringExtra("culture").orEmpty())
        domainTextView.text =
            getString(R.string.domain_format, intent.getStringExtra("domain").orEmpty())
        symbolTextView.text =
            getString(R.string.symbol_format, intent.getStringExtra("symbol").orEmpty())
        parentageTextView.text =
            getString(R.string.parentage_format, intent.getStringExtra("parentage").orEmpty())
        romanEquivalentTextView.text =
            getString(
                R.string.roman_equivalent_format,
                intent.getStringExtra("romanEquivalent").orEmpty()
            )
        descriptionTextView.text =
            intent.getStringExtra("description").orEmpty()
    }
}