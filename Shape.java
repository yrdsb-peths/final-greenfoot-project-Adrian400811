import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Shapes are what the player shoot at to get experience points and upgrade
 * points.
 * 
 * @author Adrian Lee 
 * @version W1 Jun 2023
 */
public class Shape extends Actor
{
    private int hp;
    public Shape(int thp){
        hp = thp;
        setRotation(Greenfoot.getRandomNumber(359));
    }
    public void act()
    {
        // Add your action code here.
        if(isTouching(Player.class) ) { 
            MyWorld world = (MyWorld) getWorld();
            hp += -1;
        }
        if(isTouching(Bullet.class) ) { 
            MyWorld world = (MyWorld) getWorld();
            hp += -1;
        }
        if(hp <= 0){
            MyWorld world = (MyWorld) getWorld();
            world.removeObject(this);
            world.increaseExp(5);
        }
    }
}
