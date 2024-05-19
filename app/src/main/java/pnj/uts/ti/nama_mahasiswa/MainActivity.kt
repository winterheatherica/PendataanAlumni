package pnj.uts.ti.nama_mahasiswa

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var emailEditText: EditText? = null
    private var passwordEditText: EditText? = null
    private var loginButton: Button? = null

    // Definisi kredensial pengguna
    private val credentials = mapOf(
        "a" to "a", // Kredensial yang sudah ada
        "erika" to "erika" // Kredensial tambahan
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        emailEditText = findViewById<EditText>(R.id.emailEditText)
        passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        loginButton = findViewById<Button>(R.id.loginButton)

        loginButton?.setOnClickListener {
            val email = emailEditText?.text.toString()
            val password = passwordEditText?.text.toString()

            // Validasi kredensial
            if (credentials.containsKey(email) && credentials[email] == password) {
                val intent = Intent(this@MainActivity, MainActivity2::class.java)
                intent.putExtra("email", email)
                startActivity(intent)
            } else {
                Toast.makeText(this@MainActivity, "Email atau password salah", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}
