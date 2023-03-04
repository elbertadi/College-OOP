package Main;

public class Dish {
	
	private String name;
	private Integer quantity;
	private Float time;
	private String id;
	
	public Dish(String name, Integer quantity, Float time, String id) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.time = time;
		this.id = id;
	}
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Float getTime() {
		return time;
	}


	public void setTime(Float time) {
		this.time = time;
	}


	public Dish() {
		// TODO Auto-generated constructor stub
	}

}
