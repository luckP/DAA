import java.util.*;
class Main{
  public static void InsertionSort(int k, int n, int vet[]){
    if(k>n)
      System.out.println("Error: k>n");

    for (int i=k+1; i<n; i++) {
      for (int j=i; j>=k; j--) {
        if(vet[j]<vet[j-1]){
          int aux = vet[j];
          vet[j] = vet[j-1];
          vet[]j-1 = aux;
        }
      }
    }
  }

  public static void main(String args[]){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); // numero de elementos do array
    int k = scn.nextInt(); // numero de elementos do array
    int vet[] = new int[n];
    for (int i=0; i<n; i++)
      vet[i] = scn.nextInt();

    InsertionSort(k, n, vet);

    for (int i=0; i<n; i++)
      System.out.println(vet[i]);
  }
}
