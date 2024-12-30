import sas.*; import java.awt.Color; import java.util.concurrent.ThreadLocalRandom;
/**
 * Diese Klasse zeichnet einen Baum an den von der Mainklasse angegebenen Koordinaten
 * 
 * @Bergschnee5 & Tamino
 * 1.0-final
 */
public class Baumplacer_Sprites
{
    //Variablen
    private View fenster;
    private Polygon nadeln;
    private Rectangle stamm;
    
    public Baumplacer_Sprites(double posx,double posy)
    {
        nadeln = new Polygon(posx,posy);
        nadeln.add(100,0);
        nadeln.add(75,-30);
        nadeln.add(85,-30);
        nadeln.add(60,-60);
        nadeln.add(70,-60);
        nadeln.add(50,-90);
        nadeln.add(30,-60);
        nadeln.add(40,-60);
        nadeln.add(15,-30);
        nadeln.add(25,-30);
        nadeln.setColor(new Color(40,114,51));
        stamm = new Rectangle(posx+40,posy,20,20);
        stamm.setColor(new Color(76,47,38));
    }
}
//Alter Code hier
//Erstelle Random & Print Random //
//Picture Baum1 = new Picture(posx,posy,"shapes/Baum1.png");
