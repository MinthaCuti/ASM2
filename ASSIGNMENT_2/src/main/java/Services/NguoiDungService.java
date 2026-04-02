/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Models.NguoiDung;
import java.util.ArrayList;

/**
 *
 * @author huyhk
 */
public class NguoiDungService {

    // danh sach luu nguoi dung
    ArrayList<NguoiDung> list = new ArrayList<>();

    // THEM 
    public void add(NguoiDung nd) throws Exception {

        // kiem tra ma nguoi dung theo regex: ND + so
        if (!nd.getMaNguoiDung().matches("ND\\d+")) {
            throw new Exception("Ma nguoi dung phai co dang ND + so");
        }

        // kiem tra trung ma
        for (NguoiDung x : list) {
            if (x.getMaNguoiDung().equals(nd.getMaNguoiDung())) {
                throw new Exception("Ma nguoi dung da ton tai");
            }
        }

        // kiem tra so dien thoai chi duoc nhap so
        if (!nd.getDienThoai().matches("\\d+")) {
            throw new Exception("So dien thoai chi duoc nhap so");
        }

        // them vao list
        list.add(nd);
    }

    // LAY TAT CA
    public ArrayList<NguoiDung> getAll() {
        return list;
    }

    // TIM THEO MA 
    public NguoiDung findById(String ma) throws Exception {

        for (NguoiDung x : list) {
            if (x.getMaNguoiDung().equals(ma)) {
                return x;
            }
        }

        throw new Exception("Khong tim thay nguoi dung");
    }

    // CAP NHAT
    public void update(NguoiDung nd) throws Exception {

        // tim nguoi dung cu
        NguoiDung old = findById(nd.getMaNguoiDung());

        // cap nhat thong tin
        old.setTenNguoiDung(nd.getTenNguoiDung());
        old.setGioiTinh(nd.isGioiTinh());
        old.setDienThoai(nd.getDienThoai());
        old.setDiaChi(nd.getDiaChi());
        old.setQuan(nd.getQuan());
        old.setEmail(nd.getEmail());
    }

    // XOA 
    public void delete(String ma) throws Exception {

        NguoiDung nd = findById(ma);

        list.remove(nd);
    }
}
