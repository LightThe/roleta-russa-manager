# Roleta Russa Manager

Um sistema de gerenciamento para eventos informais em equipes com um usuário pagante (patrocinador) por evento. O Roleta Russa Manager existe para controlar quais pessoas já pagaram, eventos que ainda estão para acontecer (com um sistema de agendamentos) e eventuais acordos entre as pessoas da equipe, como trocas entre os patrocinadores, adiamentos inteligentes e divisão da conta entre mais de um patrocinador.

## Andamento

### O que já acontece

Backend em Spring/JPA com endpoints REST

### O que ainda falta

Frontend Angular com componentes PrimeNG

## REST API Endpoints:

Coming soon

## Dependências Necessárias

* Coming
* Soon

## Como Usar

Após realizar o clone do repositório, execute o container necessario para o banco de dados navegando até a pasta dos containers e executando o docker compose:

```bash
cd Docker/containers
docker-compose up -d
```

Após a inicialização do banco de dados, execute a aplicação backend através do maven:

```bash
mvn spring-boot:run
```

Divirta-se de montão

## Contribuindo para o projeto

Para contribuir com o desenvolvimento do Roleta Russa Manager, você precisa atender as dependências listadas acima, 

### Compilação

Antes de executar a aplicação, é necessario realizar uma compilação inicial através do maven:

```bash
mvn clean install
```
