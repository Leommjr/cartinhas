package br.com.ilhadaslendas.cartinhas.model;

import java.io.Serializable;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name="Time", indexes = @Index(columnList = "idTime"))
public class CBLOLTeam implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTime", nullable = false)
	private Integer id;
	
	@Column(name = "nome", nullable = false)
    private String teamName;
	
	@Column(name = "rating", nullable = false)
    private int rating;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data", nullable = false)
	private java.util.Date data;
	

	public CBLOLTeam() {
		
	}
	
    public CBLOLTeam(String teamName, Integer rating, java.util.Date data) {
        this.teamName = teamName;
        this.rating = rating;
        this.data = data;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
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

	@Override
	public int hashCode() {
		return Objects.hash(data, id, rating, teamName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CBLOLTeam other = (CBLOLTeam) obj;
		return Objects.equals(data, other.data) && Objects.equals(id, other.id) && rating == other.rating
				&& Objects.equals(teamName, other.teamName);
	}

	@Override
	public String toString() {
		return "CBLOLTeam [id=" + id + ", teamName=" + teamName + ", rating=" + rating + ", data=" + data + "]";
	}
    

}

