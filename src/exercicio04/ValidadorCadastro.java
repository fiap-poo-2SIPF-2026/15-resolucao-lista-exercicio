package exercicio04;

import java.util.ArrayList;
import java.util.List;

public class ValidadorCadastro {
    private List<Regra> regras;

    public ValidadorCadastro(List<Regra> regras) {
        this.regras = regras;
    }

    public List<String> erros(Cadastro c) {
        List<String> mensagens = new ArrayList<>();
        String mensagem;
        for (Regra regra : regras) {
            mensagem = regra.validar(c);
            if (mensagem != null) mensagens.add(mensagem);
        }
        return mensagens;
    }

}

