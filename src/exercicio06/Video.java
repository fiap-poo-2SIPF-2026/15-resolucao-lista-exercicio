package exercicio06;

import java.util.Objects;
import java.util.Set;

public class Video {
    private String titulo;
    private String canal;
    private int duracaoMinutos;
    private Set<String> tags;

    public Video(String titulo, String canal, int duracaoMinutos, Set<String> tags) {
        this.titulo = titulo;
        this.canal = canal;
        this.duracaoMinutos = duracaoMinutos;
        this.tags = tags;
    }

    public String getCanal() {
        return canal;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    // implementação padrão gerada pelo atalho do intellij
    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) return true;
        if (!(objeto instanceof Video)) return false;
        Video outro = (Video) objeto;
        return titulo.equals(outro.titulo) && canal.equals(outro.canal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, canal);
    }

    @Override
    public String toString() {
        return titulo + " — " + canal;
    }

    public String getTitulo() {
        return titulo;
    }

    public Set<String> getTags() {
        return tags;
    }
}
