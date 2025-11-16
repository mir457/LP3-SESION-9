package ACT_1;
import javax.swing.*;
import java.awt.*;

public class BorderLayoutt {
	public static void main(String[]args) {
	    JFrame ventana = new JFrame("Ventana 2 con BorderLayout");
        ventana.setLayout(new BorderLayout());

        ventana.add(new JButton("Norte"), BorderLayout.NORTH);
        ventana.add(new JButton("Sur"), BorderLayout.SOUTH);
        ventana.add(new JButton("Este"), BorderLayout.EAST);
        ventana.add(new JButton("Oeste"), BorderLayout.WEST);

        JButton centro = new JButton("Centro (Cerrar)");
        centro.addActionListener(e -> ventana.dispose());

        ventana.add(centro, BorderLayout.CENTER);

        ventana.setSize(400, 200);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
}