package it.uniroma3.model;

import javax.persistence.*;

import java.util.*;

@Entity
@NamedQuery(name = "findAllCustomers", query = "SELECT c FROM Customer c")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private  String lastName;
	
	@Column
	private String password;
	
	@Column
	private String email;
	
	@Column
	private int phoneNumber;
	
	@Column
	@Temporal (TemporalType.TIMESTAMP)
	private Calendar registrationDate;
	
	@OneToMany(mappedBy = "customer")
	private List<Order> orders;
	
	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;
	
	public Customer(){
		this.orders = new LinkedList<Order>();
	}

	public Customer(String firstname, String lastname, String email, 
					String password, int phoneNumber, Address address)
	{	
		this.address = address;
		this.firstName = firstname;
		this.lastName = lastname;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.orders = new LinkedList<Order>();
		this.registrationDate = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"));
		
	}	
	
	public Customer(String firstname, String lastname, String email, String password, int phoneNumber){
		this.firstName = firstname;
		this.lastName = lastname;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.orders = new LinkedList<Order>();
		this.registrationDate = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"));
		
	}
	
	public Customer(String firstName, String lastName){
		this.firstName=firstName;
		this.lastName=lastName;
		this.orders = new LinkedList<Order>();
		this.registrationDate = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"));
	}
	
	public Customer(String firstName, String lastName, String email, String password){
		this.firstName=firstName;
		this.lastName=lastName;
		this.email = email;
		this.password = password;
		this.orders = new LinkedList<Order>();
		this.registrationDate = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"));
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getId(){
		return this.id;
	}
	
	public String getFirstName(){
		return this.firstName;
	}
	
	public String getLastName(){
		return this.lastName;
	}
	
	
	public String getEmail(){
		return this.email;
	}
	
	public int getPhoneNumber(){
		return this.phoneNumber;
	}
	
	public void setFirstName(String newFirstName){
		this.firstName = newFirstName;
	}
	
	public void setLastName(String newLastName){
		this.lastName = newLastName;
	}
	
	public void setEmail(String newEmail){
		this.email = newEmail;
	}
		
	public void setPhoneNumber(int newPhoneNumber){
		this.phoneNumber = newPhoneNumber;
	}
	
	public void setAddress(Address newAddress){
		this.address = new Address();
		this.address = newAddress;
	}
	public Address getAddress(){
		return this.address;
	}
	
	public Calendar getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Calendar registrationDate) {
		this.registrationDate = registrationDate;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public void addOrder(Order newOrder){
		this.orders.add(newOrder);
	}
	
	public List<Order> getOrders(){
		return this.orders;
	}
	
	public boolean equals(Object o){
		Customer c = (Customer)o;
		return this.firstName.equals(c.getFirstName()) && this.password.equals(c.getPassword());
	}
	
	public boolean verifyPassword(String password){
		return this.password.equals(password);
	}
}
