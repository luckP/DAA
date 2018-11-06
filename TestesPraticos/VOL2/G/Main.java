import java.util.*;

class Main{
  public static void main(String args[]){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();// numero de trabalhadores/tarefas
    int t[][] = new int[n][n];
    for (int i=0; i<n; i++) {
      for (int j=0; j<n; j++) {
        t[i][j] = scn.nextInt();
      }
    }

    int n_p = scn.nextInt();
    int p[][] = new int[n_p][n];

    for (int i=0; i<n_p; i++) {
      for (int j=0; j<n; j++) {
        p[i][j] = scn.nextInt();
      }
    }

  }
}
