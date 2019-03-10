import java.io.*;

public class FW {

	public static void main(String[] args) {
		
		// Reads a text file and outputs to a text file
		// all consecutive sequences of letters as words 
		// separated by single spaces
		
		FileReader in = null;
	    FileWriter out = null;	    
		
	    // v javi izjeme lovimo tako da reèemo try neki in potem catch in neka izjema teh catchov damoo lahko veè
		try {
			in = new FileReader("src/datoteke_python.txt");
			out = new FileWriter("src/outputFile.txt");	
			
			int c;
			boolean space = false;
			while ((c = in.read()) != -1) {
				if (Character.isLetter(c)) {
					// if the character c is a letter write it to output file
					// and flag that a space is needed after
					out.write(c); space = true;
				}
				else if (space) {
					// if the character c is not a letter then write
					// a space only if the space flag says that one is needed.
					out.write((int) ' '); 
					// After writing a space we do not need another
					space = false;
				}
			}				
			
		} catch (IOException e) {
			System.out.println("Error " + e);
			
		} finally {
			try {
				in.close();
				out.close();
				
			} catch (IOException e) {
				System.out.println("Error " + e);
				// if (out != null) {in.close();}
			}
				
		}
		

	}

}