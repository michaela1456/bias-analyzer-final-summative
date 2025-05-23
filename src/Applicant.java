
public class Applicant {
    private String name;
    private int age;
    private String gender;
    private String race;
    private String educationLevel;
    private int yearsOfExperience;
    private String position;
    
    /**
    Assign values to the instance variables of an Applicant object.
    Pre-condition: The constructor must be properly called.
    Post-condition: Instance variables are assigned values.
    
    @param n - the String name of the applicant
    @param a - the integer age of the applicant
    @param g - the String gender of the applicant
    @param r - the String race of the applicant
    @param eL - the String highest education level of the applicant
    @param yOE - the integer number of years of experience the candidate has
    */
    public Applicant(String n, int a, String g, String r, String eL, int yOE){
        name = n;
        age = a;
        gender = g;
        race = r;
        educationLevel = eL;
        yearsOfExperience = yOE;
    }
    /**
    Returns the name of a given Applicant object.
    Pre-condition: Applicant object must be initialized.
    Post-condition: Returns the name instance variable acessed from the Applicant object
    
    @return name - the String name of the Applicant object
    */
    public String getName(){
        return name;
    }
    
    /**
    Sets the name of a given Applicant object.
    Pre-condition: Applicant object must be initialized.
    Post-condition: The instance variable name is updated using the parameter of the method.
    
    @param name - the String name of the Applicant object the instance variable name will be updated to
    */
    public void setName(String name){
        this.name = name;
    }
    /**
    Returns the age of a given Applicant object.
    Pre-condition: Applicant object must be initialized.
    Post-condition: Returns the age instance variable acessed from the Applicant object.
    
    @return age - the integer age of the Applicant object
    */
    public int getAge(){
        return age;
    }
    /**
    Sets the age of a given Applicant object.
    Pre-condition: Applicant object must be initialized.
    Post-condition: The instance variable age is updated using the parameter of the method.
    
    @param age - the integr age of the Applicant object the instance variable age will be updated to
    */
    public void setAge(int age){
        this.age = age;
    }
    /**
    Returns the gender of a given Applicant object.
    Pre-condition: Applicant object must be initialized.
    Post-condition: Returns the gender instance variable acessed from the Applicant object.
    
    @return gender - the String gender of the Applicant object
    */
    public String getGender(){
        return gender;
    }
    /**
    Sets the gender of a given Applicant object.
    Pre-condition: Applicant object must be initialized.
    Post-condition: The instance variable gender is updated using the parameter of the method.
    
    @param gender - the String gender of the Applicant object the instance variable gender will be updated to
    */
    public void setGender(String gender){
        this.gender = gender;
    }
    /**
    Returns the race of a given Applicant object.
    Pre-condition: Applicant object must be initialized.
    Post-condition: Returns the race instance variable acessed from the Applicant object.
    
    @return race - the String race of the Applicant object
    */
    public String getRace(){
        return race;
    }
    /**
    Sets the race of a given Applicant object.
    Pre-condition: Applicant object must be initialized.
    Post-condition: The instance variable race is updated using the parameter of the method.
    
    @param race - the String race of the Applicant object the instance variable race will be updated to
    */
    public void setRace(String race){
        this.race = race;
    }
    /**
    Returns the education level of a given Applicant object.
    Pre-condition: Applicant object must be initialized.
    Post-condition: Returns the educationLevel instance variable acessed from the Applicant object.
    
    @return educationLevel - the String indicating the highest level of education of a given Applicant object
    */
    public String getEducation(){
        return educationLevel;
    }
    /**
    Sets the education level of a given Applicant object.
    Pre-condition: Applicant object must be initialized.
    Post-condition: The instance variable educationLevel is updated using the parameter of the method.
    
    @param education - the highest level of education the instance variable educationLevel will be updated to
    */
    public void setEducation(String education){
        educationLevel = education;
    }
    /**
    Returns the years of experience of a given Applicant object.
    Pre-condition: Applicant object must be initialized.
    Post-condition: Returns the yearsOfExperience instance variable acessed from the Applicant object.
    
    @return yearsOfExperience - the int indicating the years of experience for the position of a given Applicant object
    */
    public int getExperience(){
        return yearsOfExperience;
    }
    /**
    Sets the years of experience of a given Applicant object.
    Pre-condition: Applicant object must be initialized.
    Post-condition: The instance variable yearsOfExperience is updated using the parameter of the method.
    
    @param experience - the integer years of experience the instance variable yearsOfExperience will be updated to
    */
    public void setExperience(int experience){
        yearsOfExperience = experience;
    }
    /**
    Returns the position the applicant is applying for (set in the subclasses of Applicant)
    Pre-condition: Applicant object must be initialized.
    Post-condition: Returns the position instance variable acessed from the Applicant object.
    
    @return position - the String indicating the position a given Applicant object is applying for
    */
    public String getPosition(){
        return position;
    }
    /**
    Sets the position of a given Applicant object.
    Pre-condition: Applicant object must be initialized.
    Post-condition: The instance variable position is updated using the parameter of the method.
    
    @param p - the position the instance variable position will be updated to
    */
    public void setPosition(String p){
        position = p;
    }
    //The rest of the methods are overriden in the subclasses
    //javadoc comments are provided in the subclass for each of the methods
    
    public double getGPA(){
        return 0.0;
    }
    
    public void setGPA(int g){
        
    }
    
     public int getLeadershipExperience(){
        return 0;
    }

    public void setLeadershipExperience(int lE){
        
    }
    
    public int getNumCert(){
        return 0;
    }
    
    public int getNumLanguages(){
        return 0;
    }
}
