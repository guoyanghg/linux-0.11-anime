import java.awt.Font;
import java.awt.Graphics;

public class StringChangeModel {
	String s="";
	Boolean flag=false;
	String[] list;
	int strcount=0;
	int x;
	int y;
	StringChangeModel list2;
	int length=0;
public StringChangeModel(String ss) {
		
		// TODO Auto-generated constructor stub
		s=ss;
		x=50;
		y=470;
		list= new String[s.length()];
		if(computelength()!=50){
		System.out.println(computelength());
		}
         for(int i=0;i<s.length();i++){
			
		    list[i]=s.substring(0, i+1);
		
		 }
         
         if(s.length()>computelength()){
        	 
        	 list2= new StringChangeModel(s.substring(computelength()+1),0,500);
        	 
         }
		
	}
	public StringChangeModel(String ss,int xx,int yy) {
		
		// TODO Auto-generated constructor stub
		s=ss;
		x=xx;
		y=yy;
		list= new String[s.length()];
		
         for(int i=0;i<s.length();i++){
			
		    list[i]=s.substring(0, i+1);
		
		 }
         
         if(s.length()>computelength()){
        	 
        	 list2= new StringChangeModel(s.substring(computelength()+1),0,500);
        	 
         }
		
	}
	
	public void draw(Graphics g){
	 
		if(!flag){
		 
		
		    g.drawString(list[strcount], x, y);
		    TimeDelay(20);
		    strcount++;
		    if(strcount==list.length){
		    	flag=true;
		    }
		  
		}else{
			
			g.drawString(s, x, y);
			if(s.length()>computelength()+1&&list2.s.length()!=0){
				list2.draw(g);
			}
			
		}
		
	}
	
    public void TimeDelay(int time){
		
    	
    	
    	try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
     
	
   }
    public int computelength(){
    	length=0;
    	int chinese=0;
    	int engc=0;
    	int bigengc=0;
    	int number=0;
    	
    	for(int i=0;i<s.length();i++){
    		if(Character.isDigit(s.charAt(i))){
    		number++;
    		length=length+10;
			if(length>300){
				return i;
			}
    		}else if(Character.isAlphabetic(s.charAt(i))){
    			if(Character.isLowerCase(s.charAt(i))){
    				
    				engc++;
    				//System.out.println("engc++");
    				length=length+10;
    				if(length>300){
    					return i;
    				}
    				
    			}else if(Character.isUpperCase(s.charAt(i))){
    				
    				bigengc++; 
    				//System.out.println("bigengc++");
    				length=length+15;
    				if(length>300){
    					return i;
    				}
    			}
    		}else if(this.isChinese(s.charAt(i))){
    			chinese++;
        		length=length+20;
    			if(length>300){
    				return i;
    			}
    			
    		}
    					
    	}
     
    	
    	return 50;
    	
    	
    }
    
    private  boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
            return true;
        }
        return false;
    }
    

}
