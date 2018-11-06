import java.util.*;
import java.util.LinkedList;

class Arco {
    int no_final;
    int valor;

    Arco(int fim, int v){
	no_final = fim;
	valor = v;
    }

    int extremo_final() {
	return no_final;
    }

    int valor_arco() {
	return valor;
    }

    void novo_valor(int v) {
	valor = v;
    }
}


class No {
    //int label;
    LinkedList<Arco> adjs;

    No() {
	adjs = new LinkedList<Arco>();
    }
}


class Grafo {
    No verts[];
    int nvs, narcos;

    public Grafo(int n) {
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

    public void insert_new_arc(int i, int j, int valor_ij){
	verts[i].adjs.addFirst(new Arco(j,valor_ij));
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
    int num_elementos = scn.nextInt();
    int origem = scn.nextInt();
    int destino = scn.nextInt();

    int n = scn.nextInt();
    int r = scn.nextInt();
    Grafo g = new Grafo(n);

    for (int i=0; i<r; i++) {
      int n1 = scn.nextInt();
      int n2 = scn.nextInt();
      int p = scn.nextInt();
      if(g.find_arc(n1, n2)==null)
        g.insert_new_arc(n1, n2, p);
    }

    int num_rotas = scn.nextInt();
    int rota = -1;
    int problemas = 10000000;

    for (int i=1; i<=num_rotas; i++) {
      int k = scn.nextInt();
      boolean c = true;
      int pp = 0;
      int v1 = scn.nextInt();
      boolean p1 = false, p2 = false;

      for (int j=1; j<k; j++) {
        int nj = scn.nextInt();
        int v2 = scn.nextInt();
        Arco a = g.find_arc(v1, v2);

        if(v1 == origem){
          p1 = true;
        }

        if(!p2){
          if(a!=null){
            pp+=a.valor;

            if(p1 &&  nj<num_elementos){
              c = false;
            }
          }

        }

        if(p1 && v2 == destino){
          p2 = true;
        }

        v1 = v2;
      }

      // if(c){
      //   System.out.println("Reserva na rota "+i+": "+pp);
      // }
      // else{
      //   System.out.println("Impossivel");
      // }

      if(c && pp<problemas && p1 && p2){

        rota = i;
        problemas = pp;
      }


    }

    if(rota!=-1){
      System.out.println("Reserva na rota "+rota+": "+problemas);
    }
    else{
      System.out.println("Impossivel");
    }






  }
}
