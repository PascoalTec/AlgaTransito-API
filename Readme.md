# Ignição Spring Rest:
CRUD = Cadastro , Consulta, Exclusão, Atualização (CREATE, READ, UPDATE, DELETE)

EndPoints = Serviços para realizar operações CRUD


# Dependencias:

Starter Spring Web = Adiciona outras dependencias que é necessário para um projeto WEB funcionar

Model Mapper = Faz toda a desserialização do json quando chamado um get no PostMan


# Aulas de boas práticas:

## Aula 5.5 e 5.7


# Estrutura do Projeto:

#### .mvn = Maven Wrapper, maven imbutido dentro do projeto para que não precise instalar o maven no computador


#### .src/main = Pasta aonde fica os códigos Java


#### .src/resources = Pasta aonde fica os códigos de Configuração


#### .src/assembler = Ficam classes que montam instâncias de objetos


#### .gitignore = Caso esteja trabalhando com o git, ele ignora alguns arquivos


#### application.properties = Arquivo para fazer customizações de configurações do Projeto Spring Boot


#### domain = Aonde vai ficar todos os códigos que vão estar sobre o nosso dominio


#### domain/model = Aonde vao ficar as classes deste contexto (ex .: Proprietario)


# Arquivo do Maven:
pom.xml:
            POM = Project Object Model

coração de um projeto maven:
arquivo xml, contem informações e configurações do projeto usados pelo maven para fazer o build do projeto, todas as configurações de dependencias e
como o projeto vai ser construido


# FATJAR:

Empacotamento de aplicações para arquivo .jar



# Anotações

## @Bean:

Este metodo vai instanciar, inicalizar, configurar um Bean que será gerenciado pelo Spring, ele vai ser disponibilizado para injeção em outras classes

## @Configuration:

Ela declara que a classe é um componente do Spring, porém com um objetivo específico de definir Beans ou configurar Beans

## Componente Spring (@Component):

É um tipo, aonde as instâncias são gerenciadas pelo componente Spring

## @RestController:

Diz que a classe controller é um componente Spring propria para desenvolvimento de Rest APIs


## @RestControllerAdvice:

Uma especialização de um componente Spring que é responsavel por capturar excessões globais da aplicação


## @GetMapping:

Metodo para obter alguma representação de um recurso

## @Repository:

Define que a interface que esteja sendo usada , indica que é um componente do Spring, mas com uma semântica bem definida

## Auto Wired:

Esta anotação define que você quer injetar uma instância

## @PathVariable:

Usada para ter um vínculo do caminho da variável da URI e a variável do metodo, ela é usada atras do tipo do metodo

ex.: public Proprietario buscar(@PathVariable Long proprietarioId)

## @NotBlank:

Jakarta Bean Validation

Não pode ser nula, em branco, não é vazio... NotBlank contempla Notnull

## @NotNull:

Jakarta Bean Validation

Como o nome já diz, não pode ser nula


## @Valid

O valid vai dizer que ao acionar a execução do metodo, o objeto do tipo Proprietario precisa ser validado


## @Transactional:

Declara que o metodo deve ser executado dentro de uma transação

caso algo dê errado, todas as transações do banco de dados serão descartadas e ela terá um rollback para quando estava funcionando


## @AllArgsConstructor:

Inserida no inicio da classe, ela injeta os constructors e define as injeções fazendo a mesma coisa que o @AutoWired mas para todas que foram colocadas, e não uma de cada vez



## @ExceptionHandler(classe da excessão):

Indica que o metodo é capaz de capturar excessões e dar uma resposta mais adequada no Http


## @ManyToOne:

Muitos para 1


## @Enumerated:

Ela possibilita a gente configurar oque queremos armazenar na coluna de STATUS no modelo relacional, um número do codigo de status ou é o proprio nome
da constante


## @JsonProperty:

Faz a desserialização de xml ou json

Ela tem uma propriedade (acess.READ_ONLY), que estamos dizendo que esta propriedade será apenas para leitura <!-- Ela tem mais propriedades-->


## @Pattern:

Esta anotação você consegue fazer a validação de uma propriedade RegEx (Expressão Regular)
 


# Collection Resource:

Apenas para organizar as chamadas "requisições" feitas no PostMan 



# application.properties:

Arquivo para fazer customizações de configurações do Projeto Spring Boot



# spring.datasource.url:

Espera uma URL de conexão de banco de dados


ex.: jdbc:mysql://host1:33060/sakila

jdbc:mysql nao muda, é padrao de conexão do MySql


host1 é o endereço aonde o banco de dados será iniciado, caso a conexão seja local, terá que alterar para "localhost"

ex.: jdbc:mysql://localhost:33060/sakila


33060 é a porta do MySql, no meu caso para o meu MySql a porta é 3306 que é o padrão, se você não especificar, ele ja pega por padrão a 3306

ex.: jdbc:mysql://localhost:3306/sakila  OU jdbc:mysql://localhost/sakila


sakila é o nome do schema, grupamento aonde fica os elementos


ex.: tabelas, views, procedures


# Manutenção do banco de dados

db/migration

Arquivo para migration do MySQL, para criação de tabelas do banco de dados

# IMPORTANTE!! Necessário ser exatamente desta forma com V001 que dita o versionamento e dois __

ex.: V001__cria-tabela-proprietario.sql



# Jakarta Persistence (JPA)

Uma especificação que fornece a API um mapeamento de objeto relacional

@Entity() se não especificar o nome da tabela, por padrão o nome da classe vira o nome da tabela

@Table(name = "tb_proprietario") indica que a classe Proprietario agora está vinculada a tabela "tb_proprietario" no modelo relacional

ex.: A classe Proprietario seria uma classe de persistência

@Id define a propriedade como a propriedade de identificação do objeto, ela será a chave primária

@GeneratedValue(strategy = GenerationType.IDENTITY) define a estratégia de geração da chave para usar a forma nativa do banco de dados, por que ele está como auto incrementado

@Column - como as colunas já estão o mesmo nome, é opcional a inclusão desta anotação, quando a classe está anotada com a classe @Entity, elas já estão mapeadas usando o padrão, o nome da propriedade será o nome da coluna da tabela


@EntityManager - é a interface do Jakarta Persistence que é usada para fazer as operações com as entidades que depois são refletidas no banco de dados, ele é um gerenciador de entidades

Metodo Equals é o metodo que se usa para comparar objetos se o conteudo do objeto é igual a outro

#### Podemos gerar o EqualsAndHashCode pela dependencia do Lombok, usando @EqualsAndHashCode

@EqualsAndHashCode ele gera um equals e hashCode com base todas as prioridades, neste caso do projeto eu só quero o ID, você usa o (onlyExplicitlyIncluded = true), eu quero apenas as propriedades que eu incluir EXPLICITA



## ResponseEntity:

Ele representa a resposta que vai ser retornada, porém com ele podemos manipular melhor a resposta.





