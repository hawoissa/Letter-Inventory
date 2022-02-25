// Hawo Issa
// CSE 143 EG with Khushi Chaudhari
// Homework 1
// LetterInventory take every single letter from 
// a document and stores it in alphabetical order.
public class LetterInventory {
   
   private int[] elementData;
   private int size;
   
   private static final int NUM_ALPHABETS = 26;
   
   // Constructs an array of 26 and counts each
   // letter of the alphabet.
   public LetterInventory(String data) {
      elementData = new int[NUM_ALPHABETS];
      data = data.toLowerCase();
      for (int i = 0; i < data.length(); i++) {
         char letter = data.charAt(i);
         if (Character.isLetter(letter)) {
            elementData[letter - 'a']++;
            size++;
         }
      }    
   }
   
   // pre: character has to be a letter
   //      (throws IllegalArgumentException otherwise)
   // post: returns how much of the letter is stored
   // param: char letter - given letter we need to 
   //       find count of
   public int get(char letter) {
      if (!Character.isLetter(letter)) {
         throw new IllegalArgumentException();
      }
      letter = Character.toLowerCase(letter);
      return elementData[letter - 'a'];
   }
   
   // pre: Character must be a letter and value has to be 1+
   //       (throw IllegalArgumentException otherwise)
   // post: Sets the given letter count to the given value
   // param: char letter - specific letter we need to change, 
   //       int value - given value to change letter count to
   public void set(char letter, int value) {
      if (!Character.isLetter(letter) || value < 0) {
         throw new IllegalArgumentException();
      }
      letter = Character.toLowerCase(letter);
      int count = get(letter);
      size = size + value - count;
      elementData[letter - 'a'] = value;   
   }
   
   // post: Returns total sum of characters
   public int size() {
      return size;
   }

   // post: return true if size > 0,
   //       returns false if size < 0   
   public boolean isEmpty() {
      return size == 0;
   }
   
   // post: Organizes each character count
   //       in alphabetical order using brackets
   public String toString() {
      String result = "[";
      for (int i = 0; i < NUM_ALPHABETS; i++) {
         for (int j = 0; j < elementData[i]; j++) {
            result += (char) ('a' + i);
         }
      }
      result += "]";
      return result;
   }
   
   // post: Takes the LetterInventory of 2 classes and 
   //       adds them together
   // param: LetterInventor other - instance using LetterIventory
   public LetterInventory add(LetterInventory other) {
      LetterInventory sum = new LetterInventory("");
      for (int i = 0; i < NUM_ALPHABETS; i++) {
         sum.elementData[i] = this.elementData[i] + other.elementData[i];
      }
      sum.size = this.size + other.size;
      return sum; 
   }
   
   // post: Takes the LetterInventory of 2 classes and 
   //       subtracts them
   // param: LetterInventor other - instance using LetterIventory
   public LetterInventory subtract(LetterInventory other) {
      LetterInventory sub = new LetterInventory("");
      for (int i = 0; i < NUM_ALPHABETS; i++) {
         int result = this.elementData[i] - other.elementData[i];
         if (result < 0) {
            return null;
         }
         sub.elementData[i] = result;
      }
      sub.size = this.size - other.size;
      return sub;
   }

}