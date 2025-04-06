package tugas.week.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    private var registeredUser: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailInput = findViewById<EditText>(R.id.emailInput)
        val passwordInput = findViewById<EditText>(R.id.passwordInput)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val registerLink = findViewById<TextView>(R.id.registerLink)

        registeredUser = intent.getParcelableExtra("userData")

        registerLink.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        loginButton.setOnClickListener {
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()

            if (registeredUser == null) {
                Toast.makeText(this, "Silakan registrasi terlebih dahulu", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (email.isBlank() || password.isBlank()) {
                Toast.makeText(this, "Isi semua field", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (email == registeredUser!!.email && password == registeredUser!!.password) {
                val intent = Intent(this, LandingActivity::class.java)
                intent.putExtra("userData", registeredUser)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Email atau password salah", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
