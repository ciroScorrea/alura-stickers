import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // fazer uma conexao http e buscar os top 250 filmes
        var url = "https://alura-imdb-api.herokuapp.com/movies";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request,  BodyHandlers.ofString());
        String body = response.body();
        // extrair só os dados que interessam (título, poster, classificação)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        
        //melhor deixar fora do for para não alocar muito recurso.
        Stickers stickers = new Stickers(); 
        
        //exibir
        for (Map<String,String> filme : listaDeFilmes) {
            String urlImage = filme.get("image");
            String title = filme.get("title");
            String fileName = title + ".png";
            InputStream inputStream = new URL(urlImage).openStream();
            
            stickers.create(inputStream, fileName);
            System.out.println(title);            
            System.out.println(filme.get("image"));            
            System.out.println(filme.get("imDbRating"));
            System.out.println();            
        }

        //Desafios
        /*
         * 1. Acessar outro endpoint do imdb
         * 2. Melhorar a saída System.out (exibir estrelas; classificação com cor; título e imagem com valor mais destacado)
         * 3. isolar a chave (extrair de um arquivo, variável de ambiente - properties, )
         * 4. Mega Desafio: Usar outra biblioteca como parser JAXON, GSON
         * 5. Mega Desafio: ter outro método para pontuar o filme, classe scanner para perguntar.
         */

    }
}
