
public class MedidorDomiciliario extends Medidor {
	public MedidorDomiciliario(CoordenadaGPS coordenadas) {
		super(coordenadas);
	}

	public TipoMedidor getTipoMedidor() {
		return TipoMedidor.DOMICILIARIO;
	}
}
