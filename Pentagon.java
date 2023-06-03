import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pentagon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pentagon extends Shape
{
    GreenfootImage pt = new GreenfootImage("shapes/pentagon.png");
    public Pentagon(){
        super(20);
        pt.scale(50, 50);
        setImage(pt);
    }
}
