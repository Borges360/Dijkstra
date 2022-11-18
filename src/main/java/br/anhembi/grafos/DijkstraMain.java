package br.anhembi.grafos;

import br.anhembi.grafos.domain.Dijkstra;
import br.anhembi.grafos.domain.Grafo;
import br.anhembi.grafos.domain.Vertice;
import br.anhembi.grafos.util.Util;

import java.util.List;
import java.util.Scanner;

public class DijkstraMain {

    public static void main(String[] args) {
        Grafo grafo = Util.lerArquivo("C:\\Desenvolvimento\\Anhembi\\grafos\\src\\main\\resources\\data.txt");

        Scanner scanner  = new Scanner(System.in);
        System.out.println("Selecione o primeiro Vertice");
        String primeiroVertice = scanner.nextLine();
        System.out.println("Selecione o segundo Vertice");
        String segundoVertice = scanner.nextLine();

        Vertice vertice1 = grafo.encontrarVertice(primeiroVertice);
        Vertice vertice2 = grafo.encontrarVertice(segundoVertice);

        Dijkstra dijkstra = new Dijkstra();
        final List<Vertice> vertices = dijkstra.encontrarMenorCaminhoDijkstra(grafo, vertice1, vertice2);
        System.out.println(vertices);
    }

}
