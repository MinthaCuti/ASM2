/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Models.NguoiDung;
import Models.NhaTro;
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
}
