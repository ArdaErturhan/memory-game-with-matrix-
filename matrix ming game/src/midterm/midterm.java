package midterm;
import java.util.Scanner;
//By Arda Erturhan
//Since we are hard coding the order I didnt add the extra note for "You can only use 2 of the same class".
interface whoami{//we are using this so when we are searching for the capital letters it ll allow us to search for the class
    public char whoAmI();
} 
class Cup implements whoami{//we put each  proccess in the codes so if the code asks for the class cup it will return 'C'
   public char whoAmI(){
          return 'C';
   		}
}
class Ball implements whoami{//Same of the cup	
   public char whoAmI(){
          return 'B';
   	}
}
class Hat implements whoami{//same of the cup
   public char whoAmI(){
          return 'H';
   	}
}
class Pen implements whoami{//same of the cup
   public char whoAmI(){
          return 'P';
   	}
}
class Undefined implements whoami{//same of the cup
	   public char whoAmI(){
	          return 'U';
	   	}
	}
public class midterm {
	public static char[][] matrik(char [][]m,String st){
		int z=0;
		 int sutun = 3;
			int satir =3;
		Cup arda = new Cup();//we created objects just like you wanted.
        Ball batula = new Ball();//we used the objects to reach the classes.
        Hat furkan = new Hat(); //ObjectName.MethodName lets us to reach the Classes and the letter.
        Pen eman = new Pen();//
        Undefined duru=new Undefined();//
    	for(int i=0; i<satir; i++) {//code for the matrix
			for(int j=0; j<sutun;  j++) {
				if(st.charAt(z)=='C'){//we are checking the current letter if it is c,h,p,b or u .if it is then we are putting it to the matrix
					m[i][j]=arda.whoAmI();
				}
				if(st.charAt(z)=='H'){
					m[i][j]=furkan.whoAmI();
				}
				if(st.charAt(z)=='P'){
					m[i][j]=eman.whoAmI();
				}
				if(st.charAt(z)=='B'){
					m[i][j]=batula.whoAmI();
				}
				if(st.charAt(z)=='U'){
					m[i][j]=duru.whoAmI();
				}
				z++;//increasing z so our string index will increase too.
				}			
			}
        return m;//returning the matrix we created from the string
	}
	public static  void playGame(char [][]m, char [][]m1,char[][]m2,String st) {	//the game function
		int sutun = 3;
		 int satir =3;//the column and row numbers :)
		  int sutun1 = 3;
		    int satir1 = 3;
		    int sutun2 = 3;
		    int satir2 = 3;
		    int countp= 0;//count p for guessing the order.we are counting if user guessed 4 or more.
		    Scanner scan = new Scanner(System.in);
		    int i;
		    int j;
		    String a;
		    String b;
			for(int z=0; z<9; z++) {
		    System.out.println("please enter the row-column numbers to disclose that location"); 
		    i=scan.nextInt();//scanners to learn which location user wants to disclose
			 j=scan.nextInt();	
				m1[i][j]=m[i][j];	//we asked the user to enter the locations of m so we can change our m1 matrix from 'X' to the current letter	
				 for(int y=0; y<satir; y++) {//the code of matrix	
						for(int c=0; c<sutun; c++) {
							System.out.print(m1[y][c]+" ");//We print the altered matrixjava
						}
						System.out.println();
						}			 
			}
			System.out.println("Would you like to try to remember the locations by yourself ?(Yes or no)");
			a=scan.next();
			if(a.equals("Yes")){//I searched on the net to see if I can ask for a particular word then I found this code.
				for(int y=0; y<satir; y++) {
					
					for(int c=0; c<sutun; c++) {
						System.out.print(m2[y][c]+" ");//we closed the matris again(I did it by rewriting the 'X' matrix in the main just like the m1).
					}
					System.out.println();
					}	
				System.out.println("please enter the letters in a order  as you remembered side by side ?");//Asking for the user to write the order side by side
				b=scan.next();
    for(int y=0; y<9; y++) {
    	if(st.charAt(y)==b.charAt(y)) {
    		countp++;//counting if the string we asked from user is the same of the order string
    	}
    }
    if(countp>=4) {
    	System.out.println("You win");
    }
    else{
    	System.out.println("You lost");
    }
				}
			

	}
	 public static void main(String [] args) {//main
		 Scanner scan = new Scanner(System.in);
		 int sutun = 3;
			int satir =3;
			 int sutun1 = 3;
			    int satir1 = 3;	
			    int sutun2 = 3;
			    int satir2 = 3;
			char [][]m = new char[sutun][satir];//creating the matrixes	
		 String st="CPCHPBUBH";//creating the order string
		 char [][]m1 = new char[sutun1][satir1];
		 char [][]m2 = new char[sutun2][satir2];
		 for(int i=0; i<satir; i++) {	//another 'X' matrix for quessing the order	
				for(int j=0; j<sutun; j++) {
					m2[i][j]='X';
				}
			}
		 
		 for(int i=0; i<satir; i++) {		//the 'X' matriks(closed matriks)
				for(int j=0; j<sutun; j++) {
					m1[i][j]='X';
				}
			}
		 for(int i=0; i<satir; i++) {//printing the X matrix.
				for(int j=0; j<sutun; j++) {
					System.out.print(m1[i][j]+" ");
				}
				System.out.println();
				}
		m =matrik(m,st);//transforming the order and the latters from order string to our matrix
		    playGame(m,m1,m2,st);//the main game
		    
		 
		}
	 }