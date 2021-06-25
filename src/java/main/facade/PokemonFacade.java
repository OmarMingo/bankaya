package facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import entity.Evidencia;
import repository.EvidenciaRepositoy;

@Component
public class PokemonFacade 
{
	private EvidenciaRepositoy repository;
	
}
