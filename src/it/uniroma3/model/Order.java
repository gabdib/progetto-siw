package it.uniroma3.model;

import javax.persistence.*;

import java.util.*;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "orders_id")
	private List<OrderLine> orderLines;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	/*
	 * la variabile può assumere il valore:
	 * 		-"open" se l'ordine non è ancora chiuso;
	 * 		-"close" se l'ordine è concluso ma inevaso;
	 * 		-"processed" se l'ordine è evaso.
	 */
	@Column
	private String state;
	
	@Column
	@Temporal (TemporalType.TIMESTAMP)
	private Calendar processingDate;

	@Column
	@Temporal (TemporalType.TIMESTAMP)
	private Calendar openingDate;

	@Column
	@Temporal (TemporalType.TIMESTAMP)
	private Calendar closingDate;
	
	public Order(Customer customer){
		this.customer = customer;
		this.orderLines = new LinkedList<OrderLine>();
		this.state = "open";
		this.openingDate = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"));
	}	
	
	public Order(){
		this.orderLines = new LinkedList<OrderLine>();
		this.state = "open";
		this.openingDate = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"));
	}	
	
	public Customer getCustomer(){
		return this.customer;
	}
	
	public void setCustomer(Customer newCustomer){
		this.customer = newCustomer;
	}
	
	public void addOrderLine(OrderLine newOrderLine){
		orderLines.add(newOrderLine);
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public long getId() {
		return id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Calendar getProcessingDate() {
		return processingDate;
	}

	public void setProcessingDate(Calendar processingDate) {
		this.processingDate = processingDate;
	}

	public Calendar getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Calendar openingDate) {
		this.openingDate = openingDate;
	}

	public Calendar getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Calendar closingDate) {
		this.closingDate = closingDate;
	}
}