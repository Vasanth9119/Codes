import java.util.*;

class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i;
        System.out.println("Enter the value of i");
        i = sc.nextInt();
        
        // Display the entered value
        System.out.println("You entered: " + i);
        
        sc.close(); // good practice to close Scanner
    }
}

