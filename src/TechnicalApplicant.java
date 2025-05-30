import java.util.ArrayList;
public class TechnicalApplicant extends Applicant{
   private ArrayList<String> programmingLanguages = new ArrayList<String>();
   private ArrayList<String> certifications = new ArrayList<String>();
   
   /**
    Assign values to the instance variables of an TechnicalApplicant object.
    Pre-condition: The constructor must be properly called and the constructor of the Applicant class is created.
    Post-condition: Instance variables are assigned values.
    
    @param n - the String name of the applicant
    @param a - the integer age of the applicant
    @param g - the String gender of the applicant
    @param r - the String race of the applicant
    @param eL - the String highest education level of the applicant
    @param yOE - the integer number of years of experience the candidate has
    @param pL - the ArrayList of Strings of the programming languages an applicant knows
    @param c - the ArrayList of Strings of the certifications an applicant has
    */
   public TechnicalApplicant(String n, int a, String g, String r, String eL, int yOE, ArrayList<String> pL, ArrayList<String> c){
        super(n, a, g, r, eL, yOE);
        super.setPosition("Software Engineer");
        RecursiveAdder.copyList(pL, programmingLanguages, 0);
        RecursiveAdder.copyList(c, certifications, 0);
    }
    /**
    Returns the number of certifications of a given TechnicalApplicant object.
    Pre-condition: TechnicalApplicant object must be initialized.
    Post-condition: Returns the size of the certifications ArrayList acessed from the TechnicalApplicant object
    
    @return certifications.size() - the integer number of certifications the TechnicalApplicant object has
    */
    public int getNumCert(){
        return certifications.size();
    }
    /**
    Returns the number of programming languages a given TechnicalApplicant object has.
    Pre-condition: TechnicalApplicant object must be initialized.
    Post-condition: Returns the size of the programmingLanguages ArrayList acessed from the Applicant object
    
    @return programmingLanguages.size() - the integer number of programming languages the applicant knows
    */
    public int getNumLanguages(){
        return programmingLanguages.size();
    }
}
