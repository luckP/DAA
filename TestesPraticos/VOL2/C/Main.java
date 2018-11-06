import java.util.*;
import java.util.LinkedList;

class Arco {
    int no_final;

    Arco(int fim){
	no_final = fim;
    }

    int extremo_final() {
	return no_final;
    }
}


class No {
    //int label;
    LinkedList<Arco> adjs;

    No() {
	adjs = new LinkedList<Arco>();
    }
}


class Grafo0 {
    No verts[];
    int nvs, narcos;
    int max_group[];

    public Grafo0(int n) {
	nvs = n;
	narcos = 0;
	verts  = new No[n+1];
  max_group = new int[n+1];
	for (int i = 0 ; i <= n ; i++)
	    verts[i] = new No();
        // para vertices numerados de 1 a n (posicao 0 nao vai ser usada)
    }

    public int num_vertices(){
	return nvs;
    }

    public int num_arcos(){
	return narcos;
    }

    public LinkedList<Arco> adjs_no(int i) {
	return verts[i].adjs;
    }

    public void insert_new_arc(int i, int j){
	verts[i].adjs.addFirst(new Arco(j));
        narcos++;
    }

    public Arco find_arc(int i, int j){
	for (Arco adj: adjs_no(i))
	    if (adj.extremo_final() == j) return adj;
	return null;
    }

    public int find_max(int i){
      if(max_group[i]!=0)
        return max_group[i];

      Queue<Integer> group = new LinkedList<Integer>();


      boolean s[]= new boolean [nvs];
      for (int j=0; j<nvs; j++) {
        s[j]=false;
      }

      Queue<Integer> q = new LinkedList<Integer>();
      q.add(i);
      int max = i;
      while(q.size()>0){
        int m = q.remove();
        s[m] = true;
        if(m>max){
          max = m;
        }
        for(Arco a: adjs_no(m)){
          if(!s[a.no_final]){
            q.add(a.no_final);
            group.add(a.no_final);
          }
        }
      }

      for(int g: group)
        max_group[g] = max;

      return max;
    }

}



class Main{
  public static void main(String args[]){

    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt()+1, // numero de nos
        r = scn.nextInt();   // numero de ramos

    Grafo0 g = new Grafo0(n);
    for (int i=0; i<r; i++) {
      int n1 = scn.nextInt();
      int n2 = scn.nextInt();
      if(g.find_arc(n1, n2)==null){
        g.insert_new_arc(n1, n2);
        g.insert_new_arc(n2, n1);
      }
    }

    int q = scn.nextInt();

    for (int i=0; i<q; i++) {
      int a = scn.nextInt();
      System.out.println("No "+a+": "+g.find_max(a));
    }








  }
}
