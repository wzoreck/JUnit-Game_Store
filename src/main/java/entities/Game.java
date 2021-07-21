package entities;

public class Game {

	private String name;
	private String description;
	private Category category;
	private Float price;
	private Integer discountPercentage;

	public Game(String name, String description, Category category) {
		this.name = name;
		this.description = description;
		this.category = category;
		this.price = 0f;
		this.discountPercentage = 0;
	}

	public Game(String name, String description, Category category, Float price, Integer discountPercentage) {
		this.name = name;
		this.description = description;
		this.category = category;
		this.price = price;
		this.discountPercentage = discountPercentage;
	}

	// Other Methods

	public Float getDiscount() {
		Float discountPrice = this.price * discountPercentage;
		return this.price - discountPrice;
	}

	// ./Other Methods

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(Integer discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

}
