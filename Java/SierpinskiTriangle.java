package Question4;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.Objects;

public class SierpinskiTriangle extends JFrame implements DocumentListener {
    static int order = 0;
    static JTextField orderText = new JTextField("0");

    public static int getOrder() {
        return order;
    }

    public static void setOrder(int order) {
        SierpinskiTriangle.order = order;
    }

    public SierpinskiTriangle() throws HeadlessException {
        setSize(600, 600);
        setTitle("Sierpinski Triangle");
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(Order(), BorderLayout.SOUTH);
        setVisible(true);
    }

    private JPanel Order() {
        var panel = new JPanel();
        var textArea = new JLabel("Enter an order: ");
        panel.add(textArea);
        panel.add(orderText);
        orderText.setColumns(10);
        orderText.setEditable(true);
        orderText.getDocument().addDocumentListener(this);
        return panel;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0,0,getWidth(),600);

        g.setColor(Color.BLACK);
        Point p1 = new Point(250, 50);          //Top
        Point p2 = new Point(50, 450);          //left
        Point p3 = new Point(450, 450);         //right
        drawTriangle(g, getOrder(), p1, p2, p3);
    }

    private void drawTriangle(Graphics g, int order, Point p1, Point p2, Point p3) {
        //base case
        if (order == 0) {
            Polygon Triangle = new Polygon();
            Triangle.addPoint(p1.x, p1.y);
            Triangle.addPoint(p2.x, p2.y);
            Triangle.addPoint(p3.x, p3.y);
            g.setColor(Color.BLACK);
            g.fillPolygon(Triangle);
        } else {
            Point mp1_2 = midpoint(p1, p2);
            Point mp2_3 = midpoint(p2, p3);
            Point mp3_1 = midpoint(p3, p1);
            drawTriangle(g, order - 1, p1, mp1_2, mp3_1);
            drawTriangle(g, order - 1, mp1_2, p2, mp2_3);
            drawTriangle(g, order - 1, mp3_1, mp2_3, p3);
        }
    }

    private Point midpoint(Point p1, Point p2) {
        return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        if (Objects.equals(orderText.getText(), ""))
            setOrder(0);
        else
            setOrder(Integer.parseInt(orderText.getText()));
        repaint();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        if (Objects.equals(orderText.getText(), ""))
            setOrder(0);
        else
            setOrder(Integer.parseInt(orderText.getText()));
        repaint();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        if (Objects.equals(orderText.getText(), ""))
            setOrder(0);
        else
            setOrder(Integer.parseInt(orderText.getText()));
        repaint();
    }

    public static void main(String[] args) {
        var triangle = new SierpinskiTriangle();
        triangle.setVisible(true);
    }
}
