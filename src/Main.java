import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Main{
    public static MyFrame f= new MyFrame();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   
      
      JFrame j= new JFrame();
      
      
      f.setVisible(true);
    
      j.setSize(800, 600);
      int windowWidth = j.getWidth(); //��ô��ڿ�
      int windowHeight = j.getHeight(); //��ô��ڸ�
      Toolkit kit = Toolkit.getDefaultToolkit(); //���幤�߰�
      Dimension screenSize = kit.getScreenSize(); //��ȡ��Ļ�ĳߴ�
      int screenWidth = screenSize.width; //��ȡ��Ļ�Ŀ�
      int screenHeight = screenSize.height; //��ȡ��Ļ�ĸ�
      j.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//���ô��ھ�����ʾ
      
      j.setVisible(true);
      
      j.add(f);
      
      
      f.setSize(500,500);
      
      j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      
      
      
	}
	

}
