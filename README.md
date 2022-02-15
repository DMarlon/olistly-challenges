# Nome Do Projeto

Olistly - Desafios

## 🔧 Desafios

1. União e Intersecção
2. Maiores Valores Array
3. Palíndromo
4. File System
5. Criptografia

## Executação do Projeto

* Usando docker
1. Pode ser baixado apenas o [Dockerfile](Dockerfile)
2. Após o download basta criar a imagem usando o comando ```docker build . -t nome_da_imagem```
3. Após buildar o projeto basta executa-lo usando o comando ```docker run nome_da_imagem```

* Fazendo manualmente
1. Para execução manual do projeto deve ser clonado o repositório.
2. Deve ser executado o build do projeto usando o comando ```./gradlew build```
3. O build vai gerar o arquivo .jar na pasta ```build/libs/challenges-0.0.1-OLY.jar```
4. Para executar-lo basta rodar ```java -jar challenges-0.0.1-OLY.jar```
5. Para verificar o relatorio dos testes basta acessar o arquivo ```index.html``` no local ```build/reports/tests/test/index.html```

## Observações

* Para o projeto em geral tentei utilizar tipos primitivos do Java, pois suas bibliotecas padrões de coleções e objetos já tem muitas coisas implementadas e prontas, que se usadas dificultaria a avaliação do teste, pois seria apenas a utilização de sua biblioteca sem necessidade de escrever a lógica.
* Para as classes de domínio tentei utilizar o padrão de projeto static factory juntamente com construtores privados, evitando assim a construção de objetos externamente as suas classes, assim auxiliando na legibilidade do código tentando deixar o mesmo usando fluent interface.
* Para o desafio 5 foi usado meu projeto já existente de [criptografia](https://github.com/DMarlon/cryptography), visando facilitar o uso de AES em projetos Java.

# Testes

* Foi desenvolvido testes unitários das classes criadas no projeto, visando facilitar a manutenção e refatoração do código.
* Todos os testes são executados no build do projeto, caso algum teste não passar o build não é concluído.
* No momento do build do projeto é criado um relatório referente a execução dos testes, o mesmo permite navegar e verificar detalhadamente cada execução. Para facilitar o acesso foi criado um link simbólico na raiz do projeto chamado ```test-report.html```

## Feito Com:
[![UBUNTU](https://img.shields.io/badge/Ubuntu-e95420?style=for-the-badge&logo=ubuntu&logoColor=white)](https://ubuntu.com/download)
[![JAVA](https://img.shields.io/badge/Java-cc0000?style=for-the-badge&logo=java&logoColor=white)](https://www.java.com/)
[![ECLIPSE](https://img.shields.io/badge/Eclipse-2c2255?style=for-the-badge&logo=eclipse&logoColor=white)](https://www.eclipse.org/downloads/)
[![GRADLE](https://img.shields.io/badge/gradle-538fa4?style=for-the-badge&logo=gradle&logoColor=white)](https://gradle.org/)

## 🔖 Licença
[![LICENÇA](https://img.shields.io/badge/Custom_GPL_3.0-E58080?style=for-the-badge&logo=bookstack&logoColor=white)](/LICENSE)

### Suporte Ou Contato

[![GITHUB](https://img.shields.io/badge/Github-000000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/dmarlon/)
[![Linkedin](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/marlon-dauernheimer-55278073/)

### Documentação de Referência
Para referência adicional, considere as seguintes seções:

* [Official Gradle documentation](https://docs.gradle.org)
* [Junit documentation](https://junit.org/junit4/project-info.html)
* [Docker documentation](https://docs.docker.com/)

