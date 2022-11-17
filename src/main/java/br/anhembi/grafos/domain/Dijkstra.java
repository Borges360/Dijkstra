package br.anhembi.grafos.domain;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Dijkstra {

    public Grafo calcularCaminhoMaisCurto(Grafo grafo, Node source) {
        source.setDistancia(0);

        Set<Node> nodesProcessados = new HashSet<>();
        Set<Node> nodesNaoProcessados = new HashSet<>();

        nodesNaoProcessados.add(source);

        while (nodesNaoProcessados.size() != 0) {
            Node nodeAtual = getMenordistancia(nodesNaoProcessados);
            nodesNaoProcessados.remove(nodeAtual);
            for (Map.Entry<Node,Integer> parAjacente:
                    nodeAtual.getNodesAdjacentes().entrySet()) {
                Node nodeAdjacente = parAjacente.getKey();
                Integer edgeWeight = parAjacente.getValue();
                if (!nodesProcessados.contains(nodeAdjacente)) {
                    calcularMenorDistancia(nodeAdjacente, edgeWeight, nodeAtual);
                    nodesNaoProcessados.add(nodeAdjacente);
                }
            }
            nodesProcessados.add(nodeAtual);
        }
        return grafo;
    }

    private static void calcularMenorDistancia(Node evaluationNode,
                                               Integer edgeWeigh, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistancia();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistancia()) {
            evaluationNode.setDistancia(sourceDistance + edgeWeigh);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getCaminhoMaisCurto());
            shortestPath.add(sourceNode);
            evaluationNode.setCaminhoMaisCurto(shortestPath);
        }
    }

    private Node getMenordistancia(Set<Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node: unsettledNodes) {
            int nodeDistance = node.getDistancia();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

}
