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

    public boolean check_BFS(int i, int j){
      boolean checked[] = new boolean[26];
      for (int k=0; k<26; k++) {
        checked[k] = false;
      }
      Queue<Integer> q = new LinkedList<Integer>();
      q.add(i);
      while(q.size()>0){
        int e = q.remove();
        checked[e] = true;
        if(find_arc(e, j)!=null){
          return true;
        }
        LinkedList<Arco> adjs = verts[e].adjs;
        for(Arco a: adjs){
          if(!checked[a.no_final])
            q.add(a.no_final);
        }
      }
      return false;
    }
}

class Main{
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    String line = scn.nextLine();
    Grafo0 g = new Grafo0(26);
    while(!line.equals("#")){
      char s1 = line.charAt(0);
      for (int i=1; i<line.length(); i++) {
        char s2 = line.charAt(i);
        g.insert_new_arc((int)s1-'A'+1, (int)s2-'A'+1);
        s1 = s2;
      }

      line = scn.nextLine();
    }


    line = scn.nextLine();
    while(!line.equals("#")){
      char s1 = line.charAt(0);
      boolean c = true;
      for (int i=1; i<line.length(); i++) {
        char s2 = line.charAt(i);
        c = c && g.check_BFS((int)s1-'A'+1, (int)s2-'A'+1);
        s1 = s2;
      }
      if(c)
        System.out.println("sim");
      else
        System.out.println("nao");

      line = scn.nextLine();
    }
  }
}
