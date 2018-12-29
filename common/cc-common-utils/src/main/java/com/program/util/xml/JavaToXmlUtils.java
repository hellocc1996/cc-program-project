package com.program.util.xml;

import com.program.util.exception.XmlException;
import org.w3c.dom.Element;

import java.lang.reflect.Field;

public class JavaToXmlUtils {

    /**
     * @param parent
     * @param obj
     * @Desc 把实体类中有的字段直接转为xml节点
     */
    public static void entityToXml(Element parent, Object obj) {
        Class cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();
        try {
            for (Field field : fields) {
                XmlUtils.appendElement(parent, field.getName(), field.get(obj).toString());
            }
        } catch (IllegalArgumentException | IllegalAccessException e) {
            throw new XmlException(XmlException.XML_PARSE_ERROR, e);
        }
    }
}
