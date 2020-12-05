import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
// @author TheMeladrone
public class FoodCostCalculator {

  public static void main(String[] args) {
    Scanner userTally = new Scanner(System.in);    
    Scanner platingPrice = new Scanner(System.in); 
    Scanner salePrice = new Scanner(System.in);
    double sellingFor = 0;
    double foodCost = 0;
    double read;     
    boolean repeat = true;



    System.out.println("WELCOME TO THE FOOD CALCULATOR");
    System.out.println("                  ██████████                ");
    System.out.println("            ██████░░░░  ░░░░██████          ");
    System.out.println("        ████  ░░  ░░░░░░░░░░░░░░░░████      ");
    System.out.println("      ██░░░░░░  ░░░░░░░░░░░░░░  ░░░░░░██    ");
    System.out.println("    ▓▓░░░░░░░░  ░░░░░░░░░░░░░░░░░░░░░░░░██  ");
    System.out.println("    ██░░░░░░░░░░░░░░░░  ░░░░  ░░░░    ░░██  ");
    System.out.println("  ██░░░░░░░░░░  ░░░░░░░░░░░░░░░░        ░░██");
    System.out.println("  ██░░░░░░  ░░░░░░░░░░░░░░░░  ░░░░      ░░██");
    System.out.println("  ██░░░░░░░░░░░░░░░░░░  ░░░░░░░░░░░░░░░░░░██");
    System.out.println("    ██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▓▓  ");
    System.out.println("   ██ ░░      ░░░░░░░░░░░░░░░░░░░░░░░░░░██  ");
    System.out.println("   ██ ░░░░        ░░░░░░░░░░░░░░  ░░░░░░██  ");
    System.out.println("    ▓▓░░        ░░░░░░  ░░░░░░░░  ░░░░    ▓▓");
    System.out.println("  ██▒▒▒▒                ░░      ▒▒▒▒░░▒▒▒▒██");
    System.out.println("    ▓▓▒▒░░  ░░░░    ░░  ▒▒▒▒  ▒▒▒▒▒▒▒▒▒▒██░░");
    System.out.println("  ██▒▒░░▒▒▒▒▒▒░░  ▒▒▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒▒▒▒▒▒██");
    System.out.println("  ██▒▒▒▒░░░░░░▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██");
    System.out.println("    ██▒▒░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██░░");
    System.out.println("    ██░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░██  ");
    System.out.println("      ▓▓░░░░░░▒▒░░▒▒▒▒░░▒▒░░░░░░░░░░░░▓▓    ");
    System.out.println("        ██░░░░░░░░░░░░░░░░░░░░░░░░░░██      ");
    System.out.println("          ██████░░░░░░░░░░░░░░██████        ");
    System.out.println("                ▓▓▓▓▓▓▓▓▓▓▓▓▓▓              ");

    promptEnterKey();

    System.out.println("Step 1: Break up your dish into individual ingredients. ");
    System.out.println("Step 2: Add the prices of each componet for one serve");
    System.out.println("");
    System.out.println("(10 items max, use 0's to fill in any excess fields)");
    System.out.println("");


    while(repeat){

      try{
        for(read = 10; read > 0; read--) {
          System.out.println("Enter price: ");
          System.out.print("$");
          foodCost += userTally.nextDouble();
          repeat = false;
        }
      }


      catch (InputMismatchException nfe) {
        System.out.println("You have entered a non numeric field value");
        System.out.println("Please try again");
        userTally.next();
        foodCost = 0;
        repeat = true;
      }
    }
    System.out.println("-------------------------------------"); 
    System.out.println("");
    System.out.println("Your total food cost is $" + foodCost);
    System.out.println("");
    System.out.println("-------------------------------------");
    double plating = foodCost;
    System.out.println("");
    System.out.println("What is your selling price of your dish ? ");
    System.out.print("$");

    repeat =true; 


    while(repeat){
      try{
        sellingFor = salePrice.nextDouble();

        System.out.println("");
        Calculations(plating,sellingFor); 
        repeat =false;
      }
      catch (InputMismatchException nfe) {
        System.out.println("You have entered a non numeric field value");
        System.out.println("Please try again");

        System.out.println("");
        salePrice.next();
        sellingFor = 0;
        repeat = true;
      }
    }

    System.out.println("");
  }


  private static void Calculations(double plating, double sellingFor){


    double  
      cost = plating / sellingFor * 100,

           profitPercentage = 100 - cost;


    DecimalFormat df2 = new DecimalFormat("#"); 

    System.out.println("The food is costing you " + df2.format(cost) + "%" +(" of your income per plate"));
    System.out.println();   


    System.out.println("-------------------------------------");
    System.out.println("");
    System.out.println("This gives you a profit of: " + df2.format(profitPercentage) + "%");
    System.out.println("");
    System.out.println("-------------------------------------");
    System.out.println("You should always make over 75% in food profit, if you're below, increase your price.");
    System.out.println();
  }


  public static  void promptEnterKey(){
    System.out.println("Press \"ENTER\" to continue...");
    Scanner scanner = new Scanner(System.in);
    scanner.nextLine();

  }

}




