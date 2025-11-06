### Resumo das Alterações Realizadas

1. **Criação Inicial dos Dockerfiles e do Docker Compose**
   Iniciei a configuração do ambiente Docker do projeto:

   * Criei o **Dockerfile do backend** (`Tutoria-PEI-FRAN-Backend/Dockerfile`) para construir e executar a aplicação Spring Boot.
   * Criei o **Dockerfile do frontend** (`TutoriaPEI-FRAN/Dockerfile`) para servir os arquivos estáticos da pasta `www` usando o Nginx.
   * Criei o arquivo **`docker-compose.yml`** na raiz do projeto, responsável por orquestrar os serviços do backend e do frontend.

2. **Ajustes nos Dockerfiles do Backend (Correção das Imagens Base)**
   Durante o processo, precisei corrigir diversas vezes as **tags das imagens base** no Dockerfile do backend, já que algumas versões iniciais não estavam disponíveis no Docker Hub. As alterações foram as seguintes:

   * `openjdk:21-jre-slim` → `openjdk:21-slim-jre`
   * `maven:3.8.5-openjdk-21` → `maven:3.9.6-openjdk-21`
   * `openjdk:21-slim-jre` → `openjdk:21-jre-slim-bullseye`
   * `maven:3.9.6-openjdk-21` → `maven:3.9.6-amazoncorretto-21` (imagem usada para o build com Maven)
   * `openjdk:21-jre-slim-bullseye` → `eclipse-temurin:21-jre-jammy` (imagem usada para a execução do JRE)

3. **Resolução do Erro “Não foi possível conectar ao servidor” (CORS e HTTPS)**
   Durante os testes, identifiquei que o erro de conexão entre o frontend e o backend estava sendo causado por dois fatores principais: o backend estava rodando em **HTTPS na porta 8443**, enquanto o frontend tentava se conectar a um **IP interno do Docker** ou a uma **porta incorreta**, além de um problema de **CORS**.

   As correções realizadas foram:

   * **`Registrar.js` (Frontend):**

     * Inicialmente, alterei a URL de conexão de `https://172.100.121.229:8443/usuarios` para `https://localhost:8443/usuarios`.
     * Depois, ao decidir usar HTTP para simplificar o ambiente local, mudei para `http://localhost:8080/usuarios`.

   * **`CorsConfig.java` (Backend):**

     * Ajustei as configurações de CORS para permitir requisições vindas de `http://localhost` e `http://127.0.0.1`, que são as origens do frontend.
     * Removi `https://localhost:8443` da lista de origens permitidas, já que essa URL pertence ao próprio backend.

   * **`application.properties` (Backend):**
     
     Como não tinha o certificado gerado por vocês.   

     * Comentei as configurações de SSL (`server.ssl.*`) e defini `server.port=8080`, permitindo que o backend rodasse em **HTTP** na porta 8080.
     * Essa mudança facilitou o desenvolvimento local e eliminou os problemas com certificados autoassinados.

   * **`docker-compose.yml`:**

     * Atualizei o mapeamento de portas do backend de `8443:8443` para `8080:8080`, refletindo a alteração para HTTP.

---

**Em resumo:**
As principais mudanças garantiram o uso de **imagens base válidas** nos Dockerfiles e a configuração correta da comunicação entre **frontend e backend via HTTP na porta 8080** durante o desenvolvimento. Com isso, consegui resolver os problemas de conexão e CORS que estavam ocorrendo na configuração inicial com HTTPS.

---

### Resumo – Uso do Docker Compose

O **Docker Compose** é a ferramenta que uso para definir e executar aplicações que dependem de vários contêineres Docker. Com um único arquivo `docker-compose.yml`, consigo configurar e gerenciar todos os serviços do projeto de forma integrada.

Os principais comandos que utilizo são:

* **`docker compose up`** – Cria e inicia os contêineres definidos no `docker-compose.yml`. Se já existirem, ele apenas os inicia. Uso `-d` quando quero rodar em segundo plano.
* **`docker compose up --build`** – Força a reconstrução das imagens antes de subir os contêineres. Costumo usar esse comando sempre que altero os Dockerfiles ou arquivos de configuração.
* **`docker compose build`** – Apenas constrói as imagens sem iniciar os contêineres, útil para testar o processo de build.
* **`docker compose down`** – Encerra e remove os contêineres, redes e volumes criados. Quando quero limpar completamente o ambiente, uso `docker compose down -v`.
* **`docker compose logs [SERVICE_NAME]`** – Mostra os logs de um ou mais serviços, o que me ajuda a monitorar e depurar o sistema.
* **`docker compose ps`** – Exibe o status dos contêineres, as portas e os nomes dos serviços ativos.

No meu fluxo de trabalho, geralmente sigo esta sequência:

1. **`docker compose up --build`** – para iniciar o ambiente pela primeira vez ou após alterações.
2. **`docker compose up`** – para subir rapidamente os serviços quando nada mudou.
3. **`docker compose logs`** – para acompanhar a execução e resolver possíveis problemas.
4. **`docker compose down`** – para encerrar tudo e liberar recursos ao finalizar o trabalho.

---

Agora é preciso testar com o Cordova para gerar o APK. 

