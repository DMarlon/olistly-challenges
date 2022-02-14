package br.com.challenges;

import java.util.Arrays;

import br.com.challenges.fifth.Fifth;
import br.com.challenges.fifth.exception.CreateCryptorException;
import br.com.challenges.fifth.exception.DecryptionException;
import br.com.challenges.fifth.exception.EncryptionException;
import br.com.challenges.fifth.exception.GenerateSecretException;
import br.com.challenges.fifth.model.Cryptor;
import br.com.challenges.first.domain.Intersection;
import br.com.challenges.first.domain.Union;
import br.com.challenges.fourth.domain.File;
import br.com.challenges.fourth.domain.Folder;
import br.com.challenges.second.Second;
import br.com.challenges.third.domain.Palindrome;

public class Challenges {
	private static final int[] first = {4, 5, 6};
	private static final int[] second = {1, 2, 3, 5, 1, 1};

    public static void main(String[] args) {
    	executeFirst();
    	executeSecond();
    	executeThird();
    	executeFourth();
    	executeFifth();
    }

    public static void executeFirst() {
		System.out.println("Iniciando primeiro desafio!");

		System.out.println(String.format("Argumento 1: %s", Arrays.toString(Challenges.first)));
		System.out.println(String.format("Argumento 2: %s", Arrays.toString(Challenges.second)));

		System.out.println(String.format("Resultado união: %s", Arrays.toString(Union.arrays(Challenges.first, Challenges.second).transform())));
		System.out.println(String.format("Resultado interseção: %s", Arrays.toString(Intersection.arrays(Challenges.first, Challenges.second).transform())));

		System.out.println("Fim");
		System.out.println("");
    }

    public static void executeSecond() {
		System.out.println("Iniciando segundo desafio!");

		System.out.println(String.format("Argumento: %s", Arrays.toString(Challenges.second)));
		Second second = new Second();
		System.out.println(String.format("Resultado: %s",Arrays.toString(second.execute(Challenges.second))));

		System.out.println("Fim");
		System.out.println("");
    }

    public static void executeThird() {
    	System.out.println("Iniciando terceiro desafio!");

		System.out.println(String.format("parâmetro: %s é palíndromo: %b", "ovo", Palindrome.is("ovo")));
		System.out.println(String.format("parâmetro: %s é palíndromo: %b", "osso", Palindrome.is("osso")));
		System.out.println(String.format("parâmetro: %s é palíndromo: %b", "reviver", Palindrome.is("reviver")));
		System.out.println(String.format("parâmetro: %s é palíndromo: %b", "olist", Palindrome.is("olist")));

		System.out.println("Fim");
		System.out.println("");
    }

    public static void executeFourth() {
		System.out.println("Iniciando quarto desafio!");

		Folder boot = Folder.mkdir("boot");
		boot.add(File.touch("grub.fake", new byte[10000]));

		Folder home = Folder.mkdir("home");
		home.add(Folder.mkdir("teste").add(File.touch("README.md", new byte[2500])));

		Folder etc = Folder.mkdir("etc");
		etc.add(File.touch("hosts", new byte[2500]));
		etc.add(File.touch("hostx", new byte[5000]));


		Folder init = Folder.mkdir("/");
		init.add(boot);
		init.add(home);
		init.add(etc);

		System.out.println(String.format("Tamanho do file system é: %d kb", init.getSize() / 1000));

		System.out.println("Fim");
		System.out.println("");
    }

    public static void executeFifth() {
    	System.out.println("Iniciando quinto desafio!");

		try {
			Fifth fifth = new Fifth();

			Cryptor cryptor = fifth.execute();
			String encrypt = cryptor.encrypt("Criptografar AES Teste");
			String decrypt = cryptor.decrypt(encrypt);

			System.out.println(String.format("Encriptografado: %s", encrypt));
			System.out.println(String.format("Descriptografado: %s", decrypt));

		} catch (GenerateSecretException | CreateCryptorException | EncryptionException | DecryptionException exception) {
			System.out.println("Erro ao criptografar os dados");
		}

		System.out.println("Fim");
		System.out.println("");
    }

}
