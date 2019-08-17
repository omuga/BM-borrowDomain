package com.tps.prestamo;

import com.tps.prestamo.controller.PrestamoController;
import com.tps.prestamo.models.Prestamo;
import com.tps.prestamo.repository.PrestamoRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.junit.Before;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.sql.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	protected MockMvc mockMvc;

	protected String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

	protected <T> T mapFromJson(String json, Class<T> clazz)
		throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, clazz);
	}
	@Mock
	PrestamoRepository prestamoRepository;

	@Before
	public void setUp(){

		final PrestamoController prestamoController = new PrestamoController(prestamoRepository);
		mockMvc = MockMvcBuilders.standaloneSetup(prestamoController).build();
	}

	@Test
	public void prestamoControllerPostTest() throws Exception{
		String str="2015-03-31";  
		String str2="2015-04-31";  
		Date date_inicio = Date.valueOf(str);
		Date date_final = Date.valueOf(str2);
		String uri = "/borrow/prestamo";
		Prestamo prestamo = new Prestamo();
		Long id_sol = (long) 1;
		Long id_pres = (long) 2;
		Long id_book = (long) 1;
		prestamo.setIdPrestamista(id_pres);
		prestamo.setIdSolicitante(id_sol);
		prestamo.setFechaInicio(date_inicio);
		prestamo.setFechaTermino(date_final);
		prestamo.setIdBookItem(id_book);
		String inputJson = mapToJson(prestamo);
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
	  .contentType(org.springframework.http.MediaType.APPLICATION_JSON).content(inputJson)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}

	@Test
	public void PrestamoControllerGetAllTest() throws Exception {
		String uri = "/borrow/all";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
	  .contentType(org.springframework.http.MediaType.APPLICATION_JSON)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}
	@Test
	public void contextLoads() {
	}

}
