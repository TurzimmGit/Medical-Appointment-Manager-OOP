<p align="center">
  <img src="sistema-clinica/src/main/resources/assets/ClinicaProjetoLogo.png" width="400px" height="100px" alt="Project Logo"/>
</p>

<p align="center">
  <h1 align="center">Medical Appointment Manager (Clinicativa v1.0)</h1>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/License-MIT-09baba?style=flat-square&logo=opensourceinitiative&logoColor=white"/>
  <img src="https://img.shields.io/badge/For-UFMT_Academic_Training-09baba?style=flat-square&logo=gitbook&logoColor=white"/>
  <img src="https://img.shields.io/badge/%F0%9F%9A%80_Tests-100%25_Passing-09baba?style=flat-square"/>
</p>

<p align="center">
  <em>
    A professional Java 17 implementation of a medical scheduling system featuring robust JDBC persistence, multi-table inheritance, containerized architecture, and desktop interface support.
  </em>
</p>

<p align="center"><em>Built with:</em></p>
<p align="center">
  <img src="https://img.shields.io/badge/Language-Java_17-09baba?style=flat-square&logo=openjdk&logoColor=white"/>
  <img src="https://img.shields.io/badge/Database-PostgreSQL_15-09baba?style=flat-square&logo=postgresql&logoColor=white"/>
  <img src="https://img.shields.io/badge/Environment-Docker_&_Compose-09baba?style=flat-square&logo=docker&logoColor=white"/>
  <img src="https://img.shields.io/badge/Framework-Maven_&_JUnit5-09baba?style=flat-square&logo=apachemaven&logoColor=white"/>
</p>

---

<details><summary><b>📋 Table of Contents</b></summary>

- [🧭 Overview](#overview)
  - [The C to Java Architectural Refactoring](#the-c-to-java-architectural-refactoring)
- [⚙️ Features](#features)
- [📁 Project Structure](#project-structure)
- [🗄️ Database Design (init.sql)](#database-design-initsql)
- [🧩 Get Started](#get-started)
- [🧠 Test Suite & Validation](#test-suite--validation)
- [👤 Author](#author)
- [📜 License](#license)

</details>

<a id="overview"></a>
## 🧭 Overview

This project is an advanced enterprise-grade ecosystem built for managing patient records, medical appointments, and surgical schedules. It provides a flexible user experience supporting a **hybrid UI engine**: operations can be fully executed via an interactive native **Terminal CLI** loop or through a structured, responsive **Java Swing Graphical User Interface (GUI)** designed with production-ready UX principles.

<a id="the-c-to-java-architectural-refactoring"></a>
### 🧬 The C to Java Architectural Refactoring

> 🧠 **From Legacy C Streams to Modern Data Persistence:**
> This system was originally conceived as a rigorous data structures challenge at **UFMT (Federal University of Mato Grosso)**. The initial implementation was fully built in **C**, relying on an imperative programming paradigm where appointments were managed purely in volatile RAM using raw pointers and single-linked lists.
> 
> This version represents a complete architectural refactoring to fulfill a production-ready Object-Oriented environment:
> - **Inheritance & Polymorphism:** Moving away from flat data structures to clean class hierarchies (`Pessoa` $\rightarrow$ `Medico` / `Paciente`) mirrored into relational mapping via specialized database queries.
> - **Persistent ACID Ledger:** Replacing custom runtime memory storage with standard structural database engines via pure **JDBC**.
> - **Transactional Integrity:** Enforcing strict multi-table transaction blocks (`commit` and `rollback`) to eliminate isolated or orphaned database records.

**Note on Language:** To preserve the original academic criteria of the UFMT guidelines, variable domain terms, error logs, and console print statements are explicitly written in **Portuguese**. However, the repository infrastructure, continuous integration designs, and structural descriptions are documented in **English** to remain aligned with standard developer methodologies.

---

<a id="features"></a>
## ⚙️ Features

|      | Category          | Description |
| :--- | :---------------- | :----------- |
| ☕ | **Hybrid Frontend** | Seamless system operation through an interactive text-based Terminal CLI or a custom-designed Java Swing GUI desktop application. |
| 🐋 | **DevOps Container** | Local PostgreSQL 15 database isolation utilizing decoupled alpine Docker services and mapped storage volumes. |
| 🛡️ | **Calendar Guard** | Precise temporal parser configured with `ResolverStyle.STRICT` to block chronologically impossible inputs (e.g., Leap year check for February 29th). |
| ⏳ | **Overlapping Engine** | Sophisticated constraint manager checking overlapping schedules (30-minute block for general consults and full procedural windows for surgeries). |
| 🚀 | **Automated Pipeline** | Complete integration testing pipeline executing continuous multi-stage inputs, stress loads of 100 entries, and cascade rollbacks. |

---

<a id="project-structure"></a>
## 📁 Project Structure

The project layout divides local docker definitions, source code domains, and automated validation files:

```text
.
├── .github/
│   └── modernize/java-upgrade/hooks/scripts/
├── .vscode/
├── docker-dev/
│   └── init-db/                     # Schema definition script (init.sql)
├── Modelagem De Dados/              # Unified database models and entity maps
└── sistema-clinica/                 # Main Maven codebase root
    ├── src/
    │   ├── main/
    │   │   ├── java/com/artur/clinica/
    │   │   │   ├── app/             # Application bootstrappers and Swing GUI Views
    │   │   │   ├── Controller/      # Application orchestration layers (MVC Pattern)
    │   │   │   ├── exception/       # Specialized business logic exceptions
    │   │   │   ├── model/           # Relational domain business entities
    │   │   │   └── services/        # JDBC Persistence Layer (DAO Modules)
    │   │   └── resources/
    │   │       └── assets/          # Embedded vector banners and app branding icons
    │   └── test/java/com/artur/clinica/
    │       ├── ConflitoHorarioTest.java
    │       ├── ConsultaIntegracaoTest.java
    │       └── ConsultaValidacaoTest.java
    ├── target/                      # Production compiler builds output
    └── pom.xml                      # Project Object Model dependencies manifesto

```

---

## 🗄️ Database Design (`init.sql`)

The system implements Table Inheritance and normalization architectures via cascading keys on PostgreSQL:

* **`pessoa` $\rightarrow$ `medico` / `paciente**`: Joined-subclass structures utilizing mutual foreign sequence indexes.
* **`consulta` $\rightarrow$ `consulta_clinica` / `cirurgia**`: Centralizes operational metadata (Dates, Times, Identifiers) while allowing specialized parameters, tracked by sequence ticket identifiers (`CodTicket`).
* **`alergias`**: Decoupled multi-item table preventing data row duplicates through composite parameters (`UQ_Paciente_Alergia`).

---

## 🧩 Get Started

### Prerequisites

* Java Development Kit (JDK) 17
* Apache Maven added to terminal environment paths
* Docker & Docker Compose running on background

### 🛠️ Local Installation & Setup

**1. Clone the repository and navigate to the project directory:**

```bash
git clone [https://github.com/TurzimmGit/medical-appointment-manager.git](https://github.com/TurzimmGit/medical-appointment-manager.git)
cd medical-appointment-manager

```

**2. Boot up the PostgreSQL container service:**

```bash
docker compose down -v
docker compose up -d

```

*This resets historical volumes, builds the database network, and injects `init.sql` automatically.*

**3. Compile the Java code using Maven:**

```bash
mvn clean compile

```

**4. Run the program:**

```bash
mvn exec:java -Dexec.mainClass="com.artur.clinica.app.Main"

```

---

## 🧠 Test Suite & Validation

The application utilizes a robust test environment handled by JUnit 5 to test constraints both in memory and against physical database environments:

```bash
mvn test

```

### Coverage Scope:

* **Memory Constraints:** Verifies format match constraints for names and CPF tokens, and isolates logical calendar blocks to reject illegal dates (e.g., February 30th).
* **Database Rules:** Runs parallel checks to block duplicate schedulings for matching medical profiles while allowing false-positive variations (different doctors in the same slot).
* **Strain Simulation:** Triggers automated block loops simulating 100 dynamic patient inputs to verify indexing transaction speed and connection pooling capacity before auto-purging tables.

---

## 👤 Author

* **Artur Ferreira Sales (Turzimm)** — *Information Systems Student at UFMT*
* 📎 [GitHub Profile](https://github.com/TurzimmGit) | [LinkedIn](https://linkedin.com/in/artur-ferreira-sales-26a927370/)
* *If this project helped you understand OOP patterns, refactoring, or database integration, consider giving it a ⭐!*

---

## 📜 License

This project is licensed under the **MIT License**.

For full details, see the [LICENSE](https://github.com/TurzimmGit/Medical-Appointment-System/blob/main/LICENSE) file.