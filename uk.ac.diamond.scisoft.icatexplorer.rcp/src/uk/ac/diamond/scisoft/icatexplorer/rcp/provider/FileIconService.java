package uk.ac.diamond.scisoft.icatexplorer.rcp.provider;

import java.util.HashMap;

import org.apache.commons.io.FilenameUtils;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileIconService {

	private static Logger logger = LoggerFactory
			.getLogger(CNFLabelProvider.class);

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
