package com.program.util.velocity;

import java.io.StringWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VelocityTplUtils {

    private static final Logger log = LoggerFactory.getLogger(VelocityTplUtils.class);

    @Autowired
    private VelocityEngine velocityEngine;

    public String getMergedTemplate(String templateUrl, Map<String, Object> variableMap) {
        try {
            Template template = velocityEngine.getTemplate(templateUrl, "utf-8");
            VelocityContext context = new VelocityContext();
            if (variableMap != null && !variableMap.isEmpty()) {
                Iterator<Entry<String, Object>> iter = variableMap.entrySet().iterator();
                while (iter.hasNext()) {
                    Entry<String, Object> entry = iter.next();
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (value == null) {
                        continue;
                    }
                    if (value instanceof String) {
                        context.put(key, URLEncoder.encode(value.toString(), "utf-8"));
                    } else {
                        context.put(key, value);
                    }
                }
            }
            StringWriter sw = new StringWriter();
            template.merge(context, sw);
            //弹出层页的所有html内容
            String result = sw.toString();
            // decode针对%进行转义
            result = result.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
            return URLDecoder.decode(result, "utf-8");
        } catch (Exception e) {
            log.error("getMergedTemplate:", e);
        }
        return null;
    }
}
