package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//declaração de objeto
		var consumoAPI = new ConsumoAPI();
		var conversor = new ConverteDados();

		//declaração de variaveis
		var apiKey = "3ed7865b";
		var title = "The Boys";
		var json = consumoAPI.obterDados("http://www.omdbapi.com/?t=" + title.replace(" ", "+") + "&apikey=" + apiKey);
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);

		//execute
		System.out.println(json);
		System.out.println(dados);

	}
}
