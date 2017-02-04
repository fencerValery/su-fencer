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
     StringBuilder  str = new StringBuilder("00000000000000000000000000000000");
      System.out.println(str.length());
       if (xx >= 0){
         for (int i = str.length() - 1; i >= 0; i--){
           int y = x % 2;    
           x /= 2;
           str.deleteCharAt(i);
           str.insert(i, y);
             if (x == 0){
               break;
              }      
          }
       }
       
      
       if (xx < 0){
          for (int i = str.length() - 1; i >= 0; i--){
            int y = x % 2;    
            x /= 2;
            str.deleteCharAt(i);
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

  public static int randomNumber(int a, int b){
    Random ran = new Random();
    int x = ran.nextInt(b - a) + a;
    return x;
  }

  public static int[] createMas(int x, int a, int b){
    int[] mas = new int[x];
     for (int i = 0; i < mas.length; i++){
       mas[i] = randomNumber(a, b);
     }
     return mas;
  }

  public static void printMas(int[] mas){
    for (int x: mas){
       System.out.print(x + " ");
    }
  }
  
  // lambda expression
  interface RandomNum{
  int createNum(int a, int b);
  }

 public static int[] createMasLambda(int z){
     
    RandomNum rt;
    rt = (x, y) -> (int)(Math.random()*(y - x) + x);    
    int[] mas = new int[10];
    for (int i = 0; i < mas.length; i++){
        mas[i] = rt.createNum(10, 40);
    }
     return mas;
 }
  
}