import java.util.*;
class Main{
  public static void InsertionSort(int n, int vet[]){

    for (int i=1; i<n; i++) {
      for (int j=i; j>0; j--) {
        if(vet[j]<vet[j-1]){
          int aux = vet[j];
          vet[j] = vet[j-1];
          vet[j-1] = aux;
        }
      }
    }
  }

  public static int LinearSearch(int e, int n, int vet[]){
    for (int i=0; i<n; i++) {
      if(vet[i] == e)
        return i;
      }
      return -1;
  }

  public static void main(String args[]){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); // numero de elementos do array
    int vet[] = new int[n];
    for (int i=0; i<n; i++)
      vet[i] = scn.nextInt();

    InsertionSort(n, vet);

    int num_search = scn.nextInt();
    for (int i=0; i<num_search; i++) {
      int e = scn.nextInt();
      System.out.println("O elemento "+e+" possui index: "+LinearSearch(e, n, vet));
    }

  }
}
