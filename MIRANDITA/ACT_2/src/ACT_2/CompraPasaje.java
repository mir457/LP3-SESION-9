package ACT_2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CompraPasaje extends JFrame {

    private JTextField txtNombre, txtDNI, txtFecha;
    private JCheckBox chkAudifonos, chkManta, chkRevistas;
    private JRadioButton rbtnPrimerPiso, rbtnSegundoPiso;
    private JComboBox<String> cboOrigen, cboDestino;
    private JList<String> lstServicio;
    private JButton btnReiniciar, btnMostrar;

    public CompraPasaje() {
        super("Sistema de Compra de Pasajes");
        setSize(450, 550);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p1.add(new JLabel("Nombre completo:"));
        txtNombre = new JTextField(15);
        p1.add(txtNombre);

        p1.add(new JLabel("DNI:"));
        txtDNI = new JTextField(10);
        p1.add(txtDNI);
        add(p1);

        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p2.add(new JLabel("Fecha de viaje (dd/mm/aaaa):"));
        txtFecha = new JTextField(10);
        p2.add(txtFecha);
        add(p2);

        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p3.add(new JLabel("Servicios opcionales:"));
        chkAudifonos = new JCheckBox("Audífonos");
        chkManta = new JCheckBox("Manta");
        chkRevistas = new JCheckBox("Revistas");
        p3.add(chkAudifonos);
        p3.add(chkManta);
        p3.add(chkRevistas);
        add(p3);

        JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p4.add(new JLabel("Piso del bus:"));
        rbtnPrimerPiso = new JRadioButton("1er Piso", true);
        rbtnSegundoPiso = new JRadioButton("2do Piso");
        ButtonGroup grupoPiso = new ButtonGroup();
        grupoPiso.add(rbtnPrimerPiso);
        grupoPiso.add(rbtnSegundoPiso);
        p4.add(rbtnPrimerPiso);
        p4.add(rbtnSegundoPiso);
        add(p4);

        JPanel p5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p5.add(new JLabel("Lugar de origen:"));
        cboOrigen = new JComboBox<>(new String[]{"Arequipa", "Lima", "Cusco", "Puno"});
        p5.add(cboOrigen);
        add(p5);

        JPanel p6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p6.add(new JLabel("Lugar de destino:"));
        cboDestino = new JComboBox<>(new String[]{"Arequipa", "Lima", "Cusco", "Puno"});
        p6.add(cboDestino);
        add(p6);

        JPanel p7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p7.add(new JLabel("Tipo de servicio:"));
        String[] tipos = {"Económico", "Standard", "VIP"};
        lstServicio = new JList<>(tipos);
        lstServicio.setVisibleRowCount(3);
        p7.add(new JScrollPane(lstServicio));
        add(p7);

        JPanel p8 = new JPanel();
        btnReiniciar = new JButton("Reiniciar");
        btnMostrar = new JButton("Mostrar Resumen");
        p8.add(btnReiniciar);
        p8.add(btnMostrar);
        add(p8);

        btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String dni = txtDNI.getText();
                String fecha = txtFecha.getText();

                String serv = "";
                if (chkAudifonos.isSelected()) serv += "Audífonos ";
                if (chkManta.isSelected()) serv += "Manta ";
                if (chkRevistas.isSelected()) serv += "Revistas ";
                if (serv.equals("")) serv = "Ninguno";

                String piso = rbtnPrimerPiso.isSelected() ? "1er Piso" : "2do Piso";

                String origen = cboOrigen.getSelectedItem().toString();
                String destino = cboDestino.getSelectedItem().toString();

                String tipo = lstServicio.getSelectedValue();
                if (tipo == null) {
                    JOptionPane.showMessageDialog(null, "Seleccione un tipo de servicio");
                    return;
                }

                String resumen =
                        "===== RESUMEN DE COMPRA =====\n\n" +
                        "Nombre: " + nombre + "\n" +
                        "DNI: " + dni + "\n" +
                        "Fecha de viaje: " + fecha + "\n\n" +
                        "Origen: " + origen + "\n" +
                        "Destino: " + destino + "\n" +
                        "Piso del bus: " + piso + "\n\n" +
                        "Servicios opcionales: " + serv + "\n" +
                        "Servicio elegido: " + tipo;

                JOptionPane.showMessageDialog(null, resumen, "Resumen", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        btnReiniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtNombre.setText("");
                txtDNI.setText("");
                txtFecha.setText("");
                chkAudifonos.setSelected(false);
                chkManta.setSelected(false);
                chkRevistas.setSelected(false);
                rbtnPrimerPiso.setSelected(true);
                cboOrigen.setSelectedIndex(0);
                cboDestino.setSelectedIndex(0);
                lstServicio.clearSelection();
            }
        });
    }

    public static void main(String[] args) {
        CompraPasaje v = new CompraPasaje();
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setVisible(true);
    }
}
