package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PokemonModel
{
	private String abilities;
	private String base_experience;
	private String held_items;
	private String id;
	private String name;
	private String location_area_encounters;
	private String error;
}
