/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import modelo.conectar;
 

public class Cancelar extends javax.swing.JInternalFrame {
   private DefaultTableModel model;
     
    public Cancelar() {
        initComponents();
        cargarUsuarios("");
        cargarPermisoConstruccion("");
        cargarAvisoOperaciones("");
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
        jButtonCancelar_cita = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldBuscar = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

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
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 878, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tramite de Placas", jPanel2);

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
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        jTabbedPane1.addTab("Permiso de Construcción", jPanel3);

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
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Aviso de Operaciones", jPanel1);

        jPanel4.setBackground(new java.awt.Color(102, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Cancelar Citas");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(443, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(406, 406, 406))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jButtonCancelar_cita.setBackground(new java.awt.Color(255, 102, 102));
        jButtonCancelar_cita.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonCancelar_cita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar (1).png"))); // NOI18N
        jButtonCancelar_cita.setText("Cancelar Cita");
        jButtonCancelar_cita.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonCancelar_cita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelar_citaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BotonMenuBuscar (1).png"))); // NOI18N
        jLabel2.setText("BUSCAR");

        jTextFieldBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(jButtonCancelar_cita))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 928, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancelar_cita))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelar_citaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelar_citaActionPerformed
        int tabIndex = jTabbedPane1.getSelectedIndex(); // Obtener índice de la pestaña activa

    JTable currentTable = null; // Tabla activa
    String tableName = ""; // Nombre de la tabla en la base de datos
    String columnKey = "cedula"; // Columna clave para identificar el registro

    // Determinar la tabla activa según la pestaña seleccionada
    switch (tabIndex) {
        case 0: // Pestaña "Trámite de Placas"
            currentTable = jTableTramite_placa;
            tableName = "TramitePlaca";
            break;
        case 1: // Pestaña "Permiso de Construcción"
            currentTable = jTablePermiso_construccion;
            tableName = "PermisoConstruccion";
            break;
        case 2: // Pestaña "Aviso de Operaciones"
            currentTable = jTableAviso_operaciones;
            tableName = "AvisoOperaciones";
            break;
        default:
            JOptionPane.showMessageDialog(this, "No hay una pestaña válida seleccionada.");
            return;
    }

    // Verificar si hay una fila seleccionada
    int selectedRow = currentTable.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Por favor seleccione una fila para cancelar la cita.");
        return;
    }

    // Obtener el valor de la columna "cedula" de la fila seleccionada
    String cedula = currentTable.getValueAt(selectedRow, 2).toString(); // Suponiendo que la columna 'cedula' está en el índice 2

    // Confirmación
    int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea cancelar esta cita?", "Confirmar", JOptionPane.YES_NO_OPTION);
    if (confirm != JOptionPane.YES_OPTION) {
        return;
    }

    // Conexión a la base de datos para eliminar el registro
    conectar cc = new conectar();
    Connection cn = cc.conexion();

    try {
        String sql = "DELETE FROM " + tableName + " WHERE " + columnKey + " = ?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setString(1, cedula);
        int rowsAffected = pst.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Cita cancelada correctamente.");
            // Actualizar la tabla correspondiente
            if (tabIndex == 0) {
                cargarUsuarios("");
            } else if (tabIndex == 1) {
                cargarPermisoConstruccion("");
            } else if (tabIndex == 2) {
                cargarAvisoOperaciones("");
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró la cita para cancelar.");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error al cancelar la cita: " + ex.getMessage());
    }

    }//GEN-LAST:event_jButtonCancelar_citaActionPerformed

    private void jTextFieldBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarKeyReleased
          cargarPermisoConstruccion(jTextFieldBuscar.getText());
          cargarUsuarios(jTextFieldBuscar.getText());
          cargarAvisoOperaciones(jTextFieldBuscar.getText());
    }//GEN-LAST:event_jTextFieldBuscarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar_cita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
    // End of variables declaration//GEN-END:variables
}

