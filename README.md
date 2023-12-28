<h1 align="center"> Thuler Products </h1>

- [Descrição do projeto](#descrição-do-projeto)
  
- [Funcionalidades](#funcionalidades)

- [Aplicação](#aplicação)

- [Ferramentas utilizadas](#ferramentas-utilizadas)

- [Abrir e executar o projeto](#abrir-e-executar-o-projeto)
  
<br>

## Descrição do projeto

<p align="justify">
  
O <strong>Thuler Products</strong> é um sistema de gerenciamento de produtos que permite a inserção, atualização, visualização, busca e deleção de produtos em uma base de dados PostgreSQL.
Para isso, foi usado a linguagem Java (JDBC, JSP, Servlets e JSTL).

</p>

<br>

## Funcionalidades

:heavy_check_mark: `Listar Produtos:` Lista todos os produtos armazenados no banco de dados em uma tabela, contendo todas as suas respectivas informações.

:heavy_check_mark: `Buscar Produto:` Através do código fornecido, será realizada a busca do produto correspondente e retornará as suas respectivas informações.

:heavy_check_mark: `Criar Novo Produto:` Através das informações fornecidas pelo usuário no formulário de cadastro de produto, realizará a inserção do mesmo no banco de dados.

:heavy_check_mark: `Excluir Produto:` Através do código fornecido, podendo ser o código correspondente ao produto (para excluí-lo) ou 0 (para excluir todos os produtos do banco de dados).

:heavy_check_mark: `Atualizar Produto:` Através das novas informações fornecidas pelo usuário no formulário de atualização de produtos, realizará a atualização do mesmo no banco de dados.

<br>

## Abrir e executar o projeto

Primeiro, certifique-se de que o `JDK 21` esteja instalado na sua máquina, assim como o `Apache Tomcat 10+` e o `Maven`. Também todas as variáveis de ambiente com as informações de acesso para seu banco de dados Postgre devem estar devidamente configuradas.

Após clonar ou baixar o projeto, pode abrí-lo na IDE de sua preferência e integrá-lo com o Apache Tomcat. Vou exemplificar um passo a passo na `IDE Eclipse`:

1. Abra a IDE, vá até o menu "File" e clique em `Open Projects from File System...`. Depois clique em "Directory", navegue até a pasta onde o projeto foi baixado ou clonado e clique em "Finish".

2. No menu inferior, procure pela aba "Terminal", vá até canto direito do mesmo menu e clique no primeiro ícone (Open a Terminal). E escolha o terminal de sua preferência.

3. Execute o comando:
```bash
mvn clean install
```
Assim, todas as dependências do projeto serão instaladas.

4. No mesmo menu inferior, procure pela aba "Servers" e clique em `No servers are available. Click this link to create a new server...` (1ª Linha).

5. Abra a pasta `Apache` e desça até a opção `Tomcat v10.1 Server` (Ou até a sua versão do Tomcat).

6. Clique em "Next" e na tabela do lado esquerdo, clique no projeto disponível, depois em "Add". Por fim, clique em "Finish".

7. Agora, no menu esquerdo (Project Explorer), basta clicar com o botão direito na pasta raíz do projeto, descer até a opção `Run as`, clicar em `Run on server` depois em "Finish".

8. Projeto rodando!

<br>
