#include <stdio.h>
#include<math.h>
typedef struct ponto {
   int x, y;
} PONTO;

int viragem_esq(PONTO p1, PONTO p2,PONTO p3);
int ponto_ord_minima(PONTO p[], int n);
int compara(PONTO p, PONTO q, PONTO p0);
double modulo(PONTO p1, PONTO p2);
double cosPontos(PONTO p1, PONTO p2, PONTO p3);