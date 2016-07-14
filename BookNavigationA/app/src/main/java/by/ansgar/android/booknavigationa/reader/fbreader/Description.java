package by.ansgar.android.booknavigationa.reader.fbreader;

import java.util.List;


public interface Description {

	public String getCover();

	public String getTitle();

	public String getAuthor();

	public String getSeries();

	public String getNumOfSer();

	public String getGenre();

	public String getLang();
	
	public List<String> getAnnotation();

}
