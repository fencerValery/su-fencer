


import java.util.ArrayList;



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


// abstract class, legacy, override equals and hashCode
public class RobotTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        RobotWorker one = new RobotWorker("Vasia");
        RobotWorker two = new RobotWorker("Petr");
        RobotWorker three = new RobotWorker("Den"); 
        RobotWorker four = new RobotWorker("Bob");
        RobotBandit banditMen = new RobotBandit("Gad", "aluminum");
        RobotBandit banditWomen = new RobotBandit("Gadya", "iron");
        ArrayList<RobotWorker> workers = new ArrayList<RobotWorker>();
        workers.add(one);
        workers.add(two);
        workers.add(three);
        workers.add(four);
        for (int i = 0; i < workers.size(); i++){
            workers.get(i).work((int)(Math.random()*19 + 1));
        }
        for (int i = 0; i < workers.size(); i++){
            System.out.print(workers.get(i).toString() + "\n");
        }
         System.out.print(banditMen.toString() + "\n");
         System.out.print(banditWomen.toString() + "\n");
       
         banditMen.attack(four);
         banditWomen.attack(four, two);
         
         for (int i = 0; i < workers.size(); i++){
            System.out.print(workers.get(i).toString() + "\n");
        }
         
         System.out.print(banditMen.toString() + "\n");
         System.out.print(banditWomen.toString() + "\n");
         RobotWorker fife = new RobotWorker("Bob");
         fife.setStrength(four.getStrength());
         System.out.print(four.toString() + "\n");
         System.out.print(fife.toString() + "\n");
         System.out.print(four.toString() + " " + four.hashCode() + "\n");
         System.out.print(fife.toString() + " " + fife.hashCode() + "\n");
         System.out.print(fife.equals(four) + "\n");
         
         
           // TODO code application logic here
    }
    
}



 abstract class Robots{
  private String name;
  private int strength;
  
  public String getName(){
    return name;
  }
  
  public void setName(String name){
    this.name = name;
  }
  
  public int getStrength(){
    return strength;
  }
  
  public void setStrength(int strength){
    this.strength = strength;
  }
  
  @Override
  public boolean equals(Object obj){
  
    if (obj == this){
	  return true;
	}
	if (obj == null || obj.getClass() != this.getClass()){
	  return false;
	}
	Robots rob = (Robots) obj;
        return strength == rob.strength && 
	(name == rob.name ||(name != null && name.equals(rob.name)));
  }
  
  @Override
  public int hashCode(){
    int x = strength * 3 + ((name == null) ? 0: name.hashCode());
	return x;
  }
  
  @Override
  public String toString(){
      return name + " strength = " +  strength;
  } 
  
  public abstract void chargingStrength(int x);
  public abstract void work(int x);
  
}


class RobotWorker extends Robots{
 public RobotWorker(String name){
  setName(name);
  setStrength (100);
 }
 
  public void chargingStrength(int x){
    setStrength(getStrength() + x);  
  }
  
  public void work(int x){
    setStrength(getStrength() - x);  
  }
 
}


class RobotBandit extends Robots{
 private String matireal;    

 public RobotBandit(String name, String matireal){
  setName(name);
  setStrength (100);
  this.matireal = matireal;
 }
 
 public String getMatireal(){
     return  matireal;
 }
 
  @Override
  public boolean equals(Object obj){
  
    if (obj == this){
	  return true;
	}
	if (obj == null || obj.getClass() != this.getClass()){
	  return false;
	}
	RobotBandit rob = (RobotBandit) obj;
        return getStrength() == rob.getStrength() && 
	( getName() == rob. getName() ||( getName() != null &&  getName().equals(rob. getName()))) && 
         ( matireal == rob. matireal ||( matireal != null &&  matireal.equals(rob. matireal)));
  }
  
  @Override
  public int hashCode(){
    int x = getStrength() * 3 + ((getName() == null) ? 0:getName().hashCode()) + (( matireal == null) ? 0: matireal.hashCode());
	return x;
  }
  
 
  public void chargingStrength(int x){
    setStrength(getStrength() + x);   
  }
  
  public void work(int x){
    setStrength(getStrength() - x); 
  }
 
   public <T extends Robots> void attack(T rob){
    rob.setStrength(rob.getStrength() - rob.getStrength()/3);
    setStrength(getStrength() + rob.getStrength()/3);  
  }
  
   public <T extends Robots> void attack(T rob, T rab){
    rob.setStrength( rob.getStrength() - rob.getStrength()/4);
    rab.setStrength(rab.getStrength() - rab.getStrength()/4);
    setStrength(getStrength() + rob.getStrength()/4 + rab.getStrength()/4);  
  }
   
  @Override
  public String toString(){
      return getName() + " charging = " +  getStrength() + " consist of " + matireal;
  } 
}






