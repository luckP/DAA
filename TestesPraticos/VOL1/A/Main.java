import java.util.*;
class Main{
  public static void main(String args[]){
    Scanner scn = new Scanner(System.in);

    int num_p = scn.nextInt()+1;
    int p[] = new int[num_p];
    for (int i=1; i<num_p; i++){
      p[i]=scn.nextInt();
    }

    int c = 0;
    for (int i=1; i<num_p; i++){
      if(p[i]!=-1 && p[i]==0)
        c++;
      else if(p[i]!=-1 && i==p[p[i]])
        c++;
      else if(p[i]!=-1){
        int count = 2;
        int j=p[i];
        int max = p[i];
        while(p[j]!=i){
          j=p[j];
          count++;
          if(j>max)
            max = j;
        }
        System.out.print(count);
        int ii = max;
        while(p[ii]!=-1){
          System.out.print(" ");
          System.out.print(ii);
          int iii = p[ii];
          p[ii] = -1;
          ii = iii;
        }
        System.out.println("");
      }


    }
    System.out.println(c);

  }
}
