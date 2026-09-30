package exercicio01;

import exercicio06.Historico;

import java.util.ArrayDeque;
import java.util.Deque;

public class Navegador {
    private String paginaAtual;
    private Deque<String> historicoVoltar = new ArrayDeque<>();
    private Deque<String> historicoAvancar = new ArrayDeque<>();

    public Navegador() {
        this.historicoVoltar = new ArrayDeque<>();
        this.historicoAvancar = new ArrayDeque<>();
    }
    public void visitar(String url) {
        if (paginaAtual != null) {
            historicoVoltar.push(paginaAtual);
        }
        paginaAtual = url;
        historicoAvancar.clear();
    }

    public boolean voltar() {
        if (historicoVoltar.isEmpty()) {
            return false;
        }
        historicoAvancar.push(paginaAtual);
        paginaAtual = historicoVoltar.pop();
        return true;
    }

    public boolean avancar() {
        if (historicoAvancar.isEmpty()) {
            return false;
        }
        historicoVoltar.push(paginaAtual);
        paginaAtual = historicoAvancar.pop();
        return true;
    }

    public String getEstado() {
        return "Atual: " + paginaAtual
                + " | Voltar: " + historicoVoltar.size()
                + " | Avançar: " + historicoAvancar.size();
    }

    public String getPaginaAtual() {
        return paginaAtual;
    }

    public int getQuantidadeVoltar() {
        return historicoVoltar.size();
    }

    public int getQuantidadeAvancar() {
        return historicoAvancar.size();
    }

    public Deque<String> getHistoricoVoltar() {
        return this.historicoVoltar;
    }
}
