import java.util.ArrayList;
import java.util.Scanner;

public class Atividade1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Digite a palavra a ser criptografada: ");
		String palavra = sc.nextLine();

		ArrayList<Integer> passwordArray = new ArrayList<Integer>();
		passwordArray.add(10);
		passwordArray.add(8);
		passwordArray.add(4);
		passwordArray.add(11);
		passwordArray.add(2);

		StringBuilder password = new StringBuilder();

		for (Integer number : passwordArray) {
			password.append(number + " ");
		}

		System.out.println();
		System.out.print("Senha atual: " + password);
		System.out.println();
		System.out.println();

		String alfabeto = "abcdefghijklmnopqrstuvwxyzç";

		ArrayList<String> list = new ArrayList<String>();

		for (int i = 0; i < 27; i++) {
			list.add(String.valueOf(alfabeto.charAt(i)));
		}

		ArrayList<Integer> letterNumber = new ArrayList<Integer>();
		int count = 0;
		int soma = 0;

		for (int i = 0; i < palavra.length(); i++) {
			int letterPosition = 0;
			boolean stop = false;
			for (String letter : list) {
				if (!stop) {
					if (String.valueOf(palavra.charAt(i)).equals(" ")) {
						soma += passwordArray.get(count);
						letterNumber.add(soma);
						stop = true;
						count++;
					} else if (letter.equalsIgnoreCase(String.valueOf(palavra.charAt(i)))) {
						letterPosition = list.indexOf(letter) + 1;
						soma += letterPosition + passwordArray.get(count);
						letterNumber.add(soma);
						stop = true;
						count++;
					}
					if (count == 5) {
						count = 0;
					}
					soma = 0;
				}
			}
		}
		
		
		while(count != 0) {
			soma += passwordArray.get(count);
			letterNumber.add(soma);
			count++;
			if (count == 5) {
				count = 0;
			}
			soma = 0;
		}

		StringBuilder palavraCriptografada = new StringBuilder();

		for (Integer number : letterNumber) {
			if (number >= 28) {
				palavraCriptografada.append(number);

			} else {
				palavraCriptografada.append(list.get(number - 1));
			}
		}

		System.out.println("Palavra Criptografada: " + palavraCriptografada);

		sc.close();
	}

}