package cn.it.shop.model;

/**
 * Account entity. @author MyEclipse Persistence Tools
 */

public class Account implements java.io.Serializable {

	// Fields

	private Integer id;
	private String login;
	private String name;
	private String password;
	
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", login=" + login + ", name=" + name
				+ ", password=" + password + "]";
	}
	// Constructors

	

	/** default constructor */
	public Account() {
	}

	/** full constructor */
	public Account(String login, String name, String password) {
		this.login = login;
		this.name = name;
		this.password = password;
	}
	
	

	public Account(Integer id, String login, String name, String password) {
		super();
		this.id = id;
		this.login = login;
		this.name = name;
		this.password = password;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}