package com.cognizant.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.cognizant.controller.PensionController;
import com.cognizant.model.BankDetail;
import com.cognizant.model.PensionDetail;
import com.cognizant.model.PensionerDetail;
import com.cognizant.model.PensionerInput;
import com.cognizant.restClient.AuthorizationClient;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
public class PensionManagementControllerTest {
	
	@Mock
	private PensionController pensionController;
		
	ObjectMapper objectMapper = new ObjectMapper();
	private static String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYxNTcyMTkxMywiaWF0IjoxNjE1NTQxOTEzfQ.sBh1dxvrhBUQWtmOIzJ0HYBIQCxZ__5Hhr1IvsOyYNI";

	
	@Test
	public void allDetailTest()
	{
		BankDetail bankDetail = new BankDetail("ICICI", "12345678", "private");
		PensionerDetail pensionerDetail = new PensionerDetail("982897132579", "Prasanna", "03-03-2000", "PCASD1234Q",27000, 10000, "self", bankDetail);
		List<PensionerDetail> list = new ArrayList<>();
		list.add(pensionerDetail);
		when(pensionController.allDetail()).thenReturn(list);
		assertEquals(pensionController.allDetail(),list);
		
	}
	
	@Test
	public void getPensionDetailTest()
	{
		PensionerInput pensionerInput = new PensionerInput("Prasanna", "03-03-2000","PASW33334DW","1234567890","family");
		PensionDetail pensionDetail = new PensionDetail("Prasanna","03-03-2000","PASW33334DW","family",30105);
		when(pensionController.getPensionDetail(token, pensionerInput)).thenReturn(pensionDetail);
		assertEquals(pensionController.getPensionDetail(token, pensionerInput),pensionDetail);
		
	}

}
