import sas.*; import java.awt.Color; import java.util.concurrent.ThreadLocalRandom; 
/**
 * Die Klasse ist für eine Wolke zuständig.
 * In einem Thread in der Klasse Main wird diese Klasse Abgerufen
 * 
 * @Bergschnee5 & Tamino
 * 1.0-final
 */
public class Clouds
{
    //Variablen
    Sprite fleisch;
    public boolean isRunningCloud = false;
    public Clouds(View fenster,double posx,double posy)
    {
        //Shapes für die Wolke
        Circle c1 = new Circle(posx,posy,30,Color.WHITE);
        Rectangle r1 = new Rectangle(posx+30,posy,100,60,Color.WHITE);
        Circle c2 = new Circle(posx+100,posy,30,Color.WHITE);
        Circle c3 = new Circle(posx+40,posy-40,40,Color.WHITE);
        //Sprite der Wolke mit der Bezeichung "fleisch" XD
        fleisch = new Sprite(c1);
        fleisch.add(r1);
        fleisch.add(c2);
        fleisch.add(c3);
        //Wolkengeschwindigkeit (Standard 3-15)
        int speed = ThreadLocalRandom.current().nextInt(3,15);
        
        while(posx<2100)
        {
            fleisch.move(1); fenster.wait(speed);
        }
        System.exit(0);
    }


}
