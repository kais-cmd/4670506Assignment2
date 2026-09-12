package com.example.a4670506assignment2.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a4670506assignment2.R
import com.example.a4670506assignment2.data.model.MythologyEntity

class MythologyAdapter(
    private val entities: List<MythologyEntity>,
    private val onItemClick: (MythologyEntity) -> Unit
) : RecyclerView.Adapter<MythologyAdapter.MythologyViewHolder>() {

    class MythologyViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val nameTextView: TextView = itemView.findViewById(R.id.tvName)
        val cultureTextView: TextView = itemView.findViewById(R.id.tvCulture)
        val domainTextView: TextView = itemView.findViewById(R.id.tvDomain)
        val symbolTextView: TextView = itemView.findViewById(R.id.tvSymbol)
        val parentageTextView: TextView = itemView.findViewById(R.id.tvParentage)
        val romanEquivalentTextView: TextView =
            itemView.findViewById(R.id.tvRomanEquivalent)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MythologyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mythology, parent, false)

        return MythologyViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: MythologyViewHolder,
        position: Int
    ) {
        val entity = entities[position]
        val context = holder.itemView.context

        holder.nameTextView.text = entity.name

        holder.cultureTextView.text =
            context.getString(R.string.culture_format, entity.culture)

        holder.domainTextView.text =
            context.getString(R.string.domain_format, entity.domain)

        holder.symbolTextView.text =
            context.getString(R.string.symbol_format, entity.symbol)

        holder.parentageTextView.text =
            context.getString(R.string.parentage_format, entity.parentage)

        holder.romanEquivalentTextView.text =
            context.getString(
                R.string.roman_equivalent_format,
                entity.romanEquivalent
            )

        holder.itemView.setOnClickListener {
            onItemClick(entity)
        }
    }

    override fun getItemCount(): Int = entities.size
}