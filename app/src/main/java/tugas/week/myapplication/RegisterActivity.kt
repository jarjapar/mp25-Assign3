package tugas.week.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val nameInput = findViewById<EditText>(R.id.nameInput)
        val emailInput = findViewById<EditText>(R.id.emailInput)
        val passwordInput = findViewById<EditText>(R.id.passwordInput)
        val repeatPasswordInput = findViewById<EditText>(R.id.repeatPasswordInput)
        val registerButton = findViewById<Button>(R.id.registerButton)

        registerButton.setOnClickListener {
            val name = nameInput.text.toString()
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()
            val repeatPassword = repeatPasswordInput.text.toString()

            if (name.isBlank() || email.isBlank() || password.isBlank() || repeatPassword.isBlank()) {
                Toast.makeText(this, "Isi semua field", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Email tidak valid", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != repeatPassword) {
                Toast.makeText(this, "Password tidak cocok", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val user = User(name, email, password)
            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("userData", user)
            startActivity(intent)
            finish()
        }
    }
}
