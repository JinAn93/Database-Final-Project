package spring.util;

import spring.model.Company;

public class Utils {
	
	public static Company normalizeCompanyName(Company company) {
		return company.setCompany_name(company.getCompany_name()
				.replaceAll("\\s+","")
				.toLowerCase());
	}
	
	public static String normalizeString(String str) {
		return str.replaceAll("\\s+","")
				.toLowerCase();
	}
}
