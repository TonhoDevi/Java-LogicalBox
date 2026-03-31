# Simulação de Partículas 2D (Java-LogicalBox)

Este projeto é uma simulação interativa de física rodando diretamente no terminal, desenvolvida em Java. O programa cria um espaço amostral bidimensional (uma grade) onde partículas interagem, se movem e colidem umas com as outras e com as paredes do ambiente.

## 🚀 Funcionalidades

- **Ambiente Customizável:** O usuário define o tamanho da grade (entre 5x5 e 15x15).
- **Controle Direcional:** O usuário escolhe a posição inicial e o vetor de força (direção) da partícula principal (`O`).
- **Partículas Autônomas:** Duas partículas adicionais (`X` e `H`) são geradas aleatoriamente e possuem movimento próprio.
- **Sistema de Colisões:** Sistema de física simples que calcula o ricochete (bounce) quando partículas colidem com as bordas do mapa ou entre si.
- **Animação no Terminal:** A cada passo/movimento, o console é atualizado mostrando o trajeto das partículas, deixando um rastro (`~`) por onde passam e marcando colisões com um símbolo (`@`).

## 📋 Pré-requisitos

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/) versão 8 ou superior instalado.

## 🔧 Como Executar

1. Compile o código executando o comando abaixo no terminal de sua preferência, na pasta onde se encontra o arquivo `main.java`:

```bash
javac main.java
```

2. Após compilado, execute o programa com o comando:

```bash
java inter.main
```

> **Nota:** Se você estiver utilizando uma IDE como o VS Code, IntelliJ IDEA ou Eclipse, basta abrir o arquivo `main.java` e clicar no botão "Run" (Executar).

## 🎮 Como Jogar / Utilizar

Ao iniciar a simulação, o terminal fará as seguintes perguntas:

1. **Tamanho do Espaço:** Digite um valor entre 5 e 15 para formar a grade do mapa plano.
2. **Posição Inicial (X e Y):** Digite a posição horizontal (X) e vertical (Y) em que sua partícula `O` irá nascer.
3. **Direção da Força:** É exibido um menu de 1 a 8 representando as direções possíveis (Cima, Direita, Baixo, Esquerda e as diagonais). Escolha a direção que sua partícula seguirá.
4. **Número de Movimentos:** Quantos turnos a simulação irá rodar automaticamente antes de finalizar.

A partir daí, observe pelo painel os movimentos das partículas e as colisões!

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java puro (Vanilla Java)
- Tipagem básica de matrizes multidimensionais (Arrays)
- Loops e condições lógicas complexas para os sistemas de rebotes e colisões
- Controle de fluxo e Threads (`Thread.sleep`) para animação no console
