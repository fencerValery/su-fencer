public class Hello{
  public static int factorial(int x){
    if (x == 1){
       return x;
    }
       return factorial(x - 1) * x;  
  }
  public static void main(String[] args){
    System.out.print("Hello!");
    System.out.print("\nWorld!");
    System.out.print("\nFactorial = " + factorial(12));
  }
}