import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Player class of the game
 * 
 * @author Adrian Lee 
 * @version W1 Jun 2023
 */
public class Player extends SmoothMover
{
    // Import assets
    GreenfootImage tank = new GreenfootImage("DiepTank.png");
    private int hp = 100;
    private int speed = 2;
<<<<<<< Updated upstream
=======
    private int exp = 1;
    private int level = 0;
    private double bulSpeed = 2.50;
    private int shootInterval = 500;
>>>>>>> Stashed changes
    /**
     * Constructor of Player class
     */
    public Player(){
        tank.scale(50,50);
        setImage(tank);
    }

    public void act()
    {
        // gun always turn to mouse
        MouseInfo m = Greenfoot.getMouseInfo();
        if(m != null){
            turnTowards(m.getX(), m.getY());
        }
        
        // movement
        if(Greenfoot.isKeyDown("w")){
            setLocation(getExactX(), getExactY()-speed);
        }
        if(Greenfoot.isKeyDown("a")){
            setLocation(getExactX()-speed, getExactY());
        }
        if(Greenfoot.isKeyDown("s")){
            setLocation(getExactX(), getExactY()+speed);
        }
        if(Greenfoot.isKeyDown("d")){
            setLocation(getExactX()+speed, getExactY());
        }
<<<<<<< Updated upstream
        if(Greenfoot.isKeyDown("space")){
=======
        if(Greenfoot.isKeyDown("i")){
            incExp(5);
        }
        if(shootTimer.millisElapsed() > shootInterval && (Greenfoot.isKeyDown("space") || autoShoot)){
>>>>>>> Stashed changes
            shoot();
        }
        
        // detect collusion with shapes
        if(isTouching(Shape.class) ) { 
            hp += -1;
        }
        
        // end game if hp = 0
        if(hp <= 0){
            MyWorld world = (MyWorld) getWorld();
            world.gameOver();
            world.removeObject(this);
        }
    }
    public void shoot(){
        Bullet b = new Bullet(getRotation(), bulSpeed);
        MyWorld world = (MyWorld) getWorld();
        world.addObject(b, this.getX(), this.getY());
    }
<<<<<<< Updated upstream
=======
    
    public void incExp(int ex){
        if(hp < 100+(50*(level-1))){
            hp += ex;
        }else{
            exp += ex;
        }
        if(exp>(100*level)){
            level += 1;
            exp = 0;
            hp += 25;
            speed += 1;
            bulSpeed += 1.50;
            shootInterval = shootInterval/4*3;
        }
        MyWorld world = (MyWorld) getWorld();
        world.updateHpBar(hp);
        world.updateExp(exp);
        world.updateLv(level);
    }
>>>>>>> Stashed changes
}
