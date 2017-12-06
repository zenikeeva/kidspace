package gui;

import figures.Polygon;
import figures.Vertex;
import quaternion.Quaternion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
    int x=100;
    int y=100;
    double phi = Math.PI/180.0*5;
    double i = 1.0;
    double j = 1.0;
    double k = 7.0;
    double cosphi = Math.cos(phi/2.0);
    double sinphi = Math.sin(phi/2.0);

    Vertex[] v = {new Vertex(100.0,200.0,70.0), new Vertex(100.0,150.0,100.0),
            new Vertex(150.0,150.0,200.0),new Vertex(150.0,120.0,120.0)
            };
    Polygon segment = new Polygon(v,true);


    public MainFrame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addMouseMotionListener(new MML());
        Timer timer = new Timer(200, new ActionListener(){
        public void actionPerformed(ActionEvent ev) {
            i=x;
            j=y;
            draw();
        }});
        timer.start();

        setSize(400, 400);
        setVisible(true);
    }

    public void draw(){
        this.update(this.getGraphics());
    }

    public void paint(Graphics g) {
        //g.clearRect(0,0,400,400);
        Quaternion q = new Quaternion(cosphi, i*sinphi, j*sinphi, k*sinphi);

        segment.rotate(q);
        segment.draw(g);
    }

    class MML implements MouseMotionListener{
        public void mouseDragged(MouseEvent e) { }

        public void mouseMoved(MouseEvent e) {
            x = e.getX();
            y = e.getY();
        }
    }
}
