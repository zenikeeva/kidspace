package figures;

import quaternion.Quaternion;
import java.awt.*;

public class Polygon {
    public Vertex[] vertices;
    boolean closed = false;

    public Polygon(Vertex[] vertices, boolean closed){
        this.vertices = vertices;
        this.closed = closed;
    }

    public Polygon(Vertex[] vertices){
        this.vertices = vertices;
    }

    public void projection(){};

    public void draw(Graphics g){
        int vl = vertices.length;
        for (int i=0; i<vl-1; i++){
            g.drawLine((int)vertices[i].x+100,(int)vertices[i].y+100, (int)vertices[i+1].x+100,(int)vertices[i+1].y+100);
        }
        if(closed) g.drawLine((int)vertices[0].x+100,(int)vertices[0].y+100, (int)vertices[vl-1].x+100,(int)vertices[vl-1].y+100);
    }

    public void move(double mx, double my, double mz){
        int vl = vertices.length;
        for (int i=0; i<vl; i++){
            vertices[i].x += mx;
            vertices[i].y += my;
            vertices[i].z += mz;
        }
    }

    public void rotate(Quaternion q){
        for (int i=0; i<vertices.length; i++){
            Quaternion tmp = (q.multiply(new Quaternion(0, vertices[i].x,vertices[i].y,vertices[i].z).
                    multiply(q.inverse())));

            vertices[i].x=tmp.x;
            vertices[i].y=tmp.y;
            vertices[i].z=tmp.z;
            System.out.println(i+": "+vertices[i].x +", "+vertices[i].y+", "+vertices[i].z+" ; ");
        }
    }
}
