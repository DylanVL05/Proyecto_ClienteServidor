/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto_cliente;

import BD.cl_ClienteDAO;
import BD.cl_EmpleadoDAO;
import BD.cl_ProductosDAO;
import BD.cl_ProveedoresDAO;
import BD.cl_VentasDAO;
import chat.Chat_Cliente;
import chat.Chat_Servidor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import proyecto_cliente.ModuloProvedor.clProvedor;
import proyecto_cliente.Modulo_Empleado_Cliente.clCliente;
import proyecto_cliente.Modulo_Empleado_Cliente.clEmpleado;

/**
 *
 * @author andro
 */
import proyecto_cliente.Modulo_Productos_Ventas.clProductos;

import proyecto_cliente.Modulo_Productos_Ventas.clVenta;

public class _menu_ extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public _menu_() {

        initComponents();       //Carga datos en tabla 
        cargarDatosEnTablaProductos();
        cargarDatosEnTablaEmpleados();
        cargarDatosEnTablaVentas();
        cargarDatosEnTablaClientes();
        cargarDatosEnTablaProveedores();
        //Productos y ventas 

        // Vincula los botones con las pestañas correspondientes
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Productos.setSelectedComponent(tab1_Cliente);
            }
        });

        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Productos.setSelectedComponent(tab2_Empleado);
            }
        });

        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Productos.setSelectedComponent(tab3_Producto);
            }
        });

        boton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Productos.setSelectedComponent(tab4_Ventas);
            }
        });

        boton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Productos.setSelectedComponent(tab5_Provedores);
            }
        });

        //Funciones para rellenar por seleccion de tabla
        jTableProductos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
    
                if (!e.getValueIsAdjusting() && jTableProductos.getSelectedRow() != -1) {
                    int filaSeleccionada = jTableProductos.getSelectedRow();

   
                    String nombre = (String) jTableProductos.getValueAt(filaSeleccionada, 0);
                    double precio = (double) jTableProductos.getValueAt(filaSeleccionada, 1);
                    int cantidad = (int) jTableProductos.getValueAt(filaSeleccionada, 2);
                    String identificacion = (String) jTableProductos.getValueAt(filaSeleccionada, 3);

        
                    Nombre_Producto.setText(nombre);
                    Precio_Producto.setText(String.valueOf(precio));
                    Cantidad_Producto.setText(String.valueOf(cantidad));
                    ID_Producto.setText(identificacion);
                }
            }
        });

        tabla_empleados.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
           
                if (!e.getValueIsAdjusting() && tabla_empleados.getSelectedRow() != -1) {
                    int filaSeleccionada = tabla_empleados.getSelectedRow();

              
                    String nombre = (String) tabla_empleados.getValueAt(filaSeleccionada, 0);
                    int edad = (int) tabla_empleados.getValueAt(filaSeleccionada, 1);
                    String identificacion = (String) tabla_empleados.getValueAt(filaSeleccionada, 2);
                    String puesto = (String) tabla_empleados.getValueAt(filaSeleccionada, 3);
                    double salario = (double) tabla_empleados.getValueAt(filaSeleccionada, 4);

                
                    nombre_empleado.setText(nombre);
                    edad_empleado.setText(String.valueOf(edad));
                    identificacion_empleado.setText(identificacion);
                    puesto_empleado.setText(puesto);
                    salario_empleado.setText(String.valueOf(salario));
                }
            }
        });

        tabla_clientes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
              
                if (!e.getValueIsAdjusting() && tabla_clientes.getSelectedRow() != -1) {
                    int filaSeleccionada = tabla_clientes.getSelectedRow();

      
                    String nombre = (String) tabla_clientes.getValueAt(filaSeleccionada, 0);
                    int edad = (int) tabla_clientes.getValueAt(filaSeleccionada, 1);
                    String identificacion = (String) tabla_clientes.getValueAt(filaSeleccionada, 2);
                    String telCliente = (String) tabla_clientes.getValueAt(filaSeleccionada, 3);
                    String direccionCliente = (String) tabla_clientes.getValueAt(filaSeleccionada, 4);

    
                    nombre_clientes.setText(nombre);
                    edad_clientes.setText(String.valueOf(edad));
                    id_clientes.setText(identificacion);
                    tel_cliente.setText(telCliente);
                    direccion_cliente.setText(direccionCliente);
                }
            }
        });

        jtable_ventas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
            
                if (!e.getValueIsAdjusting() && jtable_ventas.getSelectedRow() != -1) {
                    int filaSeleccionada = jtable_ventas.getSelectedRow();

          
                    String identificacionProducto = (String) jtable_ventas.getValueAt(filaSeleccionada, 0);
                    int cantidad = (int) jtable_ventas.getValueAt(filaSeleccionada, 1);
                    double precioUnitario = (double) jtable_ventas.getValueAt(filaSeleccionada, 2);
                    String direccionVenta = (String) jtable_ventas.getValueAt(filaSeleccionada, 3);
                    String cliente = (String) jtable_ventas.getValueAt(filaSeleccionada, 4);

                   
                    id_producto_venta.setText(identificacionProducto);
                    cantidad_venta.setText(String.valueOf(cantidad));
                    precio_venta.setText(String.valueOf(precioUnitario));
                    direccio_cliente_ventas.setText(direccionVenta);
                    cliente_ventas.setText(cliente);
                }
            }
        });

        jtable_proveedores.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
         
                if (!e.getValueIsAdjusting() && jtable_proveedores.getSelectedRow() != -1) {
                    int filaSeleccionada = jtable_proveedores.getSelectedRow();

               
                    String idProveedor = (String) jtable_proveedores.getValueAt(filaSeleccionada, 0);
                    String nombreProveedor = (String) jtable_proveedores.getValueAt(filaSeleccionada, 1);
                    String emailProveedor = (String) jtable_proveedores.getValueAt(filaSeleccionada, 2);
                    String telefonoProveedor = (String) jtable_proveedores.getValueAt(filaSeleccionada, 3);

      
                    id_provedor.setText(idProveedor);
                    nombre_provedor.setText(nombreProveedor);
                    email_provedor.setText(emailProveedor);
                    tel_provedor.setText(telefonoProveedor);
                }
            }
        });

    }

    private void configurarModeloTablaVentas() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Venta");
        model.addColumn("ID Producto");
        model.addColumn("Cantidad");
        model.addColumn("Precio Unitario");
        model.addColumn("Fecha Venta");
        model.addColumn("Dirección Venta");
        model.addColumn("Cliente");

        jtable_ventas.setModel(model);

        /////////////////////////////////////////////////////////////////////////////////////////////////  
    }

    private void cargarDatosEnTablaProductos() {
        // Código para cargar los datos desde la base de datos y actualizar la tabla
        cl_ProductosDAO productoDAO = new cl_ProductosDAO();
        List<clProductos> listaProductos = productoDAO.getAllProductos();

        DefaultTableModel model = (DefaultTableModel) jTableProductos.getModel();
        model.setRowCount(0);

        for (clProductos producto : listaProductos) {
            Object[] row = {
                producto.getNombre(),
                producto.getPrecio(),
                producto.getCantidad(),
                producto.getIdentificacion()
            };
            model.addRow(row);
        }
    }

    private void actualizarTablaProductos() {

        cl_ProductosDAO productoDAO = new cl_ProductosDAO();
        List<clProductos> listaProductos = productoDAO.getAllProductos();

        DefaultTableModel model = (DefaultTableModel) jTableProductos.getModel();
        model.setRowCount(0);

        for (clProductos producto : listaProductos) {
            Object[] row = {
                producto.getNombre(),
                producto.getPrecio(),
                producto.getCantidad(),
                producto.getIdentificacion()
            };
            model.addRow(row);
        }
    }

    private void cargarDatosEnTablaEmpleados() {

        cl_EmpleadoDAO empleadoDAO = new cl_EmpleadoDAO();
        List<clEmpleado> listaEmpleados = empleadoDAO.getAllEmpleados();

        DefaultTableModel model = (DefaultTableModel) tabla_empleados.getModel();
        model.setRowCount(0);

        for (clEmpleado empleado : listaEmpleados) {
            Object[] row = {
                empleado.getNombre(),
                empleado.getEdad(),
                empleado.getIdentificacion(),
                empleado.getPuesto(),
                empleado.getSalario(),};
            model.addRow(row);
        }
    }

    private void actualizarTablaEmpleados() {

        cl_EmpleadoDAO empleadoDAO = new cl_EmpleadoDAO();
        List<clEmpleado> listaEmpleados = empleadoDAO.getAllEmpleados();

        DefaultTableModel model = (DefaultTableModel) tabla_empleados.getModel();
        model.setRowCount(0);

        for (clEmpleado empleado : listaEmpleados) {
            Object[] row = {
                empleado.getNombre(),
                empleado.getEdad(),
                empleado.getIdentificacion(),
                empleado.getPuesto(),
                empleado.getSalario(),};
            model.addRow(row);
        }
    }

    private void cargarDatosEnTablaVentas() {
        cl_VentasDAO ventasDAO = new cl_VentasDAO();
        List<clVenta> listaVentas = ventasDAO.getAllVentas();

        DefaultTableModel model = (DefaultTableModel) jtable_ventas.getModel();
        model.setRowCount(0);

        for (clVenta venta : listaVentas) {
            Object[] row = {
                venta.getIdVenta(),
                venta.getIdProducto(),
                venta.getCantidad(),
                venta.getPrecioUnitario(),
                venta.getFechaVenta(),
                venta.getDireccion_venta(),
                venta.getCliente()
            };
            model.addRow(row);
        }
    }

    private void actualizarTablaVentas() {
        cl_VentasDAO ventasDAO = new cl_VentasDAO();
        List<clVenta> listaVentas = ventasDAO.getAllVentas();

        DefaultTableModel model = (DefaultTableModel) jtable_ventas.getModel();
        model.setRowCount(0);

        for (clVenta venta : listaVentas) {
            Object[] row = {
                venta.getIdVenta(),
                venta.getIdProducto(),
                venta.getCantidad(),
                venta.getPrecioUnitario(),
                venta.getFechaVenta(),
                venta.getDireccion_venta(),
                venta.getCliente()
            };
            model.addRow(row);
        }
    }

    private void cargarDatosEnTablaClientes() {

        cl_ClienteDAO clienteDAO = new cl_ClienteDAO();
        List<clCliente> listaClientes = clienteDAO.getAllClientes();

        DefaultTableModel model = (DefaultTableModel) tabla_clientes.getModel();
        model.setRowCount(0);

        for (clCliente cliente : listaClientes) {
            Object[] row = {
                cliente.getNombre(),
                cliente.getEdad(),
                cliente.getIdentificacion(),
                cliente.getTel_Cliente(),
                cliente.getDireccion_Cl()

            };
            model.addRow(row);
        }
    }

    private void cargarDatosEnTablaProveedores() {
        // Crear una instancia del DAO de proveedores
        cl_ProveedoresDAO proveedoresDAO = new cl_ProveedoresDAO();

        // Obtener la lista de proveedores desde la base de datos
        List<clProvedor> listaProveedores = proveedoresDAO.getAllProveedores();

        // Obtener el modelo de la tabla
        DefaultTableModel model = (DefaultTableModel) jtable_proveedores.getModel();

        // Limpiar la tabla antes de cargar nuevos datos
        model.setRowCount(0);

        // Iterar sobre la lista de proveedores y agregar filas a la tabla
        for (clProvedor proveedor : listaProveedores) {
            Object[] row = {
                proveedor.getId_Provedor(),
                proveedor.getNombreProve(),
                proveedor.getEmailProve(),
                proveedor.getTelefono()
            };
            model.addRow(row);
        }
    }

    private void actualizarTablaClientes() {

        cl_ClienteDAO clienteDAO = new cl_ClienteDAO();
        List<clCliente> listaClientes = clienteDAO.getAllClientes();

        DefaultTableModel model = (DefaultTableModel) tabla_clientes.getModel();
        model.setRowCount(0);

        for (clCliente cliente : listaClientes) {
            Object[] row = {
                cliente.getNombre(),
                cliente.getEdad(),
                cliente.getIdentificacion(),
                cliente.getTel_Cliente(),
                cliente.getDireccion_Cl()

            };
            model.addRow(row);
        }
    }

    private void actualizarTablaProveedores() {
        // Lógica para actualizar la tabla de proveedores, por ejemplo, volver a cargar los datos
        cl_ProveedoresDAO proveedoresDAO = new cl_ProveedoresDAO();
        List<clProvedor> listaProveedores = proveedoresDAO.getAllProveedores();

        DefaultTableModel model = (DefaultTableModel) jtable_proveedores.getModel();
        model.setRowCount(0);

        for (clProvedor proveedor : listaProveedores) {
            Object[] row = {
                proveedor.getId_Provedor(),
                proveedor.getNombreProve(),
                proveedor.getEmailProve(),
                proveedor.getTelefono()
            };
            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel14 = new javax.swing.JLabel();
        id_producto_buscar = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        barra_horizontal = new javax.swing.JPanel();
        barra_vertical = new javax.swing.JPanel();
        boton1 = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        boton2 = new javax.swing.JButton();
        boton3 = new javax.swing.JButton();
        boton4 = new javax.swing.JButton();
        boton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        activar_chat = new javax.swing.JButton();
        activar_Server = new javax.swing.JButton();
        Productos = new javax.swing.JTabbedPane();
        tab1_Cliente = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Agregar_clientes = new javax.swing.JButton();
        Eliminar_cliente = new javax.swing.JButton();
        Actualizar_cliente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_clientes = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        nombre_clientes = new javax.swing.JTextField();
        edad_clientes = new javax.swing.JTextField();
        id_clientes = new javax.swing.JTextField();
        tel_cliente = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        direccion_cliente = new javax.swing.JTextArea();
        tab2_Empleado = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_empleados = new javax.swing.JTable();
        Actualizar_Empleado = new javax.swing.JButton();
        Agregar_Empleado = new javax.swing.JButton();
        Eliminar_Empleado = new javax.swing.JButton();
        salario_empleado = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        nombre_empleado = new javax.swing.JTextField();
        edad_empleado = new javax.swing.JTextField();
        identificacion_empleado = new javax.swing.JTextField();
        puesto_empleado = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        tab3_Producto = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable();
        Agregar_Producto = new javax.swing.JButton();
        Actualizar_Producto = new javax.swing.JButton();
        Eliminar_Producto = new javax.swing.JButton();
        Listar_Producto = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        Nombre_Producto = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Precio_Producto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        Cantidad_Producto = new javax.swing.JTextField();
        ID_Producto = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tab4_Ventas = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtable_ventas = new javax.swing.JTable();
        Eliminar_Venta = new javax.swing.JButton();
        insertar_venta = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        id_producto_venta = new javax.swing.JTextField();
        cantidad_venta = new javax.swing.JTextField();
        precio_venta = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        direccio_cliente_ventas = new javax.swing.JTextArea();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        cliente_ventas = new javax.swing.JTextField();
        tab5_Provedores = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtable_proveedores = new javax.swing.JTable();
        actualizar_provedor = new javax.swing.JButton();
        agregar_provedor = new javax.swing.JButton();
        Eliminar_provedor = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        id_provedor = new javax.swing.JTextField();
        nombre_provedor = new javax.swing.JTextField();
        email_provedor = new javax.swing.JTextField();
        tel_provedor = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Busqueda por ID");

        id_producto_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_producto_buscarActionPerformed(evt);
            }
        });

        jLabel15.setText("Enter");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barra_horizontal.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout barra_horizontalLayout = new javax.swing.GroupLayout(barra_horizontal);
        barra_horizontal.setLayout(barra_horizontalLayout);
        barra_horizontalLayout.setHorizontalGroup(
            barra_horizontalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
        );
        barra_horizontalLayout.setVerticalGroup(
            barra_horizontalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(barra_horizontal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 50));

        barra_vertical.setBackground(new java.awt.Color(204, 204, 255));

        boton1.setText("Modulo Cliente");

        salir.setBackground(new java.awt.Color(153, 153, 255));
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        boton2.setText("Modulo Empleado");
        boton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton2ActionPerformed(evt);
            }
        });

        boton3.setText("Modulo Producto");

        boton4.setText("Modulo Ventas");

        boton5.setText("Modulo Provedores");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_cliente/imagenes/icono.png"))); // NOI18N

        jLabel4.setText("Menu");

        activar_chat.setText("Chat");
        activar_chat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activar_chatActionPerformed(evt);
            }
        });

        activar_Server.setText("Server");
        activar_Server.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activar_ServerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout barra_verticalLayout = new javax.swing.GroupLayout(barra_vertical);
        barra_vertical.setLayout(barra_verticalLayout);
        barra_verticalLayout.setHorizontalGroup(
            barra_verticalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barra_verticalLayout.createSequentialGroup()
                .addGroup(barra_verticalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(barra_verticalLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(barra_verticalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(barra_verticalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(barra_verticalLayout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(activar_chat)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(activar_Server))
                                .addGroup(barra_verticalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(boton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(boton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(boton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(boton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(boton5, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))))
                    .addGroup(barra_verticalLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(barra_verticalLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel4)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        barra_verticalLayout.setVerticalGroup(
            barra_verticalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barra_verticalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(boton1)
                .addGap(27, 27, 27)
                .addComponent(boton2)
                .addGap(29, 29, 29)
                .addComponent(boton3)
                .addGap(27, 27, 27)
                .addComponent(boton4)
                .addGap(35, 35, 35)
                .addComponent(boton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(barra_verticalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(activar_chat)
                    .addComponent(activar_Server))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(barra_vertical, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 210, 580));

        tab1_Cliente.setBackground(new java.awt.Color(204, 204, 204));
        tab1_Cliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_cliente/imagenes/Purple Badge Car Wash Logo.jpg"))); // NOI18N
        tab1_Cliente.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 454, 156));

        Agregar_clientes.setText("Agregar");
        Agregar_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Agregar_clientesActionPerformed(evt);
            }
        });
        tab1_Cliente.add(Agregar_clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 470, -1, -1));

        Eliminar_cliente.setText("Eliminar");
        Eliminar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Eliminar_clienteActionPerformed(evt);
            }
        });
        tab1_Cliente.add(Eliminar_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 500, -1, -1));

        Actualizar_cliente.setText("Actualizar");
        Actualizar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Actualizar_clienteActionPerformed(evt);
            }
        });
        tab1_Cliente.add(Actualizar_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 530, -1, -1));

        tabla_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "nombre", "edad", "id", "telefono", "direccion"
            }
        ));
        jScrollPane1.setViewportView(tabla_clientes);

        tab1_Cliente.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 219, 470, 334));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel18.setText("Clientes");
        tab1_Cliente.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, -1, -1));

        nombre_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_clientesActionPerformed(evt);
            }
        });
        tab1_Cliente.add(nombre_clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, 100, -1));
        tab1_Cliente.add(edad_clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 290, 100, -1));
        tab1_Cliente.add(id_clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 320, 100, -1));
        tab1_Cliente.add(tel_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 350, 100, -1));

        jLabel28.setText("nombre");
        tab1_Cliente.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, -1, -1));

        jLabel29.setText("edad");
        tab1_Cliente.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, -1, -1));

        jLabel30.setText("id");
        tab1_Cliente.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 320, -1, -1));

        jLabel31.setText("telefono");
        tab1_Cliente.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 350, -1, -1));

        jLabel32.setText("direccion");
        tab1_Cliente.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 380, -1, -1));

        direccion_cliente.setColumns(20);
        direccion_cliente.setRows(5);
        jScrollPane6.setViewportView(direccion_cliente);

        tab1_Cliente.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 380, -1, -1));

        Productos.addTab("tab1", tab1_Cliente);

        tab2_Empleado.setBackground(new java.awt.Color(204, 204, 204));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_cliente/imagenes/Purple Badge Car Wash Logo.jpg"))); // NOI18N

        tabla_empleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "nombre", "edad", "identificacion", "puesto", "salario"
            }
        ));
        jScrollPane2.setViewportView(tabla_empleados);

        Actualizar_Empleado.setText("Actualizar");
        Actualizar_Empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Actualizar_EmpleadoActionPerformed(evt);
            }
        });

        Agregar_Empleado.setText("Agregar");
        Agregar_Empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Agregar_EmpleadoActionPerformed(evt);
            }
        });

        Eliminar_Empleado.setText("Eliminar");
        Eliminar_Empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Eliminar_EmpleadoActionPerformed(evt);
            }
        });

        jLabel16.setText("Busqueda por ID");

        nombre_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_empleadoActionPerformed(evt);
            }
        });

        identificacion_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                identificacion_empleadoActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel17.setText("Empleados");

        jLabel3.setText("Nombre");

        jLabel21.setText("edad");

        jLabel22.setText("identificacion");

        jLabel23.setText("puesto");

        jLabel24.setText("salario");

        javax.swing.GroupLayout tab2_EmpleadoLayout = new javax.swing.GroupLayout(tab2_Empleado);
        tab2_Empleado.setLayout(tab2_EmpleadoLayout);
        tab2_EmpleadoLayout.setHorizontalGroup(
            tab2_EmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab2_EmpleadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab2_EmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tab2_EmpleadoLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(tab2_EmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Actualizar_Empleado)
                    .addGroup(tab2_EmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Eliminar_Empleado)
                        .addComponent(Agregar_Empleado))
                    .addGroup(tab2_EmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tab2_EmpleadoLayout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addComponent(jLabel17))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab2_EmpleadoLayout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addGroup(tab2_EmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab2_EmpleadoLayout.createSequentialGroup()
                                    .addComponent(jLabel21)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(edad_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab2_EmpleadoLayout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nombre_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab2_EmpleadoLayout.createSequentialGroup()
                                    .addComponent(jLabel22)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(identificacion_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(tab2_EmpleadoLayout.createSequentialGroup()
                                    .addGroup(tab2_EmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel24)
                                        .addComponent(jLabel23))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(tab2_EmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(puesto_empleado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(salario_empleado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        tab2_EmpleadoLayout.setVerticalGroup(
            tab2_EmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab2_EmpleadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab2_EmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab2_EmpleadoLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel16))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(tab2_EmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab2_EmpleadoLayout.createSequentialGroup()
                        .addGroup(tab2_EmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombre_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(tab2_EmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edad_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tab2_EmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(identificacion_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tab2_EmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(puesto_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tab2_EmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(salario_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addGap(39, 39, 39)
                        .addComponent(Eliminar_Empleado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Agregar_Empleado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Actualizar_Empleado)))
                .addContainerGap())
        );

        Productos.addTab("tab2", tab2_Empleado);

        tab3_Producto.setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_cliente/imagenes/Purple Badge Car Wash Logo.jpg"))); // NOI18N

        jTableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "precio", "cantidad", "id"
            }
        ));
        jScrollPane3.setViewportView(jTableProductos);

        Agregar_Producto.setText("Agregar");
        Agregar_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Agregar_ProductoActionPerformed(evt);
            }
        });

        Actualizar_Producto.setText("Actualizar");
        Actualizar_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Actualizar_ProductoActionPerformed(evt);
            }
        });

        Eliminar_Producto.setText("Eliminar");
        Eliminar_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Eliminar_ProductoActionPerformed(evt);
            }
        });

        Listar_Producto.setText("Listar");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel9.setText("Productos");

        Nombre_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nombre_ProductoActionPerformed(evt);
            }
        });

        jLabel10.setText("Nombre");

        Precio_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Precio_ProductoActionPerformed(evt);
            }
        });

        jLabel11.setText("Precio");

        Cantidad_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cantidad_ProductoActionPerformed(evt);
            }
        });

        ID_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ID_ProductoActionPerformed(evt);
            }
        });

        jLabel12.setText("Cantidad");

        jLabel13.setText("ID");

        javax.swing.GroupLayout tab3_ProductoLayout = new javax.swing.GroupLayout(tab3_Producto);
        tab3_Producto.setLayout(tab3_ProductoLayout);
        tab3_ProductoLayout.setHorizontalGroup(
            tab3_ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab3_ProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab3_ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab3_ProductoLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tab3_ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tab3_ProductoLayout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(tab3_ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(tab3_ProductoLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(tab3_ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Eliminar_Producto)
                                            .addComponent(Agregar_Producto)
                                            .addComponent(Actualizar_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(170, Short.MAX_VALUE))
                                    .addGroup(tab3_ProductoLayout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(ID_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(tab3_ProductoLayout.createSequentialGroup()
                                .addGroup(tab3_ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(tab3_ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel10))
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(tab3_ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Cantidad_Producto)
                                    .addComponent(Nombre_Producto, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                    .addComponent(Precio_Producto, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                                .addContainerGap())))
                    .addGroup(tab3_ProductoLayout.createSequentialGroup()
                        .addComponent(Listar_Producto)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(tab3_ProductoLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(53, 53, 53))))
        );
        tab3_ProductoLayout.setVerticalGroup(
            tab3_ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab3_ProductoLayout.createSequentialGroup()
                .addGroup(tab3_ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab3_ProductoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tab3_ProductoLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tab3_ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(tab3_ProductoLayout.createSequentialGroup()
                        .addGroup(tab3_ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Nombre_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tab3_ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Precio_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tab3_ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cantidad_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tab3_ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ID_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addComponent(Eliminar_Producto)
                        .addGap(2, 2, 2)
                        .addComponent(Agregar_Producto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Actualizar_Producto)
                        .addGap(49, 49, 49))
                    .addGroup(tab3_ProductoLayout.createSequentialGroup()
                        .addComponent(Listar_Producto)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Productos.addTab("tab3", tab3_Producto);

        tab4_Ventas.setBackground(new java.awt.Color(204, 204, 204));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_cliente/imagenes/Purple Badge Car Wash Logo.jpg"))); // NOI18N

        jtable_ventas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id_venta", "id_prodcuto", "cantidad", "precio", "fecha", "direccion", "cliente"
            }
        ));
        jScrollPane4.setViewportView(jtable_ventas);

        Eliminar_Venta.setText("Eliminar");
        Eliminar_Venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Eliminar_VentaActionPerformed(evt);
            }
        });

        insertar_venta.setText("insertar venta");
        insertar_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertar_ventaActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel19.setText("Ventas");

        jLabel25.setText("id producto");

        jLabel26.setText("cantidad");

        jLabel27.setText("precio unitario");

        direccio_cliente_ventas.setColumns(20);
        direccio_cliente_ventas.setRows(5);
        jScrollPane7.setViewportView(direccio_cliente_ventas);

        jLabel33.setText("Direccion cliente");

        jLabel34.setText("cliente");

        javax.swing.GroupLayout tab4_VentasLayout = new javax.swing.GroupLayout(tab4_Ventas);
        tab4_Ventas.setLayout(tab4_VentasLayout);
        tab4_VentasLayout.setHorizontalGroup(
            tab4_VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab4_VentasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab4_VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab4_VentasLayout.createSequentialGroup()
                        .addComponent(jScrollPane4)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab4_VentasLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(tab4_VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab4_VentasLayout.createSequentialGroup()
                                .addComponent(precio_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab4_VentasLayout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(23, 23, 23))))
                    .addGroup(tab4_VentasLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(tab4_VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tab4_VentasLayout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                .addGap(12, 12, 12))
                            .addGroup(tab4_VentasLayout.createSequentialGroup()
                                .addGroup(tab4_VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(tab4_VentasLayout.createSequentialGroup()
                                        .addComponent(jLabel25)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(id_producto_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab4_VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab4_VentasLayout.createSequentialGroup()
                                            .addComponent(jLabel34)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cliente_ventas, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab4_VentasLayout.createSequentialGroup()
                                            .addComponent(jLabel26)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(cantidad_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(tab4_VentasLayout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Eliminar_Venta)
                        .addGap(53, 53, 53)
                        .addComponent(insertar_venta)
                        .addGap(46, 46, 46))))
        );
        tab4_VentasLayout.setVerticalGroup(
            tab4_VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab4_VentasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab4_VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tab4_VentasLayout.createSequentialGroup()
                        .addGroup(tab4_VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tab4_VentasLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(tab4_VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel25)
                                    .addComponent(id_producto_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(tab4_VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel26)
                                    .addComponent(cantidad_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(tab4_VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel34)
                                    .addComponent(cliente_ventas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(tab4_VentasLayout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(precio_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tab4_VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tab4_VentasLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel33))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(tab4_VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab4_VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(insertar_venta)
                        .addComponent(Eliminar_Venta))
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        Productos.addTab("tab4", tab4_Ventas);

        tab5_Provedores.setBackground(new java.awt.Color(204, 204, 204));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_cliente/imagenes/Purple Badge Car Wash Logo.jpg"))); // NOI18N

        jtable_proveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "proveedor", "email", "tel"
            }
        ));
        jScrollPane5.setViewportView(jtable_proveedores);

        actualizar_provedor.setText("Actualizar");
        actualizar_provedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizar_provedorActionPerformed(evt);
            }
        });

        agregar_provedor.setText("Agregar");
        agregar_provedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_provedorActionPerformed(evt);
            }
        });

        Eliminar_provedor.setText("Eliminar");
        Eliminar_provedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Eliminar_provedorActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel20.setText("Proveedores");

        jLabel35.setText("id_Provedor");

        jLabel36.setText("nombre");

        jLabel37.setText("email");

        jLabel38.setText("tel");

        javax.swing.GroupLayout tab5_ProvedoresLayout = new javax.swing.GroupLayout(tab5_Provedores);
        tab5_Provedores.setLayout(tab5_ProvedoresLayout);
        tab5_ProvedoresLayout.setHorizontalGroup(
            tab5_ProvedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab5_ProvedoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab5_ProvedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab5_ProvedoresLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel20))
                    .addGroup(tab5_ProvedoresLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(tab5_ProvedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addComponent(jLabel36)
                            .addGroup(tab5_ProvedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(14, 14, 14)
                        .addGroup(tab5_ProvedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Eliminar_provedor)
                            .addComponent(agregar_provedor)
                            .addComponent(actualizar_provedor)
                            .addComponent(id_provedor)
                            .addComponent(nombre_provedor)
                            .addComponent(email_provedor)
                            .addComponent(tel_provedor, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        tab5_ProvedoresLayout.setVerticalGroup(
            tab5_ProvedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab5_ProvedoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab5_ProvedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGroup(tab5_ProvedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab5_ProvedoresLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab5_ProvedoresLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                        .addGroup(tab5_ProvedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id_provedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tab5_ProvedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombre_provedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tab5_ProvedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(email_provedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tab5_ProvedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tel_provedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38))
                        .addGap(74, 74, 74)
                        .addComponent(Eliminar_provedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(agregar_provedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(actualizar_provedor)
                        .addGap(14, 14, 14))))
        );

        Productos.addTab("tab5", tab5_Provedores);

        jPanel1.add(Productos, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 760, 590));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        this.dispose();
    }//GEN-LAST:event_salirActionPerformed

    private void Nombre_ProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nombre_ProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Nombre_ProductoActionPerformed

    private void Precio_ProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Precio_ProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Precio_ProductoActionPerformed

    private void ID_ProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ID_ProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ID_ProductoActionPerformed

    private void Agregar_ProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Agregar_ProductoActionPerformed

        String nombre = Nombre_Producto.getText();
        double precio = Double.parseDouble(Precio_Producto.getText());
        int cantidad = Integer.parseInt(Cantidad_Producto.getText());
        String identificacion = ID_Producto.getText();

        clProductos nuevoProducto = new clProductos(nombre, precio, cantidad, identificacion);

        cl_ProductosDAO productoDAO = new cl_ProductosDAO();
        productoDAO.insertProducto(nuevoProducto);

        actualizarTablaProductos();
    }//GEN-LAST:event_Agregar_ProductoActionPerformed

    private void Eliminar_ProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Eliminar_ProductoActionPerformed
        int filaSeleccionada = jTableProductos.getSelectedRow();

        if (filaSeleccionada != -1) {

            Object idObj = jTableProductos.getValueAt(filaSeleccionada, 3);

            if (idObj instanceof String) {
                String idProducto = (String) idObj;

                cl_ProductosDAO productoDAO = new cl_ProductosDAO();

                productoDAO.deleteProducto(idProducto);

                actualizarTablaProductos();
            } else {
                JOptionPane.showMessageDialog(this, "El ID del producto no es una cadena válida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un producto para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_Eliminar_ProductoActionPerformed

    private void id_producto_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_producto_buscarActionPerformed
        int filaSeleccionada = tabla_clientes.getSelectedRow();

        if (filaSeleccionada != -1) {

            Object identificacionObj = tabla_clientes.getValueAt(filaSeleccionada, 3);

            if (identificacionObj instanceof String) {
                String identificacionCliente = (String) identificacionObj;

                cl_ClienteDAO clienteDAO = new cl_ClienteDAO();

                clienteDAO.deleteCLiente(identificacionCliente);

                actualizarTablaClientes();
            } else {
                JOptionPane.showMessageDialog(this, "La identificación del cliente no es una cadena válida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_id_producto_buscarActionPerformed

    private void Actualizar_ProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Actualizar_ProductoActionPerformed
        int filaSeleccionada = jTableProductos.getSelectedRow();

        if (filaSeleccionada != -1) {

            Object idObj = jTableProductos.getValueAt(filaSeleccionada, 2);

            if (idObj instanceof String) {
                String idProducto = (String) idObj;

                String nuevoNombre = Nombre_Producto.getText();
                double nuevoPrecio = Double.parseDouble(Precio_Producto.getText());
                int nuevaCantidad = Integer.parseInt(Cantidad_Producto.getText());

                cl_ProductosDAO productoDAO = new cl_ProductosDAO();

                clProductos productoActualizado = new clProductos(nuevoNombre, nuevoPrecio, nuevaCantidad, idProducto);

                productoDAO.updateProducto(productoActualizado);

                actualizarTablaProductos();

                Nombre_Producto.setText("");
                Precio_Producto.setText("");
                Cantidad_Producto.setText("");
                ID_Producto.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "El ID del producto no es una cadena válida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un producto para actualizar.", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_Actualizar_ProductoActionPerformed

    private void identificacion_empleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_identificacion_empleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_identificacion_empleadoActionPerformed

    private void activar_chatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activar_chatActionPerformed
        Chat_Cliente cliente = new Chat_Cliente();
        cliente.setVisible(true);
    }//GEN-LAST:event_activar_chatActionPerformed

    private void activar_ServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activar_ServerActionPerformed
        Chat_Servidor servidor = new Chat_Servidor();
        servidor.setVisible(true);
    }//GEN-LAST:event_activar_ServerActionPerformed

    private void boton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton2ActionPerformed

    private void nombre_empleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre_empleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre_empleadoActionPerformed

    private void Agregar_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Agregar_clientesActionPerformed

        String nombre = nombre_clientes.getText();
        int edad = Integer.parseInt(edad_clientes.getText());
        String identificacion = id_clientes.getText();
        String telCliente = tel_cliente.getText();
        String direccionCliente = direccion_cliente.getText();

        clCliente nuevoCliente = new clCliente(nombre, edad, identificacion);

        nuevoCliente.setTel_Cliente(telCliente);
        nuevoCliente.setDireccion_Cl(direccionCliente);

        cl_ClienteDAO clienteDAO = new cl_ClienteDAO();

        clienteDAO.insertCliente(nuevoCliente);

        actualizarTablaClientes();

    }//GEN-LAST:event_Agregar_clientesActionPerformed

    private void Cantidad_ProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cantidad_ProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cantidad_ProductoActionPerformed

    private void Agregar_EmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Agregar_EmpleadoActionPerformed

        String nombre = nombre_empleado.getText();
        int edad = Integer.parseInt(edad_empleado.getText());
        String identificacion = identificacion_empleado.getText();
        String puesto = puesto_empleado.getText();
        double salario = Double.parseDouble(salario_empleado.getText());

        clEmpleado nuevoEmpleado = new clEmpleado(nombre, edad, identificacion, puesto, salario);

        cl_EmpleadoDAO empleadoDAO = new cl_EmpleadoDAO();

        empleadoDAO.insertEmpleado(nuevoEmpleado);

        actualizarTablaEmpleados();


    }//GEN-LAST:event_Agregar_EmpleadoActionPerformed

    private void Eliminar_EmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Eliminar_EmpleadoActionPerformed
        int filaSeleccionada = tabla_empleados.getSelectedRow();

        if (filaSeleccionada != -1) {

            Object idObj = tabla_empleados.getValueAt(filaSeleccionada, 2);

            if (idObj instanceof String) {
                String idEmpleado = (String) idObj;

                cl_EmpleadoDAO empleadoDAO = new cl_EmpleadoDAO();

                empleadoDAO.deleteEmpleado(idEmpleado);

                actualizarTablaEmpleados();
            } else {
                JOptionPane.showMessageDialog(this, "El ID del empleado no es una cadena válida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un empleado para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Eliminar_EmpleadoActionPerformed

    private void Actualizar_EmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Actualizar_EmpleadoActionPerformed

        int filaSeleccionada = tabla_empleados.getSelectedRow();

        if (filaSeleccionada != -1) {

            Object idObj = tabla_empleados.getValueAt(filaSeleccionada, 2);

            if (idObj instanceof String) {
                String idEmpleado = (String) idObj;

                String nuevoNombre = nombre_empleado.getText();
                int nuevaEdad = Integer.parseInt(edad_empleado.getText());
                String nuevoPuesto = puesto_empleado.getText();
                double nuevoSalario;

                try {
                    nuevoSalario = Double.parseDouble(salario_empleado.getText());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Ingrese un valor numérico válido para el salario.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                cl_EmpleadoDAO empleadoDAO = new cl_EmpleadoDAO();

                clEmpleado empleadoActualizado = new clEmpleado(nuevoNombre, nuevaEdad, idEmpleado, nuevoPuesto, nuevoSalario);

                empleadoDAO.updateEmpleado(empleadoActualizado);

                actualizarTablaEmpleados();

                nombre_empleado.setText("");
                edad_empleado.setText("");
                salario_empleado.setText("");
                puesto_empleado.setText("");
                identificacion_empleado.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "El ID del empleado no es una cadena válida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un empleado para actualizar.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_Actualizar_EmpleadoActionPerformed

    private void insertar_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertar_ventaActionPerformed

        String identificacionProducto = id_producto_venta.getText();
        int cantidad = Integer.parseInt(cantidad_venta.getText());
        double precioUnitario = Double.parseDouble(precio_venta.getText());
        String direccion_venta = direccio_cliente_ventas.getText();
        String cliente = cliente_ventas.getText();

        Date fechaVenta = new Date();

        clVenta venta = new clVenta();
        venta.setIdProducto(identificacionProducto);
        venta.setCantidad(cantidad);
        venta.setPrecioUnitario(precioUnitario);
        venta.setFechaVenta(fechaVenta);
        venta.setDireccion_venta(direccion_venta);
        venta.setCliente(cliente);
        cl_VentasDAO ventaDAO = new cl_VentasDAO();

        ventaDAO.insertVenta(venta);
        actualizarTablaVentas();
        cl_ProductosDAO productosDAO = new cl_ProductosDAO();

        productosDAO.actualizarCantidadEnStock(identificacionProducto, cantidad);
        actualizarTablaProductos();

    }//GEN-LAST:event_insertar_ventaActionPerformed

    private void nombre_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre_clientesActionPerformed

    }//GEN-LAST:event_nombre_clientesActionPerformed

    private void Eliminar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Eliminar_clienteActionPerformed
        int filaSeleccionada = tabla_clientes.getSelectedRow();

        if (filaSeleccionada != -1) {

            Object idObj = tabla_clientes.getValueAt(filaSeleccionada, 2);

            if (idObj instanceof String) {
                String idCLiente = (String) idObj;

                cl_ClienteDAO empleadoDAO = new cl_ClienteDAO();

                empleadoDAO.deleteCLiente(idCLiente);

                actualizarTablaClientes();
            } else {
                JOptionPane.showMessageDialog(this, "El ID del empleado no es una cadena válida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un empleado para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Eliminar_clienteActionPerformed

    private void Actualizar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Actualizar_clienteActionPerformed
        int filaSeleccionada = tabla_clientes.getSelectedRow();

        if (filaSeleccionada != -1) {

            Object identificacionObj = tabla_clientes.getValueAt(filaSeleccionada, 2);

            if (identificacionObj instanceof String) {
                String identificacionCliente = (String) identificacionObj;

                String nuevoNombre = nombre_clientes.getText();
                int nuevaEdad;
                String nuevoTelCliente, nuevaDireccionCliente;

                try {
                    nuevaEdad = Integer.parseInt(edad_clientes.getText());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Ingrese un valor numérico válido para la edad.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                nuevoTelCliente = tel_cliente.getText();
                if (nuevoTelCliente.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Ingrese un teléfono válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                nuevaDireccionCliente = direccion_cliente.getText();
                if (nuevaDireccionCliente.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Ingrese una dirección válida.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                cl_ClienteDAO clienteDAO = new cl_ClienteDAO();

                clCliente clienteActualizado = new clCliente(nuevoTelCliente, nuevaDireccionCliente, nuevoNombre, nuevaEdad, identificacionCliente);

                clienteDAO.updateCliente(clienteActualizado);

                actualizarTablaClientes();

                nombre_clientes.setText("");
                edad_clientes.setText("");
                tel_cliente.setText("");
                direccion_cliente.setText("");
                id_clientes.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "La identificación del cliente no es una cadena válida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente para actualizar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Actualizar_clienteActionPerformed

    private void agregar_provedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_provedorActionPerformed
        String id_Provedor = id_provedor.getText();
        String nombreProve = nombre_provedor.getText();
        String emailProve = email_provedor.getText();
        String telefono = tel_provedor.getText();

        clProvedor proveedor = new clProvedor(id_Provedor, nombreProve, emailProve, telefono);

        cl_ProveedoresDAO proveedoresDAO = new cl_ProveedoresDAO();

        proveedoresDAO.insertProveedor(proveedor);

        actualizarTablaProveedores();
    }//GEN-LAST:event_agregar_provedorActionPerformed

    private void Eliminar_provedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Eliminar_provedorActionPerformed
        int selectedRow = jtable_proveedores.getSelectedRow();

        if (selectedRow != -1) {

            String id_Provedor = jtable_proveedores.getValueAt(selectedRow, 0).toString();

            cl_ProveedoresDAO proveedoresDAO = new cl_ProveedoresDAO();

            proveedoresDAO.deleteProveedor(id_Provedor);

            actualizarTablaProveedores();
        } else {

            JOptionPane.showMessageDialog(this, "Por favor, selecciona un proveedor para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_Eliminar_provedorActionPerformed

    private void actualizar_provedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizar_provedorActionPerformed

        int filaSeleccionada = jtable_proveedores.getSelectedRow();

        if (filaSeleccionada != -1) {

            Object idObj = jtable_proveedores.getValueAt(filaSeleccionada, 0);

            if (idObj instanceof String) {
                String id_Provedor = (String) idObj;

                String nuevoNombre = nombre_provedor.getText();
                String nuevoEmail = email_provedor.getText();
                String nuevoTelefono = tel_provedor.getText();

                cl_ProveedoresDAO proveedoresDAO = new cl_ProveedoresDAO();

                clProvedor proveedorActualizado = new clProvedor(id_Provedor, nuevoNombre, nuevoEmail, nuevoTelefono);

                proveedoresDAO.updateProveedor(proveedorActualizado);

                actualizarTablaProveedores();

                nombre_provedor.setText("");
                email_provedor.setText("");
                tel_provedor.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "El ID del proveedor no es una cadena válida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un proveedor para actualizar.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_actualizar_provedorActionPerformed

    private void Eliminar_VentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Eliminar_VentaActionPerformed
        // Obtener la fila seleccionada en la tabla de ventas
        int filaSeleccionada = jtable_ventas.getSelectedRow();

        if (filaSeleccionada != -1) {
            // Obtener el valor de la columna "idProducto" de la fila seleccionada
            Object idObj = jtable_ventas.getValueAt(filaSeleccionada, 0); // Cambiado a la posición correcta de la columna

            if (idObj instanceof Integer) {
                int idVenta = (int) idObj;

                // Crear una instancia del DAO de ventas
                cl_VentasDAO ventasDAO = new cl_VentasDAO();

                // Llamar al método deleteVenta del DAO para eliminar la venta
                ventasDAO.deleteVenta(idVenta);

                // Luego de eliminar, puedes actualizar tus tablas o hacer cualquier otra acción necesaria
                actualizarTablaVentas();
                actualizarTablaProductos(); // Asumiendo que también tienes un método para actualizar la tabla de productos
            } else {
                JOptionPane.showMessageDialog(this, "El ID de la venta no es un entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una venta para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_Eliminar_VentaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(_menu_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(_menu_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(_menu_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(_menu_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new _menu_().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar_Empleado;
    private javax.swing.JButton Actualizar_Producto;
    private javax.swing.JButton Actualizar_cliente;
    private javax.swing.JButton Agregar_Empleado;
    private javax.swing.JButton Agregar_Producto;
    private javax.swing.JButton Agregar_clientes;
    private javax.swing.JTextField Cantidad_Producto;
    private javax.swing.JButton Eliminar_Empleado;
    private javax.swing.JButton Eliminar_Producto;
    private javax.swing.JButton Eliminar_Venta;
    private javax.swing.JButton Eliminar_cliente;
    private javax.swing.JButton Eliminar_provedor;
    private javax.swing.JTextField ID_Producto;
    private javax.swing.JButton Listar_Producto;
    private javax.swing.JTextField Nombre_Producto;
    private javax.swing.JTextField Precio_Producto;
    private javax.swing.JTabbedPane Productos;
    private javax.swing.JButton activar_Server;
    private javax.swing.JButton activar_chat;
    private javax.swing.JButton actualizar_provedor;
    private javax.swing.JButton agregar_provedor;
    private javax.swing.JPanel barra_horizontal;
    private javax.swing.JPanel barra_vertical;
    private javax.swing.JButton boton1;
    private javax.swing.JButton boton2;
    private javax.swing.JButton boton3;
    private javax.swing.JButton boton4;
    private javax.swing.JButton boton5;
    private javax.swing.JTextField cantidad_venta;
    private javax.swing.JTextField cliente_ventas;
    private javax.swing.JTextArea direccio_cliente_ventas;
    private javax.swing.JTextArea direccion_cliente;
    private javax.swing.JTextField edad_clientes;
    private javax.swing.JTextField edad_empleado;
    private javax.swing.JTextField email_provedor;
    private javax.swing.JTextField id_clientes;
    private javax.swing.JTextField id_producto_buscar;
    private javax.swing.JTextField id_producto_venta;
    private javax.swing.JTextField id_provedor;
    private javax.swing.JTextField identificacion_empleado;
    private javax.swing.JButton insertar_venta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTableProductos;
    private javax.swing.JTable jtable_proveedores;
    public javax.swing.JTable jtable_ventas;
    private javax.swing.JTextField nombre_clientes;
    private javax.swing.JTextField nombre_empleado;
    private javax.swing.JTextField nombre_provedor;
    private javax.swing.JTextField precio_venta;
    private javax.swing.JTextField puesto_empleado;
    private javax.swing.JTextField salario_empleado;
    private javax.swing.JButton salir;
    private javax.swing.JPanel tab1_Cliente;
    private javax.swing.JPanel tab2_Empleado;
    private javax.swing.JPanel tab3_Producto;
    private javax.swing.JPanel tab4_Ventas;
    private javax.swing.JPanel tab5_Provedores;
    private javax.swing.JTable tabla_clientes;
    private javax.swing.JTable tabla_empleados;
    private javax.swing.JTextField tel_cliente;
    private javax.swing.JTextField tel_provedor;
    // End of variables declaration//GEN-END:variables
}
