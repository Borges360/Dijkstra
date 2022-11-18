package br.anhembi.grafos.domain;

import br.anhembi.grafos.exception.VerticeNotFoundException;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListaAdjacente {

    private HashMap<Vertice, LinkedList<Aresta>> vertices;
    private boolean isDirected;

    public void ListAdj(boolean isDirected) {
        vertices = new HashMap<>();
        this.isDirected = isDirected;
    }

    public boolean adjacent(Vertice u, Vertice v) {
        return vertices.get(u).stream().filter(e -> e.getVertice().equals(v)).count() > 0;
    }

    public void addVertex(Vertice v) throws VerticeNotFoundException {
        if (vertices.get(v) != null) {
            throw new VerticeNotFoundException("Vértice " + v.getNome() + " não encontrado.");
        }
        vertices.put(v, new LinkedList<>());
    }

    public boolean removeVertex(Vertice v) {
        // TODO implement
        return false;
    }

    public boolean addEdge(Vertice u, Vertice v, double value) {
        if (vertices.get(u) == null || vertices.get(v) == null) {
            return false;
        }
        vertices.get(u).add(new Aresta(v, value));
        if (notDirected()) {
            vertices.get(v).add(new Aresta(u, value));
        }
        return true;
    }

    public boolean removeEdge(Vertice u, Vertice v) {
        vertices.get(u).forEach(e -> {
            if (e.getVertice().getNome().equals(v.getNome())) {
                vertices.get(u).remove(e);
                return;
            }
        });
        if (notDirected()) {
            vertices.get(v).forEach(e -> {
                if (e.getVertice().getNome().equals(u.getNome())) {
                    vertices.get(v).remove(e);
                    return;
                }
            });
        }
        return true;
    }
    
    public boolean isDirected() {
        return isDirected;
    }

    public boolean notDirected() {
        return !isDirected;
    }

    @Override
    public String toString() {
        String out = "";
        List<Map.Entry<Vertice, LinkedList<Aresta>>> verticesStream = vertices.entrySet().stream()
                .collect(Collectors.toList());

        for (Map.Entry<Vertice, LinkedList<Aresta>> item : verticesStream) {
            out += "from " + item.getKey();
            for (Aresta edge : item.getValue()) {
                out += edge;
            }
            out += "\n";
        }

        return out;
    }


}
