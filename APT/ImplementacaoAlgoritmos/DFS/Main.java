import java.util.*;

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

    public void DFS_visit(int s){
      boolean v[] = new boolean[nvs+1];
      for (int i=0; i<nvs; i++)
        v[i] = false;

      Stack<Integer> q = new Stack<Integer>();
      q.push(s);
      v[s] = true;
      while(!q.empty()){
        int n = q.pop();
        System.out.print(n+ " - ");
        for (Arco a: adjs_no(n))
          System.out.print(a.no_final+ ", ");
        System.out.println("");

        for(Arco a: adjs_no(n)){
          if(!v[a.no_final]){
            v[a.no_final] = true;
            q.push(a.no_final);
          }
        }
      }
    }

    public boolean DFS_search(int s, int t){
      boolean v[] = new boolean[nvs+1];
      for (int i=0; i<nvs; i++)
        v[i] = false;

      Stack<Integer> q = new Stack<Integer>();
      q.push(s);
      v[s] = true;
      while(!q.empty()){
        int n = q.pop();
        if(n == t)
          return true;
        for(Arco a: adjs_no(n)){
          if(!v[a.no_final]){
            v[a.no_final] = true;
            q.push(a.no_final);
          }
        }
      }
      return false;
    }
}


class Main{
  public static void main(String args[]){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    Grafo0 g = new Grafo0(n);
    int n1 = scn.nextInt(), n2 = scn.nextInt();
    while(n1!=0 && n2!=0){
      g.insert_new_arc(n1, n2);
      n1 = scn.nextInt();
      n2 = scn.nextInt();
    }
    int s = scn.nextInt();
    g.DFS_visit(s);
  }
}
