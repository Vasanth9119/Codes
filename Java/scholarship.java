import java.util.*;
class scholarship
{
    public static int main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        double CGPA,att,income;
        System.out.println("Enter your CGPA ");
        CGPA =sc.nextDouble();
        System.out.println("Enter your attendance ");
        att =sc.nextDouble();
        System.out.println("Enter your income ");
        income =sc.nextDouble();
        if(CGPA<8.5)
        {
            System.out.println("Not Eligible");
            return 0;
        }
        else if(att<85)
        {
            System.out.println("Not Eligible");
            return 0;
        }
        else if(income>500000)
        {
            System.out.println("Not Eligible");
            return 0;
        }
        else if(CGPA >= 9.5)
        {
            System.out.println("Eligible\nScholarship: Rs.50,000");
            return 0;
        }
        else if(CGPA < 9.5 && CGPA >= 9)
        {
            System.out.println("Eligible\nScholarship: Rs.35,000");
            return 0;
        }
        else
        {
            System.out.println("Eligible\nScholarship: Rs.20,000");
            return 0;
        }
    }
}