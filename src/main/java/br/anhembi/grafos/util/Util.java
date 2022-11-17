package br.anhembi.grafos.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Util {

    public static Map<Integer, String> lerArquivo(String fileName){
        BufferedReader reader;
        Map<Integer, String> linhasArquivo = new HashMap<>();
        int i = 0;
        try {
            reader = new BufferedReader(new FileReader(
                    fileName));
            String line = reader.readLine();
            while (line != null) {
                linhasArquivo.put(i, line);
                line = reader.readLine();
                i++;
            }
            reader.close();
            return linhasArquivo;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return linhasArquivo;
    }

}
