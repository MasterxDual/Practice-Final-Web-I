
public class Fecha implements Comparable<Fecha> {

	private int diaDelAnio;
	private int anio;
	
	/**
	 * Constructor 
	 * @param diaDelAnio El dia del anio, 1 a 365
	 * @param anio El anio, entre 2000 y 2100
	 */
	public Fecha (int diaDelAnio, int anio){
		if(diaDelAnio >=1 && diaDelAnio <= 365) {
			this.diaDelAnio = diaDelAnio;
		} else {
			System.err.println("Debe ingresar un dia del anio entre 1 y 365");
		}
		if(anio <= 2100 && anio >= 2000) {
			this.anio = anio;
		} else {
			System.err.println("Debe ingresar un anio entre 2000 y 2100");
		}
	}

	/**
	 * 
	 * @return el dia del anio. enntre 1 y 365
	 */
	public int getDiaDelAnio() {
		return diaDelAnio;
	}

	/**
	 * 
	 * @return el anio de la fecha
	 * 
	 */
	public int getAnio() {
		return anio;
	}

	@Override
	public int compareTo(Fecha otra) {
		// Retorna un valor negativo, cero, o positivo si esta (this) Fecha es
		// menor, igual o mayor que la "otra" fecha especificada
		return anio*365 + diaDelAnio 
				- (otra.getAnio()*365 + otra.getDiaDelAnio());
	}
	
	@Override
	public boolean equals (Object otra){
		if (otra == null || !(otra instanceof Fecha))
			return false;
		if (this.anio == ((Fecha)otra).getAnio() 
				&& this.diaDelAnio == ((Fecha)otra).getDiaDelAnio())  
			return true;
		return false;
	}
	
}
