package sp25_bcs_068;

public class CityCinema{
    
Cinema cinemas[] = new Cinema[4];
      String cityName;
     

       CityCinema(String name)
{
   for(int i =0; i<cinemas.length;i++)
       cinemas[i]=new Cinema("==================CINEMA"+i+"=====================");
            this.cityName=name;
          


}
   public void assignCinemaNames(String names[])
    {
           int i=0;
		for(String s:names)
		{
		   cinemas[i++].setCinemaName(s);
		}

    }

    public boolean book(int numC,int numS,String Id)
	{
		return cinemas[numC].book(numS,Id);
	}

    public boolean cancel(int numC,int numS,String Id)
	{
		return cinemas[numC].cancel(numS,Id);
	}
    public Cinema findCinema(String name)
	{
	  for(int i=0;i<cinemas.length;i++)
		{
		   if(cinemas[i].getCinemaName().equals(name))
			{
			   System.out.println("Cinema Found");
				return cinemas[i];
			}
		}
		System.out.println("Cinema not Found");
			return null;
	}

    public String discoveryhelperforVIPseats()
        {
             for(int i =0; i<cinemas.length;i++)  
                 {
                   String result = cinemas[i].getFirstVIP();
                    if(result.equals("No VIP Seat Available"))
                          continue;
                   else 
                       return cinemas[i].getFirstVIP();
                 }
                   return "No VIP Seat Available";
        }

    public void display()
       {
        
           int count = 0;
          for(int i=0; i<cinemas.length;i++)
            {
                       count++;
       System.out.println("-----cinema of city: " +cityName );
     System.out.println("============Cinema num : "+count+" ============");
      
        


             cinemas[i].display();
        }

    }

}


