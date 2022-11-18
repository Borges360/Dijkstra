package br.anhembi.grafos.domain;

import java.util.*;

public class Vertice {

    private String nome;

    private List<Vertice> caminhoMaisCurto = new LinkedList<>();

    private Integer distancia = Integer.MAX_VALUE;

    private Map<Vertice, Integer> nodesAdjacentes = new HashMap<>();

    public void addDestino(Vertice destination, int distance) {
        nodesAdjacentes.put(destination, distance);
    }

    public Vertice(String nome) {
        this.nome = nome;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Vertice> getCaminhoMaisCurto() {
        return caminhoMaisCurto;
    }

    public void setCaminhoMaisCurto(List<Vertice> caminhoMaisCurto) {
        this.caminhoMaisCurto = caminhoMaisCurto;
    }

    public Integer getDistancia() {
        return distancia;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }

    public Map<Vertice, Integer> getNodesAdjacentes() {
        return nodesAdjacentes;
    }

    public void setNodesAdjacentes(Map<Vertice, Integer> nodesAdjacentes) {
        this.nodesAdjacentes = nodesAdjacentes;
    }
}
