package sp25_bcs_068;

public class MainDemo{
      public static void main(String args[]){

         // assigining names to cinemas 

    	        CityCinema c1=new CityCinema("Lahore");
		CityCinema c2=new CityCinema("Karachi");
		CityCinema c3=new CityCinema("Islamabad");
		c1.assignCinemaNames(new String [] {"CineStar Emporium","Township","CineStar Gulberg","Fortress"});
		c2.assignCinemaNames(new String [] {"Atrium Saddar","Nueplex DHA","The Arena","Malir Cantt"});
		c3.assignCinemaNames(new String [] {"Megaplex","JFC Cineplex","Open Air Theater","Red Zone"});   
         
         
               
                 c1.book(0,0,"1-000");
                 c1.book(1,2,"2-000");
                 c1.display();
                 c1.findCinema("Township");  

     System.out.println(c1.discoveryhelperforVIPseats());

    

               
                  

}


}