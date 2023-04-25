/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication14;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author thaih
 */
public class Account {

    private long sotk;
    private String tentk;
    private double sotientrongtk;
    private String trangthai;
    Scanner scanner = new Scanner(System.in);
   public Account(){ 
      
   }

    public Account(long sotk, String tentk, double sotientrongtk, String trangthai) {
        this.sotk = sotk;
        this.tentk = tentk;
        this.sotientrongtk = sotientrongtk;
        this.trangthai = trangthai;
    }

    public long getSotk() {
        return sotk;
    }

    public void setSotk(long sotk) {    
        this.sotk = sotk;
    }

    public String getTentk() {
        return tentk;
    }

    public void setTentk(String tentk) {
        this.tentk = tentk;
    }

    public double getSotientrongtk() {
        return sotientrongtk;
    }

    public void setSotientrongtk(double sotientrongtk) {
        this.sotientrongtk = sotientrongtk;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
       Locale local = new Locale("vi", "VN");
       NumberFormat currencyEN = NumberFormat.getCurrencyInstance(local);
        String str1 = currencyEN.format(sotientrongtk);
        return "Account{" + "sotk=" + sotk + ", tentk=" + tentk + ", sotientrongtk=" + sotientrongtk + ", trangthai=" + trangthai + '}';
    }
    public double napTien() {
        double nap;
        System.out.print("Nhập số tiền bạn cần nạp: ");
        nap = scanner.nextDouble();
      
        if (nap >= 0) {
            sotientrongtk = nap + sotientrongtk;
            NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
            String str1 = currencyEN.format(nap);
            System.out.println("bạn vừa nạp " + str1 + " vào tài khoản.");
        } else {
            System.out.println("Số tiền nạp vào không hợp lệ!");
        }
        return nap;
    }
    
    public double rutTien() {
        double phi = 5;
        double rut;
        System.out.print("Nhập số tiền bạn cần rút: ");
        rut = scanner.nextDouble();
        
        if (rut <= (sotientrongtk - phi)) {
           sotientrongtk = sotientrongtk - (rut + phi);
            NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
            String str1 = currencyEN.format(rut);
            System.out.println("Bạn vừa rút " + str1 + "từ tài khoản Phí dịch vụ là $5.");
        } else {
            System.out.println("Số tiền rút không hợp lệ!");
            return rutTien();
        }
        return rut;
    }
     public double daoHan() {
        double laiSuat = 0.035;
        sotientrongtk = sotientrongtk + sotientrongtk * laiSuat;
        NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
        String str1 = currencyEN.format(sotientrongtk);
        System.out.println("Bạn vừa được " + str1 + " từ đáo hạn 1 tháng");
        return sotientrongtk;
    }
     
     public void nhaptk(Account tk){
          System.out.println("Nhập số tài khoản: ");
        tk.setSotk(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Nhập tên tài khoản: ");
        tk.setTentk(scanner.nextLine());
        tk.setSotientrongtk(50);
     }
     public void xuattk(){
         NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
        String str1 = currencyEN.format(sotientrongtk);
         System.out.println("{số tài khoản:"+getSotk()+", tên tài khoản:"+getTentk()+",sô tiền trong tài khoản:"+getSotientrongtk()+"}");
     }
     
}
   

   
   
 