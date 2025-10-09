package sp25_bcs_068;
import java.util.Arrays;
public class ScreenDemo{

                public static void main(String args[]){

                      Screen s1 = new Screen("-----------   Emporium Screen 01  ----------",5);
 
                             s1.displayLayout();
                      System.out.println("booking some seats......");
                 
                              
                              s1.book("1-000");
                              s1.cancel("1-000");
                              s1.book("1-001");
                              s1.book("1-002");
                              s1.book("3-000");
                          
                              System.out.println("First Avb seat is "+s1.findFirstAvailable());
                              System.out.println("---Premium Avb Are---\n"+ Arrays.toString(s1.listAvb(SeatType.PREMIUM)));
                              s1.displayLayout();
                              s1.displayVerbose();

    }
}