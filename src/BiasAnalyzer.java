import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class BiasAnalyzer {
   private ArrayList<String> applicants;
   private double biasThreshold;
   
   /**
    Assign values to the instance variables of a BiasAnalyzer object.
    Pre-condition: The constructor must be properly called.
    Post-condition: Instance variables are assigned values.
    
    @param a - the ArrayList of Strings containing the names of the applicants
    @param bT - the double indicating the desired biasThreshold for the BiasAnalyzer object
    */
   public BiasAnalyzer(ArrayList<String> a, double bT){
       for (String s: a){
           applicants.add(s);
       }
       biasThreshold = bT;
   }
   
   /**
    Returns the biasThreshold of a given BiasAnalyzer object.
    Pre-condition: BiasAnalyzer object must be initialized.
    Post-condition: Returns the biasThreshold instance variable acessed from the BiasAnalyzer object
    
    @return biasThreshold - the double indicating the desired biasThreshold for the BiasAnalyzer object
    */
   public double getBiasThreshold(){
       return biasThreshold;
   }
   
   /**
    Returns the HashMap of Applicant and Double objects of a given BiasAnalyzer object.
    Pre-condition: BiasAnalyzer object must be initialized.
    Post-condition: Returns a HashMap biasScores
    
    @param applicants - the ArrayList with the applicant objects in the original text file
    @return biasScores - the LinkedHashMap indicating the Applicant objects from an ArrayList applicants and their respective bias score
    */
  //retreieved from https://builtin.com/articles/hashmap-in-java
   public Map<Applicant, Double> analyzeBias(ArrayList<Applicant> applicants){
       mergeSort(applicants, applicants.size());   //sorts the applicants ArrayList
       Map <Applicant, Double> biasScores = new LinkedHashMap<>(); 
       
       //iterates through the applicants ArrayList and adds the Applicants object and bias score to the LinkedHashMap object
       for (Applicant a: applicants){
           double score = calculateBiasScore(a); 
           biasScores.put(a, score);
       }
       return biasScores;
   }
   
   /**
    The ArrayList of Applicant objects applicants is sorted recursively from most to least years of experience.
    Pre-condition: Applicant objects must be initialized.
    Post-condition: An ArrayList of Applicant objects in a sorted order is produced.
    
    @param applicants - the ArrayList with the Applicant objects that must be sorted
    @param length - the integer indicating the length of the applicants ArrayList
    */
   private static void mergeSort(ArrayList<Applicant> applicants, int length){
       //base case, once length is 1 it should return
       if (length==1){
           return;
       }
       
       //determine the middle of the ArrayList to assign values to the left and right ArrayLists
       int mid = length/2;
       ArrayList<Applicant> left = new ArrayList<>(applicants.subList(0, mid));
       ArrayList<Applicant> right = new ArrayList<>(applicants.subList(mid, length));
       
       
       //sort the left array
       mergeSort(left, mid);
       //sort the right array
       mergeSort(right, length-mid);
       //merge the two arrays together
       merge(applicants, left, right);
   }
   
   /**
    Updates an ArrayList so it is ordered from most to least years of experience.
    Pre-condition: Applicant objects must be initialized and left and right side Arrays must be sorted.
    Post-condition: Updates the applicant ArrayList of Applicant objects from most years of experience to least.
    
    @param left - the ArrayList object containing the left portion of the original ArrayList (sorted)
    @param right - the ArrayList object containing the right portion of the original ArrayList (sorted)
    */
   private static void merge(ArrayList<Applicant> applicant, ArrayList<Applicant> left, ArrayList<Applicant> right){
       int i = 0, j = 0, k=0;
       
       //iterate through the left and right ArrayList
       while (i<left.size()&& j<right.size()){
           /*if the applicant in the left ArrayList has more experience than the applicant in the right array, 
           the object from the left ArrayList is placed in the applicant ArrayList first */
           if (left.get(i).getExperience()>=right.get(j).getExperience()){
               applicant.set(k, left.get(i));
               k++;
               i++;
            /* if not, the object in the right array gets placed in the applicant ArrayList first*/
           }else{
               applicant.set(k,right.get(j));
               k++;
               j++;
           }
       }
       //adds any remaining objects from the left ArrayList into the applicant ArrayList
       while (i<left.size()){
           applicant.set(k, left.get(i));
           k++;
           i++;
       }
       //adds any remaining objects from the right ArrayList into the applicant ArrayList
       while (j<right.size()){
           applicant.set(k, right.get(j));
           k++;
           j++;
       }
   }
   
   /**
    Returns a bias score for a given Applicant object.
    Pre-condition: Applicant objects and BiasAnalyzer objects must be initialized.
    Post-condition: Returns a double bias score that begins at the threshold and gets points
                    added or subtracted depending on the applicant's demographics.
    
    @param applicant - the Applicant object the bias score is being given to
    @return score - the ArrayList with the sorted Applicant object from most years of experience to least
    */
   private double calculateBiasScore(Applicant applicant){
       //the score is set to the biasThreshold for the BiasAnalyzer object
       double score = this.biasThreshold;
       
       /*if an applicant is less than 25 or older than 50, they are less likely to get hired for a position, 
       increasing their score*/
       if (applicant.getAge()<25){
           score += 1.0;
       }else if (applicant.getAge()>50){
           score +=1.5;
       }
       //if an applicant is not a male, they are less likely to get hired for a position
       if (!("male".equalsIgnoreCase(applicant.getGender()))){
           score += 1.2;
       }
       //if an applicant is not white, they are less likely to get hired for a position
       if(!("white".equalsIgnoreCase(applicant.getRace()))){
           score += 1.3;
       }
       //if an applicant has a PhD, they are more likely to get hired, decreasing their score
       if ("PhD".equalsIgnoreCase(applicant.getEducation())){
           score -=0.5;
       }
       /*for every year of experience an applicant has, 0.1 is deducted from their score since
       they are more likely to get hired*/
       score -= 0.1*applicant.getExperience();
       
       /*if the applicant is applying to a Managerial position, their score is deduced by 0.1 for every year of
       leadership experience they have and 0.05 is deducted for every certification they have*/
       if ("Manager".equalsIgnoreCase(applicant.getPosition())){
           score -= 0.1*applicant.getLeadershipExperience();
           score -= 0.05*applicant.getNumCert();
       }
       /*if the applicant is applying to a Technical position such as Software Engineer, their score is deducted
       by 0.1 for every programming language they know and 0.05 is deducted for every certfication they have*/
       if ("Software Engineer".equalsIgnoreCase(applicant.getPosition())){
           score -= 0.1*applicant.getNumLanguages();
           score -= 0.05*applicant.getNumCert();
       }
       //if the applicant is applying to an Intern position, their score is deducted by 0.1 times their GPA
       if ("Intern".equalsIgnoreCase(applicant.getPosition())){
           score -= 0.1*applicant.getGPA();
       }
       
       return score;
   }
}
