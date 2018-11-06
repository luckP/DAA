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

    public Grafo0(int n) {
	nvs = n;
	narcos = 0;
	verts  = new No[n+1];
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
}


class Main{
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int num_node = scn.nextInt()+1, num_traj = scn.nextInt();
    Grafo0 g = new Grafo0(num_node);

    for (int i=0; i<num_traj; i++) {
      int n = scn.nextInt();
      int n1 = scn.nextInt();
      for (int j=1; j<n; j++) {
        int n2 = scn.nextInt();
        if(g.find_arc(n1, n2)==null)
          g.insert_new_arc(n1, n2);
        n1 = n2;
      }
    }

    for (int i=1; i<num_node; i++) {
      System.out.println(g.adjs_no(i).size());
    }


  }
}
