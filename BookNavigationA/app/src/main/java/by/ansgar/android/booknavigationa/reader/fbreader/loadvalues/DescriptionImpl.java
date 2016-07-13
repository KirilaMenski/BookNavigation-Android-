package by.ansgar.android.booknavigationa.reader.fbreader.loadvalues;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import by.ansgar.android.booknavigationa.reader.fbreader.loader.Loader;

public class DescriptionImpl implements Description {

	private String path;
	private InputStream mInputStream;

	public DescriptionImpl(String path) {
		this.path = path;
	}

	public DescriptionImpl(InputStream inputStream) {
		this.mInputStream = inputStream;
	}

	public String getTitle() {

//		NodeList nodeList = Loader.loadFile(path)
		NodeList nodeList = Loader.loadFile(mInputStream)
				.getElementsByTagName("title-info");
		String title = "";
		for (int i = 0; i < nodeList.getLength(); i++) {
			Element element = (Element) nodeList.item(i);
			try {
				title = element.getElementsByTagName("book-title").item(0)
						.getChildNodes().item(0).getNodeValue();
			} catch (Exception e) {
				continue;
			}
		}
		return title;
	}

	public String getGenre() {
//		NodeList nodeList = Loader.loadFile(path)
		NodeList nodeList = Loader.loadFile(mInputStream)
				.getElementsByTagName("title-info");
		String genre = "";
		for (int i = 0; i < nodeList.getLength(); i++) {
			Element element = (Element) nodeList.item(i);
			try {
				genre = element.getElementsByTagName("genre").item(0)
						.getChildNodes().item(0).getNodeValue();
			} catch (Exception e) {
				continue;
			}
		}
		return genre;
	}

	@Override
	public String getCover() {
//		NodeList nodeList = Loader.loadFile(path)
		NodeList nodeList = Loader.loadFile(mInputStream)
				.getElementsByTagName("coverpage");
		String cover = "";
		for (int i = 0; i < nodeList.getLength(); i++) {
			Element element = (Element) nodeList.item(i);
			try {
				cover = element.getElementsByTagName("image").item(0)
						.getAttributes().getNamedItem("l:href").getNodeValue();
			} catch (Exception e) {
				continue;
			}
		}
		return cover;
	}

	@Override
	public String getAuthor() {
//		NodeList nodeList = Loader.loadFile(path)
		NodeList nodeList = Loader.loadFile(mInputStream)
				.getElementsByTagName("title-info");
		String firstname = "";
		String lastname = "";
		for (int i = 0; i < nodeList.getLength(); i++) {
			Element element = (Element) nodeList.item(i);
			try {
				firstname = element.getElementsByTagName("first-name").item(0)
						.getChildNodes().item(0).getNodeValue();
				lastname = element.getElementsByTagName("last-name").item(0)
						.getChildNodes().item(0).getNodeValue();
			} catch (Exception e) {
				continue;
			}
		}
		return firstname + " " + lastname;

	}

	@Override
	public String getSeries() {
//		NodeList nodeList = Loader.loadFile(path)
		NodeList nodeList = Loader.loadFile(mInputStream)
				.getElementsByTagName("title-info");
		String series = "";
		for (int i = 0; i < nodeList.getLength(); i++) {
			Element element = (Element) nodeList.item(i);
			try {
				series = element.getElementsByTagName("sequence").item(0)
						.getAttributes().getNamedItem("name").getNodeValue();
			} catch (Exception e) {
				continue;
			}
		}
		return series;

	}

	@Override
	public String getNumOfSer() {
//		NodeList nodeList = Loader.loadFile(path)
		NodeList nodeList = Loader.loadFile(mInputStream)
				.getElementsByTagName("title-info");
		String number = "";
		for (int i = 0; i < nodeList.getLength(); i++) {
			Element element = (Element) nodeList.item(i);
			try {
				number = element.getElementsByTagName("sequence").item(0)
						.getAttributes().getNamedItem("number").getNodeValue();
			} catch (Exception e) {
				continue;
			}
		}
		return number;
	}

	@Override
	public String getLang() {
//		NodeList nodeList = Loader.loadFile(path)
		NodeList nodeList = Loader.loadFile(mInputStream)
				.getElementsByTagName("title-info");
		String lang = "";
		for (int i = 0; i < nodeList.getLength(); i++) {
			Element element = (Element) nodeList.item(i);
			try {
				lang = element.getElementsByTagName("lang").item(0)
						.getChildNodes().item(0).getNodeValue();
			} catch (Exception e) {
				continue;
			}
		}
		return lang;
	}

	@Override
	public List<String> getAnotation() {
//		NodeList nodeList = Loader.loadFile(path)
		NodeList nodeList = Loader.loadFile(mInputStream)
				.getElementsByTagName("annotation");
		List<String> anotation = new ArrayList<String>();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Element element = (Element) nodeList.item(i);
			try {
				anotation.add(element.getElementsByTagName("p").item(0)
						.getChildNodes().item(0).getNodeValue() + " ");
			} catch (Exception e) {
				continue;
			}
		}
		return anotation;
	}

}
