package sp25_bcs_068;

public class Cinema{
        public  String CinemaName;
         int numScreens= 3;
         Screen screens[];



 public Cinema(String name)
  {
      this.CinemaName=name;
         screens = new Screen[numScreens];
      for(int i = 0; i<screens.length; i++)
            screens[i]=new Screen();
   }

  public void setCinemaName(String n)
   { 
       this.CinemaName=n;
   }
   
  public String getCinemaName()
  {
     return CinemaName;
  }

  public boolean book(int screen, String id)
  {
      return screens[screen].book(id);
  }

  public boolean cancel(int screen, String id)
  {
      return screens[screen].cancel(id);
  }

  public Seat findFirstAvailable(int screenNum)
  {
     
         return screens[screenNum].findFirstAvailable();
  }


   public String getFirstVIP()
	{
		for(int i=0;i<screens.length;i++)
		{
			String id=screens[i].getFirstVIP();
			if(id==null)
				continue;
			else
				return String.format("%s > %s Seat %s (VIP:1000 pkr)",CinemaName,screens[i].getName(),id);
		}
		return "No VIP Seat Available";
	}

   public void display()
  {
    int count=0;
    System.out.println("Cinema Name is ----->> "+CinemaName);
    for(int i =0 ; i<screens.length;i++){
          count++;
     System.out.println("--------------Screen num : "+count+" ---------------");
        


       screens[i].displayLayout();
   
     }
  }


}

