package ru.babin.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Test
	public void contextLoads() {
	}

	public static void main(String[] args) {
		System.out.println("starting");

		String url = "http://localhost:8090/statistics?type=copy&device=device9&timeTo=01.11111";
		String charset = "UTF-8";

		try {
			URLConnection urlConnection = new URL(url).openConnection();
			urlConnection.setRequestProperty("accept-charset", charset);
			InputStream result = urlConnection.getInputStream();
			String convertStreamToString = convertStreamToString(result);
			System.out.println("result = " + convertStreamToString);
			result.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * TODO тесты сделать нормально
	 */
	private static void forFutureTests() {
		//OK
		testJobs("src/test/java/defaultExample.xml");
		testJobs("src/test/java/empty.xml"); //OK
		testJobs("src/test/java/big.xml"); //OK
		testJobs("src/test/java/additionalFields.xml"); //OK
		testJobs("src/test/java/amountEmpty.xml");
		testJobs("src/test/java/negativeAmount.xml");
		testJobs("src/test/java/shuffled.xml");
		testJobs("src/test/java/amountNoElement.xml");
		testJobs("src/test/java/amountString.xml");

		//invalid
		testJobs("src/test/java/invalidEmptyJob.xml");
		testJobs("src/test/java/invalidMalformed.xml");
		testJobs("src/test/java/invalidNoId.xml");
		testJobs("src/test/java/invalidTotalEmpty.xml");
	}

	private static void testJobs(String path) {
		String url = "http://localhost:8090/jobs";
		String charset = "UTF-8";

		try {
			URLConnection urlConnection = new URL(url).openConnection();
			urlConnection.setUseCaches(false);
			urlConnection.setDoOutput(true); // Triggers POST.
			urlConnection.setRequestProperty("accept-charset", charset);
			urlConnection.setRequestProperty("content-type", "application/xml");

			OutputStreamWriter writer = new OutputStreamWriter(urlConnection.getOutputStream(), charset);

			byte[] encoded = Files.readAllBytes(Paths.get(path));
			String readed = new String(encoded, "UTF-8");
			System.out.println("readed = " + readed);
			writer.write(readed); // Write POST query string (if any needed).
			try {
			} finally {
				writer.close();
			}

			InputStream result = urlConnection.getInputStream();
			String convertStreamToString = convertStreamToString(result);
			System.out.println("result = " + convertStreamToString);
			result.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	

	static String convertStreamToString(java.io.InputStream is) {
		java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
		return s.hasNext() ? s.next() : "";
	}

	/**
	 * TODO сделать нормально, чтобы принималось и возвращалось
	 *
	 * @param query
	 */
	private void query(String query) {
		String url = "http://localhost:8090/";
		String charset = "UTF-8";

		try {
			URLConnection urlConnection = new URL(url).openConnection();
			urlConnection.setUseCaches(false);
			urlConnection.setDoOutput(true); // Triggers POST.
			urlConnection.setRequestProperty("accept-charset", charset);
			urlConnection.setRequestProperty("content-type", "application/x-www-form-urlencoded");

			OutputStreamWriter writer = new OutputStreamWriter(urlConnection.getOutputStream(), charset);
			writer.write(query); // Write POST query string (if any needed).
			try {
			} finally {
				writer.close();
			}

			InputStream result = urlConnection.getInputStream();
			String convertStreamToString = convertStreamToString(result);
			result.close();

			System.out.println("convertStreamToString = " + convertStreamToString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
