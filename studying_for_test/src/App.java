import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        // show numbers 1 to 100 
        // Numbers divisible by 3 by "Fizz"
        // Numbers divisible by 5 by "Buzz"
        // Numbers divisible by 3 and 5 by "FizzBuzz"

        int i = 1;
        while(i <= 100)
        {

            if(i % 3 == 0 && i % 5 == 0)
            {
                System.out.printf("The number %d is FizzBuzz!\n", i);
            }
            else if(i % 3 == 0)
            {
                System.out.printf("The number %d is Fizz!\n", i);
            }
            else if(i % 5 == 0)
            {
                System.out.printf("The number %d is Buzz!\n", i);
            }
            i += 1;
        }

        // check if a number is prime
        int divisors = 0;
        int numbers = 20;

        System.out.println("Write a number to check if is prime: ");
        int number_to_check = Integer.parseInt(input.nextLine());
        while(numbers > 0)
        {
            if(number_to_check % numbers == 0)
            {
                divisors += 1;
            }
        }

        

    }
}
