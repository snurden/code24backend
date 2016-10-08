import java.util.*;
import java.io.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

public class Receive {

	public static ArrayList<Account> accounts = new ArrayList<Account>();

	public static void main(String[] args) {
		System.out.println("Reading JSON files...");
		for (int i = 0; i < args.length; i++) {
			JSONParser jp = new JSONParser();
			try {
				FileReader fr = new FileReader(args[i]);
				Object o = jp.parse(fr);
				JSONObject json = (JSONObject)o;
				
				Account a = new Account(accounts.size(), (String)json.get("name"), (String)json.get("email"), (String)json.get("password"), (String)json.get("sid"));
				accounts.add(a);
				
			} catch (Exception e) {System.out.println("\tERROR with file [" + i +"]: " + e);}
		}
		System.out.println("\nJSON files read.\nPrinting JSON files...\n");
		for (Account a : accounts) {
			System.out.println("\t" + a);
		}
		System.out.println("\nJSON files printed.\nExiting...");
	}
}

class Account {
	int id;
	String name;
	String email;
	String password;
	String sid;

	public Account (int idNum, String a, String b, String c, String d) {
		id = idNum;
		name = a + "";
		email = b + "";
		password = c + "";
		sid = d + "";
	}
	
	public String toString() {
		return "ID:[" + id + "], name:[" + name + "], email:[" + email + "], password:[" + password + "], sid:[" + sid + "].";
	}
}