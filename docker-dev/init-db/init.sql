CREATE SEQUENCE IF NOT EXISTS seq_consulta_clinica START WITH 1;
CREATE SEQUENCE IF NOT EXISTS seq_cirurgia START WITH 1;

--  TABELA MÃE: PESSOA
CREATE TABLE pessoa (
    IDPessoa SERIAL PRIMARY KEY,
    Nome VARCHAR(80) NOT NULL
);

--  TABELA FILHA: MEDICO 
CREATE TABLE medico (
    IDPessoa INTEGER PRIMARY KEY,
    CRM VARCHAR(13) UNIQUE NOT NULL,
    Especialidade VARCHAR(80) NOT NULL,
    CONSTRAINT FK_Medico_Pessoa FOREIGN KEY (IDPessoa) 
        REFERENCES pessoa (IDPessoa) ON DELETE CASCADE
);

--  TABELA FILHA: PACIENTE 
CREATE TABLE paciente (
    IDPessoa INTEGER PRIMARY KEY,
    CPF VARCHAR(15) UNIQUE NOT NULL,
    TipoSanguineo VARCHAR(3) NOT NULL,
    data_nascimento DATE NOT NULL,
    CONSTRAINT FK_Paciente_Pessoa FOREIGN KEY (IDPessoa) 
        REFERENCES pessoa (IDPessoa) ON DELETE CASCADE
);

--  TABELA DE ALERGIAS
CREATE TABLE alergias (
    IDAlergias SERIAL PRIMARY KEY,
    IDPessoa INTEGER NOT NULL,
    Alergias VARCHAR(30) NOT NULL,
    CONSTRAINT FK_Alergias_Paciente FOREIGN KEY (IDPessoa) 
        REFERENCES paciente (IDPessoa) ON DELETE CASCADE,
    -- Garante que o mesmo paciente não tenha a mesma alergia duplicada!
    CONSTRAINT UQ_Paciente_Alergia UNIQUE (IDPessoa, Alergias) 
);

--  TABELA MÃE: CONSULTA GERAL
CREATE TABLE consulta (
    IDConsulta SERIAL PRIMARY KEY,
    CRM VARCHAR(13) NOT NULL,
    CPF VARCHAR(15) NOT NULL,
    Data DATE NOT NULL,
    Horario TIME NOT NULL,
    CONSTRAINT FK_Consulta_Medico FOREIGN KEY (CRM) 
        REFERENCES medico (CRM) ON DELETE RESTRICT,
    CONSTRAINT FK_Consulta_Paciente FOREIGN KEY (CPF) 
        REFERENCES paciente (CPF) ON DELETE RESTRICT
);

-- TABELA FILHA: CONSULTA CLINICA 
CREATE TABLE consulta_clinica (
    IDConsulta INTEGER PRIMARY KEY,
    CodTicket VARCHAR(14) UNIQUE NOT NULL,
    TipoConsulta VARCHAR(11) NOT NULL,
    CONSTRAINT FK_Clinica_Consulta FOREIGN KEY (IDConsulta) 
        REFERENCES consulta (IDConsulta) ON DELETE CASCADE
);

--  TABELA FILHA: CIRURGIA 
CREATE TABLE cirurgia (
    IDConsulta INTEGER PRIMARY KEY,
    CodTicket VARCHAR(14) UNIQUE NOT NULL,
    TipoAnestesia VARCHAR(10) NOT NULL,
    TipoCirurgia VARCHAR(15) NOT NULL,
    CONSTRAINT FK_Cirurgia_Consulta FOREIGN KEY (IDConsulta) 
        REFERENCES consulta (IDConsulta) ON DELETE CASCADE
);

--  TABELA INTERMEDIÁRIA: PARTICIPA 
CREATE TABLE participa (
    IDConsulta INTEGER,
    CRM VARCHAR(13),
    PRIMARY KEY (IDConsulta, CRM),
    CONSTRAINT FK_Participa_Cirurgia FOREIGN KEY (IDConsulta) 
        REFERENCES cirurgia (IDConsulta) ON DELETE CASCADE,
    CONSTRAINT FK_Participa_Medico FOREIGN KEY (CRM) 
        REFERENCES medico (CRM) ON DELETE RESTRICT
);