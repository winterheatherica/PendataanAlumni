package pnj.uts.ti.nama_mahasiswa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import android.util.Log

class MainActivity2 : AppCompatActivity(), View.OnClickListener {

    // Variabel untuk menyimpan fragment saat ini
    private var currentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2_main)

        val homeTextView: TextView = findViewById(R.id.homeTextView)
        val beritaTextView: TextView = findViewById(R.id.beritaTextView)
        val profileTextView: TextView = findViewById(R.id.profileTextView)

        val email = intent.getStringExtra("email")

        val profileFragment = ProfileFragment().apply {
            arguments = Bundle().apply {
                putString("email", email)
            }
        }

        homeTextView.setOnClickListener(this)
        beritaTextView.setOnClickListener(this)
        profileTextView.setOnClickListener(this)

        // Tampilkan fragment Home saat MainActivity2 dibuka
        displayFragment(HomeFragment())
        // Simpan fragment saat ini sebagai currentFragment
        currentFragment = HomeFragment()
    }

    override fun onClick(v: View) {
        var fragment: Fragment? = null

        when (v.id) {
            R.id.homeTextView -> fragment = HomeFragment()
            R.id.beritaTextView -> fragment = BeritaFragment()
            R.id.profileTextView -> fragment = ProfileFragment()
        }

        if (fragment != null) {
            displayFragment(fragment)
            // Simpan fragment saat ini sebagai currentFragment
            currentFragment = fragment
        }
    }

    private fun displayFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    override fun onBackPressed() {
        // Periksa apakah currentFragment bukan null dan bukan HomeFragment
        if (currentFragment != null && currentFragment !is HomeFragment) {
            // Kembali ke HomeFragment jika currentFragment bukan HomeFragment
            displayFragment(HomeFragment())
            // Simpan HomeFragment sebagai currentFragment
            currentFragment = HomeFragment()
        } else {
            // Panggil super.onBackPressed() jika currentFragment adalah HomeFragment
            super.onBackPressed()
        }
    }
}

