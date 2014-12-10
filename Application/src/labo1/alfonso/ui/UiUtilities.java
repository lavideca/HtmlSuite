package labo1.alfonso.ui;

import java.awt.Component;
import java.awt.Container;

public class UiUtilities {
	private static Component getComponentById(Container container, String componentId) {
        if(container.getComponents().length > 0) {
            for(Component c : container.getComponents()) {
                if(componentId.equals(c.getName())) {
                    return c;
                }
                if(c instanceof Container) {
                    return getComponentById((Container) c, componentId);
                }
            }
        }

        return null;
    }
}
