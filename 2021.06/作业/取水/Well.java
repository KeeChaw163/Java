   package qushui;
   class Well {
	  String well1=("1号水井");
	  String well2=("2号水井");
	  String well3=("3号水井");
	  
	public void openWell1(Water water){
	   water.shuiliang1-=2000;  //消耗水量
	  }
   public void openWell2(Water water){
			   water.shuiliang2-=2000; //消耗水量
     }
   public void openWell3(Water water ){
				   water.shuiliang3-=2000; //消耗水量
	 }
   
   }
     
   