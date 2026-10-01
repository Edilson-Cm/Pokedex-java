package praticaPoke;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.Socket;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PokeApi {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        List<String>listaPokemon = new ArrayList<>();
        while (true){
            try {
                System.out.println("Que pokemon voce quer procurar?");
                var meuPokemon = scan.nextLine();
                var enderecoPokemon = "https://pokeapi.co/api/v2/pokemon/" + meuPokemon;
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(enderecoPokemon))
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                var json = response.body();
                Gson gson = new Gson().newBuilder().create();
                var traduz = gson.fromJson(json, PokeRecord.class);
                Pokemons meuPokemons = new Pokemons(traduz);
                System.out.println(meuPokemons);
                System.out.println("Gostaria de adicionar a sua equipe? 1:[SIM]  2:[NÃO]");
                var decisao = scan.nextLine();
                if (decisao.equals("1")) {
                    listaPokemon.add(meuPokemon);
                    System.out.println("Sua equipe:");
                    for (String s : listaPokemon) {
                        System.out.println("Sua lista: " + s);
                    }
                } else break;
            } catch (ErroPokeBolas e) {
                throw new ErroPokeBolas(e.getMessage());
            }

        }
    }
}
