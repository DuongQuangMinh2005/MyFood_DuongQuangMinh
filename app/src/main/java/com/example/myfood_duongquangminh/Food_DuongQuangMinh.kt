package com.example.myfood_duongquangminh

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Food_DuongQuangMinh(context: Context) : SQLiteOpenHelper(context,"Food_DuongQuangMinh.db",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        // Tạo bảng User
        db?.execSQL("CREATE TABLE User_DuongQuangMinh(id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT)")
        // Tạo bảng Restaurant_DuongQuangMinh
        db?.execSQL("CREATE TABLE Restaurant_DuongQuangMinh(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, address TEXT, image TEXT)")
        // Tạo bảng Food_DuongQuangMinh
        db?.execSQL("CREATE TABLE Food_DuongQuangMinh(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, price INTEGER, size TEXT, description TEXT, image TEXT, restaurantId INTEGER, FOREIGN KEY (restaurantId) REFERENCES Restaurant_DuongQuangMinh(id))")
        // Thêm dữ liệu mẫu cho User
        db?.execSQL("INSERT INTO User_DuongQuangMinh(username, password) VALUES('user1', 'pass1')")
        db?.execSQL("INSERT INTO User_DuongQuangMinh(username, password) VALUES('user2', 'pass2')")
        db?.execSQL("INSERT INTO User_DuongQuangMinh(username, password) VALUES('user3', 'pass3')")
        db?.execSQL("INSERT INTO User_DuongQuangMinh(username, password) VALUES('user4', 'pass4')")
        db?.execSQL("INSERT INTO User_DuongQuangMinh(username, password) VALUES('user5', 'pass5')")
        // Thêm dữ liệu mẫu cho Restaurant
        db?.execSQL("INSERT INTO Restaurant_DuongQuangMinh(name, address, image) VALUES('nhà hàng A','1 Lê Lợi','img1')")
        db?.execSQL("INSERT INTO Restaurant_DuongQuangMinh(name, address, image) VALUES('nhà hàng B','2 Lê Lợi','img2')")
        db?.execSQL("INSERT INTO Restaurant_DuongQuangMinh(name, address, image) VALUES('nhà hàng C','3 Lê Lợi','img3')")
        db?.execSQL("INSERT INTO Restaurant_DuongQuangMinh(name, address, image) VALUES('nhà hàng D','4 Lê Lợi','img4')")
        db?.execSQL("INSERT INTO Restaurant_DuongQuangMinh(name, address, image) VALUES('nhà hàng E','5 Lê Lợi','img5')")
        // Thêm dữ liệu mẫu cho Food
        db?.execSQL("INSERT INTO Food_DuongQuangMinh(name,price,size,description,image,restaurantId) VALUES('Phở Bò', 35000, 'Small', 'Phở bò thơm ngon', 'food1', 1)")
        db?.execSQL("INSERT INTO Food_DuongQuangMinh(name,price,size,description,image,restaurantId) VALUES('Cơm Tấm', 40000, 'Small', 'Cơm tấm sườn bì', 'food2', 1)")
        db?.execSQL("INSERT INTO Food_DuongQuangMinh(name,price,size,description,image,restaurantId) VALUES('Bún Chả', 32000, 'Small', 'Bún chả Hà Nội', 'food3', 2)")
        db?.execSQL("INSERT INTO Food_DuongQuangMinh(name,price,size,description,image,restaurantId) VALUES('Bánh Mì', 20000, 'Small', 'Bánh mì pate', 'food4', 2)")
        db?.execSQL("INSERT INTO Food_DuongQuangMinh(name,price,size,description,image,restaurantId) VALUES('Mì Quảng', 37000, 'Small', 'Mì Quảng Đà Nẵng', 'food5', 3)")
        db?.execSQL("INSERT INTO Food_DuongQuangMinh(name,price,size,description,image,restaurantId) VALUES('Bánh Cuốn', 30000, 'Small', 'Bánh cuốn nóng', 'food6', 3)")
        db?.execSQL("INSERT INTO Food_DuongQuangMinh(name,price,size,description,image,restaurantId) VALUES('Gỏi Cuốn', 25000, 'Small', 'Gỏi cuốn tôm thịt', 'food7', 4)")
        db?.execSQL("INSERT INTO Food_DuongQuangMinh(name,price,size,description,image,restaurantId) VALUES('Chả Giò', 22000, 'Small', 'Chả giò miền Nam', 'food8', 4)")
        db?.execSQL("INSERT INTO Food_DuongQuangMinh(name,price,size,description,image,restaurantId) VALUES('Hủ Tiếu', 33000, 'Small', 'Hủ tiếu Nam Vang', 'food9', 5)")
        db?.execSQL("INSERT INTO Food_DuongQuangMinh(name,price,size,description,image,restaurantId) VALUES('Bánh Xèo', 28000, 'Small', 'Bánh xèo miền Tây', 'food10', 5)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS User_DuongQuangMinh")
        db?.execSQL("DROP TABLE IF EXISTS Restaurant_DuongQuangMinh")
        db?.execSQL("DROP TABLE IF EXISTS Food_DuongQuangMinh")
        onCreate(db)
    }

}
