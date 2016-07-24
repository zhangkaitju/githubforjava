package cn.edu.tju.entity;

public class Language implements Comparable<Language> {
	public static final String JAVA = "Java";
	
	private String name;
	private int byteCount;
	
	public Language(String name, int byteCount) {
		this.name = name;
		this.byteCount = byteCount;
	}

	/**
	 * Informs the language name
	 * @return a {@link String} object
	 */
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Informs the byte count of the language in its project
	 *  @return a {@link String} object
	 */
	public int getByteCount() {
		return this.byteCount;
	}

	public void setByteCount(int byteCount) {
		this.byteCount = byteCount;
	}

	@Override
	public int compareTo(Language o) {
		if (this.getByteCount() < o.getByteCount()) return -1;
		if (this.getByteCount() > o.getByteCount()) return 1;
		
		return 0;
	}
	
	public String toString() {
		return this.name;
	}
}