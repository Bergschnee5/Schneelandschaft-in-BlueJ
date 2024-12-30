import sas.*; import java.awt.Color; import java.util.concurrent.ThreadLocalRandom;
/**
 * Diese Klasse ist für das Picture vom Schlitten zuständig
 * Die PNG ist so grün, weil ich kein Photoshop-PRO bin -_-
 * 
 * @Bergschnee5 & Tamino
 * 1.0-final
 */
public class Santa
{
    //Variablen
    Sprite sled;
    public boolean isRunningFly = false;
    int t = 1;
    //Die Methode um das Bild zu Laden
    public Santa()
    {
        Picture sledPicture = new Picture(-400,100,357,54, "shapes/Santa.png");
        
        sled = new Sprite();
        sled.add(sledPicture);
    }
    //Bewegung durch den "Himmel" von links nach rechts
    public void santaFly(View fenster)
    {
        //Eine kontrolle um probleme zu minimieren
        isRunningFly = true;
        //Bewegung
        for(int i=0;i<1300;i++)
        {
            sled.move(2,0);fenster.wait(t);
        }
        sled.move(-2600,0);
        isRunningFly = false;

    }
}
