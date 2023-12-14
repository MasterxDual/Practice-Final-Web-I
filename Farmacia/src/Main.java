import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author agust
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("BIENVENIDO A NUESTRO SISTEMA DE FARMACIA");
        System.out.println("----------------------------");
        menu();
    }
                
    private static void menu() {
        Scanner scanner = new Scanner(System.in);
        int option;
        List<Producto> ventas = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();
        
        do {
            
            System.out.println("Que quiere hacer\n1-Cargar venta\n2-Listar todas las ventas");
            System.out.println("3-Listar todos los productos\n4-Terminar venta");
            
            option = scanner.nextInt();
            switch(option) {
            case 1:
                System.out.println("Los productos disponibles son:");
                imprimirListaProductos();
                
                System.out.println("Seleccione su producto");
                Producto productoSeleccionado = getListaProductos().get(scanner.nextInt() - 1);
                
                Cliente clienteNuevo = new Cliente();
                System.out.println("Por favor\nIngrese su dni:");
                clienteNuevo.setDni(scanner.nextLong());
                System.out.println("Ingrese su apellido:");
                clienteNuevo.setApellido(new Scanner(System.in).nextLine());
                System.out.println("Ingrese su nombre:");
                clienteNuevo.setNombre(new Scanner(System.in).nextLine());
                imprimirVentaIngresada(productoSeleccionado, clienteNuevo);
                ventas.add(productoSeleccionado);
                clientes.add(clienteNuevo);
                break;
            case 2:
                System.out.println("Sus ventas hasta el momento son");
                imprimirListaVentas(ventas, clientes);
                break;
            case 3:
                imprimirListaProductos();
                break;
            case 4:
                System.out.println("Adios");
                break;
            default:
                System.out.println("Debe ingresar un numero entre el 1 y el 4");
                break;
            }
        } while(option != 4);
        
            
        
    }
    
    private static List<Producto> getListaProductos() {
        List<Producto> productos = new ArrayList<>();

        productos.add(new Producto("Ibuprofeno", 100));
        productos.add(new Producto("Paracetamol", 230));
        productos.add(new Producto("Aspirina", 300));
        productos.add(new Producto("Omeoprazol", 350));
        productos.add(new Producto("Rivotril", 342));
        
        return productos;
    }
    
    private static void imprimirListaProductos() {
        for(int z = 0; z < getListaProductos().size(); z++) {
            System.out.println(z+1 + "-" + getListaProductos().get(z).getNombre());
        }
    }
    
    private static void imprimirVentaIngresada(Producto producto, Cliente cliente) {
        System.out.println("Su venta es:");
        System.out.println(producto.getNombre());
        System.out.println("Importe:" + producto.getPrecio());
        System.out.println("Cliente");
        System.out.println("Nombre:" + cliente.getNombre());
        System.out.println("Apellido:" + cliente.getApellido());
    }
    
    private static void imprimirListaVentas(List<Producto> ventas, List<Cliente> clientes) {
        for(int y = 0; y < ventas.size(); y++) {
            System.out.println(y+1 + "-" + ventas.get(y).getNombre());
            System.out.println("Importe:" + ventas.get(y).getPrecio());
            System.out.println("Cliente:\n" + "Nombre:" + clientes.get(y).getNombre());
            System.out.println("Apellido:" + clientes.get(y).getApellido());
        }
    }
}
