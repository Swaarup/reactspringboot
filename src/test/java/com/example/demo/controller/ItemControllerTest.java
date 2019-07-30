//package com.example.demo.controller;
//
//import org.hamcrest.Matchers;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.example.demo.docs.Item;
//import com.example.demo.service.ItemService;
//
//import java.util.Arrays;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//public class ItemControllerTest {
//
//	private MockMvc mockMvc;
//	@InjectMocks
//	ItemController itemController;
//	@Mock
//
//	ItemService itemService;
//
//	@Before
//	public void setUp() {
//		mockMvc = MockMvcBuilders.standaloneSetup(itemController).build();
//	}
//
//	@Test
//	public void getAllItems() throws Exception {
//		Item itms = new Item();
//		itms.setCategory("Mobiles");
//		itms.setId("123X");
//		itms.setItemId(1239);
//		itms.setName("Sony-P90");
//		itms.setSerialNumber("SonyPx90S");
//		List<Item> items = Arrays.asList(itms);
//		Mockito.when(itemService.getAllItems()).thenReturn(items);
//		mockMvc.perform(MockMvcRequestBuilders.get("/getAllItems")).andExpect(MockMvcResultMatchers.status().isOk());
//
//	}
//
////	@Test
////	public void getItemById() throws Exception {
////		Item itms = new Item();
////		itms.setCategory("Mobiles");
////		itms.setId("123X");
////		itms.setItemId(1239);
////		itms.setName("Sony-P90");
////		itms.setSerialNumber("SonyPx90S");
////		Mockito.when(itemService.getItemByItemId(1239)).thenReturn(itms);
////		mockMvc.perform(MockMvcRequestBuilders.get("/getItemById?item=1239").accept(MediaType.APPLICATION_JSON))
////				.andExpect(MockMvcResultMatchers.status().isOk())
////				.andExpect(MockMvcResultMatchers.jsonPath("$.itemId", Matchers.is(1239)))
////				.andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is("123X")))
////				.andExpect(MockMvcResultMatchers.jsonPath("$.serialNumber", Matchers.is("SonyPx90S")))
////				.andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("Sony-P90")))
////				.andExpect(MockMvcResultMatchers.jsonPath("$.category", Matchers.is("Mobiles")));
////		Mockito.verify(itemService).getItemByItemId(1239);
////	}
//
//}
