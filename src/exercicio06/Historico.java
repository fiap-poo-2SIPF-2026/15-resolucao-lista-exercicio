package exercicio06;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Historico {
    private List<Visualizacao> visualizacoes = new ArrayList<>();
    private Deque<Video> recentes = new ArrayDeque<>();

    public Historico() {
       this.visualizacoes = new ArrayList<>();
        this.recentes = new ArrayDeque<>();
    }
    public void registrar(Video v, int percentual) {
        visualizacoes.add(new Visualizacao(v, percentual));
        recentes.remove(v);
        recentes.addFirst(v);
        if (recentes.size() > 5) {
            recentes.removeLast();
        }
    }

    public Deque<Video> getRecentes() {
        return this.recentes;
    }

    public List<Visualizacao> getVisualizacoes() {
        return this.visualizacoes;
    }

    public double mediaPercentual() {
        return visualizacoes.stream()
                .mapToInt(Visualizacao::getPercentualAssistido)
                .average()
                .orElse(0.0);
    }
}
