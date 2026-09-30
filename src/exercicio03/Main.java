package exercicio03;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        List<Convidado> registros = Arrays.asList(
                new Convidado("Ana", "Ana@Empresa.com", "Empresa"),
                new Convidado("Ana", " ana@empresa.com ", "Empresa"),
                new Convidado("Bruno", "bruno@empresa.com", "Empresa"),
                new Convidado("Bruno", " BRUNO@EMPRESA.COM ", "Empresa"),
                new Convidado("Carla", "carla@empresa.com", "Empresa"),
                new Convidado("Carla", "Carla@Empresa.Com ", "Empresa"),
                new Convidado("Diego", "diego@empresa.com", "Empresa"),
                new Convidado("Diego", " DIEGO@empresa.com", "Empresa"),
                new Convidado("Eva", "eva@empresa.com", "Empresa"));

        Set<Convidado> inscritos = new HashSet<>(registros);

        Set<Convidado> confirmados = new HashSet<>(Arrays.asList(
                new Convidado("Ana", " ANA@EMPRESA.COM ", "Empresa"),
                new Convidado("Carla", "CARLA@empresa.com", "Empresa")));

        Set<Convidado> inscritosConfirmados = new HashSet<>(inscritos);

        Set<Convidado> naoConfirmados = new HashSet<>(inscritos);

        System.out.println("Antes: " + registros.size());

        System.out.println("Depois: " + inscritos.size());

        inscritosConfirmados.retainAll(confirmados);
        naoConfirmados.removeAll(confirmados);
        System.out.println("\nInscritos com presença confirmada:");
        inscritosConfirmados.forEach(System.out::println);

        System.out.println("\nInscritos sem confirmação:");
        naoConfirmados.forEach(System.out::println);
    }
}
