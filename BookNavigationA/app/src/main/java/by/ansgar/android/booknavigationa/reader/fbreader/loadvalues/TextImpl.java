package by.ansgar.android.booknavigationa.reader.fbreader.loadvalues;

import java.util.ArrayList;
import java.util.List;


public class TextImpl implements Text {

	private String path;

	public TextImpl(String path) {
		this.path = path;
	}

	@Override
	public List<String> getText() {
//		NodeList nodeList = Loader.loadFile(path)
//				.getElementsByTagName("section");
		List<String> text = new ArrayList<String>();
//		for (int i = 0; i < nodeList.getLength(); i++) {
//			Element element = (Element) nodeList.item(i);
//			NodeList nl = Loader.loadFile(path).getElementsByTagName("p");
//			for (int j = 0; j < nl.getLength(); j++) {
//				try {
//					text.add(element.getElementsByTagName("p").item(j)
//							.getTextContent() + " ");
//				} catch (Exception e) {
//					continue;
//				}
//				text.add("\n");
//			}
//		}
		return text;
	}

}
