import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {
	BufferedReader br;
	String[] list=new String[8];
	public Reader() {
		
		try {
			br= new BufferedReader(new InputStreamReader(new FileInputStream("E://vs2013-linuxpro//Linux//process.log")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<8;i++){
			try {
				list[i]=br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated constructor stub
	}

}
