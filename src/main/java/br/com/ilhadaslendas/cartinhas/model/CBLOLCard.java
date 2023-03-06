package br.com.ilhadaslendas.cartinhas.model;

import java.io.Serializable;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name="Cartinha", indexes = @Index(columnList = "idCartinha"))
public class CBLOLCard implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCartinha", nullable = false)
	private Integer id;
	
	@Column(name = "nome", nullable = false)
    private String playerName;
	
	@Column(name = "pais", nullable = false)
    private String country;
	
	@Column(name = "rating", nullable = false)
    private int rating;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data", nullable = false)
	private java.util.Date data;
	
	@Column(name = "descricao", nullable = false)
    private String description;

	public CBLOLCard() {
		
	}
	
    public CBLOLCard(String playerName, String country, Integer rating, java.util.Date data, String description) {
        this.playerName = playerName;
        this.country = country;
        this.rating = rating;
        this.data = data;
        this.description = description;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public java.util.Date getData() {
		return data;
	}

	public void setData(java.util.Date data) {
		this.data = data;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(country, data, description, id, playerName, rating);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CBLOLCard other = (CBLOLCard) obj;
		return Objects.equals(country, other.country) && Objects.equals(data, other.data)
				&& Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(playerName, other.playerName) && rating == other.rating;
	}

	@Override
	public String toString() {
		return "CBLOLCard [id=" + id + ", playerName=" + playerName + ", country=" + country + ", rating=" + rating
				+ ", data=" + data + ", description=" + description + "]";
	}

	
}

