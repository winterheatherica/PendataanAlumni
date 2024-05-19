// ProfileFragment.kt
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

        // Mendapatkan data login dari argument
        val loggedInUser = arguments?.getParcelable<User>("loggedInUser")

        // Menampilkan data login
        val emailTextView = view.findViewById<TextView>(R.id.emailTextView)
        val nimTextView = view.findViewById<TextView>(R.id.nimTextView)
        val namaTextView = view.findViewById<TextView>(R.id.namaTextView)
        val kelasTextView = view.findViewById<TextView>(R.id.kelasTextView)

        emailTextView.text = "Email: ${loggedInUser?.email}"
        nimTextView.text = "NIM: ${loggedInUser?.nim}"
        namaTextView.text = "Nama: ${loggedInUser?.nama}"
        kelasTextView.text = "Kelas: ${loggedInUser?.kelas}"

        return view
    }
}
