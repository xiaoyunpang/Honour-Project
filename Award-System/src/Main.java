import com.jaunt.*;
import com.jaunt.component.*;

public class Main {

	public static void main(String[] args) {
		
		try{
			UserAgent userAgent = new UserAgent();
		    userAgent.visit("http://www.nserc-crsng.gc.ca/ase-oro/Details-Detailles_eng.asp?id=1");
		    //System.out.println(userAgent.doc.innerHTML());
		    //userAgent.visit("http://www.nserc-crsng.gc.ca/ase-oro/Results-Resultats_eng.asp");
		    //Elements tables = userAgent.doc.findEach("<form>");
		    Element element;
		    element = userAgent.doc.findEvery("<div id='RightColDetails'>");
		    //String title = userAgent.doc.findFirst("<title>").getText();
		    //element = userAgent.doc.getElement(0).getElement(1).getElement(0);
		    System.out.println(element.innerHTML());
		    //userAgent.doc.choose("fiscalyearfrom", "(1991)");
		    //userAgent.doc.submit("Reset");
		    //userAgent.doc.getActiveForm();
		    //System.out.println(userAgent.doc.innerHTML());
		    }
		catch(JauntException e){
			System.err.println(e);
			}

	}

}
