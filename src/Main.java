import java.io.IOException;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        //instructions and prompting for the user
        System.out.println("Welcome to the bias detector app!\n");
        System.out.println("This program takes a text file containing data about the applicants to your company and gives them a bias score.");
        System.out.println("The bias score is determined by analyzing the applicants race, gender, age, years of experience, education and their qualifications to a position.");
        System.out.println("For example, an intern's GPA and the number of programming languages a Software Engineer knows is analyzed.");
        System.out.println("If the applicant has a score greater than the inputed threshold, they would not be hired, likely due to biases.");
        System.out.println("This program is intended to highlight how potential biases may arise in the hiring process, especially when automated.\n");
        System.out.println("Please begin by inputing a bias threshold. This is ment to represent how inclusive a company's hiring strategy may be. The larger the threshold, the more inclusive the hiring strategy.");
        
        System.out.println("Please enter the bias threshold between 0 - 9 inclusive (can be a decimal number): ");
        double biasThreshold = input.nextDouble();
        input.nextLine();
        
        System.out.println("A txt file should be inputed with applicant data (one line per applicant) and will be parsed by the program to determine the bias score and if the candidate would be hired.");
        System.out.println("A txt file would be outputed with the hiring data. The inputed file does not have to be in any particular order, but the outputed data will be ordered from least years of experience to most.");
        
        System.out.println("Please enter the txt file path for the input file (applicant data): ");
        String inputFilePath = input.nextLine();
        input.nextLine();
        
        System.out.println("Please enter the txt file path for the output file (hiring data): ");
        String outputFilePath = input.nextLine();
        input.nextLine();
        
        //create a file handler object using the inputted biasThreshold variable
        FileHandler f = new FileHandler(biasThreshold);
        
        try{
            //call the processApplicants file using the input and output file paths inputted by the user
            f.processApplicants(inputFilePath, outputFilePath);
            //print the output file was successfully created
            System.out.println("Hiring report generated sucessfully at: "+outputFilePath);
        }catch (IOException e) {
            //if IOException thrown, indicate there was an error and why
            System.err.println("An error occurred while processing the applicants: " + e.getMessage());
        }   finally {
        }
        //close the Scanner object
        input.close();
    }
}