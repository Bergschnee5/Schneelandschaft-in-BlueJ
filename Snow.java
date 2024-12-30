import sas.*; import java.awt.Color; import java.util.concurrent.ThreadLocalRandom;
/**
 * Diese kleine Klasse ist für eine Flocke zuständig und wird in einem Thread in der Main Klasse abgerufen
 * 
 * @Bergschnee5 & Tamino
 * 1.0-final
 */
 
public class Snow
{
    Sprite schnee1;
    public boolean isRunningSnow = false;
    public Snow(View fenster,double posx,double posy)
    {
        //Die Schneeflocke besteht aus einem Kreis o
        Circle schnee = new Circle(posx,posy,3,Color.WHITE);
        //Hier wird der Speed eingestellt (Standard 5-15)
        int speed = ThreadLocalRandom.current().nextInt(5,15);
        //Bewegung der Flocken bis pos 1200 für einen geringeren einfluss auf die Performance wird diese auch gelöscht nach dem Limit. Anders als bei den Wolken fallen die Flocken quer!
        while(posy<1200)
        {
            schnee.move(1,1); fenster.wait(speed);
        }
        System.exit(0);
    }

}