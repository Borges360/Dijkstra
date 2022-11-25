package br.anhembi.grafos;

import br.anhembi.grafos.domain.FloydWarshall;
import br.anhembi.grafos.domain.Grafo;
import br.anhembi.grafos.domain.GrafoMatriz;
import br.anhembi.grafos.output.Print;
import br.anhembi.grafos.service.TransformaImpl;
import br.anhembi.grafos.util.Util;

public class FloydWarshallMain {

    public static void main(String[] args) {
        Grafo grafo = Util.lerArquivo("C:\\Desenvolvimento\\Anhembi\\grafos\\src\\main\\resources\\data.txt");
        TransformaImpl transforma = new TransformaImpl();
        final int[][] grafoMatriz = transforma.toMatriz(grafo);
        FloydWarshall floydWarshall = new FloydWarshall(new Print());
        floydWarshall.floydWarshall(grafoMatriz);


    }

}
