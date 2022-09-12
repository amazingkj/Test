package com.kong.Main;

import com.kong.CEO.StoreUIBasic;
import com.kong.Home.Home;

public class MainPage{
	
	MainPage(int lv){
		if(lv == 1) {
			//admin();
		}else if(lv == 2) {
			new StoreUIBasic();
			//System.out.println(lv);
		}else {
			new Home();
			//System.out.println(lv);
		}	
	}
	
}
