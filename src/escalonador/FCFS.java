package escalonador;

import java.util.ArrayList;
import java.util.List;

public class FCFS extends Escalonador {

    private static List<Processo> listaProntos;

    //Implementação do algoritimo FCFS para calcular: 
    //Tempo de retono médio 
    //Tempo de resposta médio 
    //Tempo de espera médio
    
    public FCFS(List<Processo> processos) {
        
        listaProntos = new ArrayList<Processo>(processos);
        int tempoRetorno = 0, tempoResposta = 0, tempoEspera = 0;
        int totalProcessos = processos.size();

        int retorno = tempoChegadaMinimo(processos);

        // enquanto houver processos na fila de prontos
        while (!listaProntos.isEmpty()) {
            Processo p = listaProntos.remove(0); // obtem o primeiro processo da fila e remove
            retorno += p.getDuracao();
            
            tempoRetorno += (retorno - p.getTempoChegada());
            tempoEspera += (retorno - p.getTempoChegada() - p.getDuracao());
        }

        tempoResposta = tempoEspera; // No FCFS o tempo de resposta é igual ao tempo de espera

        // armazena os tempos médios
        super.setRetornoMedio((double) tempoRetorno / totalProcessos);
        super.setRespostaMedio((double) tempoResposta / totalProcessos);
        super.setEsperaMedio((double) tempoEspera / totalProcessos);
    }

    public void printMetricas() {
        super.printMetricas("FCFS");
    }
}
