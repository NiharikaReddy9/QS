package AJava;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.Instant;
import java.util.*;

public class Programs {
    public static void main(String args[]){
        int a = 10; float b =10.5f; double c =10.5;
        Integer a1 = 10;                               //[Float, Double] [like Stringclass we can create obj and pass value for int also but it is depricate we can assing just Integer ia1 =10]
        String str = "java";
        String str11 = new String("selenium");

        String str1 = "123"; String str2= "123.5f"; String str3= "123.5"; char ch = '1';
        int    num1   = Integer.parseInt(str1);        // [Float, Double]  // int num4   = Integer.parseInt(String.valueOf(ch)); [we dont hav edirect method so 1st convert char to string then string to int]
        int p1 = 111; float p2 = 112.5f; double p3= 113.5; boolean bol = true;
        String ss = String.valueOf(p1);

        String strr      = "java selenium";
        String strup    = strr.toUpperCase();
        String[] strAup = new String[]{strr.toUpperCase()};
        //----------------------
        char cc  = 'a';
        char cch = Character.toUpperCase(cc);
        boolean bb = Character.isUpperCase(cc);
        //----------------------
        String strr1   = "i love java with selenium";
        String[] strA = strr1.split(" ");
        char[] cA     = strr1.toCharArray();
        System.out.println(Arrays.toString(strA));
        System.out.println(Arrays.toString(cA));

        for(int i=1; i<5; i++){
           // System.out.println("iam "+i);
        }

        String[] Sarry1 = {"cabinCrew","CocpetCrew","captin","firstOfficer"}; //   String[] Sarry2 = new String[3];
        for(int i=0; i<Sarry1.length; i++){
            System.out.println(Sarry1[i]);
        }
        for(String sa :Sarry1){
            System.out.println(sa);
        }

        ArrayList al = new ArrayList();
        al.add("ola");
        al.add(12);
        for(int i=0; i<al.size(); i++){
            System.out.println(al.get(i));
        }
        for(Object sal1 :al){
            System.out.println(sal1);
        }

        Map<String, String> map = new HashMap<>();
        map.put("India", "Delhi");
        map.put("USA", "Washington");
        map.put("France", "Paris");
        for (Map.Entry<String, String> entry : map.entrySet()) {   // get single key value pair System.out.println(map.get("India")); // Output: Delhi
            System.out.println(entry.getKey() + " → " + entry.getValue());

        }
        
         /*   List<Object> constantLists = new ArrayList<Object>();
           constantLists.add(new PageConstantsEcom());
           Object constants = constantLists.get(0);
           Field[] fields = constants.getClass().getFields(); Method[] methods = constants.getClass().getMethods();
           * SIMPLY CAN WRITE *
           Base bv = new Base();
           Field[] fields = bv.getClass().getFields();
      */
    }
}

/*
    WHILE & DO WHILE
int i = 1;        // initialization outside
while (i <= 5) {  // only condition here
    System.out.println(i);
    i++;          // increment inside
}
________________________________________________
int i = 1;        // initialization outside
do {
    System.out.println(i); // loop body runs first
    i++;          // increment inside
} while (i <= 5); // condition is checked after execution


for (String a : Sarray) {
    // ✅ Declaration: String a   → loop variable
    // ✅ Initialization: gets one value from 'crew' on each loop
    System.out.println(a);
}
________________________________________________
int day = 3;      // initialization
switch (day) {    // switch on the value of 'day'
    case 1:
        System.out.println("Monday");
        break; // stop after this case
    case 2:
        System.out.println("Tuesday");
        break;
    default:
        System.out.println("Weekend");
}

String[] Sarry1 = {"cabinCrew", "CockpitCrew"};
// ✅ Declaration:   String[] Sarry1
// ✅ Initialization: {"cabinCrew", "CockpitCrew"} (values assigned directly)



 */