package br.anhembi.grafos.domain;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Dijkstra {

    public Grafo calcularCaminhoMaisCurto(Grafo grafo, Vertice source) {
        source.setDistancia(0);

        Set<Vertice> nodesProcessados = new HashSet<>();
        Set<Vertice> nodesNaoProcessados = new HashSet<>();

        nodesNaoProcessados.add(source);

        while (nodesNaoProcessados.size() != 0) {
            Vertice verticeAtual = getMenordistancia(nodesNaoProcessados);
            nodesNaoProcessados.remove(verticeAtual);
            for (Map.Entry<Vertice,Integer> parAjacente:
                    verticeAtual.getNodesAdjacentes().entrySet()) {
                Vertice verticeAdjacente = parAjacente.getKey();
                Integer edgeWeight = parAjacente.getValue();
                if (!nodesProcessados.contains(verticeAdjacente)) {
                    calcularMenorDistancia(verticeAdjacente, edgeWeight, verticeAtual);
                    nodesNaoProcessados.add(verticeAdjacente);
                }
            }
            nodesProcessados.add(verticeAtual);
        }
        return grafo;
    }

    private static void calcularMenorDistancia(Vertice evaluationVertice,
                                               Integer edgeWeigh, Vertice sourceVertice) {
        Integer sourceDistance = sourceVertice.getDistancia();
        if (sourceDistance + edgeWeigh < evaluationVertice.getDistancia()) {
            evaluationVertice.setDistancia(sourceDistance + edgeWeigh);
            LinkedList<Vertice> shortestPath = new LinkedList<>(sourceVertice.getCaminhoMaisCurto());
            shortestPath.add(sourceVertice);
            evaluationVertice.setCaminhoMaisCurto(shortestPath);
        }
    }

    private Vertice getMenordistancia(Set<Vertice> unsettledVertices) {
        Vertice lowestDistanceVertice = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Vertice vertice : unsettledVertices) {
            int nodeDistance = vertice.getDistancia();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceVertice = vertice;
            }
        }
        return lowestDistanceVertice;
    }

}
