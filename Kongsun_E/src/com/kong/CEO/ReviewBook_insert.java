package com.kong.CEO;

import java.util.Scanner;

import com.kong.JDBC.ReviewDAO;
import com.kong.JDBC.ReviewDTO;

public class ReviewBook_insert {

	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	ReviewDAO rdao=new ReviewDAO();
	ReviewDTO r =new ReviewDTO(null, null, null, null);
	
	
	String id=scan.nextLine();//문자열로 입력 받음 
	String store=scan.nextLine();
	String point=scan.nextLine();
	String cont=scan.nextLine();
	
	
	r.setR_id(id); r.setR_store(store); r.setR_point(point); r.setR_cont(cont); 
	
	int re=rdao.insertReview(r);//저장 
	
	
	if(re==1) System.out.println("저장 성공 ");

	}

}
