public class InternApplicant extends Applicant{
    private double gpa;
    
    /**
    Assign values to the instance variables of an InternApplicant object.
    Pre-condition: The constructor must be properly called and the constructor of the Applicant class is created.
    Post-condition: Instance variables are assigned values.
    
    @param n - the String name of the applicant
    @param a - the integer age of the applicant
    @param g - the String gender of the applicant
    @param r - the String race of the applicant
    @param eL - the String highest education level of the applicant
    @param yOE - the integer number of years of experience the candidate has
    @param gpa - the double gpa an intern has
    */
    public InternApplicant(String n, int a, String g, String r, String eL, int yOE, double gpa){
        super(n, a, g, r, eL, yOE);
        super.setPosition("Intern");
        this.gpa = gpa;
    }
    /**
    Returns the gpa of a given InternApplicant object.
    Pre-condition: InternApplicant object must be initialized.
    Post-condition: Returns the gpa instance variable acessed from the InternApplicant object
    
    @return gpa - the double gpa of the InternApplicant object
    */
    @Override
    public double getGPA(){
        return gpa;
    }
    /**
    Sets the gpa of a given InternApplicant object.
    Pre-condition: InternApplicant object must be initialized.
    Post-condition: The instance variable gpa is updated using the parameter of the method.
    
    @param g - the double gpa of the InternApplicant object the instance variable gpa will be updated to
    */
    @Override
    public void setGPA(int g){
        gpa = g;
    }
}