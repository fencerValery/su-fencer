public class Hello{
  public static int factorial(int x){
    if (x == 1){
       return x;
    }
       return factorial(x - 1) * x;  
  }


   // for forward code from decimal to binary
   public static String translationDecimalToBinaryInt(int xx){
     int x = Math.abs(xx);
     StringBuilder  str= new StringBuilder("00000000000000000000000000000000");
     
       if (xx >= 0){
         for (int i = str.length(); i >= 0; i--){
           int y = x % 2;    
           x /= 2;
           str.delete(i, i);
           str.insert(i, y);
             if (x == 0){
               break;
              }      
          }
       }
     
       if (xx < 0){
          for (int i = str.length(); i >= 0; i--){
            int y = x % 2;    
            x /= 2;
            str.delete(i, i);
            str.insert(i, y);
              if (x == 0){
                 str.deleteCharAt(0);
                 str.insert(0, 1);
                 break;
              }      
          }
      }
       return str.toString();
  }
  
}