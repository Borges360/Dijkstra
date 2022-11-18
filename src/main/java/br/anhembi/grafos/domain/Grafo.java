package br.anhembi.grafos.domain;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

    private List<Vertice> grafo = new ArrayList<Vertice>();
    private boolean isDirected;

    public void setVertices(List<Vertice> vertices) {

        this.grafo.addAll(vertices);
    }

    public void setVertice(Vertice vertice) {

        this.grafo.add(vertice);
    }

    public void adicionarVertice(Vertice novoVertice) {

        this.grafo.add(novoVertice);
    }

    public List<Vertice> getVertices() {

        return this.grafo;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public void setDirected(boolean directed) {
        isDirected = directed;
    }

    // Método que retorna o vértice cuja descrição é igual à procurada.
    public Vertice encontrarVertice(String nome) {

        for (int i = 0; i < this.getVertices().size(); i++) {

            if (nome.equalsIgnoreCase(this.getVertices().get(i).getDescricao())) {

                return this.getVertices().get(i);

            }
        }

        return null;

    }

}
