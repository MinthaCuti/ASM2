/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Models.NguoiDung;
import Models.NhaTro;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author huyhk
 */
public class NhaTroService {

    // danh sach nha tro
    ArrayList<NhaTro> list = new ArrayList<>();

    // THEM
    public void add(NhaTro nt, NguoiDungService ndService) throws Exception {

        // regex: NT + so
        if (!nt.getMaNhaTro().matches("NT\\d+")) {
            throw new Exception("Ma nha tro phai co dang NT + so");
        }

        // kiem tra trung ma
        for (NhaTro x : list) {
            if (x.getMaNhaTro().equals(nt.getMaNhaTro())) {
                throw new Exception("Ma nha tro da ton tai");
            }
        }

        // kiem tra gia phong
        if (nt.getGiaPhong() <= 0) {
            throw new Exception("Gia phong phai lon hon 0");
        }

        // kiem tra nguoi dung ton tai
        NguoiDung chuNha = ndService.findById(nt.getMaNguoiDung());

        chuNha.getDanhSachNhaTro().add(nt);
        // them vao danh sach
        list.add(nt);
    }

    // LAY TAT CA
    public ArrayList<NhaTro> getAll() {
        return list;
    }

    // TIM THEO MA
    public NhaTro findById(String ma) throws Exception {

        for (NhaTro x : list) {
            if (x.getMaNhaTro().equals(ma)) {
                return x;
            }
        }

        throw new Exception("Khong tim thay nha tro");
    }

    // CAP NHAT
    public void update(NhaTro nt) throws Exception {

        NhaTro old = findById(nt.getMaNhaTro());

        old.setDienTich(nt.getDienTich());
        old.setGiaPhong(nt.getGiaPhong());
        old.setDiaChi(nt.getDiaChi());
        old.setQuan(nt.getQuan());
        old.setMoTa(nt.getMoTa());
        old.setNgayDangTin(nt.getNgayDangTin());
        old.setMaNguoiDung(nt.getMaNguoiDung());
    }

    // XOA
    public void delete(String ma) throws Exception {

        NhaTro nt = findById(ma);

        list.remove(nt);
    }

// LƯU FILE
    public void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("nhatro.txt"))) {
            for (NhaTro nt : list) {
                // Lưu đầy đủ các cột, cách nhau bằng dấu phẩy
                String line = nt.getMaNhaTro() + ","
                        + nt.getDienTich() + ","
                        + nt.getGiaPhong() + ","
                        + nt.getDiaChi() + ","
                        + nt.getQuan() + ","
                        + nt.getMaNguoiDung();
                bw.write(line);
                bw.newLine();
            }
            System.out.println("Lưu file nhatro.txt thành công!");
        } catch (Exception e) {
            System.out.println("Lỗi lưu file: " + e.getMessage());
        }
    }

// ĐỌC FILE
    public void readFromFile() {
        // Xóa list cũ trước khi đọc để tránh bị trùng lặp dữ liệu
        list.clear();
        try (BufferedReader br = new BufferedReader(new FileReader("nhatro.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length < 6) {
                    continue; // Bỏ qua dòng lỗi
                }
                NhaTro nt = new NhaTro();
                nt.setMaNhaTro(data[0]);
                nt.setDienTich(Double.parseDouble(data[1]));
                nt.setGiaPhong(Double.parseDouble(data[2]));
                nt.setDiaChi(data[3]);
                nt.setQuan(data[4]);
                nt.setMaNguoiDung(data[5]);

                list.add(nt);
            }
            System.out.println("Đọc file nhatro.txt thành công!");
        } catch (Exception e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
    }
}
public void insertToDb(NhaTro nt) throws Exception {
    String sql = "INSERT INTO NhaTro (MaNhaTro, DienTich, GiaPhong, DiaChi, Quan, MoTa, MaNguoiDung) VALUES (?, ?, ?, ?, ?, ?, ?)";
    
    try (java.sql.Connection con = Helpers.JdbcHelper.getConnection();
         java.sql.PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setString(1, nt.getMaNhaTro());
        ps.setDouble(2, nt.getDienTich());
        ps.setDouble(3, nt.getGiaPhong());
        ps.setString(4, nt.getDiaChi());
        ps.setString(5, nt.getQuan());
        ps.setString(6, nt.getMoTa());
        ps.setString(7, nt.getMaNguoiDung());

        ps.executeUpdate();
    }
}