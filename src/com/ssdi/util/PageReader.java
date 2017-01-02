package com.ssdi.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.hibernate.engine.query.spi.ReturnMetadata;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PageReader {
	public static Map<String,String> getPagePath(String absoluteDiskPath)
	{
		String pageName="";
		String pagePath="";
		Map returnMap = new HashMap<String,String>();
		try
		{
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new File(absoluteDiskPath));
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("page");
			System.out.println("----------------------------");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					pageName = eElement.getElementsByTagName("page-name").item(0).getTextContent();
					pagePath = eElement.getElementsByTagName("page-path").item(0).getTextContent();
				}
				returnMap.put(pageName, pagePath);
			}

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return returnMap;

	}

}
