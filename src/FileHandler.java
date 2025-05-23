import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class FileHandler {
    private BiasAnalyzer analyzer;
    
    /**
    Assign values to the instance variables of an FileHandler object.
    Pre-condition: The constructor must be properly called.
    Post-condition: Instance variables are assigned values.
    
    @param bT - a double value indicating the threshold for the bias scores in the BiasAnalyzer object.
    */
    public FileHandler(double bT){
        this.analyzer = new BiasAnalyzer(new ArrayList<String>(), bT);
    }
    
    /**
    Writes the hiring data into the output txt file.
    Pre-condition: The input and output file paths are valid.
    Post-condition: The lines of text are writen in the output file or the type of error is printed.
    
    @param inputFilePath - the file path for the input file (applicant data)
    @param outputFilePath - the file path for the output file (hiring data)
    */
    public void processApplicants(String inputFilePath, String outputFilePath) throws IOException{
        //create an ArrayList of Applicant objects using the loadApplicants method
        ArrayList<Applicant> applicants = loadApplicants(inputFilePath);
        
        //use the analyzeBias method from the BiasAnalyser class to create a LinkedHashMap of the applicants and their scores
        Map<Applicant, Double> scores = analyzer.analyzeBias(applicants);

        //retrieved from https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
        //a new FileWriter object is created for the output file path
        try (FileWriter writer = new FileWriter(outputFilePath)){
            //retrieved from https://www.geeksforgeeks.org/iterate-map-java/
            /*for every entry in the LinkedHashMap scores, it is determined if the applicant should be hired or not
            using the getBiasThreshold method from the BiasAnalyzer class*/
            for (Map.Entry<Applicant, Double> entry: scores.entrySet()){
                Applicant a = entry.getKey();
                double score = entry.getValue();
                String decision = "";
                if (score>=analyzer.getBiasThreshold()){
                    decision = "Hired";
                }else{
                    decision = "Not Hired";
                }
                //the format the output file will have for each line. Each line corresponds to an applicant
                String outputLine = a.getName() + ", Bias Score: "+String.format("%.2f", score)+","+ decision;
                writer.write(outputLine + System.lineSeparator());
            }
        //if an IOException in thrown, the type of error that occured will be displayed on the terminal
        }catch (IOException e ){
            e.printStackTrace();
        }
    }
    
    /**
    Identifies applicant attributes from the input file to define Applicant objects.
    Pre-condition: The file path must be valid.
    Post-condition: A list with Applicant objects created for each applicant to the company.
    
    @param filePath - the String file path for the inputed file where the hiring data is stored
    @return list - the ArrayList that stores the Applicant objects created from the hiring data
    */
    public ArrayList<Applicant> loadApplicants(String filePath) throws FileNotFoundException{
        ArrayList<Applicant> list = new ArrayList<>();
        File file = new File(filePath);
        try(Scanner scan = new Scanner(file)){
            
            //Start of code from ChatGPT
            //while the file has a line of applicant data
            while (scan.hasNextLine()){
                String line = scan.nextLine().trim();
                //if the line is empty, skip to next line and check again
                if (line.isEmpty()) continue;
                //divide the line in the txt file into a String array, each String is seperated by a comma
                String[] parts = line.split(",");
                //Assign values to variables base on the array parts, parsing to an int when necessary
                String name = parts[0];
                int age = Integer.parseInt(parts[1]);
                String gender = parts[2];
                String race = parts[3];
                String education = parts[4];
                int experience = Integer.parseInt(parts[5]);
                String position = parts[6];
                //end of code from ChatGPT
                
                /*if the applicant is applying to be an intern, assign the last few Strings in the parts array
                to the variables and create an InterApplicant object using the variables*/
                if (position.equalsIgnoreCase("Intern")){
                    int gpa = Integer.parseInt(parts[7]);
                    Applicant a = new InternApplicant(name, age, gender, race, education, experience, gpa);
                    //add the Applicant object to the ArrayList list
                    list.add(a);
                }
                /*if the applicant is applying to be a manager, assign the last few Strings in the parts array
                to the variables and create a Manager Applicant object using the variables*/
                if (position.equalsIgnoreCase("Manager")){
                    int lE = Integer.parseInt(parts[7]);
                    String[] certArray = parts[8].split(";");
                    ArrayList<String> certifications = new ArrayList<>();
                    for (String cert : certArray) {
                        certifications.add(cert.trim());
                    }
                    Applicant a = new ManagerialApplicant(name, age, gender, race, education, experience, lE, certifications);
                    //add the Applicant object to the ArrayList list
                    list.add(a);
                }
                
                /*if the applicant is applying to be a manager, assign the last few Strings in the parts array
                to the variables and create a Technical Applicant object using the variables*/
                if(position.equalsIgnoreCase("Software Engineer")){
                    String[] programLang = parts[7].split(";");
                    ArrayList<String> pL = new ArrayList<>();
                    for (String p : programLang) {
                        pL.add(p.trim());
                    }
                    String[] certArray = parts[8].split(";");
                    ArrayList<String> certifications = new ArrayList<>();
                    for (String cert : certArray) {
                        certifications.add(cert.trim());
                    }
                    Applicant a = new TechnicalApplicant(name, age, gender, race, education, experience, pL, certifications);
                    //add the Applicant object to the ArrayList list
                    list.add(a);
                }
            }
        }
        return list;
    }
   
}