#include<stdio.h>
#include<stdlib.h>

int main(){
  char a[1000];
  scanf("%s", a);
  while(a[0]!='#'){
    printf("%s\n", a);
    scanf("%s", a);
  }
}
