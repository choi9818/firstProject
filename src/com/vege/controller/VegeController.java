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
			System.out.println("| 1.간편 회원가입 | 2.로그인 | 3.메뉴보기 | 4.주문 | 5.주문확인 | 6.종료 |");
			System.out.println("===============================================================");
			System.out.print("MAIN 선택>> ");

			String inputStr = sc.next();

			switch (inputStr) {
			case "1":insert();break;
			case "2":login();break;
			case "3":menu();break;
			case "4":purchase();break;
			case "5":pdetail();break;
			case "6":exit();break;

			default:
				System.out.println("제공되지 않는 옵션입니다.");
				break;
			}
		}
	}

	private static void insert() {

		System.out.print("전화번호를 입력해주세요(하이픈(-)없이 숫자만 입력) : ");
		phone_num = sc.next();
		System.out.print("성함을 입력해주세요 : ");
		String customer_name = sc.next();
		System.out.print("생년월일을 입력해주세요(00/00/00) : ");
		Date birth = DateUtil.convertToDate(sc.next());
		System.out.print("주소를 입력해주세요 : ");
		String address = sc.next();

		int result = service.customerInsert(new CustomerDTO(phone_num, birth, customer_name, address));
		
		if (result >= 1) {
			System.out.println();
			System.out.println("간편 회원가입을 완료했습니다.");
		}
		else
			System.out.println("간편 회원가입에 실패했습니다.");
	}
	
	private static void login() {
		System.out.print("전화번호를 입력해주세요 : ");
		phone_num = sc.next();
		System.out.print("성함을 입력해주세요 : ");
		customer_name = sc.next();
		customer = service.login(phone_num, customer_name);
		System.out.println();
		if (customer == null) {
			System.out.println("로그인에 실패했습니다. 입력하신 정보가 정확한지 확인해 주세요.");
		}else {
			System.out.println(customer_name + "님 안녕하세요.");
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
			System.out.println("로그인이 되어있지 않습니다. MAIN의 [2.로그인] 먼저 진행해 주세요.");
			return;
		} else {
			List<PurchaseDetailDTO> detailList = new ArrayList<>();
			while (true) {
				System.out.print("주문하고자 하는 메뉴의 번호를 선택해 주세요 : ");
				int pnum = sc.nextInt();
				System.out.print("주문하고자 하는 메뉴의 수량을 입력해 주세요 : ");
				int purchase_quantity = sc.nextInt();
				PurchaseDetailDTO detail = new PurchaseDetailDTO(0, 0, pnum, purchase_quantity);
				detailList.add(detail);
				System.out.print("계속 주문하시겠습니까?(Y/N)>> ");
				String go = sc.next();
				if (go.equalsIgnoreCase("N"))
					break;
			}
			purchase_num = purservice.purchaseInsert(customer, detailList);
		}
	}
	
	private static void pdetail() {
		PurchaseDetailService service = new PurchaseDetailService();
		
		System.out.print("주문시 로그인한 전화번호를 입력해 주세요 : ");
		phone_num = sc.next();
		System.out.print("주문시 로그인한 성함을 입력해 주세요 : ");
		customer_name = sc.next();
		if(purchase_num==0) {
			System.out.println("주문 내역 없음");
			return;
		}
		List<PurchaseDetailResultVO> detaillist = service.totalPrice(purchase_num, phone_num, customer_name);
		int total_amount=0;
		for(PurchaseDetailResultVO detail:detaillist) {
			System.out.println(detail);
			total_amount += detail.getAmount();
		}
		System.out.println("합계 금액:" + total_amount);
			System.out.println("주문상태:[주문완료]");
	}
	private static void exit() {
		System.out.println();
		System.out.println("프로그램을 종료합니다.");
		bool = false;
		
	}
}
