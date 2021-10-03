package com.vege.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vege.model.CustomerDTO;
import com.vege.model.CustomerService;
import com.vege.model.ProductService;
import com.vege.model.PurchaseDetailDTO;
import com.vege.model.PurchaseDetailResultVO;
import com.vege.model.PurchaseDetailService;
import com.vege.model.PurchaseService;
import com.vege.util.DateUtil;
import com.vege.view.ProductView;
import com.vege.view.PurchaseDetailView;

public class VegeController {
	static Scanner sc = new Scanner(System.in);
	static CustomerDTO customer;
	static String phone_num;
	static String customer_name;
	static CustomerService service = new CustomerService();
	static int purchase_num;
	static boolean bool = true;
	public static void main(String[] args) {

		while (bool) {
			System.out.println("=============================MAIN==============================");
			System.out.println("| 1.���� ȸ������ | 2.�α��� | 3.�޴����� | 4.�ֹ� | 5.�ֹ�Ȯ�� | 6.���� |");
			System.out.println("===============================================================");
			System.out.print("MAIN ����>> ");

			String inputStr = sc.next();

			switch (inputStr) {
			case "1":insert();break;
			case "2":login();break;
			case "3":menu();break;
			case "4":purchase();break;
			case "5":pdetail();break;
			case "6":exit();break;

			default:
				System.out.println("�������� �ʴ� �ɼ��Դϴ�.");
				break;
			}
		}
	}

	private static void insert() {

		System.out.print("��ȭ��ȣ�� �Է����ּ���(������(-)���� ���ڸ� �Է�) : ");
		phone_num = sc.next();
		System.out.print("������ �Է����ּ��� : ");
		String customer_name = sc.next();
		System.out.print("��������� �Է����ּ���(00/00/00) : ");
		Date birth = DateUtil.convertToDate(sc.next());
		System.out.print("�ּҸ� �Է����ּ��� : ");
		String address = sc.next();

		int result = service.customerInsert(new CustomerDTO(phone_num, birth, customer_name, address));
		
		if (result >= 1) {
			System.out.println();
			System.out.println("���� ȸ�������� �Ϸ��߽��ϴ�.");
		}
		else
			System.out.println("���� ȸ�����Կ� �����߽��ϴ�.");
	}
	
	private static void login() {
		System.out.print("��ȭ��ȣ�� �Է����ּ��� : ");
		phone_num = sc.next();
		System.out.print("������ �Է����ּ��� : ");
		customer_name = sc.next();
		customer = service.login(phone_num, customer_name);
		System.out.println();
		if (customer == null) {
			System.out.println("�α��ο� �����߽��ϴ�. �Է��Ͻ� ������ ��Ȯ���� Ȯ���� �ּ���.");
		}else {
			System.out.println(customer_name + "�� �ȳ��ϼ���.");
		}
	}
	
	private static void menu() {
		ProductService service = new ProductService();
		ProductView.display(service.selectAll());

	}

	private static void purchase() {
		PurchaseService purservice = new PurchaseService();
		if (phone_num == null) {
			System.out.println();
			System.out.println("�α����� �Ǿ����� �ʽ��ϴ�. MAIN�� [2.�α���] ���� ������ �ּ���.");
			return;
		} else {
			List<PurchaseDetailDTO> detailList = new ArrayList<>();
			while (true) {
				System.out.print("�ֹ��ϰ��� �ϴ� �޴��� ��ȣ�� ������ �ּ��� : ");
				int pnum = sc.nextInt();
				System.out.print("�ֹ��ϰ��� �ϴ� �޴��� ������ �Է��� �ּ��� : ");
				int purchase_quantity = sc.nextInt();
				PurchaseDetailDTO detail = new PurchaseDetailDTO(0, 0, pnum, purchase_quantity);
				detailList.add(detail);
				System.out.print("��� �ֹ��Ͻðڽ��ϱ�?(Y/N)>> ");
				String go = sc.next();
				if (go.equalsIgnoreCase("N"))
					break;
			}
			purchase_num = purservice.purchaseInsert(customer, detailList);
		}
	}
	
	private static void pdetail() {
		PurchaseDetailService service = new PurchaseDetailService();
		
		System.out.print("�ֹ��� �α����� ��ȭ��ȣ�� �Է��� �ּ��� : ");
		phone_num = sc.next();
		System.out.print("�ֹ��� �α����� ������ �Է��� �ּ��� : ");
		customer_name = sc.next();
		if(purchase_num==0) {
			System.out.println("�ֹ� ���� ����");
			return;
		}
		List<PurchaseDetailResultVO> detaillist = service.totalPrice(purchase_num, phone_num, customer_name);
		int total_amount=0;
		for(PurchaseDetailResultVO detail:detaillist) {
			System.out.println(detail);
			total_amount += detail.getAmount();
		}
		System.out.println("�հ� �ݾ�:" + total_amount);
			System.out.println("�ֹ�����:[�ֹ��Ϸ�]");
	}
	private static void exit() {
		System.out.println();
		System.out.println("���α׷��� �����մϴ�.");
		bool = false;
		
	}
}
