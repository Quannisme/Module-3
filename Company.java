package company;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Emp
{
	private String id, name;
	private int ns;
	private double hsl;
	void nhap()
	{
		System.out.println(" nhap nhan vien");
		Scanner kb= new Scanner(System.in);
		System.out.print(" nhap ho ten:"); name= kb.nextLine();
		System.out.print(" nhap ma so:"); name= kb.nextLine();
		System.out.print(" nhap nam sinh:"); ns= kb.nextInt();
		System.out.print(" nhap he so luong:"); hsl= kb.nextDouble();
	}
	Emp(){}
	Emp(String n1, String id1, int ns1, double hsl1)
	{
		name=n1; id=id1; ns=ns1; hsl=hsl1;
	}
	void in() {
		System.out.println(" In nhan vien");
	}
	double tinhluong() {  return hsl*1500000; }
}
class Manager extends Emp
{
	private String cv;
	private double bonus;
	Manager() {	}
	Manager(String n1, String id1, int ns1, double hsl1, String cv1, double pc1)
	{
		super(n1, id1, ns1, hsl1);
		cv=cv1; bonus=pc1;
	}
	void nhap()
	{
		super.nhap();
		System.out.println(" nhap thong tin quan ly");
	}
	void in() {
		super.in();
		System.out.println(" In thong tin quan ly");
	}
	double tinhluong() {  return super.tinhluong() + bonus; }
}
class sortbySalary implements Comparator<Emp>
{
	public int compare(Emp a, Emp b)
	{
		if (a.tinhluong()> b.tinhluong()) return 1;
		else return 0;
	}
}
public class Company {
	Emp []a;
	void sapxep2() { Arrays.sort(a, new sortbySalary()); }
	
	void nhap()
	{
		System.out.println(" nhap so nhan vien:"); 
		Scanner kb= new Scanner(System.in);
		int n= kb.nextInt();
		a= new Emp[n];
		for(int i=0; i<n; i++)
		{
			
			System.out.print("\n Nhap nguoi thu "+ (i+1)+ ":");
			System.out.print("nhap nhan vien (1) hay quan ly (<>1):");
			int tl= kb.nextInt();
			if(tl==1) { Emp e= new Emp(); e.nhap(); a[i]=e; }
			else { Manager m= new Manager(); m.nhap(); a[i]=m; }	
		}
	}
	void in() { for(Emp e:a) e.in(); }
	void sapxep1()
	{
		for(int i=0; i<a.length; i++)
			for(int j=0; j<a.length; j++)
				if(a[i].tinhluong()>a[j].tinhluong())
				{
					Emp t= a[i]; a[i]=a[j]; a[j]=t;
					
				}
	}
	void docfile(String fn)
	{
		try
		{
			Scanner kb= new Scanner(new File(fn));
			String t1= kb.nextLine();
			int n= Integer.parseInt(t1);
			System.out.println("\n N= " + n);
			a= new Emp[n];
			for(int i=0; i<n; i++)
			{
				t1= kb.nextLine();
				int tl= Integer.parseInt(t1);
				if(tl==1) { 
					String n1, id1, t;
					int ns1;
					double hsl1;
					n1= kb.nextLine(); id1=kb.nextLine(); 
					t= kb.nextLine(); ns1=Integer.parseInt(t);  
					t= kb.nextLine(); hsl1= Double.parseDouble(t);
					Emp e= new Emp(n1, id1, ns1, hsl1); a[i]=e; 
					System.out.println(i + id1 + " :" + n1);
				}
				else { 
					String n1, id1, cv1, t;
					int ns1;
					double hsl1, pc1;
					n1= kb.nextLine(); id1=kb.nextLine(); 
					t= kb.nextLine(); ns1=Integer.parseInt(t);  
					t= kb.nextLine(); hsl1= Double.parseDouble(t);
					cv1= kb.nextLine();  
					t= kb.nextLine(); pc1= Double.parseDouble(t);
					Manager m= new Manager(n1, id1, ns1, hsl1, cv1, pc1); 
					a[i]=m; 
					System.out.println(i + id1 + " :" + n1+ " bonus: " + pc1);
				}	
			}
		} catch(IOException e) { System.out.println("\n Loi doc ghi file!" + e); }
	}
	public static void main(String[] args) {
		Company c= new Company();
		c.docfile("E:\\congty.txt"); 
		c.in();
	}
}
