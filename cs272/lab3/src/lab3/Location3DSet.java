package lab3;

public class Location3DSet {
//This class should include proper instance variables to keep all location objects and the actual
//	number of locations
private Location3D[ ] data;
private int manyItems; 
	
//	A no-argument constructor, which initializes a Location3DSet instance, sets its capacity to
//	10, and creates an array to store 10 Location3D objects
	public Location3DSet() {
		data = new Location3D[10];
		manyItems = 0;
	}	
	
//	The following method which returns the actual number of elements in this collection.
	public int size() {
		return manyItems;
	}
	
// The following method which returns the capacity of this collection instance.
	public int capacity() {
		return data.length;
	}
	
// A method which adds one given Location3D object to the first available space of the
//	Location3D array in this Location3DSet instance. When the collection space is sufficient to hold
//	the new location, this location object can be directly added to the collection. Otherwise, you need to
//	double the space of the instance array by implementing a method ensureCapacity (defined
//	below). The precondition is that the location object a should NOT be null.	
	public void add(Location3D a) {
		if( this.capacity() > this.size()){
			data[manyItems] = a;
		}else{	
			Location3D[ ] old = data.clone();
			data = new Location3D[old.length + 10];
			for(int i=0; i<old.length; ++i){
				data[i]=old[i];
			}
			old = null;
			this.add(a);
		}
	}
	
//	A method to remove from the collection the location with the given x, y, z.
	public boolean remove(double x, double y, double z) {

		boolean found = false;
		int i = 0;


		Location3D dummy = new Location3D();
		dummy.setX(x);
		dummy.setY(y);
		dummy.setZ(z);

		while (!found && i < manyItems) {
			if(data[i].equals(dummy)){
				found = true;
				break;
			}else{
				++i;
			}
		}

		if(found){
			data[i] = null;
			for(int j=i; j < manyItems;++j){
				if(data[j] == null && !(j+1 > capacity())){
					data[j] = data[j+1];
					data[j+1] = null;
				}
			}
			--manyItems;
		}

		return found;
	}
	
//A method to save x, y, z of all locations in the set to a .csv file. The content format of the
//	.csv file should be:
//		x,y,z
//		1.0,1.5,3.0
//		2.0,4.0,5.0
//		2.5,3.5,2.1	
	public void save(String file) {}
	
//(15 pts) Write a method to calculate the 3 nearest neighbors of each location and store those in the
//location’s nearest neighbor array. We will use Euclidean distance to calculate the distances between
//points.
	public void find_nearest_neighbors() {
		double[] distances= new double[data.length];
		Location3D[] k = {null,null,null};
		for(int currentPoint=0; currentPoint < data.length; ++currentPoint){
			// find the min
				k[0]= null;
				k[1]= null;
				k[2]= null;

			for(int lookingPoint=0 ; lookingPoint<data.length;++lookingPoint){
				distances[lookingPoint] = findDistance(data[currentPoint],data[lookingPoint]);

				k[0]=(findDistance(k[0],data[lookingPoint]) < distances[lookingPoint]||k[0]==null)?data[lookingPoint]:k[0];
				k[1]=((findDistance(k[1],data[lookingPoint]) < distances[lookingPoint]||k[1]==null) && findDistance(k[1],data[lookingPoint]) >= findDistance(k[0],data[lookingPoint]))?data[lookingPoint]:k[1];
				k[2]=((findDistance(k[2],data[lookingPoint]) < distances[lookingPoint]||k[2]==null) && findDistance(k[2],data[lookingPoint]) >= findDistance(k[2],data[lookingPoint]))?data[lookingPoint]:k[2];
			}
			data[currentPoint].setNearestNeighbors(k);
		}
	}

// finds the Euclidean distance betwine 2 points
	public double findDistance(Location3D l1,Location3D l2){
		return Math.sqrt((Math.pow(l1.getX()-l2.getX(), 2)+Math.pow(l1.getY()-l2.getY(), 2)+Math.pow(l1.getz()-l2.getz(), 2)));
	}

	//testing 
	public static void main(String[] args) {
		Location3DSet dataset = new Location3DSet();

	}

}
