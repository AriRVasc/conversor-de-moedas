import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {

    public Converte convert(String baseCurrency) throws Exception {
        URI exchange = URI.create("https://v6.exchangerate-api.com/v6/fcf1d33f66da2ab8392515d8/latest/" + baseCurrency);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(exchange)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());


            return new Gson().fromJson(response.body(), Converte.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não foi possível obter as taxas de câmbio", e);
        }
    }
}

