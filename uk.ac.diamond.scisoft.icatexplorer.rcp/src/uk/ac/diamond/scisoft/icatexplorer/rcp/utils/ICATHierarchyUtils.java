
package uk.ac.diamond.scisoft.icatexplorer.rcp.utils;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.icat3.client.Investigation;

/**
 * @since 3.2
 *
 */
public class ICATHierarchyUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(ICATHierarchyUtils.class);
	
	
	/**
	 * @param result
	 * @return
	 */
	public static List<String> getBeamlines(List<Investigation> allVisits) {
		
		ArrayList<String> beamlines = new ArrayList<String>();
		for(int i =0; i< allVisits.size(); i++){
			
			// get beamlines
			String beamline = (allVisits.get(i)).getInstrument();
			beamlines.add(beamline);
		}
		
		return beamlines;			
		
	}
	
	public static List<String> getYears(List<Investigation> allVisits) {
		
		ArrayList<String> years = new ArrayList<String>();
		for(int i =0; i< allVisits.size(); i++){
			
			// get years
			String year = String.valueOf((allVisits.get(i)).getInvStartDate().getYear());
			years.add(year);
		}
		
		return years;			
		
	}
	
	public static List<String> getYearsByBeamline(List<Investigation> allVisits, String currentBeamline) {
		
		logger.debug("getYearsByBeamline() with beamline: " + currentBeamline);
		
		ArrayList<String> years = new ArrayList<String>();
		for(int i =0; i< allVisits.size(); i++){
			
			//get beamlines
			String beamline = String.valueOf((allVisits.get(i)).getInstrument());
			
			// get years
			String year = String.valueOf((allVisits.get(i)).getInvStartDate().getYear());
			
			// test if year exist for current beamline
			if(beamline.equalsIgnoreCase(currentBeamline)){
				logger.debug("adding year: " + year);
				years.add(year);
			}
		}
		
		logger.debug("years: " + years);
		
		return years;			
		
	}

	/**
	 * @param allVisits
	 * @param string
	 * @param string2
	 * @return
	 */
	public static List<Investigation> getVisitsByBeamlineYear(
			List<Investigation> allVisits, String currentBeamline, String currentYear) {
		
		logger.debug("getVisitsByBeamlineYear() with beamline: " + currentBeamline + " and year: " + currentYear);

		ArrayList<Investigation> visits = new ArrayList<Investigation>();
		for(int i =0; i< allVisits.size(); i++){
			
			//get beamlines
			String beamline = String.valueOf((allVisits.get(i)).getInstrument());
			
			// get years
			String year = String.valueOf((allVisits.get(i)).getInvStartDate().getYear());
			
			// test if year exist for current beamline
			if(beamline.equalsIgnoreCase(currentBeamline) && year.equalsIgnoreCase(currentYear)){
				logger.debug("adding visit: " + allVisits.get(i));
				//visits.add(allVisits.get(i).getVisitId());
				visits.add(allVisits.get(i));
			}
		}
		
		return visits;
	}

}
