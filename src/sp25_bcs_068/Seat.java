package sp25_bcs_068;

public class Seat{
	private String Id;
	private SeatType seatType;
	private double price;
	private boolean isAvailable;


        public Seat(){
     isAvailable = true;

}

 
	
	public Seat(int row,int col,SeatType type,double price)
	{
		this.Id=String.format("%d-%03d",row,col);
		this.price=price;
		this.isAvailable=true;
		this.seatType=type;
	}
	
	public void setSeatId(int row,int col)
	{
		this.Id=String.format("%d-%03d",row,col);
	}

	public void setPrice(double price)
	{
		this.price=price;
	}

	public void setSeatType(SeatType type)
	{
		this.seatType=type;
	}

	public String getSeatId()
	{
		return this.Id;
	}

	public double getPrice()
	{
		return this.price;
	}

	public SeatType getType()
	{
		return this.seatType;
	}

	public boolean isAvailable()
	{
		return this.isAvailable;
	}

	public boolean bookSeat()
	{
		if(this.isAvailable)
		{
			this.isAvailable=false;
			return true;
		}
		return false;
	}
	public boolean cancelSeat()
	{
		if(!this.isAvailable)
		{
			this.isAvailable=true;
			return true;
		}
		return false;
	}

	@Override
	public String toString()
	{
		return String.format("%-5s:%-5B %-5s %-5.2f \n",this.Id,(isAvailable)?"A":"B",seatType,price);
	}
}