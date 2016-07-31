import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyPannel extends JPanel implements ActionListener, KeyListener {
	
	
	Color random_color = new Color(0, 0, 0);
	Timer random_timer = new Timer (500, this);
	boolean istimeron = false;
	int [] heretowers;
	int [] heredigits;
	int towercount;
	int arraylenght;
	int towerwidth;
	int maxtowerheight;
	int cur_panheight ;
	int cur_array_deep;
	JButton myButton = new JButton("get random digits");

//public static final int BUTTON_W=100;
//public static final int BUTTON_H=30;
//JPanel buttonJPanel = new JPanel();


//Пока просто так добавил конструктор
	public MyPannel (int positionx, int positiony, int height, int width)
	{
		add(myButton);
	}

	public MyPannel (int panwidth, int panheight, int [] towers, int [] digits, int array_deep)
	{
		//работа с кнопкой
		setLayout(new BorderLayout());
		add(myButton,BorderLayout.NORTH);
		myButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				MainWindow.ReDraw(MainWindow.windowwidth-10, MainWindow.windowheight-10, MainWindow.lines, MainWindow.MASSDEEP, MainWindow.RANDOMDEEP);;
				repaint();
			}
		});
		
		
		
		this.addKeyListener(this);
		this.setFocusable(true);
		setFocusable(true);
		heretowers = towers;
		heredigits = digits;
		//System.out.println(heredigits[500]);
		cur_array_deep = array_deep;
		
		towercount = towers.length -1;
		arraylenght = digits.length;
		towerwidth = Math.round(panwidth / (2*towercount +1));
		cur_panheight=panheight;
		
	}
	
	//Обрабатываем массив, и делаем из него массив количества точечек в каждом столбике
	public int [] getprocessMath (int [] processArray, int processTowers, int maximumval) 
	{
		//int maxval = 0;
		int dotquantity = 0;
		int cut1, cut2, delta = 0;
		int [] shti = new int [processTowers]; 
				
	
		dotquantity =(int) Math.round (maximumval/processTowers);
		cut1=0;
		cut2=dotquantity;
		delta = cut2-cut1;
		
		//System.out.println("processarray " + processArray[500]);
		
		for (int k = 0; k< processTowers; k++)
		{
			for (int j = 0 ; j< processArray.length; j++)
				{
					if (processArray[j] < cut2 && processArray[j] >=cut1)
						shti[k]++;
					if (cut2 == processArray.length && processArray [j] == maximumval)
					{
						shti [k]++;
					}
				}
		//System.out.println(cut1 + " " + cut2 + " " + shti [k] + " "+ maximumval + " " + processTowers);
		cut1=cut2;
		cut2=cut2+delta;
		}
		//System.out.println("shti " + shti[0]+ " " + shti[1]+ " " + shti[2]+ " " + shti[3] );
		return shti;
	}
	
	//Рисуем столбики
	public void paintComponent (Graphics g) //!!!!!!!!!!!!!
	{
		super.paintComponent(g); 
		g.setColor(Color.BLACK);
		
		int [] draw_towers = null;
		draw_towers = getprocessMath(heredigits, towercount,cur_array_deep);
		//System.out.println("drawtowers " + draw_towers[0]+ " " + draw_towers[1]+ " " + draw_towers[2]+ " " + draw_towers[3] );
		for (int i=0 ; i<towercount; i++)
		{
			int c_red = (int) (Math.random()*255);
			int c_green = (int) (Math.random()*255);
			int c_blue = (int) (Math.random()*255);
			random_color = new Color(c_red, c_green, c_blue);
			g.setColor(random_color);
			
			//System.out.println(towerwidth+2*i*towerwidth + " " + cur_panheight + " " + towerwidth + " " + draw_towers[i]);
			g.fillRect(towerwidth+2*i*towerwidth,  cur_panheight-draw_towers[i]-50 , towerwidth, draw_towers[i]);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
	


