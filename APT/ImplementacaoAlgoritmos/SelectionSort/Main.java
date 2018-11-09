import java.util.*;
class Main{
  public static void selectSort(int n, int vet[]){
    for (int i=0; i<n; i++) {
      int min = i;
      for (int j=i; j<n; j++) {
        if(vet[j]<vet[min])
          min = j;
      }
      int aux = vet[i];
      vet[i] = vet[min];
      vet[min] = aux;

    }
  }

  public static void main(String args[]){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); // numero de elementos do array
    int vet[] = new int[n];
    for (int i=0; i<n; i++)
      vet[i] = scn.nextInt();

    selectSort(n, vet);

    for (int i=0; i<n; i++)
      System.out.println(vet[i]);
  }
}
