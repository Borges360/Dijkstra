package br.anhembi.grafos.domain;

public class Aresta {

    private Vertice vertex;
    private double value;

    public Aresta(Vertice vertex, double value) {
        this.vertex = vertex;
        this.value = value;
    }

    public Vertice getVertice() {
        return vertex;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return " [to " + vertex + ", " + value + "]";
    }



}
