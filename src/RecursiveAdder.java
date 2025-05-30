import java.util.ArrayList;

/**
Takes an ArrayList containing String objects and assigns all values to a different ArrayList
Pre-condition: source and destination are properly instantiated and source.size()>0
Post-condition: source and destination contains the same String objects, destination.size()== source.size()
@param ArrayList<String> source - an ArrayList containing String objects that must be copied
@param ArrayList<String> destination - an ArrayList containing String objects where the objects in source will be copied to
@param int index - the index at which the method starts adding objects from source to the destination
*/
public class RecursiveAdder {
    public static void copyList (ArrayList<String> source, ArrayList<String> destination, int index){
        if (index>=source.size()){
            return; //base case, stop when the index is larger than the ArrayList
        }
        destination.add(source.get(index)); //add the current String
        
        copyList(source, destination, index+1); //switch to next index
    }
    
    
}
