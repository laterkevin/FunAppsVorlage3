package de.syntax_institut.funappsvorlage.adapter

import android.service.autofill.Dataset
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.syntax_institut.funappsvorlage.R
import de.syntax_institut.funappsvorlage.data.datamodels.Song

/**
 * Diese Klasse organisiert mithilfe der ViewHolder Klasse das Recycling
 */
class SearchAdapter(private val dataset: List<Song>) : RecyclerView.Adapter<SearchAdapter.ItemViewHolder>() {

    /**
     * der ViewHolder umfasst die View uns stellt einen Listeneintrag dar
     */
    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // TODO
        val tvArtist: TextView = itemView.findViewById(R.id.tvArtist)
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvPicture: ImageView = itemView.findViewById(R.id.tvCoverImg)
    }

    /**
     * hier werden neue ViewHolder erstellt
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_result, parent, false)

        return ItemViewHolder(itemLayout)
    }

    /**
     * hier findet der Recyclingprozess statt
     * die vom ViewHolder bereitgestellten Parameter erhalten die Information des Listeneintrags
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        // TODO
        val song = dataset[position]
        holder.tvArtist.text = song.artistName
        holder.tvTitle.text = song.trackName
//        holder.tvPicture.drawable = song.artworkUrl100
    }

    /**
     * damit der LayoutManager weiß, wie lang die Liste ist
     */
    override fun getItemCount(): Int {
        return TODO()
    }
}
