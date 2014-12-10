package labo1.alfonso.model;

import org.w3c.dom.NodeList;

public class Query {
	private String text;
	private NodeList results;
	
	protected String getText() {
		return text;
	}
	
	protected NodeList getResults() {
		return results;
	}

	public Query(String text, NodeList results) {
		super();
		this.text = text;
		this.results = results;
	}
}
