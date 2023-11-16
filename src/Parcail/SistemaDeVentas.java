import java.sql.*;
import java.util.ArrayList;


class DBHelper {
    private static final String URL = "jdbc:mysql://localhost:33061/ventas";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Método para ejecutar una consulta sin devolver resultados
    public static void ejecutarConsulta(String consulta) {
        try {
            // Establecer la conexión con la base de datos
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Crear la declaración
            try (PreparedStatement statement = connection.prepareStatement(consulta)) {
                // Ejecutar la consulta
                statement.executeUpdate();
            }

            // Cerrar la conexión
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para ejecutar una consulta y devolver un conjunto de resultados
    public static ResultSet ejecutarConsultaConResultado(String consulta) {
        try {
            // Establecer la conexión con la base de datos
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Crear la declaración
            PreparedStatement statement = connection.prepareStatement(consulta);

            // Ejecutar la consulta y devolver el conjunto de resultados
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}

//Creación de las Clases Producto y Vendedor con Atributos Equivalentes de la Base de Datos
class Producto {
    private int producto_id;
    private String nombre;
    private Double precio_por_unidad;
    private int stock;

    public Producto() {
    }

    public Producto(int producto_id, String nombre, Double precio_por_unidad, int stock) {
        this.producto_id = producto_id;
        this.nombre = nombre;
        this.precio_por_unidad = precio_por_unidad;
        this.stock = stock;
    }

    public int getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(int producto_id) {
        this.producto_id = producto_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio_por_unidad() {
        return precio_por_unidad;
    }

    public void setPrecio_por_unidad(Double precio_por_unidad) {
        this.precio_por_unidad = precio_por_unidad;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    // Método para obtener un producto por su ID
    public static Producto obtenerProducto(int productoID) {

        String consulta = "SELECT * FROM productos WHERE producto_id = " + productoID;

        try {

            ResultSet resultado = DBHelper.ejecutarConsultaConResultado(consulta);


            if (resultado != null && resultado.next()) {
                int id = resultado.getInt("producto_id");
                String nombre = resultado.getString("nombre");
                Double precioPorUnidad = resultado.getDouble("precio_por_unidad");
                int stock = resultado.getInt("stock");

                return new Producto(id, nombre, precioPorUnidad, stock);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Null si no encuentro
        return null;
    }

    public static Producto obtenerProductoMasVendido() {

        String consulta = "SELECT producto_id, SUM(cantidad_vendida) as total_vendido " +
                "FROM ventas " +
                "GROUP BY producto_id " +
                "ORDER BY total_vendido DESC " +
                "LIMIT 1";

        try {

            ResultSet resultado = DBHelper.ejecutarConsultaConResultado(consulta);


            if (resultado != null && resultado.next()) {

                int productoIDMasVendido = resultado.getInt("producto_id");

                return obtenerProducto(productoIDMasVendido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }
}




class Vendedor {
    private int vendedor_id;
    private String nombre;
    private String apellido;
    private int dni;
    private Date fecha_nacimiento;
    private Date fecha_contratacion;

    public Vendedor() {
    }

    public Vendedor(int vendedor_id, String nombre, String apellido, int dni, Date fecha_nacimiento, Date fecha_contratacion) {
        this.vendedor_id = vendedor_id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fecha_nacimiento = fecha_nacimiento;
        this.fecha_contratacion = fecha_contratacion;
    }

    public int getVendedor_id() {
        return vendedor_id;
    }

    public void setVendedor_id(int vendedor_id) {
        this.vendedor_id = vendedor_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Date getFecha_contratacion() {
        return fecha_contratacion;
    }

    public void setFecha_contratacion(Date fecha_contratacion) {
        this.fecha_contratacion = fecha_contratacion;
    }

    public Vendedor(String consultaBusqueda) {
        try {

            ResultSet resultado = DBHelper.ejecutarConsultaConResultado(consultaBusqueda);


            if (resultado != null && resultado.next()) {

                this.vendedor_id = resultado.getInt("vendedor_id");
                this.nombre = resultado.getString("nombre");
                this.apellido = resultado.getString("apellido");
                this.dni = resultado.getInt("dni");
                this.fecha_nacimiento = resultado.getDate("fecha_nacimiento");
                this.fecha_contratacion = resultado.getDate("fecha_contratacion");
            } else {
                System.out.println("No se encontró ningún vendedor con el ID especificado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static ArrayList<Vendedor> listadoDeVendedores(String consulta) {
        ArrayList<Vendedor> listaVendedores = new ArrayList<>();

        try {
            ResultSet resultado = DBHelper.ejecutarConsultaConResultado(consulta);

            while (resultado != null && resultado.next()) {

                int id = resultado.getInt("vendedor_id");
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");
                int dni = resultado.getInt("dni");
                Date fechaNacimiento = resultado.getDate("fecha_nacimiento");
                Date fechaContratacion = resultado.getDate("fecha_contratacion");

                Vendedor vendedor = new Vendedor(id, nombre, apellido, dni, fechaNacimiento, fechaContratacion);
                listaVendedores.add(vendedor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Lista completa de vendedores
        return listaVendedores;
    }


}


class SistemaDeVentas {

    public static void generarInforme() {
        String consulta = "SELECT * FROM productos";

        System.out.println("Informe de Productos en Stock:");
        System.out.println("Producto                        Stock    Precio     Total");
        System.out.println("---------------------------------------------------------------------------");

        try {
            ResultSet resultado = DBHelper.ejecutarConsultaConResultado(consulta);

            double valorTotalProductos = 0.0;
            while (resultado != null && resultado.next()) {
                String nombreProducto = resultado.getString("nombre");
                int stock = resultado.getInt("stock");
                double precioPorUnidad = resultado.getDouble("precio_por_unidad");

                double valorTotalProducto = stock * precioPorUnidad;
                System.out.printf("%-32s %-10d %-10f %-10f%n", nombreProducto, stock, precioPorUnidad, valorTotalProducto);

                valorTotalProductos += valorTotalProducto;
            }
            System.out.println("---------------------------------------------------------------------------");

            System.out.printf("%-49s %-40.2f%n", "Total:", valorTotalProductos);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

    class main {
        public static void main(String[] args) {
            Vendedor vendedorBuscado = new Vendedor("SELECT * FROM `vendedores` WHERE `vendedor_id` = 3");
            //System.out.println("Vendedor encontrado: " + vendedorBuscado.getNombre());

            // Llamada al metodo
            SistemaDeVentas.generarInforme();


            // Ejemplo de uso para obtener un producto por ID
            int productoIDBuscado = 1;  // Coloca el ID del producto que deseas buscar

            // Llamo metodo
            Producto productoObtenido = Producto.obtenerProducto(productoIDBuscado);

            // Verificar si se encontró primero
/*            if (productoObtenido != null) {
                // Mostrar los detalles del producto
                System.out.println("Producto encontrado:");
                System.out.println("ID: " + productoObtenido.getProducto_id());
                System.out.println("Nombre: " + productoObtenido.getNombre());
                System.out.println("Precio por Unidad: " + productoObtenido.getPrecio_por_unidad());
                System.out.println("Stock: " + productoObtenido.getStock());
            } else {
                System.out.println("No se encontró ningún producto con el ID especificado.");
            }
*/

            //Obtener todos los registros de la tablavendedores
            String consulta = "SELECT * FROM vendedores";

            // Obtener el listado de vendedores u
            ArrayList <Vendedor> listadoVendedores = Vendedor.listadoDeVendedores(consulta);
/*
            // Mostrar el listado de vendedores
            for (Vendedor vendedor : listadoVendedores) {
                System.out.println("Vendedor ID: " + vendedor.getVendedor_id());
                System.out.println("Nombre: " + vendedor.getNombre());
                System.out.println("Apellido: " + vendedor.getApellido());
                System.out.println("DNI: " + vendedor.getDni());
                System.out.println("Fecha de Nacimiento: " + vendedor.getFecha_nacimiento());
                System.out.println("Fecha de Contratación: " + vendedor.getFecha_contratacion());
                System.out.println("-------------------------------------");
            }
*/

        }
    }


