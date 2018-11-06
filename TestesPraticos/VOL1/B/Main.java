import java.util.*;
class Main{
  public static void main(String args[]){
    Scanner scn = new Scanner(System.in);
// 2 euros, 1 euro, e de 50, 20, 10 e 5 cêntimos
    int cont2e =scn.nextInt(),
        cont1e =scn.nextInt(),
        cont50c=scn.nextInt(),
        cont20c=scn.nextInt(),
        cont10c=scn.nextInt(),
        cont5c =scn.nextInt();
    int E = scn.nextInt(), C = scn.nextInt();
    int count = 0;
    int countError = 0;
    int countQuantia = 0;

    while(E!=0 || C!=0){
      int M = 0;
      count++;
      E = E*100+C;

      int m = scn.nextInt();
      while(m!=0){
        if(m==1||m==2)
          M=M+m*100;
        else
          M+=m;
        switch(m){
          case 2: cont2e++;break;
          case 1: cont1e++;break;
          case 50: cont50c++;break;
          case 20: cont20c++;break;
          case 10: cont10c++;break;
          case 5: cont5c++;break;
        }
        m = scn.nextInt();
      }

      E=M-E;
      while(cont2e>0 && E>=200){
        E-=200;
        cont2e--;
      }

      while(cont1e>0 && E>=100){
        E-=100;
        cont1e--;
      }

      while(cont50c>0 && E>=50){
        E-=50;
        cont50c--;
      }

      while(cont20c>0 && E>=20){
        E-=20;
        cont20c--;
      }

      while(cont10c>0 && E>=10){
        E-=10;
        cont10c--;
      }

      while(cont5c>0 && E>=5){
        E-=5;
        cont5c--;
      }

      if(E>0){
        countError++;
        countQuantia+=E;

      }
      // System.out.println(E);



      E = scn.nextInt();
      C = scn.nextInt();
    }
    // System.out.println(countQuantia);

    System.out.print(countQuantia/100);
    System.out.print(" ");
    System.out.println(countQuantia%100);

    System.out.print(countError);
    System.out.print("/");
    System.out.println(count);

  }
}
