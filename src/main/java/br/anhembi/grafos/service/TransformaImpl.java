package br.anhembi.grafos.service;

import br.anhembi.grafos.domain.Grafo;

public class TransformaImpl {

    public int [][] toMatriz(Grafo grafo){
        int tamanho = grafo.getVertices().size();
        int[][] adjMatrix = new int[tamanho][tamanho];
        for(int i = 0; i < tamanho; i++){
            for(int j = 0; j < grafo.getVertices().get(i).getArestas().size(); j++){
                if(i==j){
                    adjMatrix[i][j] = 0;
                } else {
                    adjMatrix[i][j] = grafo.getVertices().get(i).getArestas().get(j).getPeso();
                }

            }
        }
        return adjMatrix;
    }

}
