package AJava;

import java.util.*;

public class Program {
    public static void main(String args[]){
//        String[] a = {"java","c","c++","sql"};
//        String str0 = a[0];
//        for(int i=0; i<a.length-1; i++){
//            a[i] = a[i+1];
//        }
//        int size = a.length-1;
//        a[size] = str0;
//        System.out.println(Arrays.toString(a));

//        String str0 = a[a.length-1];
//        for(int i=a.length-1; i>0; i--){
//            a[i] = a[i-1];
//        }
//        a[0] = str0;
//        System.out.println(Arrays.toString(a));



//        int i=0; int j= a.length-1; String temp;
//        while(i<j){
//            temp = a[i];
//            a[i] = a[j];
//            a[j] =temp;
//            i++;
//            j--;
//        }
//        System.out.println(Arrays.toString(a));

//        char[] c = {'a','B','C','d',e};
//        for(int i=0; i<c.length; i++){
//            if(Character.isUpperCase(c[i])){
//                c[i] = Character.toLowerCase(c[i]);
//            }
//        }
//        System.out.println(Arrays.toString(c));


//        String[] a = {"java","c","c++","sql"};
//        String str = "c";
//        for(int i=0; i<a.length; i++){
//            if(a[i].equals(str)){
//                for(int j=i; j<a.length-1; j++){
//                    a[j] = a[j+1];
//                }
//                break;
//            }
//        }
//        System.out.println(Arrays.toString(a));
//        /*
//        Great question! Arrays in Java have a fixed size,
//        so you cannot dynamically reduce the size of an array after deleting an element
//        — even if you shift elements and the last one becomes a duplicate or null.
//        That's why after your deletion and shifting, the array still contains the same length,
//        and you get a duplicate at the end.
//        ✅ Solution using a dynamic structure (ArrayList) instead of an array:
//         */
//        List<String> list = new ArrayList<>(Arrays.asList("java", "c", "c++", "sql"));
//        list.remove("c");
//        System.out.println(list);



//      int[] a = {9,5,0,5,5};
//      boolean[] visit = new boolean[a.length];
//      System.out.println(Arrays.toString(visit));
//        System.out.println(Arrays.toString(a));
//
//      for(int i=0; i<a.length; i++){
//          if(visit[i]){
//            continue;
//          }
//          int count = 1;
//          for(int j=i+1; j<a.length; j++) {
//              if (a[i] == a[j]) {
//                count++;
//                visit[j] = true;
//              }
//          }
//          if (count > 1) {
//              System.out.println(a[i] + " repeated " + count + " times");
//          }
//      }


//     Map<String,Integer> mp = new HashMap<String,Integer>();
//     mp.put("Java", 1);
//     mp.put("c",2);
//     mp.put("c++",1);
//     mp.put("sql",1);
//
//     for(Map.Entry<String,Integer> obo : mp.entrySet()){
//         if(obo.getValue()>1) {
//           //  System.out.println(obo.getKey() + " " + obo.getValue());
//         }
//     }
//
//     String[] a = {"java","c","c++","sql","c"};
//     Map<String,Integer> mp1 = new HashMap<String,Integer>();
//        for(int i=0; i< a.length; i++){
//           if(mp1.containsKey(a[i])){
//               mp1.put(a[i],mp1.get(a[i]) + 1);
//           }
//           else{
//               mp1.put(a[i],1);
//           }
//        }
//        for(Map.Entry<String,Integer> obo1 : mp.entrySet()){
//            if(obo1.getValue()==1) {
//             //   System.out.println(obo1.getKey() + " " + obo1.getValue());
//            }
//        }

    }
}

// count, boolean, boolean[]

/*
1) left & right rotate the Array
2) reverse the array
3) Add and remove ele in array
4) find dulp & howmany duplics in array & map
5) max mad min
6) covertions
7) map retrive
8) [Random string, number generation, get the current time & datae]



 */