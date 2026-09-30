package exercicio06;

public class Visualizacao {
    private Video video;
    private int percentualAssistido;

    public Visualizacao(Video video, int percentualAssistido) {
        this.video = video;
        this.percentualAssistido = percentualAssistido;
    }

    public Video getVideo() {
        return video;
    }

    public int getPercentualAssistido() {
        return percentualAssistido;
    }
}
