# determinar uma funcao POSMAX(v,k,n) para determinar o índice da primeira posição que contém o elemento máximo
# de um vetor v de n inteiros, restringindo a análise aos elementos v[k], v[k+1],..., v[n]. Os elementos são intdexados 
# de 1 a n. Se k for maior do que n ou menor do que 1, a função retorna -1.

def posmax(v,k,n):
    if k>n or k<0:
        return -1
    p_max = k
    k+=1
    while(k<n):
        if v[k]>v[p_max]:
            p_max=k
        k+=1
    return p_max

def main():
    v = [1,2,3,4,5,4,6,3,7,1,2,8,9,4,5,6,7,2,3,9,6,4,3,2,5,8,9,0,9,8,7,8,9,7]
    n = len(v)
    k = 15
    print(posmax(v, k, n))



if __name__ == '__main__':
    main()