package com.vege.view;

import java.util.List;

import com.vege.model.PurchaseDetailDTO;

public class PurchaseDetailView {
	public static void display(List<PurchaseDetailDTO> detaillist) {
		for(PurchaseDetailDTO detail:detaillist) {
			System.out.println(detail);
		}
	}
}
