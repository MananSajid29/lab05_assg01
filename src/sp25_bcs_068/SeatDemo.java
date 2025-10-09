package sp25_bcs_068;

public class SeatDemo{

              public static void main(String args[]){
     // first creating a seat through default constructor 
                 Seat s1 = new Seat();
                s1.setSeatId(1,005);
                s1.setSeatType(SeatType.VIP);
                s1.setPrice(1000);
              
             System.out.println(s1);
      // now creating a seat through parameterized constructor

                Seat s2 = new Seat(2,003,SeatType.RECLINER,1200);
            

                      System.out.println(s2);
     }

}