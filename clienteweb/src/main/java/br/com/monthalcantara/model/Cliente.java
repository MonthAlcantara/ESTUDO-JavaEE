package br.com.monthalcantara.model;

public class Cliente {
private String email;

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

@Override
public String toString() {
	return "Cliente [email=" + email + "]";
}

}
