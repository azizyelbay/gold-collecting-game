
package javaapplication16;


public class Koordinat {
    int x;
    int y;
    int mesafe;

    public Koordinat() {
        
    }
    public Koordinat(int x, int y, int mesafe) {
        this.x = x;
        this.y = y;
        this.mesafe = mesafe;
        
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getMesafe() {
        return mesafe;
    }

    public void setMesafe(int mesafe) {
        this.mesafe = mesafe;
    }
    
    
}
