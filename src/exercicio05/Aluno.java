package exercicio05;

// no enunciado eu digitei RA, mas o correto é RM
public class Aluno {
    private String rm;
    private String nome;
    private String curso;

    public Aluno(String rm, String nome, String curso) {
        this.rm = rm;
        this.nome = nome;
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }
    // implementação padrão gerada pelo atalho do intellij
    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) return true;
        if (!(objeto instanceof Aluno)) return false;
        Aluno outro = (Aluno) objeto;
        return rm.equals(outro.rm);
    }

    @Override
    public int hashCode() {
        return rm.hashCode();
    }

    @Override
    public String toString() {
        return rm + " — " + nome + " (" + curso + ")";
    }

    public String getRm() {
        return rm;
    }

    public String getNome() {
        return nome;
    }
}
