package by.ansgar.android.booknavigationa.reader.fbreader.loader;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Loader {
	static Document document;

//	public static Document loadFile(String path) {
	public static Document loadFile(InputStream inputStream){
		try {
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
//			document = builder.parse(new File(path));
			InputSource inputSource = new InputSource(inputStream);
			document = builder.parse(inputSource);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

		return document;
	}
	
}
