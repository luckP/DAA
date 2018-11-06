import java.util.*;

class Main{
  public static void main(String args[]){
    Scanner scn = new Scanner(System.in);
    int l[] = new int[10000];
    int i = 0;
    do{
      l[i] = scn.nextInt();
      i=l[i];
    }while(i!=0);

    i=0;
    while(l[i]!=0){
      System.out.println(l[i]);
      i=l[i];
    }
  }
}
