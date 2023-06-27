package com.infotek.trivial.aplication.dominio;

public class Categoria {

    private String category;
    private String description;    
    
    public Categoria() {
		super();
	}
    
	public Categoria(String category, String description) {
		super();
		this.category = category;
		this.description = description;
	}


	public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
