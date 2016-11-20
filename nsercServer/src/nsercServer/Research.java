package nsercServer;

public class Research {
	public String title;
	public int cYear;
	public String fYear;
	public String name;
	public String institution;
	public String department;
	public String province;
	public int amount;
	public String installment;
	public String program;
	public String committee;
	public String subject;
	public String AOA;
	public String coresearchers;
	public String partners;
	public String summary;
	
	public Research() {
		
	}
	
	public Research(String title, int cYear, String fYear, String name, 
			String institution, String department, String province, 
			int amount, String installment, String program, String committee, 
			String subject, String AOA, String coresearchers, String partners, 
			String summary) {
		this.title = title;
		this.cYear = cYear;
		this.fYear = fYear;
		this.name = name;
		this.institution = institution;
		this.department = department;
		this.province = province;
		this.amount = amount;
		this.installment = installment;
		this.program = program;
		this.committee = committee;
		this.subject = subject;
		this.AOA = AOA;
		this.coresearchers = coresearchers;
		this.partners = partners;
		this.summary = summary;
		
	}
	
	public String getTitle() { return this.title; }
	public int getcYear() { return this.cYear; }
	public String getfYear() { return this.fYear; }
	public String getName() { return this.name; }
	public String getInstitution() { return this.institution; }
	public String getDepartment() { return this.department; }
	public String getProvince() { return this.province; }
	public int getamount() { return this.amount; }
	public String getInstallment() { return this.installment; }
	public String getProgram() { return this.program; }
	public String getCommittee() { return this.committee; }
	public String getSubject() { return this.subject; }
	public String getAOA() { return this.AOA; }
	public String getCoresearchers() { return this.coresearchers; }
	public String getPartners() { return this.partners; }
	public String getSummary() { return this.summary; }

}
