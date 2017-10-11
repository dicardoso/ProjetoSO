package escalonador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Processo> listaProcessos = new ArrayList<Processo>();

    public static void main(String[] args) throws FileNotFoundException, IOException {
        //Arquivo
        File file = new File("arquivo.txt");
        int id = 0;

        try {
            FileReader reader = new FileReader(file);
            BufferedReader in = new BufferedReader(reader);

            String linha;
            String[] split = null;

            while ((linha = in.readLine()) != null) {
                split = linha.split(" ");

                if (split.length != 2) { //Testa se a formatação dos dados
                    System.out.println("Erro de formatação no arquivo!!!");
                } 
                else {
                    listaProcessos.add(new Processo(++id, Integer.parseInt(split[0]), Integer.parseInt(split[1])));
                }
            }
        } 
        catch (IOException e) {
            System.out.println("Houve um problema no arquivo");
        }

        FCFS fcfs = new FCFS(listaProcessos);  
        SJF sjf = new SJF(listaProcessos);
        
        fcfs.printMetricas("FCFS");
        sjf.printMetricas("SJF");
    }
}
