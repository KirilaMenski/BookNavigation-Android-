package by.ansgar.android.booknavigationa.reader.fbreader.loadvalues;

import java.util.List;

import org.w3c.dom.Document;


public interface Description {

	public String getCover();

	public String getTitle();

	public String getAuthor();

	public String getSeries();

	public String getNumOfSer();

	public String getGenre();

	public String getLang();
	
	public List<String> getAnotation();

}
