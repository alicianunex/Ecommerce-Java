package entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
/**
 * Entity implementation class for Entity: Client
 */
@Entity
@Table(name="client")
public class Client implements Serializable {
   
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;


	public Client() {
	}   

	public Client(String name, String address, String phone, String email, String password) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}   
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", adress=" + address + ", phone=" + phone
				+ ", email=" + email + ", password=" + password + "]";
	}

}
