package labo1.alfonso.model;

import org.w3c.dom.Node;

public class AdapterNode {
    org.w3c.dom.Node domNode;

    public AdapterNode(org.w3c.dom.Node node) {
        domNode = node;
    }

    public String toString() {
        String nodeName = domNode.getNodeName();

        return nodeName;
    }

    public int index(AdapterNode child) {
        int count = childCount();

        for (int i = 0; i < count; i++) {
            AdapterNode n = this.child(i);

            if (child.domNode == n.domNode) {
                return i;
            }
        }

        return -1;
    }

    public AdapterNode child(int searchIndex) {
        Node node = domNode.getChildNodes().item(searchIndex);
        return new AdapterNode(node);
    }

    public int childCount() {
    	return domNode.getChildNodes().getLength();
    }
}