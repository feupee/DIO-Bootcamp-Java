import java.util.List;

public class GerenciadorVoos {
    // Método estático para encontrar o melhor voo com base nos critérios especificados
    public static Voo encontrarMelhorVoo(List<Voo> voos, String origem, String destino, String data) {
        Voo melhorVoo = null;
        int menorTempoEstimado = Integer.MAX_VALUE; // Inicializa com o maior valor possível
        int maiorQuantidadeVagas = Integer.MIN_VALUE; // Inicializa com o menor valor possível

        for (Voo voo : voos) {
            if (voo.getOrigem().getCidade().equals(origem) &&
                    voo.getDestino().getCidade().equals(destino) &&
                    voo.getData().equals(data)) {

                // Verifica se o voo tem um tempo estimado menor que o atual
                int tempoEstimado = voo.calcularTempoEstimado();
                if (tempoEstimado < menorTempoEstimado) {
                    menorTempoEstimado = tempoEstimado;
                    melhorVoo = voo;
                }

                // Verifica se o voo tem uma quantidade de vagas maior que o atual
                int quantidadeVagas = Integer.parseInt(voo.getQuantidadeDeVagas());
                if (quantidadeVagas > maiorQuantidadeVagas) {
                    maiorQuantidadeVagas = quantidadeVagas;
                    melhorVoo = voo;
                }
            }
        }

        return melhorVoo;
    }
}
