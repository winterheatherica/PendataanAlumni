// File: ProfileFragment.kt
package pnj.uts.ti.nama_mahasiswa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val emailTextView = view.findViewById<TextView>(R.id.emailTextView)
        val nimTextView = view.findViewById<TextView>(R.id.nimTextView)
        val namaTextView = view.findViewById<TextView>(R.id.namaTextView)
        val kelasTextView = view.findViewById<TextView>(R.id.kelasTextView)

        // Ambil kredensial pengguna yang digunakan untuk login
        val email = arguments?.getString("email")

        // Sesuaikan tampilan profil berdasarkan kredensial
        when (email) {
            "a" -> {
                emailTextView.text = "Email: a"
                nimTextView.text = "NIM: 2207411058"
                namaTextView.text = "Nama: Rafii Anindito"
                kelasTextView.text = "Kelas: TI-4B"
            }
            "erika" -> {
                emailTextView.text = "Email: erika"
                nimTextView.text = "NIM: 12207411058"
                namaTextView.text = "Nama: Erika Kathrina"
                kelasTextView.text = "Kelas: TI-4B"
            }
            else -> {
                // Kondisi default jika kredensial tidak dikenali
                emailTextView.text = "Email: $email"
                nimTextView.text = "NIM: -"
                namaTextView.text = "Nama: -"
                kelasTextView.text = "Kelas: -"
            }
        }

        return view
    }
}

