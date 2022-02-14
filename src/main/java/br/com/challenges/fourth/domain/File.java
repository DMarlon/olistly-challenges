package br.com.challenges.fourth.domain;

import java.util.Objects;

public class File implements FileSystem {
	private String name;
	private byte[] content;

	public static File touch(String name, byte[] content) {
		if (Objects.isNull(name))
			throw new IllegalArgumentException("O parâmetro nome não pode ser nullo!");

		if (Objects.isNull(content))
			throw new IllegalArgumentException("O parâmetro conteudo não pode ser nullo!");

		String sanitizedName = name.trim();

		if (sanitizedName.trim().isEmpty())
			throw new IllegalArgumentException("O parâmetro nome não pode ser em branco!");

		return new File(sanitizedName, content);
	}

	private File(String name, byte[] content) {
		this.name = name;
		this.content = content;
	}

	public String getName() {
		return this.name;
	}

	public long getSize() {
		return this.content.length;
	}
}
