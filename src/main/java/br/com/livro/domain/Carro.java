package br.com.livro.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Carro implements Serializable {

	private static final long serialVersionUID = -1830145804949737628L;
	
	@Id
	@Column(name="id",unique=true,nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false, length=50)
	private String tipo;
	
	@Column(nullable=false, length=100)
	private String nome;
	
	@Column(name="descricao",nullable=true, length=100)
	private String desc;
	
	@Column(nullable=true, length=50)
	private String urlFoto;
	
	@Column(nullable=true, length=50)
	private String urlvideo;
	
	@Column(nullable=true, length=15)
	private String latitude;
	
	@Column(nullable=true, length=15)
	private String longitude;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getUrlFoto() {
		return urlFoto;
	}
	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}
	public String getUrlvideo() {
		return urlvideo;
	}
	public void setUrlvideo(String urlvideo) {
		this.urlvideo = urlvideo;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	@Override
	public String toString() {
		return "Carro [id=" + id + ", tipo=" + tipo + ", desc=" + desc + ", urlFoto=" + urlFoto + ", urlvideo="
				+ urlvideo + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	
}
