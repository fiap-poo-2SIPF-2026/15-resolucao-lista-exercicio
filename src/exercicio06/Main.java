package exercicio06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Historico historico = new Historico();
        List<Visualizacao> visualizacoes;
        Map<String, Double> minutosPorCanal;
        Set<Video> concluidos;
        Set<Video> iniciadosNaoConcluidos;
        double media;

        Video v1 = new Video("Collections", "Java Fácil", 20,
                new HashSet<>(Arrays.asList("java", "backend")));

        Video v2 = new Video("Streams", "Java Fácil", 30,
                new HashSet<>(Arrays.asList("java", "backend")));

        Video v3 = new Video("APIs", "Web Prática", 25,
                new HashSet<>(Arrays.asList("backend", "web")));

        Video v4 = new Video("Currículo", "Carreira Tech", 10,
                new HashSet<>(Arrays.asList("carreira", "tecnologia")));

        Video v5 = new Video("Entrevistas", "Carreira Tech", 15,
                new HashSet<>(Arrays.asList("carreira", "java")));

        Video v6 = new Video("SQL", "Dados Hoje", 40,
                new HashSet<>(Arrays.asList("dados", "backend")));

        Video v7 = new Video("Modelagem", "Dados Hoje", 35,
                new HashSet<>(Arrays.asList("dados", "backend")));

        // Registra cada visualização e atualiza os cinco vídeos recentes.
        historico.registrar(v1, 50);
        historico.registrar(v2, 90);
        historico.registrar(v3, 40);
        historico.registrar(v4, 100);
        historico.registrar(v5, 60);
        historico.registrar(v6, 25);
        historico.registrar(v7, 80);
        historico.registrar(v3, 95);
        historico.registrar(v2, 30);

        System.out.println("Recentes, do mais recente para o mais antigo:");
        historico.getRecentes().forEach(System.out::println);

        visualizacoes = historico.getVisualizacoes();

        // agrupa pelo canal e soma os minutos de todas as visualizações.
        // exemplo: um vídeo de 20 minutos assistido em 50% soma 10 minutos.
        minutosPorCanal = visualizacoes.stream()
                .collect(Collectors.groupingBy(
                        visualizacao -> visualizacao.getVideo().getCanal(),
                        Collectors.summingDouble(visualizacao -> {
                            int duracao = visualizacao.getVideo().getDuracaoMinutos();
                            int percentual = visualizacao.getPercentualAssistido();
                            return duracao * percentual / 100.0;
                        })));

        System.out.println("\nMinutos efetivamente assistidos por canal:");
        // keySet fornece os nomes dos canais; get consulta seus minutos.
        // comparing ordena pelos minutos; reversed coloca o maior primeiro.
        minutosPorCanal.keySet().stream()
                .sorted(Comparator.comparing(minutosPorCanal::get).reversed())
                .forEach(canal -> {
                    double minutos = minutosPorCanal.get(canal);
                    System.out.println(canal + " — " + String.format("%.2f", minutos));
                });

        // basta uma visualização de 90% ou mais para concluir o vídeo.
        concluidos = visualizacoes.stream()
                .filter(visualizacao -> visualizacao.getPercentualAssistido() >= 90)
                .map(Visualizacao::getVideo)
                .collect(Collectors.toSet());

        // Primeiro é necessário reunir todos os vídeos registrados, sem repetição.
        iniciadosNaoConcluidos = visualizacoes.stream()
                .map(Visualizacao::getVideo)
                .collect(Collectors.toSet());

        // depois retiram-se os concluídos: restam os iniciados não concluídos.
        iniciadosNaoConcluidos.removeAll(concluidos);
        System.out.println("\nVídeos concluídos:");
        concluidos.forEach(System.out::println);
        System.out.println("\nVídeos iniciados e não concluídos:");
        iniciadosNaoConcluidos.forEach(System.out::println);

        // O método calcula a média usando as visualizações do próprio histórico.
        media = historico.mediaPercentual();
        System.out.println("\nPercentual médio assistido: " + String.format("%.2f%%", media));
    }
}
