package gueue;
import java.io.*;

public class QueueTest
{
		   // in: reader for reading input data
		   private static Reader in =  new InputStreamReader(System.in);

		   private static char getNextChar()
		   {
		      char ch = ' ';
		      try {
		         ch = (char)in.read();
		      }
		      catch (Exception exception) {
		         System.err.println("Read Error");
		         ch = ' ';
		      }
		      return ch;
		   }
		   public static void main(String[] args)
		   {
			      Gueue queue = new Gueue(4); // 4 chars
			      char ch;
			      while ((ch = getNextChar()) != 'q') 
			      {
			         switch (ch) 
			         {
			           case 'i':
			               ch = getNextChar();
			               queue.insert(ch);
			               System.out.println(ch + " inserted");
			               break;
			          case 'd':
			              System.out.println(queue.delete() +   " deleted");
			              break;
			         case 'p':
			              queue.print();
			              break;
			         default: System.out.println("Input error");
			         }
			         while ((ch = getNextChar()) != '\n') ;
			         
			   
			      }
			     
			   }
			}

