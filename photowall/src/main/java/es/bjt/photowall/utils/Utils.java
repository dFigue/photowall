package es.bjt.photowall.utils;

import java.util.UUID;

public class Utils {
	
	
	public static String generateUID()
	{
		
		UUID uuid = UUID.randomUUID();		
		return uuid.toString();
		
	}

}
