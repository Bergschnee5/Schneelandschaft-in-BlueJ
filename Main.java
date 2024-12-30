import sas.*; import java.awt.Color; import java.util.concurrent.ThreadLocalRandom;
/**
 * Die Hauptklasse!
 * In dieser werden alle relevanten Klassen abgerufen und die Landschaft gezeichnet
 * 
 * @Bergschnee5 & Tamino
 * 1.0-final
 */
public class Main
{
    Snowman frosty;
    Clouds w1;
    Santa satan;
    //Variablen//
    boolean huttimer = true;
    boolean cloudtimer = true;
    boolean ifpresseddown = false;
    boolean ifpressedleft = false;
    boolean ifpressedRight = false;
    View fenster = new View(1900,1000);
    //Threads für die Wolken u. Schnee//
    Thread cloudSpawnRepeat = new Thread(() -> 
                {
                    while(true)
                    {
                        //Dieser Thread führt neue Threads aus um Wolken zu Zeichnen
                        Thread cloudSpawn = new Thread(() -> {Clouds wolke = new Clouds(fenster,-200,ThreadLocalRandom.current().nextInt(50,200));});
                        cloudSpawn.start();
                        fenster.wait(ThreadLocalRandom.current().nextInt(1000,3000));
                    }
            });

    Thread snowSpawnRepeat = new Thread(() -> 
                {
                    while(true)
                    {
                        //Dieser Thread führt neue Threads aus um Schneeflocken zu Zeichnen
                        Thread schneeSpawn = new Thread(() -> {Snow schnee = new Snow(fenster,ThreadLocalRandom.current().nextInt(-500,1800),-50);});
                        schneeSpawn.start();
                        fenster.wait(ThreadLocalRandom.current().nextInt(100,200));
                    }
            });

    public Main() //Konstuktor//  =_=
    {
        //Farben Definieren
        java.awt.Color himmel = new java.awt.Color(135,206,235);
        java.awt.Color boden = new java.awt.Color(255,248,250);
        java.awt.Color bergrau = new java.awt.Color(102,102,102);
        Rectangle sky = new Rectangle(0,0,1900,1000,himmel);
        //Scene
        Polygon berg = new Polygon(1200,1000,bergrau);
        berg.add(200,-350);
        berg.add(300,-200);
        berg.add(500,-400);
        berg.add(600,-300);
        berg.add(900,-500);
        berg.add(1000,0);
        //Berge
        Polygon bergschnee1 = new Polygon(1400,650,Color.WHITE);
        bergschnee1.add(-86,150);
        bergschnee1.add(-15,80);
        bergschnee1.add(67,99);
        //Berge
        Polygon bergschnee2 = new Polygon(1700,600,Color.WHITE);
        bergschnee2.add(100,100);
        bergschnee2.add(-91,90);
        
        
        //Boden
        Circle huegel1 = new Circle(-222,800,500, boden);
        Circle huegel2 = new Circle(222,875,500, boden);
        Circle huegel4 = new Circle(666,850,500, boden);
        Circle huegel6 = new Circle(1500,700,500, boden);
        Rectangle gerade1 = new Rectangle(0,900,2000,120, boden);
        
        satan = new Santa();
        
        //Start der Threads (Schnee u. Wolken)
        cloudSpawnRepeat.start();
        snowSpawnRepeat.start();

        //Schneemann
        frosty = new Snowman(300,750);
        //Bäume
        new Baumplacer_Sprites(750,910);
        new Baumplacer_Sprites(1700,800);
        
        //Bewegende Objekte
        while(true)
        {
            //Das hier ist für die Bäume
            if(sky.mousePressed()) 
            {
                new Baumplacer_Sprites(sky.getMouseX()-50,sky.getMouseY()-20);

            }
            if(fenster.keyDownPressed())
            {
                //Führt die Hut-Animation aus
                if(ifpresseddown == false && frosty.isRunningHut == false)
                {
                    Thread hut = new Thread(() -> {frosty.huthoch(fenster);});
                    ifpresseddown = true;
                    hut.start();

                }
            }
            else
            {
                ifpresseddown = false;

            }
            if(fenster.keyLeftPressed())
            {
                if(ifpressedleft == false && satan.isRunningFly == false)
                {
                    //Führt die Santa-Animation aus
                    Thread flySled = new Thread(() -> {satan.santaFly(fenster);});
                    ifpressedleft = true;
                    flySled.start();

                }
            }
            else
            {
                ifpressedleft = false;

            }
            if(fenster.keyRightPressed())
            {
                if(ifpressedRight == false && frosty.isRunningMund == false)
                {
                    //Führt die Mund-Animation aus (WIP)
                    Thread mundRotate = new Thread(() -> {frosty.mundrotate(fenster);});
                    ifpressedRight = true;
                    mundRotate.start();
                }
            }
            else
            {
                ifpressedRight = false;

            }
        }
        
    }

}