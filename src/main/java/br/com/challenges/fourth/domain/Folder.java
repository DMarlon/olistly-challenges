package br.com.challenges.fourth.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Folder implements FileSystem {
	private String name;
	private Map<String, FileSystem> content;

	public static Folder mkdir(String name) {
		if (Objects.isNull(name))
			throw new IllegalArgumentException("O parâmetro nome não pode ser nullo!");

		String sanitizedName = name.trim();

		if (sanitizedName.isEmpty())
			throw new IllegalArgumentException("O parâmetro nome não pode ser em branco!");

		return new Folder(sanitizedName);
	}

	private Folder(String name) {
		this.name = name;
		this.content = new HashMap<String, FileSystem>();
	}

	public Folder add(FileSystem fileSystem) {
		if (this.content.containsKey(fileSystem.getName()))
			throw new IllegalArgumentException(String.format("%s já existe!", fileSystem.getName()));

		this.content.put(fileSystem.getName(), fileSystem);

		return this;
	}

	public void remove(String name) {
		this.content.remove(name);
	}

	public String getName() {
		return this.name;
	}

	public long getSize() {
		if (Objects.isNull(this.content))
			return 0;

		return content.values().stream().collect(Collectors.summingLong(FileSystem::getSize));
	}
}
