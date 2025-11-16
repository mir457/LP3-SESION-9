package ACT_1;
import javax.swing.*;
import java.awt.*;

public class FlowLayoutt {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Ventana 1 con FlowLayout");
        ventana.setLayout(new FlowLayout());

        JButton b1 = new JButton("Botón 1");
        JButton b2 = new JButton("Botón 2");
        JButton b3 = new JButton("Botón 3");

        b1.addActionListener(e -> System.out.println("Presionaste botón 1"));
        b2.addActionListener(e -> System.out.println("Presionaste botón 2"));
        b3.addActionListener(e -> System.out.println("Presionaste botón 3"));

        ventana.add(b1);
        ventana.add(b2);
        ventana.add(b3);

        ventana.setSize(400, 100);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}