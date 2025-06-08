/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import modelo.conectar;
 

public class Reprogramar_cita extends javax.swing.JInternalFrame {
   private DefaultTableModel model;
     
    public Reprogramar_cita() {
        initComponents();
        cargarUsuarios("");
        cargarPermisoConstruccion("");
        cargarAvisoOperaciones("");
        agregarEventoClickTabla();
    }



   void cargarUsuarios(String valor) {
        // Definir los títulos de las columnas
        String[] titulos = {"Nombre", "Apellido", "Cédula", "Fecha de Cita", "Hora", "Placa", "Marca", "Modelo"};
        String[] registros = new String[8];
        model = new DefaultTableModel(null, titulos);

        // Crear conexión con la base de datos
        conectar cc = new conectar();
        Connection cn = cc.conexion();

        try {
            // Consulta SQL para filtrar dinámicamente por nombre, apellido o cédula
            String sql = "SELECT nombre, apellido, cedula, fecha_cita, hora_cita, numero_placa, marca_vehiculo, modelo_vehiculo " +
             "FROM TramitePlaca WHERE CONCAT(nombre, ' ', apellido, ' ', cedula) LIKE ?";
                        
            PreparedStatement pst = cn.prepareStatement(sql);
            String filtro = "%" + valor + "%";
            pst.setString(1, filtro);
         

            ResultSet rs = pst.executeQuery();

            // Llenar el modelo con los datos obtenidos
            while (rs.next()) {
                registros[0] = rs.getString("nombre");
                registros[1] = rs.getString("apellido");
                registros[2] = rs.getString("cedula");
                registros[3] = rs.getString("fecha_cita");
                registros[4] = rs.getString("hora_cita");
                registros[5] = rs.getString("numero_placa");
                registros[6] = rs.getString("marca_vehiculo");
                registros[7] = rs.getString("modelo_vehiculo");


                model.addRow(registros);
            }

            // Asignar el modelo al JTable
            jTableTramite_placa.setModel(model);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos: " + ex.getMessage());
        }
    }
   void cargarPermisoConstruccion(String valor) {
    // Definir los títulos de las columnas para el Permiso de Construcción
    String[] titulos = {"Nombre", "Apellido", "Cédula", "Fecha de Cita", "Hora", "Direccion", "Tipo", "Superficie"};
    String[] registros = new String[8];  // Asegúrate de que tiene el tamaño adecuado
    model = new DefaultTableModel(null, titulos);

    // Crear conexión con la base de datos
    conectar cc = new conectar();
    Connection cn = cc.conexion();

    try {
            // Consulta SQL para filtrar dinámicamente por nombre, apellido o cédula
            String sql = "SELECT nombre, apellido, cedula, fecha_cita, hora_cita, direccion_proyecto, tipo_proyecto, superficie_m2 " +
             "FROM PermisoConstruccion WHERE CONCAT(nombre, ' ', apellido, ' ', cedula) LIKE ?";
                        
            PreparedStatement pst = cn.prepareStatement(sql);
            String filtro = "%" + valor + "%";
            pst.setString(1, filtro);
         

            ResultSet rs = pst.executeQuery();

            // Llenar el modelo con los datos obtenidos
            while (rs.next()) {
                registros[0] = rs.getString("nombre");
                registros[1] = rs.getString("apellido");
                registros[2] = rs.getString("cedula");
                registros[3] = rs.getString("fecha_cita");
                registros[4] = rs.getString("hora_cita");
                registros[5] = rs.getString("direccion_proyecto");
                registros[6] = rs.getString("tipo_proyecto");
                registros[7] = rs.getString("superficie_m2");
                model.addRow(registros);
            }

        // Asignar el modelo al JTable
        jTablePermiso_construccion.setModel(model);

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al cargar los datos: " + ex.getMessage());
    }
}
   
   void cargarAvisoOperaciones(String valor) {
    // Definir los títulos de las columnas para el Aviso de Operaciones
    String[] titulos = {"Nombre", "Apellido", "Cédula", "Fecha de Cita", "Hora", "nombre del negocio", "Tipo de negocio", "Dirección"};
    String[] registros = new String[8];  // Asegúrate de que tiene el tamaño adecuado
    model = new DefaultTableModel(null, titulos);

    // Crear conexión con la base de datos
    conectar cc = new conectar();
    Connection cn = cc.conexion();

    try {
            // Consulta SQL para filtrar dinámicamente por nombre, apellido o cédula
            String sql = "SELECT nombre, apellido, cedula, fecha_cita, hora_cita, nombre_negocio, tipo_negocio, direccion_negocio " +
             "FROM AvisoOperaciones WHERE CONCAT(nombre, ' ', apellido, ' ', cedula) LIKE ?";
                        
            PreparedStatement pst = cn.prepareStatement(sql);
            String filtro = "%" + valor + "%";
            pst.setString(1, filtro);
         

            ResultSet rs = pst.executeQuery();
        // Llenar el modelo con los datos obtenidos
        while (rs.next()) {
            registros[0] = rs.getString("nombre");
            registros[1] = rs.getString("apellido");
            registros[2] = rs.getString("cedula");
            registros[3] = rs.getString("fecha_cita");
            registros[4] = rs.getString("hora_cita");
            registros[5] = rs.getString("nombre_negocio");
            registros[6] = rs.getString("tipo_negocio");
            registros[7] = rs.getString("direccion_negocio");

            model.addRow(registros);
        }

        // Asignar el modelo al JTable
        jTableAviso_operaciones.setModel(model);

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al cargar los datos: " + ex.getMessage());
    }
}
  private void agregarEventoClickTabla() {
    // Agregar un MouseListener para detectar clics en las filas de la tabla de placas
    jTableTramite_placa.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            int fila = jTableTramite_placa.rowAtPoint(evt.getPoint());
            if (fila != -1) {
                // Obtener valores seleccionados (fecha y hora)
                String fecha = jTableTramite_placa.getValueAt(fila, 3).toString(); // La columna 3 sería la de fecha
                String hora = jTableTramite_placa.getValueAt(fila, 4).toString(); // La columna 4 sería la de hora

                // Rellenar los campos correspondientes con los valores seleccionados
                jTextFieldHora.setText(hora);

                try {
                    // Convertir la cadena de fecha a un formato Date para JDateChooser
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date date = formatoFecha.parse(fecha);
                    jDateChooserFecha.setDate(date); // Establecer la fecha en el JDateChooser
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    });

    // Agregar un MouseListener para detectar clics en las filas de la tabla de permiso de construcción
    jTablePermiso_construccion.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            int fila = jTablePermiso_construccion.rowAtPoint(evt.getPoint());
            if (fila != -1) {
                // Obtener valores seleccionados (fecha y hora)
                String fecha = jTablePermiso_construccion.getValueAt(fila, 3).toString(); // La columna 3 sería la de fecha
                String hora = jTablePermiso_construccion.getValueAt(fila, 4).toString(); // La columna 4 sería la de hora

                // Rellenar los campos correspondientes con los valores seleccionados
                jTextFieldHora.setText(hora);

                try {
                    // Convertir la cadena de fecha a un formato Date para JDateChooser
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date date = formatoFecha.parse(fecha);
                    jDateChooserFecha.setDate(date); // Establecer la fecha en el JDateChooser
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    });

    // Agregar un MouseListener para detectar clics en las filas de la tabla de aviso de construcción
    jTableAviso_operaciones.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            int fila = jTableAviso_operaciones.rowAtPoint(evt.getPoint());
            if (fila != -1) {
                // Obtener valores seleccionados (fecha y hora)
                String fecha = jTableAviso_operaciones.getValueAt(fila, 3).toString(); // La columna 3 sería la de fecha
                String hora = jTableAviso_operaciones.getValueAt(fila, 4).toString(); // La columna 4 sería la de hora

                // Rellenar los campos correspondientes con los valores seleccionados
                jTextFieldHora.setText(hora);

                try {
                    // Convertir la cadena de fecha a un formato Date para JDateChooser
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date date = formatoFecha.parse(fecha);
                    jDateChooserFecha.setDate(date); // Establecer la fecha en el JDateChooser
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    });
}
  
  
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTramite_placa = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePermiso_construccion = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableAviso_operaciones = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonReprogramar = new javax.swing.JButton();
        jTextFieldHora = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldBuscar = new javax.swing.JTextField();
        jDateChooserFecha = new com.toedter.calendar.JDateChooser();

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setResizable(true);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jTableTramite_placa.setForeground(new java.awt.Color(51, 51, 255));
        jTableTramite_placa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableTramite_placa);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 878, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tramite de Placas", jPanel2);

        jTablePermiso_construccion.setForeground(new java.awt.Color(51, 51, 255));
        jTablePermiso_construccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTablePermiso_construccion);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 839, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        jTabbedPane1.addTab("Permiso de Construcción", jPanel3);

        jTableAviso_operaciones.setForeground(new java.awt.Color(0, 0, 255));
        jTableAviso_operaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTableAviso_operaciones);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 883, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Aviso de Operaciones", jPanel1);

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Reprogramar Citas");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(404, 404, 404)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Hora");

        jButtonReprogramar.setBackground(new java.awt.Color(153, 255, 153));
        jButtonReprogramar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonReprogramar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/descarga (1).png"))); // NOI18N
        jButtonReprogramar.setText("Reprogramar cita");
        jButtonReprogramar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReprogramarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Fecha");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BotonMenuBuscar (1).png"))); // NOI18N
        jLabel4.setText("Filtro:");

        jTextFieldBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarKeyReleased(evt);
            }
        });

        jDateChooserFecha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jDateChooserFechaFocusGained(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldHora, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jDateChooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonReprogramar)
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 919, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jDateChooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jTextFieldHora, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jButtonReprogramar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonReprogramarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReprogramarActionPerformed
        int fila = -1;
    JTable tablaSeleccionada = null;

    // Verificar cuál es la tabla activa en el JTabbedPane
    int tabIndex = jTabbedPane1.getSelectedIndex();

    switch (tabIndex) {
        case 0: // Tramite de Placas
            tablaSeleccionada = jTableTramite_placa;
            break;
        case 1: // Permiso de Construcción
            tablaSeleccionada = jTablePermiso_construccion;
            break;
        case 2: // Aviso de Operaciones
            tablaSeleccionada = jTableAviso_operaciones;
            break;
        default:
            JOptionPane.showMessageDialog(null, "No hay tabla seleccionada.");
            return;
    }

    // Obtener la fila seleccionada de la tabla activa
    fila = tablaSeleccionada.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(null, "Por favor, seleccione una cita para reprogramar.");
        return;
    }

    // Obtener los datos de los campos
    java.util.Date fechaSeleccionada = jDateChooserFecha.getDate();
    String nuevaHora = jTextFieldHora.getText();

    if (fechaSeleccionada != null && !nuevaHora.isEmpty()) {
        // Convertir la fecha seleccionada al formato adecuado
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        String nuevaFecha = formatoFecha.format(fechaSeleccionada);

        // Obtener la cédula del trámite desde la tabla seleccionada
        String cedula = tablaSeleccionada.getValueAt(fila, 2).toString(); // Asumiendo que la cédula está en la columna 2

        // Conectar a la base de datos y realizar la actualización
        conectar cc = new conectar();
        Connection cn = cc.conexion();

        try {
            String sql = "";
            // Ajustar la consulta SQL dependiendo de la tabla seleccionada
            switch (tabIndex) {
                case 0:
                    sql = "UPDATE TramitePlaca SET fecha_cita = ?, hora_cita = ? WHERE cedula = ?";
                    break;
                case 1:
                    sql = "UPDATE PermisoConstruccion SET fecha_cita = ?, hora_cita = ? WHERE cedula = ?";
                    break;
                case 2:
                    sql = "UPDATE AvisoOperaciones SET fecha_cita = ?, hora_cita = ? WHERE cedula = ?";
                    break;
            }
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, nuevaFecha);
            pst.setString(2, nuevaHora);
            pst.setString(3, cedula);

            int filasAfectadas = pst.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Cita reprogramada con éxito.");
                // Recargar la tabla correspondiente para reflejar los cambios
                switch (tabIndex) {
                    case 0:
                        cargarUsuarios("");
                        break;
                    case 1:
                        cargarPermisoConstruccion("");
                        break;
                    case 2:
                        cargarAvisoOperaciones("");
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo reprogramar la cita.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al reprogramar la cita: " + e.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(null, "Por favor ingrese una nueva fecha y hora.");
    }


    }//GEN-LAST:event_jButtonReprogramarActionPerformed

    private void jTextFieldBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarKeyReleased
          cargarPermisoConstruccion(jTextFieldBuscar.getText());
          cargarUsuarios(jTextFieldBuscar.getText());
          cargarAvisoOperaciones(jTextFieldBuscar.getText());
    }//GEN-LAST:event_jTextFieldBuscarKeyReleased

    private void jDateChooserFechaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jDateChooserFechaFocusGained
        jTextFieldHora.requestFocus();
    }//GEN-LAST:event_jDateChooserFechaFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonReprogramar;
    private com.toedter.calendar.JDateChooser jDateChooserFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableAviso_operaciones;
    private javax.swing.JTable jTablePermiso_construccion;
    private javax.swing.JTable jTableTramite_placa;
    private javax.swing.JTextField jTextFieldBuscar;
    private javax.swing.JTextField jTextFieldHora;
    // End of variables declaration//GEN-END:variables
}

