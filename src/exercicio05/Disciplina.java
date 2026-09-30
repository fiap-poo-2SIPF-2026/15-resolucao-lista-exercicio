package exercicio05;

public class Disciplina {
    private String codigo;
    private String nome;
    private int semestreSugerido;

    public Disciplina(String codigo, String nome, int semestreSugerido) {
        this.codigo = codigo;
        this.nome = nome;
        this.semestreSugerido = semestreSugerido;
    }

    public String getNome() {
        return nome;
    }

    // implementação padrão como fizemos em aula
    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) return true;
        if (!(objeto instanceof Disciplina)) return false;
        Disciplina outra = (Disciplina) objeto;
        return codigo.equals(outra.codigo);
    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }

    @Override
    public String toString() {
        return codigo + " — " + nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getSemestreSugerido() {
        return semestreSugerido;
    }
}
