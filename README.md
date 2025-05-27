# FinTech Solutions - Landing Page

## 📋 Visão Geral

Este projeto é uma landing page completa desenvolvida com Play Framework 2.6, PostgreSQL 11 e Bootstrap 4.6, criada para atender aos requisitos do teste prático da Pague Bem Brasil. A aplicação apresenta uma empresa fictícia de tecnologia financeira, com áreas dinâmicas para exibição de serviços/produtos, gráfico de faturamento e formulário de contato.

## ✨ Funcionalidades

- **Área Sobre a Empresa**: Seção com informações sobre a empresa fictícia FinTech Solutions
- **Catálogo de Serviços/Produtos**: Exibição dinâmica de produtos carregados do banco de dados
- **Gráfico de Faturamento**: Visualização gráfica do faturamento mensal dos últimos 6 meses usando ChartJS
- **Formulário de Contato**: Interface para os visitantes entrarem em contato com a empresa
- **Design Responsivo**: Layout adaptável para dispositivos móveis e desktop

## 🛠️ Tecnologias Utilizadas

- **Backend**:
  - Play Framework 2.6 (Java)
  - PostgreSQL 11
  - Ebean ORM
  - Java 11
  
- **Frontend**:
  - Bootstrap 4.6
  - ChartJS 2.9.4
  - jQuery 3.5.1
  - HTML5/CSS3
  
- **Ferramentas de Build**:
  - SBT (Scala Build Tool)
  - Play Ebean Plugin

## 📦 Pré-requisitos

Antes de começar, certifique-se de ter instalado:

- JDK 11 ou superior
- SBT (Scala Build Tool)
- PostgreSQL 11
- Git (opcional, para versionamento)

## 🚀 Instalação e Configuração

### 1. Instalação do JDK

**Ubuntu/Debian**:
```bash
sudo apt update
sudo apt install -y openjdk-11-jdk
```

**Windows**:
- Baixe o JDK 11 do site oficial da Oracle ou use o OpenJDK
- Configure a variável de ambiente JAVA_HOME

**macOS**:
```bash
brew install openjdk@11
```

Verifique a instalação:
```bash
java -version
```

### 2. Instalação do SBT

**Ubuntu/Debian**:
```bash
echo "deb https://repo.scala-sbt.org/scalasbt/debian all main" | sudo tee /etc/apt/sources.list.d/sbt.list
echo "deb https://repo.scala-sbt.org/scalasbt/debian /" | sudo tee /etc/apt/sources.list.d/sbt_old.list
curl -sL "https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x2EE0EA64E40A89B84B2DF73499E82A75642AC823" | sudo apt-key add
sudo apt update
sudo apt install -y sbt
```

**Windows**:
- Baixe o instalador do SBT do site oficial: https://www.scala-sbt.org/download.html

**macOS**:
```bash
brew install sbt
```

### 3. Configuração do PostgreSQL

**Ubuntu/Debian**:
```bash
# Adicionar repositório do PostgreSQL
sudo sh -c 'echo "deb http://apt.postgresql.org/pub/repos/apt $(lsb_release -cs)-pgdg main" > /etc/apt/sources.list.d/pgdg.list'
wget --quiet -O - https://www.postgresql.org/media/keys/ACCC4CF8.asc | sudo apt-key add -
sudo apt update

# Instalar PostgreSQL 11
sudo apt install -y postgresql-11

# Iniciar o serviço
sudo systemctl start postgresql
sudo systemctl enable postgresql
```

**Windows**:
- Baixe o instalador do PostgreSQL 11 do site oficial: https://www.postgresql.org/download/windows/

**macOS**:
```bash
brew install postgresql@11
brew services start postgresql@11
```

### 4. Configuração do Banco de Dados

Em qualquer sistema operacional, execute os seguintes comandos para configurar o banco de dados:

```bash
# Linux/macOS
sudo -u postgres psql -c "CREATE USER playapp WITH PASSWORD 'playapp';"
sudo -u postgres psql -c "CREATE DATABASE playapp_db OWNER playapp;"
sudo -u postgres psql -c "GRANT ALL PRIVILEGES ON DATABASE playapp_db TO playapp;"

# Windows (após abrir o psql)
CREATE USER playapp WITH PASSWORD 'playapp';
CREATE DATABASE playapp_db OWNER playapp;
GRANT ALL PRIVILEGES ON DATABASE playapp_db TO playapp;
```


## ▶️ Executando o Projeto

1. Navegue até o diretório do projeto:
   ```bash
   cd caminho/para/projeto_completo
   ```

2. Execute a aplicação:
   ```bash
   sbt run
   ```

3. Acesse a aplicação em seu navegador:
   ```
   http://localhost:9000
   ```

   Na primeira execução, o Play Framework irá aplicar automaticamente as evolutions do banco de dados. Clique em "Apply this script now!" quando solicitado.

## 🧩 Estrutura do Projeto

```
projeto_completo/
├── app/                    # Código fonte da aplicação
│   ├── controllers/        # Controladores da aplicação
│   │   ├── HomeController.java
│   │   ├── ProductController.java
│   │   └── RevenueController.java
│   ├── models/             # Modelos de dados
│   │   ├── Product.java
│   │   └── Revenue.java
│   └── views/              # Templates de visualização
│       ├── index.scala.html
│       └── main.scala.html
├── conf/                   # Arquivos de configuração
│   ├── application.conf    # Configuração principal
│   ├── routes              # Definição de rotas
│   └── evolutions/         # Scripts de evolução do banco de dados
│       └── default/
│           └── 1.sql       # Script inicial de criação de tabelas e dados
├── public/                 # Arquivos estáticos
│   ├── images/             # Imagens do site
│   ├── javascripts/        # Arquivos JavaScript
│   └── stylesheets/        # Arquivos CSS
│       └── main.css
├── project/                # Configurações do SBT
│   └── plugins.sbt         # Plugins do SBT
└── build.sbt               # Arquivo de build
```

## 📝 Detalhes de Implementação

### Backend

O backend da aplicação é construído com Play Framework 2.6 e utiliza o padrão MVC (Model-View-Controller):

- **Models**: Representam as entidades do banco de dados e a lógica de negócios
  - `Product.java`: Modelo para produtos/serviços
  - `Revenue.java`: Modelo para dados de faturamento

- **Controllers**: Processam as requisições e retornam as respostas
  - `HomeController.java`: Renderiza a página principal
  - `ProductController.java`: API para produtos
  - `RevenueController.java`: API para dados de faturamento

- **Views**: Templates Scala que geram o HTML
  - `main.scala.html`: Template base com cabeçalho, menu e rodapé
  - `index.scala.html`: Template da página principal

### Frontend

O frontend utiliza Bootstrap 4.6 para o layout responsivo e ChartJS para a visualização de dados:

- **Bootstrap**: Framework CSS para design responsivo
- **ChartJS**: Biblioteca JavaScript para criação de gráficos
- **jQuery**: Biblioteca JavaScript para manipulação do DOM

### Banco de Dados

O PostgreSQL 11 é utilizado como banco de dados relacional, com as seguintes tabelas:

- **product**: Armazena informações sobre produtos/serviços
- **revenue**: Armazena dados de faturamento mensal

## 🔄 APIs Disponíveis

A aplicação expõe as seguintes APIs RESTful:

- **GET /api/products**: Retorna todos os produtos/serviços
- **GET /api/products/:id**: Retorna um produto específico pelo ID
- **GET /api/revenues**: Retorna todos os dados de faturamento


## 📊 Personalização

### Modificando a Empresa Fictícia

Para personalizar a empresa fictícia, edite:

- Informações da empresa em `app/views/index.scala.html`
- Logo e cores em `public/stylesheets/main.css`
- Nome da empresa em `app/views/main.scala.html`

### Adicionando Novos Produtos/Serviços

Para adicionar novos produtos/serviços, edite o script de evolução em `conf/evolutions/default/1.sql` ou use o console SQL do PostgreSQL:

```sql
INSERT INTO product (name, description, image_url, price) VALUES 
('Novo Serviço', 'Descrição do novo serviço', '/assets/images/novo-servico.jpg', 299.90);
```

### Modificando o Gráfico de Faturamento

Para personalizar o gráfico de faturamento:

1. Edite os dados em `conf/evolutions/default/1.sql`
2. Modifique as opções do gráfico em `app/views/index.scala.html`

## 👨‍💻 Autor

Gabriel Inojoza

