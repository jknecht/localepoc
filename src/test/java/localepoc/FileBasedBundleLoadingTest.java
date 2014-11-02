package localepoc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

public class FileBasedBundleLoadingTest {
	
	@Test
	public void loadResourcesFromFileSystem() {
		ResourceBundle rb = LocationResourceBundle.getBundle("bundle", "loc1", Locale.getDefault(), new FileSystemBasedClassloader(new File("./bundles")));
		assertNotNull(rb);
		assertEquals("My Value", rb.getString("val3"));
	}

}
