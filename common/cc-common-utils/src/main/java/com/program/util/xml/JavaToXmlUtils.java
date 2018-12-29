package com.program.util.xml;

import org.w3c.dom.Element;

public class JavaToXmlUtils {

    /**
     * @param parent
     * @param fields
     * @Desc 把实体类中有的字段直接转为xml节点
     */
    public static void entityToXml(Element parent, String... fields) {
        for (String field : fields) {
            XmlUtils.appendElement(parent, field, "取值");
        }
    }
}
