import java.util.*;
import java.util.LinkedList;

class Arco {
    int no_final;
    int valor0;
    int valor1;

    Arco(int fim, int v0, int v1){
	no_final = fim;
	valor0  = v0;
	valor1 = v1;
    }

    int extremo_final() {
	return no_final;
    }

    int valor0_arco() {
	return valor0;
    }

    int valor1_arco() {
	return valor1;
    }

    void novo_valor0(int v) {
	valor0 = v;
    }

    void novo_valor1(int v) {
	valor1 = v;
    }
}


class No {
    //int label;
    LinkedList<Arco> adjs;

    No() {
	adjs = new LinkedList<Arco>();
    }
}


class Grafo2 {
    No verts[];
    int nvs, narcos;

    public Grafo2(int n) {
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

    public void insert_new_arc(int i, int j, int valor0, int valor1){
	verts[i].adjs.addFirst(new Arco(j,valor0,valor1));
        narcos++;
    }

    public Arco find_arc(int i, int j){
	for (Arco adj: adjs_no(i))
	    if (adj.extremo_final() == j) return adj;
	return null;
    }
}

class Main{
  public static void main(String args[]){
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt(),
        r = scn.nextInt();
    Grafo2 g = new Grafo2(n);

    for (int i=0; i<r; i++) {
      int o = scn.nextInt();
      int d = scn.nextInt();
      if(g.find_arc(o, d) == null)
        g.insert_new_arc(o, d, scn.nextInt(), scn.nextInt());
    }

    int t = scn.nextInt();
    for (int i=0; i<t; i++) {
      int k = scn.nextInt(),
          p = scn.nextInt();
      boolean error = true;

      int ps[] = new int[p];
      int n1 = scn.nextInt();
      int total = 0;
      ps[0] = n1;
      for (int j=1; j<p; j++) {
        int n2 = scn.nextInt();
        ps[j] = n2;
        Arco a = g.find_arc(n1, n2);
        if(a!=null){
          total+=a.valor1;
          a.valor0-=k;
          if(a.valor0<0){
            if(error)
              System.out.println("Sem lugares suficientes em ("+n1+","+n2+")");
            error=false;

          }
        }
        else{
          if(error)
            System.out.println("("+n1+","+n2+") inexistente");
          error = false;
        }
        n1=n2;
      }
      if(error)
        System.out.println("Total a pagar: "+total*k);
      else{
        n1 = ps[0];
        for (int j=1; j<p; j++) {

          int n2 = ps[j];
          Arco a = g.find_arc(n1, n2);
          if(a!=null){
            a.valor0+=k;
          }
          n1=n2;
        }
      }


    }



  }
}
