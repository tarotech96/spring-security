/**
 * 
 */
package nvcong.taro_oppa.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Taro User Entity
 */
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", columnDefinition = "INT", nullable = false)
	private int id;
	@Column(name = "fullname", columnDefinition = "VARCHAR(255)")
	private String fullName;
	@Column(name = "role", columnDefinition = "VARCHAR(60)")
	private String role;
	@Column(name = "email", columnDefinition = "VARCHAR(60)", nullable = false)
	private String email;
	@Column(name = "password", columnDefinition = "VARCHAR(30)", nullable = false)
	private String password;
	@Column(name = "salary", columnDefinition = "INT")
	private int salary;
	@Column(name = "country", columnDefinition = "VARCHAR(255)")
	private String country;
	@Column(name = "city", columnDefinition = "VARCHAR(255)")
	private String city;
	@Column(name = "company", columnDefinition = "VARCHAR(255)")
	private String company;
	@Column(name = "address", columnDefinition = "VARCHAR(255)")
	private String address;
	@Column(name = "description", columnDefinition = "VARCHAR(255)")
	private String description;

	@OneToMany(mappedBy = "user", targetEntity = Role.class, fetch = FetchType.EAGER)
	private Set<Role> roles;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int id, String fullName, String role, String email, String password, int salary, String country,
			String city, String company, String address, String description, Set<Role> roles) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.role = role;
		this.email = email;
		this.password = password;
		this.salary = salary;
		this.country = country;
		this.city = city;
		this.company = company;
		this.address = address;
		this.description = description;
		this.roles = roles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
