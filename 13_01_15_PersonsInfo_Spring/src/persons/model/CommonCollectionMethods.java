package persons.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class CommonCollectionMethods {
	protected String fileName;

	public CommonCollectionMethods(String fileName) throws FileNotFoundException, ClassNotFoundException, IOException {
		this.fileName=fileName;
		restore();
	}

	public void save() throws FileNotFoundException, IOException{
		//System.out.println("saving information into file");
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(fileName));
		out.writeObject(this);
		out.close();
	}

	public void restore() throws FileNotFoundException, IOException, ClassNotFoundException{
		//System.out.println("restoring information into file");
		File f= new File(fileName);
		if (f.exists()){
			ObjectInputStream in=new ObjectInputStream(new FileInputStream(fileName));
			in.readObject();
			in.close();
		}
	}
}
