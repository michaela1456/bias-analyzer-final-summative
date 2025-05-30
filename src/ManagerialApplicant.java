import java.util.ArrayList;
public class ManagerialApplicant extends Applicant{
    private int leadershipExperience;
    private ArrayList<String> managementCertifications = new ArrayList<String>();
    
    /**
    Assign values to the instance variables of a ManagerialApplicant object.
    Pre-condition: The constructor must be properly called and the constructor of the Applicant class is created.
    Post-condition: Instance variables are assigned values.
    
    @param n - the String name of the applicant
    @param a - the integer age of the applicant
    @param g - the String gender of the applicant
    @param r - the String race of the applicant
    @param eL - the String highest education level of the applicant
    @param yOE - the integer number of years of experience the candidate has
    @param lE - the intger number of years of leadership experience the candidate has
    @param mc - the String ArrayList containing the names of the ManagerialApplicant object's certificications
    */
    public ManagerialApplicant(String n, int a, String g, String r, String eL, int yOE, int lE, ArrayList<String> mc){
        super(n, a, g, r, eL, yOE);
        super.setPosition("Manager");
        leadershipExperience = lE;
        RecursiveAdder.copyList(mc, managementCertifications, 0);
        
    }
    /**
    Returns the leadership experience of a given ManagerialApplicant object.
    Pre-condition: ManagerialApplicant object must be initialized.
    Post-condition: Returns the leadershipExperience instance variable acessed from the ManagerialApplicant object
    
    @return leadershipExperience - the integer years of leadership experience of the ManagerialApplicant object
    */
    public int getLeadershipExperience(){
        return leadershipExperience;
    }
    /**
    Sets the years of leadership experience of a given ManagerialApplicant object.
    Pre-condition: ManagerialApplicant object must be initialized.
    Post-condition: The instance variable leadershipExperience is updated using the parameter of the method.
    
    @param lE - the integer number of years of leadership experience the instance variable leadershipExperience will be updated to
    */
    public void setLeadershipExperience(int lE){
        leadershipExperience = lE;
    }
    /**
    Returns the number of certifications of a given ManagerialApplicant object.
    Pre-condition: ManagerialApplicant object must be initialized.
    Post-condition: Returns the size of the managementCertifications ArrayList acessed from the ManagerialApplicant object
    
    @return managementCertifications.size() - the integer number of certifications ManagerialApplicant object has
    */
    public int getNumCert(){
        return managementCertifications.size();
    }
    
}
