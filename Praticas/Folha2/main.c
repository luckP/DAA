#include "main.h"
#define MAX_P 10

int main(){
    PONTO p[MAX_P];
    int i;
    for(i=0; i<MAX_P; i++){
        scanf("%d", &p[i].x);
        scanf("%d", &p[i].y);
    }

    printf("%d\n", ponto_ord_minima(p, MAX_P));
}

// calcula o produto vetorial e verifica se ele é maior do que zero.. caso seja, é uma viragem a esquerda
int viragem_esq(PONTO p1, PONTO p2,PONTO p3){
    return ((p2.x - p1.x)*(p3.y-p1.y)-(p2.y-p1.y)*(p3.x-p1.x)>0);
}

// verifica qual o indice do ponto de ordenada minima
int ponto_ord_minima(PONTO p[], int n){
    int m = 0, i;
    for(i=1; i<n; i++)
        if((p[i].y<p[m].y) || (p[i].y == p[m].y && p[i].x>p[m].y))
            m=i;

    return m;
}

int compara(PONTO p, PONTO q, PONTO p0){
    int p_vetorial = (p.x - p0.x)*(q.y-p0.y)-(q.y-p0.y)*(q.x-p0.x);
    if(p_vetorial>0)
        return 1;
    else if(p_vetorial<0)
        return -1;
    else{
        int escalar = modulo(p0, p) * modulo(p0, q);
        // *(q.y-p0.y)-(q.y-p0.y)*(q.x-p0.x);
    // sqrt(double x)
    }
    return 0;
}

double modulo(PONTO p1, PONTO p2){
    return sqrt (((p2.x - p1.x) * (p2.x - p1.x)) + ((p2.y - p1.y) * (p2.y - p1.y)));
}

double cosPontos(PONTO p1, PONTO p2, PONTO p3){
    return (p2.x-p1.x)*(p3.x-p1.x)+(p2.y-p1.y)*(p3.y-p1.y)/(modulo(p1,p2)*modulo(p1,p3));
}



void ordena(PONTO p[], int a,int b){

}