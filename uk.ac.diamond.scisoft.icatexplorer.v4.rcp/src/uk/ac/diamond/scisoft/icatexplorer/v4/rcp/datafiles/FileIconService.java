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

package uk.ac.diamond.scisoft.icatexplorer.v4.rcp.datafiles;

import java.util.HashMap;

import org.apache.commons.io.FilenameUtils;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileIconService {

	private static Logger logger = LoggerFactory
			.getLogger(FileIconService.class);

	HashMap<String, String> iconMap = new HashMap<String, String>();

	public FileIconService() {

		iconMap.put("nxs", "nexus.png");
		iconMap.put("img", "img.png");
		iconMap.put("edf", "img.png");
		iconMap.put("pgm", "img.png");
		iconMap.put("mccd", "img.png");
		iconMap.put("jpg", "jpg.png");
		iconMap.put("jpeg", "jpg.png");
		iconMap.put("dat", "dat.png");
		iconMap.put("spec", "spec.png");
		iconMap.put("zip", "zip.png");
		iconMap.put("tar", "tar.png");
		iconMap.put("default", "default.png");

	}

	public Image getIcon(String filename) {
		String iconName = iconMap.get("default");

		try {
			String fileExtension = FilenameUtils.getExtension(filename);
			if (iconMap.containsKey(fileExtension)) {
				iconName = iconMap.get(fileExtension);
			}
		} catch (Exception e) {
			logger.error("problem mapping file extension to icon file", e);
		}

		return AbstractUIPlugin.imageDescriptorFromPlugin(
				"uk.ac.diamond.scisoft.icatexplorer.rcp",
				"icons/cnficons/" + iconName).createImage();
	}

}
