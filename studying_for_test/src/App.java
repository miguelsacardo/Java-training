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
        int numbers_count = 1;

        System.out.println("Write a number to check if is prime: ");
        int number_to_check = Integer.parseInt(input.nextLine());
        while(numbers_count <= number_to_check)
        {
            if(number_to_check % numbers_count == 0)
            {
                System.out.println(numbers_count);
                divisors += 1;
            }

            numbers_count += 1;
        }

        if(divisors == 2)
        {
            System.out.println("The number " + number_to_check + " is prime!");
        }
        else
        {
            System.out.println("The number " + number_to_check + " is not prime!");
        }
        System.out.printf("divisors: %d", divisors);
    }
}
