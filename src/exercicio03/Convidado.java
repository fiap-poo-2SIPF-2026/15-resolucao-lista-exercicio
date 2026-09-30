package exercicio03;

public class Convidado {
    private String nome;
    private String email;
    private String empresa;

    public Convidado(String nome, String email, String empresa) {
        this.nome = nome;
        this.email = email;
        this.empresa = empresa;
    }

    // o método trim() retira espaços extras se por ventura existirem no início e no final da string
    private String emailNormalizado() {
        return email.trim().toLowerCase();
    }

    // utilizando a implementação padrão do hashCode() no atalho do intellij
    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) return true;
        if (!(objeto instanceof Convidado)) return false;
        Convidado outro = (Convidado) objeto;
        return emailNormalizado().equals(outro.emailNormalizado());
    }
    @Override
    public int hashCode() {
        return emailNormalizado().hashCode();
    }

    @Override
    public String toString() {
        return nome + " — " + emailNormalizado() + " — " + empresa;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getEmpresa() {
        return empresa;
    }
}
