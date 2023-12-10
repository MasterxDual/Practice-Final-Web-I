1. Implementar las clases MedidorComercial y MedidorDomiciliario, tal que extiendan de la clase Medidor,
   y que implementen los metodos abstractos y constructores requeridos.

2. Cliente: Completar la implementacion del constructor y los metodos incompletos de la clase Cliente
	public Cliente (String nombre)
	public void agregarLectura (Fecha f) throws LecturaInconsistenteException
	public boolean asociarMedidor(Medidor m)
	public void removerMedidor()
	public String toString()

3. Fecha: Completar el constructor de la clase Fecha de acuerdo a la documentacion
	public Fecha (int diaDelAnio, int anio)

4. Empresa: Completar la implementacion del los metodos incompletos de la clase Empresa
	public Cliente getCliente(String nombre)
	public Medidor nuevoMedidor(TipoMedidor tipo, CoordenadaGPS pos)
	public Cliente nuevoCliente (String nombre)
	public void asociarMedidor(Cliente c, Medidor m)
	public void disociarMedidor (Cliente c)
	public int consumoPeriodo (Cliente c, Fecha desde, Fecha hasta)
