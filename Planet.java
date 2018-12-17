import java.lang.Math;

public class Planet{

    // Current x position
    public double xxPos;

    // Current y position
    public double yyPos;

    // Current velocity in the x direction
    public double xxVel;

    // Current Velocity in the y direction
    public double yyVel;

    public double mass;

    public String imgFileName;

    public Planet (double xP, double yP, double xV, double yV, double m, String img ){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet (Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    };

    public double calcDistance(Planet planetIn){
        // Calculating the distance between planet 1 & planet 2
        // (x2 - x1),(y2 - y1)
        double dx = ((planetIn.xxPos) - (this.xxPos));
        double dy = ((planetIn.yyPos) - (this.yyPos));

        double r = Math.sqrt(((dx)*(dx)) + ((dy)*(dy)));

        return r;
    };

    public double calcForceExertedBy (Planet planetIn){

        double g = 6.67e-11;
        double r = calcDistance(planetIn);
        double f = ((g)*(this.mass)*(planetIn.mass))/ (r*r);

        return f;
    };
    


}