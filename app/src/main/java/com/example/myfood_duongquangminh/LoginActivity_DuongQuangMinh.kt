package com.example.myfood_duongquangminh

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LoginActivity_DuongQuangMinh : AppCompatActivity() {
    private lateinit var dbHelper: Food_DuongQuangMinh

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_duongquangminh) // Đảm bảo đúng tên file xml

        dbHelper = Food_DuongQuangMinh(this)

        val edtUsername = findViewById<EditText>(R.id.edt_login_tendangnhap)
        val edtPassword = findViewById<EditText>(R.id.edt_login_matkhau)
        val btnLogin = findViewById<Button>(R.id.btn_dangnhap)
        val tvSignup = findViewById<TextView>(R.id.signupText)

        btnLogin.setOnClickListener {
            val username = edtUsername.text.toString().trim()
            val password = edtPassword.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val db = dbHelper.readableDatabase
            val cursor = db.rawQuery(
                "SELECT * FROM User_DuongQuangMinh WHERE username = ? AND password = ?",
                arrayOf(username, password)
            )
            if (cursor.count > 0) {
                cursor.close()
                db.close()
                Toast.makeText(this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show()
                // Chuyển sang HomeActivity (bạn tự tạo màn này)
                finish()
            } else {
                cursor.close()
                db.close()
                Toast.makeText(this, "Sai tên đăng nhập hoặc mật khẩu!", Toast.LENGTH_SHORT).show()
            }
        }

        tvSignup.setOnClickListener {
            // Khi bấm vào “Đăng kí”, chuyển sang màn đăng ký
            val intent = Intent(this, RegisterActivity_DuongQuangMinh::class.java)
            startActivity(intent)
        }
    }
}
