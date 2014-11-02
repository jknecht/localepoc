package localepoc;

import java.util.Enumeration;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Vector;

public class LocationResourceBundle extends ResourceBundle {
	ResourceBundle specificResoureBundle;
	ResourceBundle genericResoureBundle;
	
	public static ResourceBundle getBundle(String baseName, String location, Locale locale, ClassLoader loader) {
		LocationResourceBundle bundle = new LocationResourceBundle();
		try {
			bundle.specificResoureBundle = ResourceBundle.getBundle(baseName + "_" + location, locale, loader);
		} catch (MissingResourceException ignored) {}
		bundle.genericResoureBundle = ResourceBundle.getBundle(baseName, locale, loader);
		return bundle;
	}

	@Override
	protected Object handleGetObject(String key) {
		if (specificResoureBundle != null) {
			try {
				return specificResoureBundle.getObject(key);
			} catch (MissingResourceException ignored) {}
		}
		return genericResoureBundle.getObject(key);
	}

	@Override
	public Enumeration<String> getKeys() {
		Vector<String> keys = new Vector<String>();
		if (specificResoureBundle != null) {
			for (Enumeration<String> e = specificResoureBundle.getKeys(); e.hasMoreElements();) {
				keys.add(e.nextElement());
			}
		}
		for (Enumeration<String> e = genericResoureBundle.getKeys(); e.hasMoreElements();) {
			String nextKey = e.nextElement();
			if (!keys.contains(nextKey)) {
				keys.add(nextKey);
			}
		}
		return keys.elements();
	}

}
