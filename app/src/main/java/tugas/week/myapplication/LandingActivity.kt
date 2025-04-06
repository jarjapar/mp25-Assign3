package tugas.week.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LandingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        val welcomeText = findViewById<TextView>(R.id.welcomeText)
        val backButton = findViewById<Button>(R.id.backButton)

        val user = intent.getParcelableExtra<User>("userData")

        welcomeText.text = "Hello, ${user?.name ?: "User"}"

        backButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("userData", user)
            startActivity(intent)
            finish()
        }
    }
}
