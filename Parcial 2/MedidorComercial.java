
public class MedidorComercial extends Medidor {
	public MedidorComercial(CoordenadaGPS coordenadas) {
		super(coordenadas);
	}

	public TipoMedidor getTipoMedidor() {
		return TipoMedidor.COMERCIAL;
	}
}
