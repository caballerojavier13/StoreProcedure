/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControladorVisual;

/**
 *
 * @author Aleatrix
 */
import java.util.List;
import javax.swing.table.DefaultTableModel;
import Modelo.Persona;

/**
 * Convierte un ResultSet en un DefaultTableModel
 *  *
 */
public class GestorTabla
{
    /**
     * Rellena el DefaultTableModel con los datos del ResultSet.
     * Vacía el DefaultTableModel completamente y le mete los datos que hay
     * en el ResultSet.
     * @param rs El resultado de lac onsula a base de datos.
     * @param modelo El DefaultTableModel que queremos rellenar
     */
    public static void rellena(List rs, DefaultTableModel modelo)
    {
        //configuraColumnas(rs, modelo); //coneste metodo configuro las columnas de forma automatica
        vaciaFilasModelo(modelo);
        anhadeFilasDeDatos(rs, modelo);
    }

    /**
     * Añade al DefaultTableModel las filas correspondientes al ResultSet.
     * @param rs El resultado de la consulta a base de datos
     * @param modelo El DefaultTableModel que queremos rellenar.
     */
  
    public static void anhadeFilasDeDatos(List<Persona> rs, DefaultTableModel modelo) {
        try {
            for (int i = 0; i < rs.size(); i++) {
                Object[] datosFila = new Object[modelo.getColumnCount()];
                datosFila[0] = rs.get(i).getId();        
                datosFila[1] = rs.get(i).getNombre();
                datosFila[2] = rs.get(i).getApellido();
                datosFila[3] = rs.get(i).getDomicilio();
                datosFila[4] = rs.get(i).getEdad();
                modelo.addRow(datosFila);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Borra todas las filas del modelo.
     * @param modelo El modelo para la tabla.
     */
    public static void vaciaFilasModelo(final DefaultTableModel modelo) {
        try {
            while (modelo.getRowCount() > 0) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Pone en el modelo para la tabla tantas columnas como tiene el resultado
     * de la consulta a base de datos.
     * @param rs Resultado de consulta a base de datos.
     * @param modelo Modelo de la tabla.
     */
    public static void configuraColumnas(final List rs,
            final DefaultTableModel modelo)
    {
        try
        {
            
            // Se obtiene los metadatos de la consulta. Con ellos
            // podemos obtener el número de columnas y el nombre
            // de las mismas.
           // ResultSetMetaData metaDatos = rs.getMetaData();

            // Se obtiene el numero de columnas.
           // int numeroColumnas = metaDatos.getColumnCount();

            // Se obtienen las etiquetas para cada columna
            Object[] etiquetas = new Object[rs.size()];
            for (int i = 0; i < rs.size(); i++)
            {
                etiquetas[i] = modelo.getColumnName(i+1);
            }

            // Se meten las etiquetas en el modelo. El numero
            // de columnas se ajusta automáticamente.
            modelo.setColumnIdentifiers(etiquetas);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
