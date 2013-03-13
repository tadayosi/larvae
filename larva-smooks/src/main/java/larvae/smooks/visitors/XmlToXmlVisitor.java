package larvae.smooks.visitors;

import org.milyn.SmooksException;
import org.milyn.container.ExecutionContext;
import org.milyn.delivery.dom.DOMVisitAfter;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XmlToXmlVisitor implements DOMVisitAfter {

  @Override
  public void visitAfter(Element element, ExecutionContext executionContext) throws SmooksException {
    Node value = element.getElementsByTagName("value").item(0);
    element.setAttribute("value", value.getTextContent());
    element.removeChild(value);
  }

}
