package labo1.alfonso.model;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class HtmlDocument {
	private Document document;
	private List<Query> queries;
	
	public Document getDocument() {
		return this.document;
	}

	protected void setDocument(Document document) {
		this.cleanDocument(document);
		this.document = document;
	}
	
	protected String getHtmlText() {
		return this.document.getTextContent();
	}
	
	protected List<Query> getQueries() {
		return this.queries;
	}

	public HtmlDocument(Document document) {
		this.cleanDocument(document);
		this.document = document;
		this.queries = new ArrayList<Query>();
	}
	
	private void cleanDocument(Document doc) {
		this.cleanDocumentRecursively(doc, Node.COMMENT_NODE, null);
		this.cleanDocumentRecursively(doc, Node.TEXT_NODE, null);
	}
	
	private void cleanDocumentRecursively(Node node, short nodeType, String name) {
		if (node.getNodeType()==nodeType && (name == null || node.getNodeName().equals(name))) {
			node.getParentNode().removeChild(node);
		} else {
			NodeList list = node.getChildNodes();
			for (int i = 0; i < list.getLength(); i++) {
				cleanDocumentRecursively(list.item(i), nodeType, name);
			}
		}
	}
}
