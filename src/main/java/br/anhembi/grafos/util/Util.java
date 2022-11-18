package br.anhembi.grafos.util;

import br.anhembi.grafos.domain.Aresta;
import br.anhembi.grafos.domain.Grafo;
import br.anhembi.grafos.domain.Vertice;
import br.anhembi.grafos.exception.VerticeNotFoundException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Util {

    public static Grafo lerArquivo(String fileName) {
        boolean directed = false;
        int amountVertices;

        try {

            List<Vertice> vizinhosAtual = new ArrayList<Vertice>();
            List<Aresta> arestasAtual = new ArrayList<Aresta>();

            FileReader fileReader = new FileReader(fileName);
            BufferedReader buffer = new BufferedReader(fileReader);

            String line = buffer.readLine();
            if (line.equalsIgnoreCase("S"))
                directed = true;

            line = buffer.readLine();
            amountVertices = Integer.parseInt(line);

            Grafo graph = new Grafo();
            graph.setDirected(directed);

            System.out.println("O gráfico é " + (directed ? "direcional" : "não é direcional"));

            for (int i = 0; i < amountVertices; i++) {
                graph.adicionarVertice(new Vertice(buffer.readLine()));
            }

            while (buffer.ready()) {
                line = buffer.readLine();
                String[] partes = line.split(",");
                Vertice verticeOrigem = graph.encontrarVertice(partes[0]);
                Vertice verticeDestino = graph.encontrarVertice(partes[1]);
                Aresta aresta = new Aresta(verticeOrigem, verticeDestino, Integer.parseInt(partes[2]));
                verticeOrigem.setVizinho(verticeDestino);

                if(!graph.isDirected()){
                    verticeDestino.setVizinho(verticeOrigem);
                    verticeDestino.setAresta(new Aresta(verticeDestino, verticeOrigem, Integer.parseInt(partes[2])));
                }
                graph.encontrarVertice(partes[0]).setAresta(aresta);

            }

            buffer.close();
            fileReader.close();

            return graph;

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

}
