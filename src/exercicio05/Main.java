package exercicio05;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Map<Disciplina, Set<Aluno>> matriculados;
        Map<String, Double> mediasPorCurso;
        Map<Aluno, List<String>> reprovacoes;

        Aluno ana = new Aluno("001", "Ana Lima", "SI");
        Aluno bruno = new Aluno("002", "Bruno Costa", "ADS");
        Aluno carla = new Aluno("003", "Carla Souza", "ADS");
        Aluno diego = new Aluno("004", "Diego Ramos", "SI");

        // outro objeto representando o mesmo aluno para exercitar equals/hashCode.
        Aluno diegoOutraInstancia = new Aluno("004", "Diego Ramos", "SI");
        Disciplina poo = new Disciplina("POO2", "Programação Orientada a Objetos", 2);
        Disciplina ed = new Disciplina("ED", "Estruturas de Dados", 3);
        Disciplina bd = new Disciplina("BD", "Banco de Dados", 3);

        List<Matricula> matriculas = Arrays.asList(
                new Matricula(ana, poo, 9.0),
                new Matricula(bruno, poo, 7.0),
                new Matricula(carla, poo, 8.0),
                new Matricula(diego, poo, 6.0),
                new Matricula(ana, ed, 9.5),
                new Matricula(bruno, ed, 6.0),
                new Matricula(diego, ed, 4.0),
                new Matricula(ana, bd, 8.5),
                new Matricula(diegoOutraInstancia, bd, 5.0));

        matriculados = matriculas.stream().collect(Collectors.groupingBy(
                Matricula::getDisciplina,
                Collectors.mapping(Matricula::getAluno, Collectors.toCollection(HashSet::new))));

        System.out.println("\nDisciplinas abertas e alunos ordenados pelo RM:");
        matriculados.entrySet().stream()
                .filter(entrada -> entrada.getValue().size() >= 3)
                .forEach(entrada -> {
                    System.out.println(entrada.getKey() + " — " + entrada.getValue().size() + " matriculados");
                    entrada.getValue().stream()
                            .sorted(Comparator.comparing(Aluno::getRm))
                            .forEach(System.out::println);
                });

        mediasPorCurso = matriculas.stream().collect(Collectors.groupingBy(
                m -> m.getAluno().getCurso(), Collectors.averagingDouble(Matricula::getNota)));
        System.out.println("\nMédia das notas por curso:");
        mediasPorCurso.forEach((curso, media) ->
                System.out.println(curso + " = " + String.format("%.2f", media)));

        reprovacoes = matriculas.stream().filter(m -> m.getNota() < 6.0)
                .collect(Collectors.groupingBy(Matricula::getAluno,
                        Collectors.mapping(m -> m.getDisciplina().getNome(), Collectors.toList())));
        System.out.println("\nAlunos com duas ou mais reprovações:");
        reprovacoes.entrySet().stream().filter(entrada -> entrada.getValue().size() >= 2)
                .forEach(entrada -> System.out.println(entrada.getKey() + " → " + entrada.getValue()));

        // sem equals e hashCode, os dois objetos de Diego formam chaves distintas
        // no groupingBy. Cada chave teria uma reprovação e Diego não seria exibido.
        // O fragmento de saída inclui aprovados e melhor aluno, mas esses cálculos
        // não constam em "O que implementar" e não foram acrescentados.
    }
}
