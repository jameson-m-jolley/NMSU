package lab3;
import java.lang.Math;
public class Location3D {
    // Instance variables
    private double x;
    private double y;
    private double z;
    private Location3D[] nearestNeighbors;

    // Constructor
    public Location3D() {
        // Initialize instance variables
    	x = 0.0;
    	y = 0.0;
    	z = 0.0;
    	this.nearestNeighbors = new Location3D[3];
		for(Location3D i : nearestNeighbors){
			i = null;
		}
    }

	public Location3D(double x,double y,double z) {
        // Initialize instance variables
		this.x = x;
    	this.y = y;
    	this.z = z;
    	this.nearestNeighbors = new Location3D[3];
		for(Location3D i : nearestNeighbors){
			i = null;
		}
    }

    // Copy Constructor
    public Location3D(Location3D obj) {
    	
    	try {
    		if(obj instanceof Location3D){
    			this.x = obj.x;
    			this.y = obj.y;
    			this.z = obj.z;
    			this.nearestNeighbors = obj.nearestNeighbors;
    		}else{
    		 throw new IllegalArgumentException();
    		}
    	}catch(Exception e) {
    		  //  Block of code to handle errors
    		if(e instanceof IllegalArgumentException ) {
    			System.out.println(e+": warring the obj passed was not of type Location3D a coppy can't be preformed,an obj with the defalt values was created");
    			x = 0.0;
    			y = 0.0;
    			z = 0.0;
    			this.nearestNeighbors = new Location3D[3];
        	}else {
        		throw e;
        	}
    		
    	}
        // Copy instance variables
    }

    // Clone method
    public Location3D clone() {
        // Return a deep copy of the object
    	Location3D r = new Location3D();
    			r.x = this.x;
    			r.y = this.y;
    			r.z = this.z;
    			r.nearestNeighbors = this.nearestNeighbors;
        return r;
    }

    // Getters and Setters
    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }
    public double getz() {
        return this.z;
    }
    public Location3D[] getNearestNeighbors(){
		return this.nearestNeighbors;
	}

	public void setNearestNeighbors(Location3D[] k){
		this.nearestNeighbors = k;
	}

    public void setX(double x) {
        this.x =x;
    }
    public void setY(double y) {
        this.y =y;
    }
    public void setZ(double z) {
        this.z =z;
    }

    // Implement similar methods for y and z coordinates

    // toString method
    public String toString() {
        // Return a string representation of the location
        return ""+this.x+","+this.y+","+this.z;
    }

    // equals method
    public boolean equals(Object obj) {
        // Check if two Location3D objects are equal
    	if (obj instanceof Location3D ) {
    		Location3D nobj = new Location3D((Location3D)obj); 
    		if(nobj.x!= this.x){
    			nobj = null;
    			return false;
    		}else if(nobj.y != this.y) {
    			nobj = null;
    			return false;
    		}else if(nobj.z != this.z) {
    			nobj = null;
    			return false; 
    		}else if(!this.nearestNeighbors.equals(nobj.nearestNeighbors)) {
    			nobj = null;
    			return false;
    		}else {
    			nobj = null;
    			return true;
    		}
    	}else {
    		return false;
    	}
        
    }

    // Method to rotate the location by a specified angle around a specified axis
    public void rotate(double theta, int axis) {

		double tempx,tempy,tempz;

		tempx = x;
		tempy = y;
		tempz = z;
		

        // Rotate the location
    	/*
    	 * After a 𝜃 rotation around the x-asis (i.e., axis = 0):
			x’ = x
			y’ = y cos(𝜃) – z sin(𝜃)
			z’ = y sin(𝜃) + z cos(𝜃)
			
			
		After a 𝜃 rotation around the y-asis (i.e., axis = 1):
			x’ = x cos(𝜃) + z sin(𝜃)
			y’ = y
			z’ = -x sin(𝜃) + z cos(𝜃)
			
			
		After a 𝜃 rotation around the z-asis (i.e., axis = 2):
			x’ = x cos(𝜃) – y sin(𝜃)	
			y’ = x sin(𝜃) + y cos(𝜃)
			z’ = z
    	 * */
     switch(axis) {
     	case 0:
     		 y = (tempy*Math.cos(theta)) - (tempz*Math.sin(theta));
     		 z = (tempy*Math.sin(theta)) + (tempz*Math.cos(theta)); 
     		break;
     	case 1:
     		x =(tempx * Math.cos(theta)) + (tempz*Math.sin(theta));
     		z = (-tempx * Math.sin(theta)) + (tempz* Math.cos(theta));
     		break;
     	case 2:
     		x = (tempx*Math.cos(theta)) - (tempy*Math.sin(theta));	
     		y = tempx*Math.sin(theta) + (tempy*Math.cos(theta));
     		break;
     	default:
     		throw new IllegalArgumentException();
     }
    }//end of roatate 
    
    
    
    public static void main(String[] args){
    	 // Makes a point
        Location3D point = new Location3D();
        point.setX(3);
        Location3D point2 = new Location3D(point);
        point.setY(8);
        Location3D point1 = point.clone();
        point.setZ(2);
        Location3D point3 = point.clone();
        
        System.out.println("point0 = " + point.toString());
        System.out.println("point1 = " + point1.toString());
        System.out.println("point2 = " + point2.toString());
        System.out.println("point3 = " + point3.toString());
        System.out.println("is point3 == point0 ?: " + point3.equals(point));
        System.out.println("is point2 == point1 ?: " + point2.equals(point1));
        
        // Rotate point3 around x-axis by 45 degrees
        point3.rotate(Math.toRadians(45), 0);
        System.out.println("After rotating point3 around x-axis by 45 degrees: " + point3.toString());
        
        // Rotate point1 around y-axis by 90 degrees
        point1.rotate(Math.toRadians(90), 1);
        System.out.println("After rotating point1 around y-axis by 90 degrees: " + point1.toString());
        
        // Rotate point2 around z-axis by 30 degrees
        point2.rotate(Math.toRadians(30), 2);
        System.out.println("After rotating point2 around z-axis by 30 degrees: " + point2.toString());
    	
    	
    	
    }
}

