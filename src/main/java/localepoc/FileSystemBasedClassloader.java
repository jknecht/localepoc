package localepoc;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;

public class FileSystemBasedClassloader extends ClassLoader {
	private final ClassLoader loader;
	
	public FileSystemBasedClassloader(File root) {
		try {
			URL[] urls = {root.toURI().toURL()};
			loader = new URLClassLoader(urls);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.ClassLoader#loadClass(java.lang.String)
	 */
	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		return loader.loadClass(name);
	}

	/* (non-Javadoc)
	 * @see java.lang.ClassLoader#getResource(java.lang.String)
	 */
	@Override
	public URL getResource(String name) {
		return loader.getResource(name);
	}

	/* (non-Javadoc)
	 * @see java.lang.ClassLoader#getResources(java.lang.String)
	 */
	@Override
	public Enumeration<URL> getResources(String name) throws IOException {
		return loader.getResources(name);
	}

	/* (non-Javadoc)
	 * @see java.lang.ClassLoader#getResourceAsStream(java.lang.String)
	 */
	@Override
	public InputStream getResourceAsStream(String name) {
		return loader.getResourceAsStream(name);
	}

	/* (non-Javadoc)
	 * @see java.lang.ClassLoader#setDefaultAssertionStatus(boolean)
	 */
	@Override
	public void setDefaultAssertionStatus(boolean enabled) {
		loader.setDefaultAssertionStatus(enabled);
	}

	/* (non-Javadoc)
	 * @see java.lang.ClassLoader#setPackageAssertionStatus(java.lang.String, boolean)
	 */
	@Override
	public void setPackageAssertionStatus(String packageName, boolean enabled) {
		loader.setPackageAssertionStatus(packageName, enabled);
	}

	/* (non-Javadoc)
	 * @see java.lang.ClassLoader#setClassAssertionStatus(java.lang.String, boolean)
	 */
	@Override
	public void setClassAssertionStatus(String className, boolean enabled) {
		loader.setClassAssertionStatus(className, enabled);
	}

	/* (non-Javadoc)
	 * @see java.lang.ClassLoader#clearAssertionStatus()
	 */
	@Override
	public void clearAssertionStatus() {
		loader.clearAssertionStatus();
	}

}
