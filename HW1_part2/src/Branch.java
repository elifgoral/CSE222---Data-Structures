
/**
 * class of Branch
 * @author Elif Goral
 * 		    171044003
 *
 */
import java.util.ArrayList;

public class Branch extends Company{
	
    private String BranchName;
    public ArrayList<BranchEmployee> BranchEmp = new ArrayList<BranchEmployee>();
    public ArrayList<TransportationPersonel> TransPer = new ArrayList<TransportationPersonel>();

	public Branch(String BranchName) {
		this.BranchName = BranchName;
	}
        
    /**
     * That method returns Branch's Name.
     * @return BranchName
     */
    public String getBranchName() {
		return BranchName;
	}

	/**
	 * That method sets the Branch's Name.
	 * @param branchName that name will be assign to Branch's Name.
	 */
	public void setBranchName(String branchName) {
		BranchName = branchName;
	}
}
