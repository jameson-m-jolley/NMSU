package lab3;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner; // Import the Scanner class to read text files


public class Location3DSet {
//This class should include proper instance variables to keep all location objects and the actual
//	number of locations
private Location3D[] data;
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
			manyItems++;
		}else{	
			ensureCapacity((manyItems+1)*2);
			//recusive call after adding more Capacity
			this.add(a);
		}
	}

	public void ensureCapacity(int capacity){
		Location3D [] dataclone = new Location3D[capacity];
		if(this.capacity() >=  capacity){
			for(int i=0; i<capacity; ++i){
				dataclone[i]=data[i];
			}
		}else{
			for(int i=0; i<data.length; ++i){
				dataclone[i]=data[i];
			}
		}
		data = dataclone;
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
	public void save(String file) {
		try {
        FileWriter writer = new FileWriter(file+".csv");
        writer.write("x,y,z\n"); // Writing the header
        
       // for (Location3D i : this.data) {
       //     if (i != null)
        //        writer.write(i.getX() + "," + i.getY() + "," + i.getZ() + "\n");
       // }
	   writer.write(this.toString());
        
        writer.close();
        	System.out.println("Data successfully saved to " + file);
    	} catch (IOException e) {
        	System.out.println("An error occurred while saving the data: " + e.getMessage());
    	}
		
	}

	public String toString(){
		String ret = "";
		System.out.println("convering all the data points to a csv string...");
		for(Location3D i: this.data){
			try {
				if(i != null)
					ret += i.toString()+"\n";
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		}
		return ret;
	}
	

	/*this is a load method that takes a csv file and ads the points to the data */
	public void load(String path){
		try{
			File Ndata = new File(path);
			Scanner reader = new Scanner(Ndata);
			String[] arr;
			String line;
			int linenum=0;
			while(reader.hasNextLine()){
				
				line = reader.nextLine();
				linenum++;
				arr = line.split(","); 
				//splits the line into a [x,y,z]
				try{
					this.add(new Location3D(Double.parseDouble(arr[0]),Double.parseDouble(arr[1]),Double.parseDouble(arr[2]) ));
				}catch(Exception e){
					System.out.println("obj on line number:"+linenum+" >> faled to parse into a Double and autoBox: errored with message <"+e+">");
				}

			}
			reader.close();
			Ndata = null;
			
		}catch(FileNotFoundException e){
			System.out.println("file at path:<"+path+"> is not found");
		}

	}
	
//(15 pts) Write a method to calculate the 3 nearest neighbors of each location and store those in the
//location’s nearest neighbor array. We will use Euclidean distance to calculate the distances between
//points.
	public void find_nearest_neighbors() {
		double[] distances = new double[data.length];
		int[] lowest_indexs= {0,0,0,0};
		
		System.out.println("computing nearest neighbors this may take a while...");
		for(int currentPoint=0; currentPoint < manyItems; ++currentPoint){

			//find all the distances
			for(int lookingPoint=0 ; lookingPoint<manyItems;++lookingPoint){
				distances[lookingPoint]= findDistance(data[currentPoint], data[lookingPoint]);
				//put the max in the lowest
				if(distances[lowest_indexs[0]]<distances[lookingPoint]){
					lowest_indexs[0] =lookingPoint;
				}
				
			}

			for(int i = 0;i<distances.length;i++){
				for(int j = lowest_indexs.length-2; j>=0; j--){
					if(distances[i] < distances[lowest_indexs[j]] && distances[i] > 0){
						//shift all 
						lowest_indexs[j+1]=lowest_indexs[j];
						lowest_indexs[j]=i;
						}
				}

				//if(distances[i] < distances[lowest_indexs[0]] && distances[i] > 0){
					//shift all 
				//		lowest_indexs[2]=lowest_indexs[1];
				//		lowest_indexs[1]=lowest_indexs[0];
				//		lowest_indexs[0] = i;
					
				//	}	

			}
			Location3D []neighbors = {
				data[lowest_indexs[0]],
				data[lowest_indexs[1]],
				data[lowest_indexs[2]]
			};

			data[currentPoint].setNearestNeighbors(neighbors);
		}
	}

// finds the Euclidean distance betwine 2 points
	public double findDistance(Location3D l1,Location3D l2){
		try{
			if(l1.equals(l2)){
			return -1;
			}
			return Math.sqrt((Math.pow(l1.getX()-l2.getX(), 2)+Math.pow(l1.getY()-l2.getY(), 2)+Math.pow(l1.getz()-l2.getz(), 2)));
		}catch(Exception e){
			System.out.print(e);
			return -1;
		}
		
	}

	//testing 
	public static void main(String[] args) {
		Location3DSet dataset = new Location3DSet();
		dataset.load("sample.csv");
		dataset.toString();
		dataset.find_nearest_neighbors();



		try {
			FileWriter writer = new FileWriter("test.txt");

			for(int i=0 ;i<100;i++){
				writer.write("testing point "+dataset.data[i]+"\n"+"printing out nearest-----\n");
				for(Location3D j: dataset.data[i].getNearestNeighbors()){
					writer.write(j.toString());
					writer.write(">cheching distance----->"+dataset.findDistance(dataset.data[i], j)+"\n");
				}
			}
			
			writer.close();
				System.out.println("Data successfully saved to test.txt");
			} catch (IOException e) {
				System.out.println("An error occurred while saving the data: " + e.getMessage());
			}
		System.out.println("saving the data set as a .csv");

		dataset.save("sampletest");
		
		
	}

}
