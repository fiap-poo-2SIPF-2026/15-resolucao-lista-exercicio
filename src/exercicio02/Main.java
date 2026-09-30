package exercicio02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int quantidadeAntes;
        int removidas;
        int totalSegundos;
        int horas;
        int minutos;
        int segundos;

        List<Faixa> playlist = new ArrayList<>(Arrays.asList(
                new Faixa("Horizonte", "Ana", 240, 2020, 12),
                new Faixa("Caminhos", "Ana", 180, 2024, 20),
                new Faixa("Sol", "Bruno", 200, 2020, 2),
                new Faixa("Mar", "Bruno", 210, 2023, 8),
                new Faixa("Vento", "Carla", 300, 2024, 30),
                new Faixa("Lua", "Carla", 220, 2020, 1),
                new Faixa("Tempo", "Diego", 250, 2023, 15),
                new Faixa("Chuva", "Diego", 190, 2024, 3)));

        System.out.println("\nPlaylist por artista e ano decrescente:");
        playlist.stream()
                .sorted(Comparator.comparing(Faixa::getArtista)
                        .thenComparing(Faixa::getAno, Comparator.reverseOrder()))
                .forEach(System.out::println);

        System.out.println("\nCinco faixas mais reproduzidas:");
        playlist.stream()
                .sorted(Comparator.comparingInt(Faixa::getReproducoes).reversed())
                .limit(5)
                .forEach(f -> System.out.println(f.getTitulo() + " — " + f.getReproducoes()));

        quantidadeAntes = playlist.size();

        // A dica "removei" do enunciado foi escrito errado e o correto é removeIf.
        playlist.removeIf(f -> f.getReproducoes() < 3);

        removidas = quantidadeAntes - playlist.size();
        System.out.println("\nFaixas removidas: " + removidas);

        totalSegundos = playlist.stream().mapToInt(Faixa::getDuracaoSegundos).sum();
        horas = totalSegundos / 3600;
        minutos = totalSegundos % 3600 / 60;
        segundos = totalSegundos % 60;
        System.out.println("\nDuração restante: " + String.format("%02d:%02d:%02d", horas, minutos, segundos));
    }
}
