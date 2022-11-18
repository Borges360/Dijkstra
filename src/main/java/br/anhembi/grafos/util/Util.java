package br.anhembi.grafos.util;

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

            Grafo graph = new Grafo(amountVertices, directed);

            for (int i = 0; i < amountVertices; i++) {
                graph.addVertice(new Vertice(buffer.readLine()));
            }

            while (buffer.ready()) {
                line = buffer.readLine();
                String[] partes = line.split(",");
                graph.addAresta(new Vertice(partes[0]), new Vertice(partes[1]), Double.parseDouble(partes[2]));
            }

            buffer.close();
            fileReader.close();

            return graph;

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return null;
        } catch (VerticeNotFoundException ex) {
            System.err.println("Erro: Tentativa de adicionar uma aresta com vértice que não existe");
            System.err.println(ex.getMessage());
            return null;
        }
    }

}
