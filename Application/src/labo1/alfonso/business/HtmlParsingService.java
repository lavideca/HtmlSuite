package labo1.alfonso.business;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import labo1.alfonso.model.HtmlDocument;
import labo1.alfonso.persistence.HtmlRepository;

public class HtmlParsingService {
	public static HtmlDocument getHtmlDocumentFromPath(String path) throws ParserConfigurationException, IOException {
		String html = HtmlRepository.getHtmlAsString(path);
		return HtmlParsingService.getHtmlDocumentFromString(html);
	}
	
	public static HtmlDocument getHtmlDocumentFromString(String html) throws ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(html));
        Document doc = null;
		try {
			doc = builder.parse(is);
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}
        
        return new HtmlDocument(doc);
	}

	public static void saveHtmlDocument(String path, HtmlDocument document) {
		
	}
}
