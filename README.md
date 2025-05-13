# 📋 Projeto: Agenda de Tarefas (Java + MySQL)

Este é um projeto de Agenda de Tarefas desenvolvido em Java com interface gráfica usando **Swing**, seguindo o padrão **MVC** e integrado a um banco de dados **MySQL** para persistência de dados.

---

## 🚀 Funcionalidades

- Adicionar novas tarefas com título, descrição e status.
- Listar todas as tarefas cadastradas.
- Interface gráfica moderna e responsiva.
- Banco de dados para armazenamento permanente.

---

## 🛠 Tecnologias Utilizadas

- Java 17
- MySQL 8
- Swing (Interface Gráfica)
- JDBC (Conexão com MySQL via mysql-connector-java)

---

## 🗄 Estrutura do Banco de Dados

Antes de rodar o projeto, execute o seguinte script no seu MySQL:

```sql
CREATE DATABASE IF NOT EXISTS taskboard_db;

USE taskboard_db;

CREATE TABLE tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    status ENUM('Pendente', 'Em Progresso', 'Concluída') DEFAULT 'Pendente'
);
```

---

## 📂 Estrutura do Projeto

```
src/
├── controller/
│   └── TaskController.java
├── dao/
│   └── TaskDAO.java
├── model/
│   └── Task.java
├── util/
│   └── ConnectionFactory.java
└── view/
    └── TaskBoardGUI.java
```

---

## ⚙️ Como Rodar o Projeto

1. Baixe o driver JDBC: [mysql-connector-java](https://dev.mysql.com/downloads/connector/j/).
2. Compile o projeto incluindo o driver no classpath:

```bash
javac -cp ".;caminho/para/mysql-connector-java-8.4.0.jar" */*.java
```

3. Execute o projeto:

```bash
java -cp ".;caminho/para/mysql-connector-java-8.4.0.jar" view.TaskBoardGUI
```

(Lembre de ajustar o caminho do `.jar`!)

---

## 📢 Observações

- Certifique-se de que o MySQL esteja rodando.
- Ajuste o usuário e senha no arquivo `ConnectionFactory.java`, se necessário.
- O driver JDBC é essencial para a conexão funcionar.

---

## 📜 Licença

Este projeto é livre para uso educacional e profissional.

---
