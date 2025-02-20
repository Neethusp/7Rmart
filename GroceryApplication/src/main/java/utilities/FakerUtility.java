package utilities;

import com.github.javafaker.Faker;

public class FakerUtility {
	Faker faker= new Faker();
	
	public String generateName()
	{
		return faker.name().firstName();
	}
	public String generateAddress()
	{
		return faker.address().fullAddress();
		
	}
	public String generatePhoneNo()
	{
		return faker.phoneNumber().toString();
		
	}
	public String generateIdNo()
	{
		return faker.idNumber().toString();
	}
	public String generateDate()
	{
		return faker.date().toString();
	}
	public String  generateCode()
	{
		return faker.code().toString();
	}

}
