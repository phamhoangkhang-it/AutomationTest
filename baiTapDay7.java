package day7_BaiTapDay7;

import java.util.Scanner;

public class baiTapDay7 {

	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	        int n = nhapSoLuongNV(scanner);
	        String[] nv = inputTenNV(scanner, n);
	        
	        printEmployeeList(nv);
	        
	        scanner.close();
	    }
	    
	    public static int nhapSoLuongNV(Scanner scanner) {
	        System.out.print("Nhập số lượng nhân viên: ");
	        int n = scanner.nextInt();
	        scanner.nextLine(); 
	        return n;
	    }
	    
	    public static String[] inputTenNV(Scanner scanner, int n) {
	        String[] employees = new String[n];
	        for (int i = 0; i < n; i++) {
	            System.out.print("Nhập tên nhân viên thứ " + (i + 1) + ": ");
	            employees[i] = scanner.nextLine();
	        }
	        return employees;
	    }
	    
	    public static void printEmployeeList(String[] employees) {
	        System.out.println("\nDanh sách nhân viên:");
	        for (String employee : employees) {
	            System.out.println(employee);
	        }
	    }
	}
