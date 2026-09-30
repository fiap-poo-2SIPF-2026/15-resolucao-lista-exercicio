package exercicio01;

public class Main {
    public static void main(String[] args) {
        Navegador navegador = new Navegador();
        boolean resultado;

        navegador.visitar("A");
        System.out.println("visitar A" + " | " + navegador.getEstado());

        navegador.visitar("B");
        System.out.println("visitar B" + " | " + navegador.getEstado());

        navegador.visitar("C");
        System.out.println("visitar C" + " | " + navegador.getEstado());

        resultado = navegador.voltar();
        System.out.println("voltar: " + resultado + " | " + navegador.getEstado());

        resultado = navegador.voltar();
        System.out.println("voltar: " + resultado + " | " + navegador.getEstado());

        resultado = navegador.avancar();
        System.out.println("avancar: " + resultado + " | " + navegador.getEstado());

        navegador.visitar("D");
        System.out.println("visitar D" + " | " + navegador.getEstado());

        resultado = navegador.voltar();
        System.out.println("voltar: " + resultado + " | " + navegador.getEstado());

        resultado = navegador.avancar();
        System.out.println("avancar: " + resultado + " | " + navegador.getEstado());

        resultado = navegador.avancar();
        System.out.println("avancar: " + resultado + " | " + navegador.getEstado());

        System.out.println("\nHistórico de volta, do topo para a base:");
        navegador.getHistoricoVoltar().forEach(System.out::println);
    }
}
