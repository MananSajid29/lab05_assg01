package sp25_bcs_068;

public class Screen{
	private final int DEFAULT_NUMROW=5;
	private final double PRICE_PRIMIUM=750;
	private final double PRICE_REGULAR=500;
	private final double PRICE_VIP=1000;
	private final double PRICE_RECLINER=1200;
	public final int totalSeat;
	public int bookedSeat=0;
	private String screenName;
	private Seat seats[][];

	public Screen()
	{
		int k=0;
		this.screenName="";
		seats=new Seat[DEFAULT_NUMROW][];
		for(int i=0;i<seats.length;i++)
			seats[i]=new Seat[10+i];

		for(int i=0;i<seats.length;i++)
			for(int j=0;j<seats[i].length;j++)
			{
				k++;
				if(i==0)
					seats[i][j]=new Seat(i,j,SeatType.REGULAR,PRICE_REGULAR);
				else if(i==seats.length-2)
					seats[i][j]=new Seat(i,j,SeatType.VIP,PRICE_VIP);
				else if(i==seats.length-1)
					seats[i][j]=new Seat(i,j,SeatType.RECLINER,PRICE_RECLINER);
				else
					seats[i][j]=new Seat(i,j,SeatType.PREMIUM,PRICE_PRIMIUM);
			}
			totalSeat=k;
	}
	
	public Screen(String name,int row)
	{
		int k=0;
		this.screenName=name;
		seats=new Seat[row][];
		for(int i=0;i<seats.length;i++)
			seats[i]=new Seat[10+i];

		for(int i=0;i<seats.length;i++)
			for(int j=0;j<seats[i].length;j++)
			{   
				k++;
				if(i==0)
					seats[i][j]=new Seat(i,j,SeatType.REGULAR,PRICE_REGULAR);
				else if(i==seats.length-2)
					seats[i][j]=new Seat(i,j,SeatType.VIP,PRICE_VIP);
				else if(i==seats.length-1)
					seats[i][j]=new Seat(i,j,SeatType.RECLINER,PRICE_RECLINER);
				else
					seats[i][j]=new Seat(i,j,SeatType.PREMIUM,PRICE_PRIMIUM);
			}
		totalSeat=k;
	}

	public void setRowType(int r,SeatType type,double price)
	{
		for(int i=0;i<seats[r].length;i++)
		{
			seats[r][i].setSeatType(type);
			seats[r][i].setPrice(price);
		}
	}

	public String getName()
	{ 
		return this.screenName;
	}
	
	public Seat getSeat(String seatId)
	{
		for(int i=0;i<=seats.length;i++)
			for(int j=0;j<seats[i].length;j++)
				if(seats[i][j].getSeatId().equals(seatId))
					return seats[i][j];
                                        
		                       
               return null;

	}

	public int getAvailableSeats()
	{
		return (totalSeat-bookedSeat);
	}

	public int getTotalSeats()
	{
		return totalSeat;
	}

	public int getRowLength(int r)
	{
		return seats[r].length;
	}

	public int getNumRows()
	{
		return seats.length;
	}

	public boolean book(String seatId)
	{
		for(int i=0;i<seats.length;i++)
			for(int j=0;j<seats[i].length;j++)
				if(seats[i][j].getSeatId().equals(seatId)){
					boolean success = seats[i][j].bookSeat();
		                         if(success){
                                                   System.out.println("Seat booked Successfulyy");
                                                             bookedSeat++;
                                                      }
                                         else  {
                                                      System.out.println("Seat " +seatId+ " already booked");           
                                          }
                                             return success;               
                                      }
            return false; 
                
	}

	public boolean book(int r,int c)
	{	if(seats[r][c].isAvailable())
			bookedSeat++;
		return seats[r][c].bookSeat();
	}

	public boolean cancel(int r,int c)
	{
		return seats[r][c].cancelSeat();
	}
	 
        public boolean cancel(String seatId)
        {
             for(int i=0;i<seats.length;i++)
		for(int j=0;j<seats[i].length;j++)
			if(seats[i][j].getSeatId().equals(seatId)){
				       bookedSeat--;
                           return seats[i][j].cancelSeat();
                                   
                                        }
		return false;   
        }

	private void checkBounds(int r,int c)
	{
		if(seats[r][c].isAvailable())
			System.out.println("Seat is not booked");
		else
			System.out.println("Seat is already booked");	
	}
     
        public String getFirstVIP()
	{
		for(int i=0;i<seats[seats.length-2].length;i++)
			if(seats[seats.length-2][i].isAvailable())
				return seats[seats.length-2][i].getSeatId();
		return "Not Available";
	}

	private int[] buildDefaultRows(int row)
	{
		int[] lengths=new int[row];
		for(int i=0;i<row;i++)
			lengths[i]=10+i;
		return lengths;
	}

	public Seat findFirstAvailable()
	{
		for(int i=0;i<seats.length;i++)
			for(int j=0;j<seats[i].length;j++)
				if(seats[i][j].isAvailable())
					return seats[i][j];
		return null;
	}

        private SeatType seattypefor(int r , int c)
        
        {
             
            for(int i=0 ; i < seats.length; i++){
                 for(int j=0; j<seats[i].length;j++){
                       return seats[r][c].getType();
        }
	  }
               return null;

       }

       private double pricefor(SeatType type)
       {
            if(type == SeatType.REGULAR)
             return PRICE_REGULAR;
            
            else if(type == SeatType.VIP)
             return PRICE_VIP;
  
            else if(type == SeatType.PREMIUM)
             return PRICE_PRIMIUM;
  
            else if(type == SeatType.RECLINER)
              return PRICE_RECLINER;

            else 
              return 0.00;
            
       }

      public Seat[] listAvb(SeatType type)
 
      {
            int count = 0 ;
            for(int i = 0 ;i<seats.length; i++)
               for(int j = 0; j<seats[i].length;j++){
                   Seat seat = seats[i][j];

                if(seat.isAvailable() && seat.getType() == type){
                    count++;           
                  }
               }

             Seat AvbSeats[] = new Seat[count];

            int counter=0;
                for(int i = 0 ;i<seats.length; i++)
               for(int j = 0; j<seats[i].length;j++){
                   Seat seat = seats[i][j];

                if(seat.isAvailable() && seat.getType() == type){
                          AvbSeats[counter] = seat;
                        counter++; 
                             
                  }
               }
      

                      return AvbSeats;
     }


 

     public void displayLayout()

    { 
           
    System.out.println("\n" + screenName );
    System.out.println("(A = Available, B = Booked)\n");

    for (int i = 0; i < seats.length; i++) {
        System.out.printf("Row %02d: ", i + 1);
        for (int j = 0; j < seats[i].length; j++) {
            Seat s = seats[i][j];
            
            System.out.print("[" + s.getSeatId() + ":" + (s.isAvailable() ? "A" : "B") + "] ");
        }
        System.out.println();
    }

    System.out.println("\nTotal Seats: " + totalSeat + 
                       " | Available: " + getAvailableSeats() + 
                       " | Booked: " + bookedSeat);
    System.out.println("========================================\n");
}

    public void displayVerbose()
    {
       
    System.out.println("\n" + screenName + " ===");
    System.out.printf("%-8s %-10s %-10s %-10s\n", "SeatID", "Status", "Type", "Price (PKR)");
    System.out.println("------------------------------------------------------");

    for (int i = 0; i < seats.length; i++) {
        for (int j = 0; j < seats[i].length; j++) {
            Seat s = seats[i][j];
            System.out.printf("%-8s %-10s %-10s %-10.2f\n",
                    s.getSeatId(),
                    s.isAvailable() ? "Available" : "Booked",
                    s.getType(),
                    s.getPrice());
        }
    }

    System.out.println("------------------------------------------------------");
    System.out.println("Total: " + totalSeat + 
                       " | Available: " + getAvailableSeats() + 
                       " | Booked: " + bookedSeat);
    System.out.println("======================================================\n");
}

	
}

		