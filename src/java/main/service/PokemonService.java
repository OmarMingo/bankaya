package service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import entity.Evidencia;
import facade.PokemonFacade;
import model.PokemonModel;

public class PokemonService
{
	@Value("${pokemon.url}")
	String pokemonURL;

	PokemonFacade facade;
	
	public PokemonModel busqueda(String pokemon)
	{
		PokemonModel datos = new PokemonModel();
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> respuesta;
		try {
			respuesta = restTemplate.exchange(pokemonURL + "pokemon/" + pokemon, HttpMethod.GET, null, String.class);
			Evidencia evidencia = new Evidencia();
			evidencia.setIpRequest(pokemonURL+"pokemon/"+pokemon);
			evidencia.setFecha(new Date());
			datos.setAbilities(this.abilities(respuesta.getBody()));
			evidencia.setMetodo("abilities");
			facade.save(evidencia);
			datos.setBase_experience(this.base_experience(respuesta.getBody()));
			evidencia.setMetodo("base_experience");
			facade.save(evidencia);
			datos.setHeld_items(this.held_items(respuesta.getBody()));
			evidencia.setMetodo("held_items");
			facade.save(evidencia);
			datos.setId(this.ids(respuesta.getBody()));
			evidencia.setMetodo("ids");
			facade.save(evidencia);
			datos.setName(this.names(respuesta.getBody()));
			evidencia.setMetodo("names");
			facade.save(evidencia);
			datos.setLocation_area_encounters(this.location_area_encounters(respuesta.getBody()));
			evidencia.setMetodo("location_area_encounters");
			facade.save(evidencia);
			datos.setError(null);
					
		}catch(Exception e) {
			datos.setError(e.getMessage());
		}
		return datos;
	}
	
	public String abilities(String respuesta) {
		String ability = respuesta.substring(posicionCadena("abilities:",respuesta), posicionCadena("base_experience",respuesta));
		return ability;
	}
	
	public String base_experiences(String respuesta) {
		String base_experience = respuesta.substring(posicionCadena("base_experience:",respuesta), posicionCadena("forms",respuesta));
		return base_experience;
	}
	
	public String held_items(String respuesta) {
		String held_item = respuesta.substring(posicionCadena("held_items:",respuesta), posicionCadena("location_area_encounters",respuesta));
		return held_item;
	}
	
	public String ids(String respuesta) {
		String id = respuesta.substring(posicionCadena("id:",respuesta), posicionCadena("is_default",respuesta));
		return id;
	}
	
	public String names(String respuesta) {
		String name = respuesta.substring(posicionCadena("name:",respuesta), posicionCadena("order",respuesta));
		return name;
	}
	
	public String location_area_encounters(String respuesta) {
		String location_area_encounter = respuesta.substring(posicionCadena("location_area_encounters:",respuesta), posicionCadena("moves",respuesta));
		return location_area_encounter;
	}
	
	public int posicionCadena(String valor, String respuesta) {
		int posicion = 0;
		while(respuesta.indexOf(valor) > -1) {
			respuesta = respuesta.substring(respuesta.indexOf(valor) + valor.length(), respuesta.length());
			posicion++;
		}
		return posicion;
	}

}
