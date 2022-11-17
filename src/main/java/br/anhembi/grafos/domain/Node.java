package br.anhembi.grafos.domain;

import java.util.*;

public class Node {

    private String nome;

    private List<Node> caminhoMaisCurto = new LinkedList<>();

    private Integer distancia = Integer.MAX_VALUE;

    private Map<Node, Integer> nodesAdjacentes = new HashMap<>();

    public void addDestino(Node destination, int distance) {
        nodesAdjacentes.put(destination, distance);
    }

    public Node(String nome) {
        this.nome = nome;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Node> getCaminhoMaisCurto() {
        return caminhoMaisCurto;
    }

    public void setCaminhoMaisCurto(List<Node> caminhoMaisCurto) {
        this.caminhoMaisCurto = caminhoMaisCurto;
    }

    public Integer getDistancia() {
        return distancia;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }

    public Map<Node, Integer> getNodesAdjacentes() {
        return nodesAdjacentes;
    }

    public void setNodesAdjacentes(Map<Node, Integer> nodesAdjacentes) {
        this.nodesAdjacentes = nodesAdjacentes;
    }
}
