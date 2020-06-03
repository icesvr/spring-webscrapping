package com.scrapping.app.models;

public class Aviso {

	
	private String titulo;
	private String categoria;
	private String Precio;
	private String img;
	private String url;
	private String region;
	private String comuna;
	
	
	
	public Aviso() {}
	public Aviso(String titulo, String categoria, String precio, String img, String url, String region, String comuna) {
		
		this.titulo = titulo;
		this.categoria = categoria;
		Precio = precio;
		this.img = img;
		this.url = url;
		this.region = region;
		this.comuna = comuna;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getPrecio() {
		return Precio;
	}
	public void setPrecio(String precio) {
		Precio = precio;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getComuna() {
		return comuna;
	}
	public void setComuna(String comuna) {
		this.comuna = comuna;
	}
	
	
	

}
