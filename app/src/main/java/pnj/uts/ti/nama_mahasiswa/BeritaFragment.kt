//BeritaFragment.kt
package pnj.uts.ti.nama_mahasiswa

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class BeritaFragment : Fragment(), OnBeritaClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_berita, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Inisialisasi daftar berita
        val beritaList = mutableListOf(
            Berita("Judul Berita 1", "Deskripsi Berita 1", R.drawable.profil, "Full"),
            Berita("Judul Berita 2", "Deskripsi Berita 2", R.drawable.profil, "Full"),
            Berita("Judul Berita 3", "Deskripsi Berita 3", R.drawable.profil, "Full"),
            // Tambahkan berita lainnya sesuai kebutuhan
        )

        val adapter = BeritaAdapter(beritaList, this) // Pass 'this' as the listener
        recyclerView.adapter = adapter

        return view
    }

    override fun onBeritaClick(berita: Berita) {
        val detailBeritaFragment = DetailBeritaFragment()
        val bundle = Bundle()
        bundle.putParcelable("berita", berita)
        detailBeritaFragment.arguments = bundle
        fragmentManager?.beginTransaction()
            ?.replace(R.id.fragmentContainer, detailBeritaFragment)
            ?.addToBackStack(null)
            ?.commit()
    }
}
