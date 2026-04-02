/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
public class JDBC_Helper {
    public static Connection getConnection() throws Exception {
        List<String> configs = new ArrayList<>();
        
        // 1. Đọc file cấu hình (áp dụng đúng đoạn code Mint gửi nè)
        try (BufferedReader br = new BufferedReader(new FileReader("db_config.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                configs.add(line.trim()); // trim() để xóa khoảng trắng thừa nếu có
            }
        } catch (Exception e) {
            throw new Exception("Không đọc được file cấu hình db_config.txt: " + e.getMessage());
        }

        // 2. Kiểm tra xem có đủ 5 thông số không
        if (configs.size() < 5) {
            throw new Exception("File cấu hình thiếu thông số kết nối!");
        }

        // 3. Gán các giá trị đã đọc được
        String host     = configs.get(0); // localhost
        String port     = configs.get(1); // 1433
        String dbName   = configs.get(2); // Tên database
        String user     = configs.get(3); // sa
        String pass     = configs.get(4); // mật khẩu

        // 4. Lắp ráp chuỗi URL kết nối
        String url = String.format("jdbc:sqlserver://%s:%s;databaseName=%s;encrypt=false", 
                                    host, port, dbName);

        // 5. Kết nối 
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, user, pass);
    }
}
