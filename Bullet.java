import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A bullet is being shot by the player to cause damage to the shapes
 * 
 * @author Adrian Lee
 * @version W1 Jun 2023
 */
public class Bullet extends SmoothMover
{
    GreenfootImage bt= new GreenfootImage("bullet.png");
    public int ang;
    public int dmg = 5;
    public double spd = 2.00;
    public Bullet(int tangle){
        ang = tangle;
        setImage(bt);
    }
    public Bullet(int tangle, int tdmg){
        ang = tangle;
        dmg = tdmg;
        setImage(bt);
    }
    public Bullet(int tangle, double tspd){
        ang = tangle;
        spd = tspd;
        setImage(bt);
    }
    public Bullet(int tangle, int tdmg, double tspd){
        ang = tangle;
        dmg = tdmg;
        spd = tspd;
        setImage(bt);
    }
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setRotation(ang);
        move(spd);
        int x = getX();
        int y = getY();
        MyWorld world = (MyWorld) getWorld();
        if(isTouching(Shape.class) ) { 
            dmg += -1;
        }
        if(x <= 0 || x >= world.getWidth()-1 || y <= 0 || y >= world.getHeight()-1 || dmg <= 0){
            world.removeObject(this);
        }
    }
}
