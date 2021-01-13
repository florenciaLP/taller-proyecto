package utils;

import java.util.Random;

public class RandomCuponCode {

	public static void main(String[] args) {
		System.out.println(RandomCuponCode.getRandomCode());
	}

	public static String getRandomCode() {
		Random rnd = new Random();
		String caracteresPermitidos = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String codigo = "";
		for(int i = 0 ; i < 10 ; i++) {
			codigo += (char)caracteresPermitidos.charAt(rnd.nextInt(caracteresPermitidos.length() - 1 ));
		}
		return codigo;
	}
}