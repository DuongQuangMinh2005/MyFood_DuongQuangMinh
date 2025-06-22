package com.example.myfood_duongquangminh

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity_DuongQuangMinh : AppCompatActivity() {
    private lateinit var dbHelper: Food_DuongQuangMinh

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dangky_duongquangminh) // Đảm bảo đúng tên file xml

        dbHelper = Food_DuongQuangMinh(this)

        val edtUsername = findViewById<EditText>(R.id.edt_dangki_tendangnhap)
        val edtPassword = findViewById<EditText>(R.id.edt_dangki_matkhau)
        val edtRepass = findViewById<EditText>(R.id.edt_dangki_repass)
        val btnRegister = findViewById<Button>(R.id.btn_dangki)

        btnRegister.setOnClickListener {
            val username = edtUsername.text.toString().trim()
            val password = edtPassword.text.toString().trim()
            val repassword = edtRepass.text.toString().trim()

            if (username.isEmpty() || password.isEmpty() || repassword.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (password != repassword) {
                Toast.makeText(this, "Nhập lại mật khẩu chưa đúng!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Kiểm tra tài khoản đã tồn tại chưa
            val db = dbHelper.readableDatabase
            val cursor = db.rawQuery(
                "SELECT * FROM User_DuongQuangMinh WHERE username = ?",
                arrayOf(username)
            )
            if (cursor.count > 0) {
                cursor.close()
                db.close()
                Toast.makeText(this, "Tên đăng nhập đã tồn tại!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            cursor.close()
            db.close()

            // Thêm user mới
            val dbw = dbHelper.writableDatabase
            dbw.execSQL(
                "INSERT INTO User_DuongQuangMinh(username, password) VALUES(?,?)",
                arrayOf(username, password)
            )
            dbw.close()

            Toast.makeText(this, "Đăng ký thành công! Vui lòng đăng nhập.", Toast.LENGTH_SHORT).show()
            // Sau khi đăng ký, quay lại màn đăng nhập
            val intent = Intent(this, LoginActivity_DuongQuangMinh::class.java)
            startActivity(intent)
            finish()
        }
    }
}
