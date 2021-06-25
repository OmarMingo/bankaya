package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.ApiOperation;
import model.PokemonModel;
import service.PokemonService;

/**
 * Controller
 * @author banregio
 *
 */
@Controller
@RequestMapping("/pokemon")
public class PokemonController
{
	PokemonService pokemonService;
	/**
	 * Busca un pokemon
	 * 
	 * @param pokemon
	 * @return PokemonModel
	 */
	@PostMapping(value = "/pokemon")
	public PokemonModel busqueda(@RequestBody String pokemon)
	{
		return pokemonService.busqueda(pokemon);
	}
	
	/**
	 *Metodos 
	 */
}
