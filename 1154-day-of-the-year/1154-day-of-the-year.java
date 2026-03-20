import java.util.*;

class Solution {
    public int dayOfYear(String date) {

        int day;
        String m = "";
        String d = "";
        String y = "";
        m = date.substring(5,7);
        d = date.substring(8,10);
        y = date.substring(0,4);
        int mm = Integer.parseInt(m);
        int dd = Integer.parseInt(d);
        int yy = Integer.parseInt(y);


        if((yy%4 == 0 && yy%100 != 0)||(yy%400 == 0)){


            switch (mm) {
            case 1 : 
            return dd;
            case 2 : 
            return 31+dd;
            case 3 : 
            return 60+dd;
            case 4 : 
            return 91+dd;
            case 5 : 
            return 121+dd;
            case 6 : 
            return 152+dd;
            case 7 : 
            return 182+dd;
            case 8 : 
            return 213+dd;
            case 9 : 
            return 244+dd;
            case 10 : 
            return 274+dd;
            case 11 : 
            return 305+dd;
            case 12 : 
            return 335+dd;
            default : return 0;

         }
        
            } else {

             switch (mm) {
            case 1 : 
            return dd;
            case 2 : 
            return 31+dd;
            case 3 : 
            return 59+dd;
            case 4 : 
            return 90+dd;
            case 5 : 
            return 120+dd;
            case 6 : 
            return 151+dd;
            case 7 : 
            return 181+dd;
            case 8 : 
            return 212+dd;
            case 9 : 
            return 243+dd;
            case 10 : 
            return 273+dd;
            case 11 : 
            return 304+dd;
            case 12 : 
            return 334+dd;
            default : return 0;
            }
            
        }
    }
}