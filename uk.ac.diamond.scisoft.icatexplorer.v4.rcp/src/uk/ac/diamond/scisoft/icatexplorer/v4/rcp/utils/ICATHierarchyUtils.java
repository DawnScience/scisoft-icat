/*
 * Copyright © 2011 Diamond Light Source Ltd.
 *
 * This file is part of GDA.
 *
 * GDA is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License version 3 as published by the Free
 * Software Foundation.
 *
 * GDA is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along
 * with GDA. If not, see <http://www.gnu.org/licenses/>.
 */

package uk.ac.diamond.scisoft.icatexplorer.v4.rcp.utils;

import java.util.ArrayList;
import java.util.List;

import org.icatproject.Investigation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @since 3.2
 *
 */
public class ICATHierarchyUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(ICATHierarchyUtils.class);
	
	
	public static List<String> getBeamlines(List<Investigation> allVisits) {
		
		ArrayList<String> beamlines = new ArrayList<String>();
		for(int i =0; i< allVisits.size(); i++){
			
			// get beamlines
			String beamline = (allVisits.get(i)).getInstrument().getName();
			beamlines.add(beamline);
		}
		
		return beamlines;			
		
	}
	
	public static List<String> getYears(List<Investigation> allVisits) {
		
		ArrayList<String> years = new ArrayList<String>();
		for(int i =0; i< allVisits.size(); i++){
			
			// get years
			String year = String.valueOf((allVisits.get(i)).getStartDate().getYear());
			years.add(year);
		}
		
		return years;			
		
	}
	
	public static List<String> getYearsByBeamline(List<Investigation> allVisits, String currentBeamline) {
		
		//logger.debug("getYearsByBeamline() with beamline: " + currentBeamline);
		
		ArrayList<String> years = new ArrayList<String>();
		for(int i =0; i< allVisits.size(); i++){
			
			//get beamlines
			String beamline = String.valueOf((allVisits.get(i)).getInstrument().getName());
			
			// get years
			String year = "uknown";
			if((allVisits.get(i)).getStartDate() != null){
				year = String.valueOf((allVisits.get(i)).getStartDate().getYear());
			}
			
			// test if year exist for current beamline
			if(beamline.equalsIgnoreCase(currentBeamline)){
				//logger.debug("adding year: " + year);
				years.add(year);
			}
		}
				
		return years;			
		
	}

	
	public static List<Investigation> getVisitsByBeamlineYear(
			List<Investigation> allVisits, String currentBeamline, String currentYear) {
		
		//logger.debug("getVisitsByBeamlineYear() with beamline: " + currentBeamline + " and year: " + currentYear);

		ArrayList<Investigation> visits = new ArrayList<Investigation>();
		for(int i =0; i< allVisits.size(); i++){
			
			//get beamlines
			String beamlineName = String.valueOf((allVisits.get(i)).getInstrument().getName());
			
			// get years
			String year = String.valueOf((allVisits.get(i)).getStartDate().getYear());
			
			// test if year exist for current beamline
			System.out.println("beamline = " + beamlineName + "currentBeamline = " +currentBeamline + " year= "+ year +" currentYear = " + currentYear);
			if(beamlineName.equalsIgnoreCase(currentBeamline) && year.equalsIgnoreCase(currentYear)){
				logger.debug("adding visit: " + allVisits.get(i));
				//visits.add(allVisits.get(i).getVisitId());
				visits.add(allVisits.get(i));
			}
		}
		
		return visits;
	}

}
