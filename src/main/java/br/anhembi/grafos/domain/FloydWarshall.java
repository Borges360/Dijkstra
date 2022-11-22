package br.anhembi.grafos.domain;

import br.anhembi.grafos.output.Print;

public class FloydWarshall {

    private final Print print;

    public FloydWarshall(Print print) {
        this.print = print;
    }

    public void floydWarshall(int[][] adjMatrix)
    {
        // caso base
        if (adjMatrix ==null || adjMatrix.length == 0) {
            return;
        }

        // número total de vértices no `adjMatrix`
        int n = adjMatrix.length;

        // cost[] e path[] armazena o caminho mais curto
        // informações (custo mais curto/rota mais curta)
        int[][] cost = new int[n][n];
        int[][] path = new int[n][n];

        // inicializa cost[] e path[]
        for (int v = 0; v < n; v++)
        {
            for (int u = 0; u < n; u++)
            {
                // inicialmente, o custo seria o mesmo que o peso da aresta
                cost[v][u] = adjMatrix[v][u];

                if (v == u) {
                    path[v][u] = 0;
                }
                else if (cost[v][u] != Integer.MAX_VALUE) {
                    path[v][u] = v;
                }
                else {
                    path[v][u] = -1;
                }
            }
        }

        // executa Floyd–Warshall
        for (int k = 0; k < n; k++)
        {
            for (int v = 0; v < n; v++)
            {
                for (int u = 0; u < n; u++)
                {
                    // Se o vértice `k` estiver no caminho mais curto de `v` para `u`,
                    // então atualiza o valor de cost[v][u] e path[v][u]

                    if (cost[v][k] != Integer.MAX_VALUE
                            && cost[k][u] != Integer.MAX_VALUE
                            && (cost[v][k] + cost[k][u] < cost[v][u]))
                    {
                        cost[v][u] = cost[v][k] + cost[k][u];
                        path[v][u] = path[k][u];
                    }
                }

                // se os elementos diagonais se tornarem negativos, o
                // gráfico contém um ciclo de peso negativo
                if (cost[v][v] < 0)
                {
                    System.out.println("Negative-weight cycle found!!");
                    return;
                }
            }
        }

        // Imprime o caminho mais curto entre todos os pares de vértices
        print.printSolution(path, n);
    }

}
