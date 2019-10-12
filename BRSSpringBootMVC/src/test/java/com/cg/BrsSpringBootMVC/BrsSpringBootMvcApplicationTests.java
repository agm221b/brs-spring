package com.cg.BrsSpringBootMVC;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.BrsSpringBootMVC.service.BRSService;

/**
 * @author Mayank
 * Created: 12/10/19
 * Last modified: 12/10/19
 * Description: junit testing
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class BrsSpringBootMvcApplicationTests {

	@Autowired
	TestRestTemplate restTemplate;
	
	@Autowired
	BRSService brsService;
	
	@Test
	public void checkshowHomePage() {
		String str= restTemplate.getForObject("/", String.class);
		assertThat(str.equals("jsp/home"));
	}
	
	@Test
	public void checkviewAdminHome() {
		String str= restTemplate.getForObject("/adminhome", String.class);
		assertThat(str.equals("jsp/Admin/AdminHome"));
	}

	@Test
	public void checkviewCustomerHome() {
		String str= restTemplate.getForObject("/customerhome", String.class);
		assertThat(str.equals("jsp/Customer/CustomerHome"));
	}
	
	@Test
	public void checkshowLoginPage() {
		String str= restTemplate.getForObject("/login", String.class);
		assertThat(str.equals("jsp/login"));
	}
	
	@Test
	public void checklogout() {
		String str= restTemplate.getForObject("/logout", String.class);
		assertThat(str.equals("jsp/logout"));
	}
	
	@Test
	public void checkshowAboutUsPage() {
		String str= restTemplate.getForObject("/aboutUs", String.class);
		assertThat(str.equals("jsp/aboutUs"));
	}
	
	@Test
	public void checkshowRegisterPage() {
		String str= restTemplate.getForObject("/register", String.class);
		assertThat(str.equals("jsp/register"));
	}
	
	@Test
	public void checkaddBus() {
		String str= restTemplate.getForObject("/addbus", String.class);
		assertThat(str.equals("jsp/Admin/AddBus"));
	}
	
	@Test
	public void checkshowRunningBuses() {
		String str= restTemplate.getForObject("/showrunningbuses", String.class);
		assertThat(str.equals("jsp/Customer/SearchBus"));
	}
	
	@Test
	public void checkdeleteBus() {
		String str= restTemplate.getForObject("/deletebus", String.class);
		assertThat(str.equals("jsp/Admin/DeleteBuses"));
	}
	
	@Test
	public void checkshowAllUsers() {
		String str= restTemplate.getForObject("/showusers", String.class);
		assertThat(str.equals("jsp/Admin/ShowAllUsers"));
	}
	

	@Test
	public void checkaddBooking() {
		String str= restTemplate.getForObject("/addbooking", String.class);
		assertThat(str.equals("jsp/Customer/AddBooking"));
	}
	
	@Test
	public void checkaddPassenger() {
		String str= restTemplate.getForObject("/addpassenger", String.class);
		assertThat(str.equals("jsp/Customer/AddPassenger"));
	}
	

	@Test
	public void checkcancelBooking() {
		String str= restTemplate.getForObject("/cancelbooking", String.class);
		assertThat(str.equals("jsp/Customer/CancelBooking"));
	}
	
	@Test
	public void checkupdateBookingsList() {
		String str= restTemplate.getForObject("/viewupdatedbookings", String.class);
		assertThat(str.equals("jsp/Customer/UpdatedBookings"));
	}
	
	@Test
	public void checkconfirmPayment() {
		String str= restTemplate.getForObject("/confirmation", String.class);
		assertThat(str.equals("jsp/Customer/payment"));
	}
	
	@Test
	public void checkconfirmBooking() {
		String str= restTemplate.getForObject("/pdetail", String.class);
		assertThat(str.equals("jsp/Customer/confirmation"));
	}
	
	@Test
	public void checkviewCurrentBooking() {
		String str= restTemplate.getForObject("/viewcurrentbooking", String.class);
		assertThat(str.equals("jsp/Customer/currentBooking"));
	}
	

	@Test
	public void checkviewAllBookings() {
		String str= restTemplate.getForObject("/viewallbookings", String.class);
		assertThat(str.equals("jsp/Customer/ViewBookings"));
	}
}
