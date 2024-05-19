//BeritaAdapter.kt
package pnj.uts.ti.nama_mahasiswa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

interface OnBeritaClickListener {
    fun onBeritaClick(berita: Berita)
}

class BeritaAdapter(private val beritaList: List<Berita>, private val listener: OnBeritaClickListener) :
    RecyclerView.Adapter<BeritaAdapter.BeritaViewHolder>() {

    class BeritaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.beritaImage)
        val titleTextView: TextView = itemView.findViewById(R.id.titleberita)
        val descriptionTextView: TextView = itemView.findViewById(R.id.deskripsiberita)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeritaViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.berita_list_item, parent, false)
        return BeritaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BeritaViewHolder, position: Int) {
        val currentItem = beritaList[position]
        holder.imageView.setImageResource(currentItem.imageResId)
        holder.titleTextView.text = currentItem.title
        holder.descriptionTextView.text = currentItem.description

        // Set click listener
        holder.itemView.setOnClickListener {
            listener.onBeritaClick(currentItem)
        }
    }

    override fun getItemCount() = beritaList.size
}
