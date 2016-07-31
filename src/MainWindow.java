import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.text.html.HTMLDocument.HTMLReader.BlockAction;

public class MainWindow {

public static	int windowwidth = 600;
public static	int windowheight = 400;
public static 	int positionwidth = 300;
public static 	int positionheight = 200;
public static 	final int MASSDEEP = 1000;
public static	final int RANDOMDEEP = 1000;
public static	final int COUNTLINES = 10;	
public static 	int [] lines = new int [COUNTLINES+1]; //!! Важно, что тут 11 строк с 0 по 10ю
public static JFrame ChartWindow = new JFrame();
public static MyMath ourMath;

//= new MyMath(MASSDEEP, RANDOMDEEP);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
int [] full_array = new int [MASSDEEP];
int [] draw_array = new int [MASSDEEP];
int quantity = Math.round( MASSDEEP/COUNTLINES);

//MyMath ourMath = new MyMath(MASSDEEP, RANDOMDEEP);
//MyMath Draw_Math = new MyMath(MASSDEEP,RANDOMDEEP);
//full_array = Draw_Math.getMathArray();
//draw_array = Draw_Math.getFragmentation();

//рассчет количества столбиков
for (int i=0; i<=COUNTLINES; i++)
	{
		lines [i] =RANDOMDEEP - i * quantity;
		
	}
		ChartWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ChartWindow.setBounds(positionwidth,positionheight,windowwidth,windowheight);
		ChartWindow.setTitle("Check if PC do real random");
		ChartWindow.setResizable(false);
		
		//Пример использования размера окна
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//ChartWindow.setSize(screenSize);
		//ChartWindow.setExtendedState(Frame.MAXIMIZED_BOTH);
		
		ReDraw(windowwidth-10,windowheight-10, lines, MASSDEEP, RANDOMDEEP);

//MyPannel ChartPanel = new MyPannel(windowwidth-10,windowheight-10, lines, ourMath.getFragmentation(), RANDOMDEEP);
//ChartWindow.add(ChartPanel);
//ChartWindow.setBackground(Color.BLACK);
//ChartWindow.setVisible(true);
//ChartWindow.setVisible(true);
	}
	public static void ReDraw(int ww, int wh, int [] lis , int mdeep, int rndd)
	{
		//ChartWindow.setVisible(false);
		ourMath = new MyMath(MASSDEEP, RANDOMDEEP);
		MyPannel ChartPanel = new MyPannel(ww, wh, lis, ourMath.getFragmentation(), rndd);
		ChartWindow.add(ChartPanel);
		ChartWindow.setVisible(true);
	}
	


}
