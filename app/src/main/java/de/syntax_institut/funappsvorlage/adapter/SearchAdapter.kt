package de.syntax_institut.funappsvorlage.adapter

import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import de.syntax_institut.funappsvorlage.R
import de.syntax_institut.funappsvorlage.data.datamodels.Song

/**
 * Diese Klasse organisiert mithilfe der ViewHolder Klasse das Recycling
 */
class SearchAdapter(private val dataset: List<Song>) :
    RecyclerView.Adapter<SearchAdapter.ItemViewHolder>() {

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
        val imgUri = song.artworkUrl100.toUri().buildUpon().scheme("https").build()

        holder.tvArtist.text = song.artistName
        holder.tvTitle.text = song.trackName
        holder.tvPicture.load(imgUri) {
            transformations(RoundedCornersTransformation(10f))
        }
    }

    /**
     * damit der LayoutManager weiß, wie lang die Liste ist
     */
    override fun getItemCount(): Int {
        return dataset.size
    }
}
