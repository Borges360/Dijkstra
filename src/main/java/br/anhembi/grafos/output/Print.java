package br.anhembi.grafos.output;

import java.util.ArrayList;
import java.util.List;

public class Print {

    private static void printPath(int[][] path, int v, int u, List<Integer> route)
    {
        if (path[v][u] == v) {
            return;
        }
        printPath(path, v, path[v][u], route);
        route.add(path[v][u]);
    }

    // Função para imprimir o menor custo com informações de caminho entre
    // todos os pares de vértices
    public void printSolution(int[][] path, int n)
    {
        for (int v = 0; v < n; v++)
        {
            for (int u = 0; u < n; u++)
            {
                if (u != v && path[v][u] != -1)
                {
                    List<Integer> route = new ArrayList<>();
                    route.add(v);
                    printPath(path, v, u, route);
                    route.add(u);
                    System.out.printf("The shortest path from %d —> %d is %s\n",
                            v, u, route);
                }
            }
        }
    }

}
