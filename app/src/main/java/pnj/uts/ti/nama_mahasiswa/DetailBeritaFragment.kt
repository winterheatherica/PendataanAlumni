package pnj.uts.ti.nama_mahasiswa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailBeritaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail_berita, container, false)

        // Menampilkan data berita
        val berita = arguments?.getParcelable<Berita>("berita")
        berita?.let {
            view.findViewById<ImageView>(R.id.detailBeritaImage).setImageResource(it.imageResId)
            view.findViewById<TextView>(R.id.detailTitleBerita).text = it.title
            view.findViewById<TextView>(R.id.detailDeskripsiBerita).text = it.description
            view.findViewById<TextView>(R.id.detailFullDescription).text = it.fullDescription
        }

        return view
    }
}
