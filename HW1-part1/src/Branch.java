
/**
 * @author Elif Goral
 * 		   171044003
 * 
 */
public class Branch {
  private String BranchName =  "";

  public Branch(String BranchName) {
		this.BranchName = BranchName;
  }

  /**
   * That function returns Branch's Name.
   * @return  BranchName
   */
  public String getBranchName() {
		return BranchName;
  }

  /**
   * That function assign that parameter to the Branch's Name.
   * @param branchName Branch Name
   */
  public void setBranchName(String branchName) {
		BranchName = branchName;
  }

}
