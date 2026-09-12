package com.example.a4670506assignment2.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a4670506assignment2.R
import com.example.a4670506assignment2.ui.details.DetailsActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class DashboardActivity : AppCompatActivity() {

    private val viewModel: DashboardViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val recyclerView =
            findViewById<RecyclerView>(R.id.recyclerViewMythology)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val keypass = intent.getStringExtra("KEYPASS")

        if (keypass.isNullOrBlank()) {
            Toast.makeText(
                this,
                getString(R.string.dashboard_error),
                Toast.LENGTH_SHORT
            ).show()
            finish()
            return
        }

        viewModel.loadDashboard(
            keypass = keypass,
            onSuccess = { entities ->
                recyclerView.adapter = MythologyAdapter(entities) { selectedEntity ->

                    val intent = Intent(
                        this,
                        DetailsActivity::class.java
                    )

                    intent.putExtra("name", selectedEntity.name)
                    intent.putExtra("culture", selectedEntity.culture)
                    intent.putExtra("domain", selectedEntity.domain)
                    intent.putExtra("symbol", selectedEntity.symbol)
                    intent.putExtra("parentage", selectedEntity.parentage)
                    intent.putExtra(
                        "romanEquivalent",
                        selectedEntity.romanEquivalent
                    )
                    intent.putExtra(
                        "description",
                        selectedEntity.description
                    )

                    startActivity(intent)
                }
            },
            onError = { message ->
                Toast.makeText(
                    this,
                    message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        )
    }
}