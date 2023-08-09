package DemoPurpose;

import java.util.Date;

public class demodate1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date dd = new Date();
		System.out.println(dd.toString().replace(" ","_" ).replace(":","_"));// method chaining reduce the line of codes since we are using obeject
		/* string dt1 =dd.toString();
		 * 
		 * String dt2=dt1.replace(" ","_");
		 * String dt3=dt2.replace(":","_");
		 * System.out.println(dt3);
		 */
		
		

	}

}
