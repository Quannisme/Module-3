package Tinh;
import java.util.*;
public class Nhap_3_so {
Scanner sc=new Scanner(System.in);
//Hoang Minh Hai
//giai phuong trinh bac 1
void tinhPtBac1()
{
	System.out.println("Nhap so a:");
	int	a=sc.nextInt();
	System.out.println("Nhap so b:");
	int b=sc.nextInt();
	System.out.println("Phuong trinh co dang tong quat:"+(b+"x"+"+"+a+"="+"0"));
	System.out.println("nghiem cua phuong trinh:"+(-b/a));
}
//Nguyen Van Thien
//giai phuong trinh bac 2
void tinhPTBac2()
{
	System.out.println("Nhap so a:");
	int a=sc.nextInt();
	System.out.println("Nhap so b:");
	int b=sc.nextInt();
	System.out.println("Nhap so c:");
	int c=sc.nextInt();
	System.out.println("Phuong trinh co dang tong quat:"+(b+"x^2"+"+"+a+"x"+"+"+c+"="+"0"));
	int delta=b*b - 4*a*c;
	int x1,x2;
	System.out.println("Dental:"+delta);
	if (delta > 0) {
        x1 =  (int) ((-b + Math.sqrt(delta)) / (2*a));
        x2 =  (int) ((-b - Math.sqrt(delta)) / (2*a));
        System.out.println("Phương trình có 2 nghiệm là: "
                + "x1 = " + x1 + " và x2 = " + x2);
    } else {
        System.out.println("Phương trình vô nghiệm!");
    }
}
//Nguyen Van Quan
//tinh dien tich va nhan dang hinh thang
void tinhDienTichVaNhanDangHinhThang()
{
	  System.out.print("Nhap day lon: ");
      double base1 = sc.nextDouble();

      System.out.print("Nhap day nho: ");
      double base2 = sc.nextDouble();

      System.out.print("Nhap chieu cao: ");
      double height = sc.nextDouble();
      
      System.out.print("Nhập độ dài cạnh bên: ");
      double side = sc.nextDouble();
      
      double area = (base1 + base2) * height / 2;
      System.out.println("dien tich hinh thang : " + area);
      if (base1 == base2) {
          if (height == Math.sqrt(side * side - Math.pow((base1 - base2) / 2, 2))) {
              System.out.println("Đây là hình thang vuong(can)");
          }else
          {
        	  System.out.println("Day la hinh thang can(vuong)");
          }
      }
}
//Nguyen Minh Bao
// tinh dien tich va nhan dang hinh chu nhat
void tinhDienTichVaNhanDangHCN()
{
	 System.out.print("Nhapa chieu dai: ");
     double length = sc.nextDouble();

     System.out.print("Nhap cchieu rong: ");
     double width = sc.nextDouble();
     
     System.out.println("Thong ttin cua hinh chu nhat:");
     System.out.println("Chieu ddai:"+width);
     System.out.println("Chieu rrong:"+length);
     
     double area = length * width;
     System.out.println("Dien tich hinh chu nhat: " + area);

     if (length == width) {
         System.out.println("Hinh nay la hinh chu nhat dai");
     } else if (length > width)	 {
         System.out.println("Hinh nay la hinh vuong ");
     } else {
         System.out.println("Hinh nay la hinh chu nhat rong");
     }
 }
//Dang Xuan Son
//tinh dien tich va nhan dang hinh tam giac
void tinhDienTichVaNhanDangHinhTamGiac()
{
    System.out.print("Nhập độ dài cạnh 1: ");
    int a = sc.nextInt();
    System.out.print("Nhập độ dài cạnh 2: ");
    int b = sc.nextInt();
    System.out.print("Nhập độ dài cạnh 3: ");
    int c = sc.nextInt();

    double p = (a + b + c) / 2;
    double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));

     if (a == b && b == c) {
        System.out.println("Tam giác cân");
        System.out.println("Diện tích = " + area);
    } else if (a == b || b == c || a == c) {
        System.out.println("Tam giác đều");
        System.out.println("Diện tích = " + area);
    } else {
        System.out.println("Tam giác thường");
        System.out.println("Diện tích = " + area);
    }
}
public static void main(String[] args) {
	Nhap_3_so s1 =new Nhap_3_so();
//	s1.tinhPtBac1();
////	s1.tinhPTBac2();
//	s1.tinhDienTichVaNhanDangHCN();
//	s1.tinhPtBac3();
	s1.tinhDienTichVaNhanDangHinhTamGiac();
}
}
