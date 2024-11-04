import java.util.Map;
public record Converte (Map<String, Double> conversion_rates){

    public double converteMoedas(String moedaAtual, String moedaConversao, double valor) {
        if (!conversion_rates.containsKey(moedaAtual)) {
            throw new IllegalArgumentException("Moeda de origem não encontrada: " + moedaAtual);
        }
        if (!conversion_rates.containsKey(moedaConversao)) {
            throw new IllegalArgumentException("Moeda de destino não encontrada: " + (moedaConversao));
        }

        double taxaAtual = conversion_rates.get(moedaAtual);
        double taxaDesejada = conversion_rates.get(moedaConversao);


        return (valor / taxaAtual) * taxaDesejada;
    }
}
