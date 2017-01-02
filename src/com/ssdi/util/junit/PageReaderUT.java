package com.ssdi.util.junit;

import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.Test;

import com.ssdi.util.PageReader;
public class PageReaderUT {
	
	PageReader pageReader = new PageReader();
	@Test
	   public void testGetPagePath() throws Exception{
		
		String path = "S:\\Workspace\\SSDI\\SVN\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\ExamPortal\\config\\pageconfig.xml";
		Map testMap = pageReader.getPagePath(path);
		assertNotNull(testMap);
		
	   }
	 
	
}
