import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestSupermercado.
 *
 * @author  Emiliano Daniele
 * @version 1.0
 */
public class TestSupermercado
{
    private Supermercado super1;
    private Gondola gondola1;
    private Gondola gondola2;
    private Gondola gondola3;
    private Producto arroz1;
    private Producto arroz2;
    private Producto fideos1;
    private Producto jabon1;
    private Producto jabon2;  
    
    

    /**
     * Default constructor for test class TestSupermercado
     */
    public TestSupermercado()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        super1 = new Supermercado("Supermercado Vea");
        gondola1 = new Gondola();
        gondola2 = new Gondola();
        gondola3 = new Gondola();
        arroz1 = new Producto(TipoProducto.Arroz, "Vea", 15.5);
        arroz2 = new Producto(TipoProducto.Arroz, "Gallo", 5.75);
        fideos1 = new Producto(TipoProducto.Fideos, "Luchetti", 9.40);
        jabon1 = new Producto(TipoProducto.Jabon, "Rexona", 12.90);
        jabon2 = new Producto(TipoProducto.Jabon, "Lux", 15.5);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
