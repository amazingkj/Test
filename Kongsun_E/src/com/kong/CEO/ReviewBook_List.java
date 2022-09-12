package com.kong.CEO;
import java.util.List;

import com.kong.JDBC.ReviewDAO;
import com.kong.JDBC.ReviewDTO;

//리뷰 목록보기 
public class ReviewBook_List {
	public static void main(String[] args) {
		ReviewDAO rdao=new ReviewDAO();
				
		List<ReviewDTO> rlist=rdao.getKongList(); //리뷰 목록을 가져옴 
		
			if(rlist.size()>0) {
				//rlist.size()>0 리스트에 글이 있다는 뜻
				
			//향상된 확장 for
			for(ReviewDTO r:rlist) {
				System.out.println(r.getR_no()+"\t"+r.getR_id()+"\t"+r.getR_store()+"\t"+r.getR_point()+"\t"+r.getR_cont()+"\t"+r.getR_date());
			}
			
		}else {
		System.out.println("작성된 리뷰가 없습니다.");		
		
	}
	}

}

