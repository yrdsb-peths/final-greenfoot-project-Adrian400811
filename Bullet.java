import greenfoot.*;

/**
 * A bullet is being shot by the player to cause damage to the shapes
 * 
 * @author Adrian Lee
 * @version W1 Jun 2023
 */
public class Bullet extends SmoothMover
{
    private GreenfootImage bulletImage;
    private int angle;
    private int damage = 5;
    private double speed = 2.50;
    
    public Bullet(int angle) {
        this.angle = angle;
        bulletImage = getImage();
        setRotation(angle);
    }
    
    public Bullet(int angle, int damage) {
        this.angle = angle;
        this.damage = damage;
        bulletImage = getImage();
        setRotation(angle);
    }
    
    public Bullet(int angle, double speed) {
        this.angle = angle;
        this.speed = speed;
        bulletImage = getImage();
        setRotation(angle);
    }
    
    public Bullet(int angle, int damage, double speed) {
        this.angle = angle;
        this.damage = damage;
        this.speed = speed;
        bulletImage = getImage();
        setRotation(angle);
    }
    
    public void act() {
        move(speed);
        int x = getX();
        int y = getY();
        MyWorld world = (MyWorld) getWorld();
        
        if (isTouching(Shape.class)) {
            damage--;
        }
        
        if (x <= 0 || x >= world.getWidth() - 1 || y <= 0 || y >= world.getHeight() - 1 || damage <= 0) {
            world.removeObject(this);
        }
    }
    
    public int getAngle() {
        return angle;
    }
    
    public void setAngle(int angle) {
        this.angle = angle;
        setRotation(angle);
    }
    
    public int getDamage() {
        return damage;
    }
    
    public void setDamage(int damage) {
        this.damage = damage;
    }
    
    public double getSpeed() {
        return speed;
    }
    
    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
