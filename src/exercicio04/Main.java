package exercicio04;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Predicate<Cadastro> nomeValido = c -> c.getNome().length() >= 3;
        Predicate<Cadastro> emailValido = c -> c.getEmail().contains("@") && c.getEmail().contains(".");
        Predicate<Cadastro> senhaLonga = c -> c.getSenha().length() >= 8;

        // coloquei essa validação como curiosidade. Ela não será cobrada. O que representa cada uma das partes?
        // .* --> zero ou mais caracteres antes do dígito
        // [0-9] --> um dígito entre 0 e 9
        // .* --> zero ou mais caracteres depois do dígito
        Predicate<Cadastro> senhaComDigito = c -> c.getSenha().matches(".*[0-9].*");
        Predicate<Cadastro> idadeValida = c -> c.getIdade() >= 18 && c.getIdade() <= 120;
        Predicate<Cadastro> cadastroValido = nomeValido.and(emailValido)
                .and(senhaLonga).and(senhaComDigito).and(idadeValida);

        Predicate<Cadastro> senhaFraca = senhaLonga.negate().or(senhaComDigito.negate());

        List<Regra> regras = Arrays.asList(
                c -> nomeValido.test(c) ? null : "Nome deve ter ao menos 3 caracteres.",
                c -> emailValido.test(c) ? null : "E-mail deve conter @ e ponto.",
                c -> senhaLonga.test(c) ? null : "Senha deve ter ao menos 8 caracteres.",
                c -> senhaComDigito.test(c) ? null : "Senha deve conter ao menos um dígito.",
                c -> idadeValida.test(c) ? null : "Idade deve estar entre 18 e 120.");

        ValidadorCadastro validador = new ValidadorCadastro(regras);

        List<Cadastro> cadastros = Arrays.asList(
                new Cadastro("Ana", "ana@empresa.com", "abcde123", 18),
                new Cadastro("Bo", "brunoempresa.com", "abc", 17),
                new Cadastro("Carla", "carla@empresa.com", "abcdefgh", 40),
                new Cadastro("Diego", "diego@empresa.com", "abc123", 121),
                new Cadastro("Eva", "eva@empresa.com", "senha123", 120));

        for (Cadastro cadastro : cadastros) {
            System.out.println(cadastro.getNome() + " | Cadastro válido: " + cadastroValido.test(cadastro)
                    + " | Senha fraca: " + senhaFraca.test(cadastro));
            System.out.println("Erros: " + validador.erros(cadastro));
        }
    }
}
