/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Views;

import Models.NguoiDung;
import Models.NhaTro;
import Models.TrangThaiPhong;
import Services.NguoiDungService;
import Services.NhaTroService;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author huyhk
 */
public class ASSIGNMENT_2 {

    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NguoiDungService ndService = new NguoiDungService();
        NhaTroService ntService = new NhaTroService();

        int chon;

        while (true) {

            System.out.println("\n===== QUAN LY NHA TRO =====");
            System.out.println("1. Them nguoi dung");
            System.out.println("2. Them nha tro");
            System.out.println("3. Hien thi nguoi dung");
            System.out.println("4. Hien thi nha tro");
            System.out.println("5. Cap nhat nguoi dung");
            System.out.println("6. Xoa nguoi dung");
            System.out.println("7. Cap nhat nha tro");
            System.out.println("8. Xoa nha tro");
            System.out.println("0. Thoat");

            System.out.print("Chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {

                // THEM NGUOI DUNG
                case 1:

                    while (true) {
                        try {

                            NguoiDung nd = new NguoiDung();

                            System.out.print("Ma nguoi dung: ");
                            nd.setMaNguoiDung(sc.nextLine());

                            System.out.print("Ten nguoi dung: ");
                            nd.setTenNguoiDung(sc.nextLine());

                            System.out.print("Gioi tinh: ");
                            nd.setGioiTinh(Boolean.parseBoolean(sc.nextLine()));

                            System.out.print("Dien thoai: ");
                            nd.setDienThoai(sc.nextLine());

                            System.out.print("Dia chi: ");
                            nd.setDiaChi(sc.nextLine());

                            System.out.print("Quan: ");
                            nd.setQuan(sc.nextLine());

                            System.out.print("Email: ");
                            nd.setEmail(sc.nextLine());

                            ndService.add(nd);

                            System.out.println("Them thanh cong!");
                            break;

                        } catch (Exception e) {
                            System.out.println("Loi: " + e.getMessage());
                            System.out.println("Nhap lai!");
                        }
                    }

                    break;

                // THEM NHA TRO
                case 2:

                    while (true) {
                        try {

                            NhaTro nt = new NhaTro();

                            System.out.print("Ma nha tro: ");
                            nt.setMaNhaTro(sc.nextLine());

                            System.out.print("Dien tich: ");
                            nt.setDienTich(Double.parseDouble(sc.nextLine()));

                            System.out.print("Gia phong: ");
                            nt.setGiaPhong(Double.parseDouble(sc.nextLine()));

                            System.out.print("Dia chi: ");
                            nt.setDiaChi(sc.nextLine());

                            System.out.print("Quan: ");
                            nt.setQuan(sc.nextLine());

                            System.out.print("Mo ta: ");
                            nt.setMoTa(sc.nextLine());

                            System.out.println("Chọn trạng thái (1. Còn tốt, 2. Hư hỏng, 3. Bảo trì): ");
                            int statusChoice = Integer.parseInt(sc.nextLine());
                            switch (statusChoice) {
                                case 1 ->
                                    nt.setTrangThai(TrangThaiPhong.Con_Tot);
                                case 2 ->
                                    nt.setTrangThai(TrangThaiPhong.Hu_Hong);
                                default ->
                                    nt.setTrangThai(TrangThaiPhong.Bao_tri);
                            }

                            nt.setNgayDangTin(new Date());

                            System.out.print("Ma nguoi dung: ");
                            nt.setMaNguoiDung(sc.nextLine());

                            ntService.add(nt, ndService);
                            
                            

                            System.out.println("Them thanh cong!");
                            break;

                        } catch (Exception e) {
                            System.out.println("Loi: " + e.getMessage());
                            System.out.println("Nhap lai!");
                        }
                    }

                    break;

                // HIEN THI NGUOI DUNG
                case 3:

                    for (NguoiDung x : ndService.getAll()) {
                        System.out.println(x);
                    }

                    break;

                // HIEN THI NHA TRO
                case 4:

                    for (NhaTro x : ntService.getAll()) {
                        System.out.println(x);
                    }

                    break;

                // CAP NHAT NGUOI DUNG
                case 5:

                    try {

                        NguoiDung nd = new NguoiDung();

                        System.out.print("Nhap ma nguoi dung: ");
                        nd.setMaNguoiDung(sc.nextLine());

                        System.out.print("Ten moi: ");
                        nd.setTenNguoiDung(sc.nextLine());

                        System.out.print("Gioi tinh: ");
                        nd.setGioiTinh(Boolean.parseBoolean(sc.nextLine()));

                        System.out.print("Dien thoai: ");
                        nd.setDienThoai(sc.nextLine());

                        System.out.print("Dia chi: ");
                        nd.setDiaChi(sc.nextLine());

                        System.out.print("Quan: ");
                        nd.setQuan(sc.nextLine());

                        System.out.print("Email: ");
                        nd.setEmail(sc.nextLine());

                        ndService.update(nd);

                        System.out.println("Cap nhat thanh cong");

                    } catch (Exception e) {
                        System.out.println("Loi: " + e.getMessage());
                    }

                    break;

                // XOA NGUOI DUNG
                case 6:

                    try {

                        System.out.print("Nhap ma nguoi dung can xoa: ");
                        String ma = sc.nextLine();

                        ndService.delete(ma);

                        System.out.println("Xoa thanh cong");

                    } catch (Exception e) {
                        System.out.println("Loi: " + e.getMessage());
                    }

                    break;

                // ================= CAP NHAT NHA TRO =================
                case 7:

                    try {

                        NhaTro nt = new NhaTro();

                        System.out.print("Ma nha tro: ");
                        nt.setMaNhaTro(sc.nextLine());

                        System.out.print("Dien tich: ");
                        nt.setDienTich(Double.parseDouble(sc.nextLine()));

                        System.out.print("Gia phong: ");
                        nt.setGiaPhong(Double.parseDouble(sc.nextLine()));

                        System.out.print("Dia chi: ");
                        nt.setDiaChi(sc.nextLine());

                        System.out.print("Quan: ");
                        nt.setQuan(sc.nextLine());

                        System.out.print("Mo ta: ");
                        nt.setMoTa(sc.nextLine());

                        nt.setNgayDangTin(new Date());

                        System.out.print("Ma nguoi dung: ");
                        nt.setMaNguoiDung(sc.nextLine());

                        ntService.update(nt);

                        System.out.println("Cap nhat thanh cong");

                    } catch (Exception e) {
                        System.out.println("Loi: " + e.getMessage());
                    }

                    break;

                // XOA NHA TRO
                case 8:

                    try {

                        System.out.print("Nhap ma nha tro can xoa: ");
                        String ma = sc.nextLine();

                        ntService.delete(ma);

                        System.out.println("Xoa thanh cong");

                    } catch (Exception e) {
                        System.out.println("Loi: " + e.getMessage());
                    }

                    break;

                case 0:
                    System.exit(0);

                default:
                    System.out.println("Khong co chuc nang nay");
            }
        }
    }
}
