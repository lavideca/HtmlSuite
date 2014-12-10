package labo1.alfonso.model;

import java.util.LinkedList;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;

import org.w3c.dom.Document;

public class TreeModelAdapter implements javax.swing.tree.TreeModel {

    private LinkedList<TreeModelListener> listenerList = new LinkedList<TreeModelListener>();

	private Document document;
	
	protected Document getDocument() {
		return document;
	}

	protected void setDocument(Document document) {
		this.document = document;
	}

	public TreeModelAdapter(Document htmlDom) {
		this.setDocument(htmlDom);
	}
	
    public Object getRoot() {
        return new AdapterNode(this.getDocument());
    }

    public boolean isLeaf(Object aNode) {
        // Determines whether the icon shows up to the left.
        // Return true for any node with no children
        AdapterNode node = (AdapterNode) aNode;

        if (node.childCount() > 0) {
            return false;
        }

        return true;
    }

    public int getChildCount(Object parent) {
        AdapterNode node = (AdapterNode) parent;

        return node.childCount();
    }

    public Object getChild(Object parent, int index) {
        AdapterNode node = (AdapterNode) parent;

        return node.child(index);
    }

    public int getIndexOfChild(Object parent, Object child) {
        AdapterNode node = (AdapterNode) parent;

        return node.index((AdapterNode) child);
    }

	@Override
	public void addTreeModelListener(TreeModelListener l) {
		if ((l != null) && !listenerList.contains(l)) {
			listenerList.add(l);
		}
	}

	@Override
	public void removeTreeModelListener(TreeModelListener l) {
      if (l != null) {
    	  listenerList.remove(l);
      }
	}

	@Override
	public void valueForPathChanged(TreePath path, Object newValue) {
		// No se usa
	}
}