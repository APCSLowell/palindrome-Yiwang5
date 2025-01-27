import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PalindromeChecker {
public void tester()
{
  //String lines[] = loadStrings("palindromes.txt");
  String[] lines = new String[6]; 
    try{
        File myFile = new File("palindromes.txt");
        Scanner myReader = new Scanner(myFile);
        int counter = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            lines[counter] = data;
            counter++;
        }
        myReader.close();
    }
    catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
  System.out.println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(palindrome(lines[i])==true)
    {
      System.out.println(lines[i] + " IS a palindrome.");
    }
    else
    {
      System.out.println(lines[i] + " is NOT a palindrome.");
    }
  }
}
public boolean palindrome(String word)
{
  String sWord = noSpaces(word);
  sWord = onlyLetters(sWord);
  sWord = noCapitals(sWord);
  String sWord2 = noSpaces(word);
  sWord2 = onlyLetters(sWord2);
  sWord2 = noCapitals(sWord2);
  if (sWord.equalsIgnoreCase(reverse(sWord2)))
  return true;
  else

  return false;
}
public String reverse(String str)
{
    String sNew = new String();
    for(int i = 0; i < str.length(); i++){
    sNew = str.charAt(i) + sNew;
    return sNew;
  }
}
public String onlyLetters(String sString){
  String word = "";
  for(int i = 0; i < sString.length(); i++){
  if(Character.isLetter(sString.charAt(i)) == true){
  word = word + sString.charAt(i);
    }
  }
  return word; 
}


public String noSpaces(String sWord){
  if(sWord == ""){
  return sWord;
  }
  String word = "";
  for(int i = 0; i < sWord.length()-1; i++){
  if (sWord.substring(i,i+1).equals(" ") == false){
  word = word + sWord.substring(i,i+1);
    }
  }
  return word + sWord.substring(sWord.length()-1);
}


public String noCapitals(String sWord){
  return sWord.toLowerCase();
}
  
}//end of checker
