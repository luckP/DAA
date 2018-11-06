import java.util.*;
class Main{
  public static void main(String args[]){
    Scanner scn = new Scanner(System.in);
    String s1 = scn.nextLine(),
           s2 = scn.nextLine();

    int size;
    if(s1.length()<s2.length())
      size = s1.length();
    else
      size = s2.length();


    for (int i=0; i<size; i++) {
      if(s1.charAt(i)!=s2.charAt(i)){
        System.out.print((char)s1.charAt(i));
        System.out.println((char)s2.charAt(i));
        return;
      }
    }
    System.out.println("Nenhum");


  }

}
