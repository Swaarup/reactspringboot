//package com.example.demo.docs;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.boot.test.context.TestConfiguration;
//
//import com.example.demo.docs.Item;
//
//@TestConfiguration
//public class ItemTest {
//	private Item item;
//	String name;
//	
//	long itemId;
//	String serialNumber;
//	String category;
//	@Before
//	 public void setUP() {
//		
//		
//		long itemId = 45612;
//		serialNumber = "IAbPENCIL";
//		category = "Pencil";
//		name = "HbPencil";
//		item = new Item();
//		item.setName(name);
//		item.setCategory(category);
//		item.setItemId(itemId);
//		item.setSerialNumber(serialNumber);
//		
//	}
//	@Test
//	public void testGetName()
//	{
//		
//		assertEquals(name, item.getName()); 
//	}
//	@Test
//	public void testGetCategory()
//	{
//		assertEquals(category, item.getCategory()); 
//	}
//	
//	@Test
//	public void testGetserialNumber()
//	{
//		assertEquals(serialNumber, item.getSerialNumber()); 
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//
//}
