package nsercServer;

public class Research {
	private String title;
	private int cYear;
	private String fYear;
	private String name;
	private String institution;
	private String department;
	private String province;
	private int amount;
	private String installment;
	private String program;
	private String committee;
	private String subject;
	private String AOA;
	private String coresearchers;
	private String partners;
	private String summary;
	
	public Research() {}
	
	// getters ...
	// setters ...
	
	// Initialization constructor
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
	
	public void setTitle(String t) { this.title = t; }
	public void setcYear(int y) { this.cYear = y; }
	public void setfYear(String y) { this.fYear = y; }
	public void setName(String n) { this.name = n; }
	public void setInstitution(String i) { this.institution = i; }
	public void setDepartment(String d) { this.department = d; }
	public void setProvince(String p) { this.province = p; }
	public void setamount(int a) { this.amount = a; }
	public void setInstallment(String i) { this.installment = i; }
	public void setProgram(String p) { this.program = p; }
	public void setCommittee(String c) { this.committee = c; }
	public void setSubject(String s) { this.subject = s; }
	public void setAOA(String a) { this.AOA = a; }
	public void setCoresearchers(String c) { this.coresearchers = c; }
	public void setPartners(String p) { this.partners = p; }
	public void setSummary(String s) { this.summary = s; }

}
