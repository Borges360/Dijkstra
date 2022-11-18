package br.anhembi.grafos.domain;

import br.anhembi.grafos.exception.VerticeNotFoundException;

import java.util.HashMap;

public class Grafo {

    private double[][] mat;
    private boolean isDirected;
    private HashMap<String, Integer> nomes;
    private int currentNumVertice;

    public Grafo(int numVertice, boolean directed) {
        mat = new double[numVertice][numVertice];
        this.nomes = new HashMap<>();
        this.isDirected = directed;
    }

    public boolean addAresta(Vertice u, Vertice v, double value) {
        Integer line = nomes.get(u.getNome());
        Integer column = nomes.get(v.getNome());
        if (line == null || column == null) {
            return false;
        }
        mat[line][column] = value;
        if (!isDirected) {
            mat[column][line] = value;
        }
        return true;
    }

    public void addVertice(Vertice v) throws VerticeNotFoundException {
        if (v.getNome() == null) {
            throw new VerticeNotFoundException("Vértice " + v.getNome() + " não encontrado.");
        }
        nomes.put(v.getNome(), currentNumVertice);
        currentNumVertice++;
    }

    @Override
    public String toString() {
        String out = "";
        for (double[] linha : mat) {
            for (double valor : linha) {
                out += (valor + " ");
            }
            out += "\n";
        }
        return out;
    }

    public boolean adjacent(Vertice u, Vertice v) {
        Integer line = nomes.get(u.getNome());
        Integer column = nomes.get(v.getNome());
        if (line == null || column == null) {
            return false;
        }
        return mat[line][column] == 1;
    }

    public boolean removeVertice(Vertice v) {
        // can't remove
        return false;
    }
    
    public boolean removeAresta(Vertice u, Vertice v) {
        Integer line = nomes.get(u.getNome());
        Integer column = nomes.get(v.getNome());
        if (line == null || column == null) {
            return false;
        }
        mat[line][column] = 0;
        mat[column][line] = 0;
        return true;
    }
    
    public boolean isDirected() {
        return isDirected;
    }

    public boolean notDirected() {
        return !isDirected;
    }

}
