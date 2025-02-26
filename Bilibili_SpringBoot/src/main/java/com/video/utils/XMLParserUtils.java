package com.video.utils;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/**
 * 类名：
 *
 * @author Acer
 * 日期：2025/2/25
 * 时间：16:13
 */
public class XMLParserUtils {
    public static <T> List<T> parse(String file, Class<T> targetClass) {
        ArrayList<T> list = new ArrayList<>();
        try {
            // 1. 获取一个解析器对象
            SAXReader saxReader = new SAXReader();
            // 2. 利用解析器把xml文件加载到内存当中，并返回一个文档对象
            Document document = saxReader.read(new File(file));
            // 3. 获取到根标签
            Element rootElement = document.getRootElement();
            // 4. 通过根标签来获取user标签
            List<Element> elements = rootElement.elements("emp");

            // 5. 遍历集合，得到每一个user标签

            for (Element element : elements) {
                // 获取 name 属性
                String name = element.element("name").getText();
                String age = element.element("age").getText();
                String image = element.element("image").getText();
                String gender = element.element("gender").getText();
                String job = element.element("job").getText();

                // 组装数据
                Constructor<T> constructor = targetClass.getDeclaredConstructor(String.class, Integer.class, String.class, String.class, String.class);
                constructor.setAccessible(true);
                T object = constructor.newInstance(name, Integer.parseInt(age), image, gender, job);

                list.add(object);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
