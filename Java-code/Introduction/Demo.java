

import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.io.Console;
public class Demo{

    void dataTypes() {
        short b = 20000;
        System.out.println("byte value is "+ b);

        boolean soldOut = true;
        System.out.println(soldOut);

        char character = '1';
        System.out.println(character);

        String name = "Hemanth";
        System.out.println(name);
    }

    void arraysLearnings() {
        // Declar int arr of size 50
        int arr[] = new int[50];
        int i, j;
        for(i = 1, j = 2; i <= 50; i++, j+=2){
            arr[i - 1] = j;
        }
        System.out.println(Arrays.toString(arr));

        // 2D array amtrix
        int[][] newArr = new int[3][4]; 
        System.out.println(newArr);
    }

    double loopings(Scanner scan) {
        double n, sum = 0.0;
        System.out.println("Enter number but when negative number entered the loop breaks: ");

        while (true) {
            n = scan.nextDouble();
            if (n < 0.0)
                break;
            sum += n;
        }
        // System.out.println(sum);
        return sum;
    }

    int loopingControlStatements(Scanner scan) {

        int limit = scan.nextInt();
        int sumValue = 0;
        outerLoop:
        for (int i = 0; i <= limit; i++) {
            innerLoop:
            for (int j = 0; j <= limit; j++) {
                if (i == 3){
                    if(j % 4 == 0) {
                        System.out.println("Broke from outerloop");
                        break outerLoop;
                    } else if (j % 3 == 0) {
                        System.out.println("Broke from innerloop");
                        break innerLoop;
                    }
                }
                sumValue += i*j;
            }
        }

        return sumValue;
    }

    void switchCase(Scanner scan) {
        System.out.println("Enter a number from 1 to 7");
        int integer = scan.nextInt();

        switch (integer) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursady");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                break;
        }

        System.out.println("Enter any alphabet ");
        int alphabet = scan.next().charAt(0);

        switch (alphabet) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                System.out.println("Vowel");
                break;
            default:
                System.out.println("Consonant");;
        }
    }
    
    void getUserInput(Scanner scan) {
        
        System.out.println("Enter your name ?");
        String name = scan.nextLine();

        System.out.println("What is your rating?");
        int rating = scan.nextInt();

        System.out.println("Enter short? ");
        short var = scan.nextShort();
        scan.nextLine();

        System.out.println("Enter string? ");
        String name2 = scan.nextLine();

        System.out.println("Your name is " + name + " and your rating is "+ rating + " and the short value is "+ var + name2);
        
    }
    
    void pyramid(Scanner scan){
        int pyramidValue = scan.nextInt();
        for(int i = 0; i < pyramidValue; i++) {
            for(int j = 0; j < pyramidValue; j++) {
                if(j < pyramidValue - i - 1){
                    System.out.print(" ");
                } else {
                    System.out.print("#");
                }
            } 
            System.out.println();
        }
    }
    
    int leetCodeMissingNumbers(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i< n; i++) {
            sum += nums[i];
        }
        System.out.print(n * (n+1)/2 - sum);
        return n * (n+1)/2 - sum;
    }
    

    void getUserInputFiles() {
        try {
            File newFile = new File("sample.txt");
            Scanner obj = new Scanner(newFile);
    
            while (obj.hasNextLine()) {
                String data = obj.nextLine();
                System.out.println(data);
            }
            obj.close();

        } 
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Congrats Hemanth for starting Java");

        Scanner scan = new Scanner(System.in);
        Demo newDemo = new Demo();

        // newDemo.arraysLearnings();
        // newDemo.dataTypes();
        // newDemo.switchCase(scan);
        // newDemo.getUserInput(scan);
        // newDemo.pyramid(scan);

        // double result = newDemo.loopings(scan);
        // System.out.println(result);

        // int sumValue = newDemo.loopingControlStatements(scan);
        // System.out.print(sumValue);

        // int[] nums = {9,6,4,2,3,5,7,0,1};
        // newDemo.leetCodeMissingNumbers(nums);

        newDemo.getUserInputFiles();

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        System.out.println("Enter your name: ");
        String name = reader.readLine();
        System.out.println("You entered: ");
        System.out.println(name);
        

        Console c = System.console();
        System.out.println("Expected Salary?");
        String str = c.readLine();
        System.out.println(str);
        System.out.println("Enter password? ");
        char[] pass = c.readPassword();
        System.out.println(pass);


        scan.close();
    }
}