import sas.*; import java.awt.Color; import java.util.concurrent.ThreadLocalRandom;
/**
 * Diese Klasse zeichnet den Schneemann in der Scene.
 * Diese wird Standardmäßig nur ein mal ausgeführt dennoch ist die Position pro abruf Wählbar in der Main Klasse.
 * 
 * @Bergschnee5 & Tamino
 * 1.0-final
 */
public class Snowman
{
    //Variablen
    Sprite hut;
    Sprite mund;
    int t = 20;
    public boolean isRunningHut = false;
    public boolean isRunningMund = false;
    public Snowman(double posx,double posy)
    {
        //Farbe
        java.awt.Color grau = new java.awt.Color(230,230,230);
        java.awt.Color orange = new java.awt.Color(217,135,54);

        //Kreise
        Circle kreisunten = new Circle(posx,posy,75, grau);
        Circle kreisoben = new Circle(posx+25,posy-50,50,grau);

        //Mund
        Circle mund1= new Circle(posx+80,posy+12,5);
        Circle mund2= new Circle(posx+60,posy+10,5);
        Circle mund3= new Circle(posx+40,posy+6,5);
        Circle mund4= new Circle(posx+100,posy+8,5);

        //Mund in Sprite
        mund = new Sprite();
        mund.add(mund1);
        mund.add(mund2);
        mund.add(mund3);
        mund.add(mund4);

        //Augen
        Circle augel = new Circle(posx+35,posy-20,5);
        Circle auger = new Circle(posx+100,posy-20,5);

        Polygon nase = new Polygon(posx+75,posy-5,orange);
        nase.add(25,5);
        nase.add(0,10);

        //Knöpfe auf dem Bauch
        Circle butter1 = new Circle(posx+73,posy+50,5);
        Circle butter2 = new Circle(posx+73,posy+75,5);
        Circle butter3 = new Circle(posx+73,posy+95,5);

        //Hut
        Rectangle hutrand = new Rectangle(posx,posy-50,150,20);
        Rectangle hutoben = new Rectangle(posx+37.5, posy-157.5,75,107.5);
        //Hut v2
        hut = new Sprite(hutrand);
        hut.add(hutoben);

    }
    //Bewegung des Hutes gesteuert von der Main Klasse
    public void huthoch(View fenster)
    {
        //Kontorlle ob die Bewegung läuft 
        isRunningHut = true;
        //Bewegungen
        for(int i=0;i<10;i++)
        {
            hut.move(0,-2);fenster.wait(t);
        }
        fenster.wait(15);
        for(int i=0;i<10;i++)
        {
            hut.move(0,2);fenster.wait(t);
        }
        isRunningHut = false;

    }

    public void mundrotate(View fenster)
    {
        //Wird den Mund bewegen (WIP)
        isRunningMund = true;
        for(int i=0;i<10;i++)
        {
            mund.setDirection(mund.getDirection()+1);fenster.wait(t);
        }

        isRunningMund = false;

    }
}