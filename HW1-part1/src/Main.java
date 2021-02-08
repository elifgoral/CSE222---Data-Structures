
/**
 * @author Elif Goral
 * 		   171044003
 * 
 */
public class Main {
  public static void main(String[] args)
  {
		
		Administrator admin = new Administrator("Elif","Goral");
		System.out.println("Adding Kucukyali Branch to the company branch list...");
		admin.addBranch("Kucukyali");
		System.out.println("Adding Bostanci Branch to the company branch list...");
		admin.addBranch("Bostanci");
		System.out.println("Adding Maltepe Branch to the company branch list...");
		admin.addBranch("Maltepe");
		System.out.println("Adding Kadiköy Branch to the company branch list...");
		admin.addBranch("Kadiköy");
		System.out.println();

		System.out.println("Branch list:");
		admin.printBranch();
		System.out.println("-------------------------------");

		System.out.println("Removing Bostanci Branch from the company branch list...");
		admin.removeBranch("Bostanci");
		System.out.println("Branch list:");
		admin.printBranch();
		System.out.println("-------------------------------");

		System.out.println("Removing Kadiköy Branch from the company branch list...");
		admin.removeBranch("Kadiköy");
		System.out.println("Branch list:");
		admin.printBranch();
		System.out.println("-------------------------------");
		
		System.out.println("Removing Kucukyali Branch from the company branch list...");
		admin.removeBranch("Kucukyali");
		System.out.println("Branch list:");
		admin.printBranch();
		System.out.println("-------------------------------");
		
		System.out.println("Removing Kucukyali Branch from the company branch list...");
		admin.removeBranch("Kucukyali");
		System.out.println("Branch list:");
		admin.printBranch();
		System.out.println("-------------------------------");
		System.out.println();
		
		System.out.println("Adding  Branch employee to the company branch employee list...");
		System.out.println("Adding  Ali - Veli - Aras Cargo to the company branch employee list...");
		admin.addBranchEmployee("Ali", " Veli", "Aras Cargo");
		System.out.println("Adding  Ahmet - Mehmet - Surat Cargo to the company branch employee list...");
		admin.addBranchEmployee("Ahmet", " Mehmet", "Surat Cargo");
		System.out.println("Adding  Hasan - Huseyin - MNG Cargo to the company branch employee list...");
		admin.addBranchEmployee("Hasan", " Huseyin", "MNG Cargo");
		System.out.println("Adding  Hasan - Huseyin - MNG Cargo to the company branch employee list...");
		admin.addBranchEmployee("Hasan", " Huseyin", "MNG Cargo");

		admin.printBranchE();
		System.out.println();
		System.out.println("Removing Ahmet - Mehmet - Surat Cargo from the company branch employee list...");
		admin.removeBranchEmployee("Ahmet", " Mehmet", "Surat Cargo");
		admin.printBranchE();
		System.out.println("-------------------------------");
		System.out.println();
		System.out.println("Removing Ahmet - Mehmet - Surat Cargo from the company branch employee list...");
		admin.removeBranchEmployee("Ahmet", " Mehmet", "Surat Cargo");
		admin.printBranchE();
		System.out.println("-------------------------------");

		System.out.println();
		
		System.out.println("Adding  Transportation personal to the company ...");
		System.out.println("Adding Elif Goral to the company Transportation personal list...");
		admin.addTransportationPersonal("Elif", "Goral");
		System.out.println("Adding Neslihan Goral to the company Transportation personal list...");
		admin.addTransportationPersonal("Neslihan", "Goral");
		System.out.println("Adding Levent Goral to the company Transportation personal list...");
		admin.addTransportationPersonal("Levent", "Goral");
		System.out.println("Adding Neslihan Goral to the company Transportation personal list...");
		admin.addTransportationPersonal("Neslihan", "Goral");
		System.out.println();

		admin.printTransportationPersonal();
		System.out.println();
		System.out.println("Removing Neslihan Goral from the company Transportation personal list...");
		admin.removeTransportationPersonal("Neslihan", "Goral");
		admin.printTransportationPersonal();
		System.out.println("-------------------------------");
		System.out.println();
		System.out.println("Removing Levent Goral from the company Transportation personal list...");
		admin.removeTransportationPersonal("Levent", "Goral");
		admin.printTransportationPersonal();
		System.out.println("-------------------------------");
		System.out.println("Removing Levent Goral from the company Transportation personal list...");
		admin.removeTransportationPersonal("Levent", "Goral");
		admin.printTransportationPersonal();

		System.out.println();

		BranchEmployee bemp = new BranchEmployee("Elif","Goral","aras Kargo");
		System.out.println("Adding customer to the company from Elif Goral ...");
		System.out.println("Adding Ipek Aa - 123 to the company customer list...");
		bemp.addCustomer("Ipek", "Aa", 123);
		System.out.println("Adding Ece Bb - 234 to the company customer list...");
		bemp.addCustomer("Ece", "Bb", 234);
		System.out.println("Adding Melike Cc - 345 to the company customer list...");
		bemp.addCustomer("Melike", "Cc", 345);
		System.out.println("Adding Ezgi Dd - 456 to the company customer list...");
		bemp.addCustomer("Ezgi", "Dd", 456);
		System.out.println("Adding Ece Bb - 234 to the company customer list...");
		bemp.addCustomer("Ece", "Bb", 234);
		System.out.println();

		bemp.printCustomer();
		
		System.out.println("Removing gg hh- 456 from the company customer list...");
		bemp.removeCustomer("gg", "hh", 456);	
		bemp.printCustomer();
		System.out.println("-------------------------------");
		System.out.println();
		
		System.out.println("Removing Ece Bb- 234 from the company customer list...");
		bemp.removeCustomer("Ece", "Bb", 234);	
		bemp.printCustomer();
		System.out.println("-------------------------------");
		System.out.println();
		
		System.out.println("Removing Ece Bb- 234 from the company customer list...");
		bemp.removeCustomer("Ezgi", "Dd", 456);	
		bemp.printCustomer();
		System.out.println("-------------------------------");
		System.out.println();
		System.out.println();

		System.out.println("adding receiver: aa bb - 123 ");
		bemp.recordInfoAboutReceiver("aa", "bb", 123);
		
		System.out.println("adding receiver: cc dd - 786 ");
		bemp.recordInfoAboutReceiver("cc", "dd", 786);
	
		bemp.printReceiver();
		
		System.out.println("removing receiver: cc dd - 786 ");
		bemp.removeInfoAboutReceiver("cc", "dd", 786);
		
		bemp.printReceiver();

		System.out.println();

		bemp.recordInfoAboutSender("ee", "ff", 123);
		bemp.recordInfoAboutSender("gg", "hh", 742);
	
		bemp.printSender();
		System.out.println("removing sender: ee ff - 123 ");
		bemp.removeInfoAboutSender("ee", "ff", 123);
		bemp.printSender();

		int TrackNum = (int) (Math.random() * (10000 - 1000)) + 1000;
		bemp.addCargoInfo("Ali", "Veli","Hasan", "Huseyin", TrackNum);
		TrackNum = (int) (Math.random() * (10000 - 1000)) + 1000;
		bemp.addCargoInfo("Ayse", "Fatma","Nesli", "AA", TrackNum);
		TrackNum = (int) (Math.random() * (10000 - 1000)) + 1000;
		bemp.addCargoInfo("ela", "goral","asdf", "goral", TrackNum);

		
		
  }

}
