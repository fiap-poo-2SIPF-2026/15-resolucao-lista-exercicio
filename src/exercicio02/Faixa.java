package exercicio02;

public class Faixa {
    private final String titulo;
    private final String artista;
    private final int duracaoSegundos;
    private final int ano;
    private final int reproducoes;

    public Faixa(String titulo, String artista, int duracaoSegundos, int ano, int reproducoes) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracaoSegundos = duracaoSegundos;
        this.ano = ano;
        this.reproducoes = reproducoes;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public int getAno() {
        return ano;
    }

    public int getReproducoes() {
        return reproducoes;
    }

    @Override
    public String toString() {
        return artista + " — " + titulo + " (" + ano + ")";
    }
}
