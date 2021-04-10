package co.edu.poli.act3;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PassEncrypt {

	public static void main(String[] args) {

		String password = "pass";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);

		System.out.println(hashedPassword);

	}
}
