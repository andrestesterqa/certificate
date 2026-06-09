package com.noahbella.englishgame.adapter

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.noahbella.englishgame.R
import com.noahbella.englishgame.model.Level

class LevelAdapter(
    private val levels: List<Level>,
    private val onLevelClick: (Level) -> Unit
) : RecyclerView.Adapter<LevelAdapter.LevelViewHolder>() {

    inner class LevelViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val card: CardView = view.findViewById(R.id.cardLevel)
        val tvEmoji: TextView = view.findViewById(R.id.tvLevelEmoji)
        val tvName: TextView = view.findViewById(R.id.tvLevelName)
        val tvDesc: TextView = view.findViewById(R.id.tvLevelDesc)
        val tvStars: TextView = view.findViewById(R.id.tvStars)
        val tvLock: TextView = view.findViewById(R.id.tvLock)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LevelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_level, parent, false)
        return LevelViewHolder(view)
    }

    override fun onBindViewHolder(holder: LevelViewHolder, position: Int) {
        val level = levels[position]
        val density = holder.card.context.resources.displayMetrics.density

        holder.tvEmoji.text = level.emoji
        holder.tvName.text = level.name
        holder.tvDesc.text = level.description

        val stars = "⭐".repeat(level.starsEarned) + "☆".repeat(3 - level.starsEarned)
        holder.tvStars.text = stars

        val gradient = GradientDrawable(
            GradientDrawable.Orientation.TL_BR,
            intArrayOf(Color.parseColor(level.colorStart), Color.parseColor(level.colorEnd))
        )
        gradient.cornerRadius = 20f * density
        holder.card.background = gradient

        if (level.isUnlocked) {
            holder.tvLock.visibility = View.GONE
            holder.card.alpha = 1f
            holder.card.setOnClickListener { onLevelClick(level) }
        } else {
            holder.tvLock.visibility = View.VISIBLE
            holder.card.alpha = 0.55f
            holder.card.setOnClickListener(null)
        }
    }

    override fun getItemCount() = levels.size
}
