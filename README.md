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
    A professional Java 17 enterprise-grade implementation of a medical scheduling system featuring robust JDBC persistence, multi-table inheritance, containerized architecture, state-of-the-art memory caching, and a reactive desktop interface.
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

This project is an advanced production-ready ecosystem built for managing patient records, medical appointments, and complex surgical schedules. It features a robust architectural design decoupled into a **true hybrid UI engine**: operations can be executed via an interactive, loop-protected native **Terminal CLI** or through a dynamic **Java Swing Graphical User Interface (GUI)** incorporating modern client-side performance optimizations.

<a id="the-c-to-java-architectural-refactoring"></a>
### 🧬 The C to Java Architectural Refactoring

> 🧠 **From Legacy C Streams to Modern Data Persistence:**
> This system was originally conceived as a rigorous data structures challenge at **UFMT (Federal University of Mato Grosso)**. The initial implementation was fully built in **C**, relying on an imperative programming paradigm where appointments were managed purely in volatile RAM using raw pointers and single-linked lists.
> 
> This version represents a complete architectural refactoring to fulfill a enterprise Object-Oriented environment:
> - **Inheritance & Polymorphism:** Moving away from flat legacy structures to clean class hierarchies (`Pessoa` $\rightarrow$ `Medico` / `Paciente`) mirrored into relational mapping via specialized PostgreSQL joined-subclass queries.
> - **Persistent ACID Ledger:** Replacing fragile runtime pointer management with industrial database persistence via pure **JDBC** and parameterized `PreparedStatement` to neutralize SQL Injection vulnerabilities.
> - **Transactional Integrity:** Enforcing manual multi-table transaction scopes (`commit` and `rollback`) to eliminate isolated or orphaned records when cascading parent-child inserts/updates.

**Note on Language:** To preserve the original academic criteria of the UFMT guidelines, domain model terms, internal error logs, and specific interface strings are written in **Portuguese**. However, the repository infrastructure, engineering patterns, and technical documentation are fully authored in **English**.

---

<a id="features"></a>
## ⚙️ Features

|      | Category          | Description |
| :--- | :---------------- | :----------- |
| 🖥️ | **Hybrid Frontend** | Seamless transition between a text-based Terminal CLI loop and a full-featured custom-designed Java Swing GUI Desktop dashboard. |
| 🧠 | **Cache Pattern** | State-of-the-art client-side local caching (`cacheConsultas`) that intercepts view listings, eliminating redundant PostgreSQL disk reads and maximizing responsiveness. |
| 🔍 | **Reactive Search** | Real-time multi-field filter engine running on a background `DocumentListener` that instantly scans 5 data columns as the user types, with automated grid reset. |
| 🛡️ | **Calendar Guard** | Precise temporal parser configured with `ResolverStyle.STRICT` to block chronologically impossible inputs (e.g., Leap year validations). |
| ⏳ | **Overlapping Engine** | Sophisticated constraint manager checking overlapping schedules (30-minute block for general consults and full procedural windows for surgeries). |
| 🐋 | **DevOps Container** | Local PostgreSQL 15 database isolation utilizing decoupled alpine Docker services and mapped storage volumes. |

---

<a id="project-structure"></a>
## 📁 Project Structure

The project layout divides infrastructure configurations, clean architecture layers (MVC), and automated validation domains:

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
<a id="database-design-initsql"></a>
## 🗄️ Database Design (`initsql`)

The application implements Table Inheritance and normalization architectures via cascading keys on PostgreSQL:

* **`pessoa` $\rightarrow$ `medico` / `paciente**`: Joined-subclass structures utilizing mutual foreign sequence indexes.
* **`consulta` $\rightarrow$ `consulta_clinica` / `cirurgia**`: Centralizes operational metadata (Dates, Times, Doctor CRMs) while allowing specialized parameters, tracked by sequence ticket identifiers (`CodTicket`).
* **`alergias`**: Decoupled multi-item table preventing data row duplicates through composite parameters (`UQ_Paciente_Alergia`).

---
<a id= "get-started"></a>
## 🧩 Get Started

### Prerequisites

* Java Development Kit (JDK) 17
* Apache Maven added to your terminal environment paths
* Docker & Docker Compose running in the background

### 🛠️ Local Installation & Setup

**1. Clone the repository and navigate to the project root:**

```bash
git clone [https://github.com/TurzimmGit/medical-appointment-manager.git](https://github.com/TurzimmGit/medical-appointment-manager.git)
cd medical-appointment-manager

```

**2. Boot up the PostgreSQL container infrastructure:**

```bash
docker compose down -v
docker compose up -d

```

*This resets historical volumes, builds the isolated network, and injects `init.sql` automatically.*

**3. Navigate to the Java module, clean, and compile using Maven:**

```bash
cd sistema-clinica
mvn clean compile

```

**4. Execute the Application:**

```bash
mvn exec:java -Dexec.mainClass="com.artur.clinica.app.Main"

```

---
<a id= "test-suite--validation"></a>
## 🧠 Test Suite & Validation

The application utilizes a robust test environment handled by JUnit 5 to test constraints both in memory and against live database environments:

```bash
mvn test

```

### Coverage Scope:

* **Memory Constraints:** Verifies format match constraints for names and CPF tokens, and isolates logical calendar blocks to reject illegal dates (e.g., February 30th).
* **Database Rules:** Runs parallel checks to block duplicate schedulings for matching medical profiles while allowing false-positive variations (different doctors in the same slot).
* **Strain Simulation:** Triggers automated block loops simulating 100 dynamic patient inputs to verify indexing transaction speed and connection pooling capacity before auto-purging tables.

---
<a id= "author"></a>
## 👤 Author

* **Artur Ferreira Sales (Turzimm)** — *Information Systems Student at UFMT*
* 📎 [GitHub Profile](https://github.com/TurzimmGit) | [LinkedIn](https://linkedin.com/in/artur-ferreira-sales-26a927370/)
* *If this project helped you understand OOP patterns, refactoring, or database integration, consider giving it a ⭐!*

---

## 📜 License

This project is licensed under the **MIT License**.

For full details, see the [LICENSE](https://github.com/TurzimmGit/Medical-Appointment-System/blob/main/LICENSE) file.


<p align="left">
<a href="#top">
<img src="https://img.shields.io/badge/Back_to_Top_⭱-09baba?style=flat&logoColor=white" />
</a>
</p>
