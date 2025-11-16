package ACT_1;
import javax.swing.*;
import java.awt.*;

public class GridLayoutt {
	public static void main (String[]args) {
        JFrame ventana = new JFrame("Ventana 3 con GridLayout");
        ventana.setLayout(new GridLayout(2, 3));

        for (int i = 1; i <= 6; i++) {
            JButton boton = new JButton("Botón " + i);
            boton.addActionListener(e -> System.out.println("Click en " + boton.getText()));
            ventana.add(boton);
        }

        ventana.setSize(400, 200);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
