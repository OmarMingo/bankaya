package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ApiModel(description = "tabla de bitacora de operaciones por transaccion")
@Table(	name = "bitacora_operacion_referencia",
		indexes = {@Index(name = "bitacora_operacion_referencia_id_idx", columnList = "id")})
public class Evidencia
{
	private static final long serialVersionUID = 1L;

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column()
	private Long id;

	@Column(name = "fecha_request")
	private Date fecha;
	
	@Column(name = "ip_request")
	private String ipRequest;

	@Column(name = "metodo")
	private String metodo;
	
}
