package br.anhembi.grafos.util;

import br.anhembi.grafos.domain.Aresta;
import br.anhembi.grafos.domain.Grafo;
import br.anhembi.grafos.domain.Vertice;
import br.anhembi.grafos.exception.VerticeNotFoundException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Util {

    public static Grafo lerArquivo(String fileName) {
        boolean directed = false;
        int amountVertices;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader buffer = new BufferedReader(fileReader);

            String line = buffer.readLine();
            if (line.equals("S") || line.equals("s"))
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
                graph.encontrarVertice(partes[0]).setAresta(new Aresta(new Vertice(partes[0]), new Vertice(partes[1]), Integer.parseInt(partes[2])));
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
