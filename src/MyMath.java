import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


		
public class MyMath {
	//public final int MASSDEEP = 1000;
	//public final int RANDOMDEEP = 1000;

	int array_deep;
	int random_deep;
	
	
	public MyMath (int x, int y) 
	{
	array_deep = x;
	random_deep = y;
	}

	public int[] getMathArray ()
	{
		int [] random_array = new int [array_deep];
		for (int i = 0; i < array_deep; i++ )
			{
				//Random random_object = new Random ();
				//int current_random_number = random_object.nextInt(random_deep);
				int current_random_number =(int)(Math.random()*random_deep);
				random_array [i] =  current_random_number;
			}
		//System.out.println("Новые случайные значения " + random_array[500]);
		return random_array; 
	}

	public int[] getFragmentation ()
	{
		int [] frag = getMathArray();
		int k = frag.length;
		//kk = new int[frag.length];
		int [] kk ;
		kk = new int[frag.length];
		
		//Проба работать с файлами
		try	
			{
			File testFile = new File ("F:\\testjava.txt");
			FileWriter testFileWriter = new FileWriter(testFile);
			BufferedWriter myBuffWriter = new BufferedWriter(testFileWriter);
	
			FileReader testFileReader = new FileReader(testFile);
			BufferedReader myBuffReader = new BufferedReader(testFileReader);
			//kk=myBuffReader.read();
		int z = 0;
		int f = 0;
		for (int i=0; i < k-1; i++)
			{
				for ( int j=1  ; j < k ; j++)
					{
					if (frag[j] > frag[i])  

						{
							z = frag [j];
							frag [j] = frag [i];
							frag [i] = z;
							myBuffWriter.write(frag[i]);
							//myBuffWriter.newLine();
							kk[i]=myBuffReader.read();
						} 
						f++;
					}
			}
		myBuffReader.close();
		myBuffWriter.close();	
		}
		catch (Exception exception)
			{
				System.out.println(exception.getMessage());
			}
	//System.out.println("Случайные значения после сортировки" + frag[500]);	
	return frag ;
	//	return kk;
	}	

	
	
}	