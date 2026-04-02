/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Date;

/**
 *
 * @author huyhk
 */
public class NhaTro {

    String MaNhaTro;
    String MaLoai;
    double DienTich;
    double GiaPhong;
    String DiaChi;
    String Quan;
    String MoTa;
    Date NgayDangTin;
    String MaNguoiDung;
    TrangThaiPhong trangThai;

    public NhaTro() {
    }

    public NhaTro(String MaNhaTro, String MaLoai, double DienTich, double GiaPhong, String DiaChi, String Quan, String MoTa, Date NgayDangTin) {
        this.MaNhaTro = MaNhaTro;
        this.MaLoai = MaLoai;
        this.DienTich = DienTich;
        this.GiaPhong = GiaPhong;
        this.DiaChi = DiaChi;
        this.Quan = Quan;
        this.MoTa = MoTa;
        this.NgayDangTin = NgayDangTin;
    }

    public TrangThaiPhong getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(TrangThaiPhong trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaNhaTro() {
        return MaNhaTro;
    }

    public void setMaNhaTro(String MaNhaTro) {
        this.MaNhaTro = MaNhaTro;
    }

    public String getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(String MaLoai) {
        this.MaLoai = MaLoai;
    }

    public double getDienTich() {
        return DienTich;
    }

    public void setDienTich(double DienTich) {
        this.DienTich = DienTich;
    }

    public double getGiaPhong() {
        return GiaPhong;
    }

    public void setGiaPhong(double GiaPhong) {
        this.GiaPhong = GiaPhong;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getQuan() {
        return Quan;
    }

    public void setQuan(String Quan) {
        this.Quan = Quan;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public Date getNgayDangTin() {
        return NgayDangTin;
    }

    public void setNgayDangTin(Date NgayDangTin) {
        this.NgayDangTin = NgayDangTin;
    }

    public String getMaNguoiDung() {
        return MaNguoiDung;
    }

    public void setMaNguoiDung(String MaNguoiDung) {
        this.MaNguoiDung = MaNguoiDung;
    }

    @Override
    public String toString() {
        return "NHATRO{" + "MaNhaTro=" + MaNhaTro + ", MaLoai=" + MaLoai + ", DienTich=" + DienTich + ", GiaPhong=" + GiaPhong + ", DiaChi=" + DiaChi + ", Quan=" + Quan + ", MoTa=" + MoTa + ", NgayDangTin=" + NgayDangTin + ", MaNguoiDung=" + MaNguoiDung + '}';
    }

}
