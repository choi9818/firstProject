package com.vege.view;

import java.util.List;

import com.vege.model.PurchaseDTO;

public class PurchaseView {
	public static void display(List<PurchaseDTO> purchaselist) {
		for(PurchaseDTO purchase:purchaselist) {
			System.out.println(purchase);
		}
	}
}
