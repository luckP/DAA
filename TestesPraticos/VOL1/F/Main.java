import java.util.*;

class Pessoa{
  int code;
  int num_t;
  int num_max;
  int tar[];

  public Pessoa(int code, int num_t, int num_max, int tar[]){
    this.code = code;
    this.num_t = num_t;
    this.num_max = num_max;
    this.tar = tar;
  }
}

class Main{
  public static void main(String args[]){
    Scanner scn = new Scanner(System.in);
    int num_p=scn.nextInt(), num_t=scn.nextInt();
    Pessoa p[] = new Pessoa[num_p];

    for (int i=0; i<num_p; i++) {
      int code = scn.nextInt();
      int nu_t = scn.nextInt();
      int num_max = scn.nextInt();
      int tar[] = new int[nu_t];
      for (int j=0; j<nu_t; j++) {
        tar[j] = scn.nextInt();
      }

      p[i] = new Pessoa(code, nu_t, num_max, tar);
    }

    int num_prop = scn.nextInt();

    
    for (int i=0; i<num_prop; i++) {
      int t=scn.nextInt();
      int pp=scn.nextInt();
      while(t!=0 && pp!=0){
        System.out.println(i);
        t=scn.nextInt();
        pp=scn.nextInt();
      }
    }






  }
}
