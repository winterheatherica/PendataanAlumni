package pnj.uts.ti.nama_mahasiswa

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity2 : AppCompatActivity(), View.OnClickListener {

    // Variabel untuk menyimpan fragment saat ini
    private var currentFragment: Fragment? = null
    private lateinit var loggedInUser: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2_main)

        val homeTextView: TextView = findViewById(R.id.homeTextView)
        val beritaTextView: TextView = findViewById(R.id.beritaTextView)
        val profileTextView: TextView = findViewById(R.id.profileTextView)

        // Mendapatkan data login dari intent
        val email = intent.getStringExtra("email")

        // Inisialisasi data login
        loggedInUser = when (email) {
            "a" -> User("a", "2207411058", "Rafii Anindito", "TI-4B")
            "erika" -> User("erika", "12207411058", "Erika Kathrina", "TI-4B")
            else -> User(email ?: "", "", "", "") // default jika email tidak dikenali
        }

        val profileFragment = ProfileFragment().apply {
            arguments = Bundle().apply {
                // Mengirim data login ke ProfileFragment
                putParcelable("loggedInUser", loggedInUser)
            }
        }

        homeTextView.setOnClickListener(this)
        beritaTextView.setOnClickListener(this)
        profileTextView.setOnClickListener(this)

        // Setup spinner
        setupSpinner()

        // Tampilkan fragment Home saat MainActivity2 dibuka
        displayFragment(HomeFragment())
        // Simpan fragment saat ini sebagai currentFragment
        currentFragment = HomeFragment()
    }

    private fun setupSpinner() {
        val spinner: Spinner = findViewById(R.id.dropdownSpinner)
        val dropdownItems = resources.getStringArray(R.array.dropdown_items).toMutableList()

        // Removing "More" from dropdown items list

        ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            dropdownItems
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }


        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedItem = parent.getItemAtPosition(position).toString()
                when (selectedItem) {
                    "More" -> {
                        displayFragment(HomeFragment())
                    }
                    "Tambah Data" -> {
                        displayFragment(TambahDataFragment())
                    }
                    "Data Alumni" -> {
                        displayFragment(DataAlumniFragment())
                    }
                    "Logout" -> {
                        val intent = Intent(this@MainActivity2, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }
    }

    override fun onClick(v: View) {
        var fragment: Fragment? = null

        when (v.id) {
            R.id.homeTextView -> fragment = HomeFragment()
            R.id.beritaTextView -> fragment = BeritaFragment()
            R.id.profileTextView -> fragment = ProfileFragment().apply {
                // Mengirim data login ke ProfileFragment saat di-click
                arguments = Bundle().apply {
                    putParcelable("loggedInUser", loggedInUser)
                }
            }
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("email", intent.getStringExtra("email"))
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
