# Bootcamp IGTI: Programador de Software Iniciante
## Módulo 3 - Desafio**
---
## Enunciado
Desenvolver um programa em Java utilizando os conceitos de orientação a objetos para auxiliar na gestão de uma concessionária de veículos.

O programa deve permitir cadastrar os carros e motos que a concessionária possui, assim como o vendedor responsável por vender cada um desses itens.

Pelo programa, também deve ser possível cadastrar clientes dessa concessionária. Na classe de carro e moto, é preciso ter um campo que representa o cliente que comprou o veículo, de forma que, no momento do cadastro do carro, este campo deve ser vazio. Depois, no programa, deve existir uma opção no qual o usuário consiga determinar que um cliente adquiriu um bem.

Dessa forma, as principais classes do programa serão cliente, vendedor, carro e moto. Os campos que cada uma dessas classes deve ter, com os seus tipos entre parênteses, são os seguintes:

**Cliente**
* Nome (String);
* CPF (String);
* Endereço (String).

**Vendedor**
* Nome (String);
* CPF (String);
* Matrícula (Integer).

**Carro**
* Modelo (String);
* Marca (String);
* Ano (Integer);
* Valor (Double);
* Vendedor Responsável (Vendedor);
* Cliente que comprou (Cliente).

**Moto**
* Modelo (String);
* Marca (String);
* Ano (Integer);
* Valor (Double);
* Vendedor Responsável (Vendedor);
* Cliente que comprou (Cliente).

Caso queira exercitar mais os conceitos, o aluno pode criar uma classe abstrata chamada Pessoa, e fazer com que Cliente e Vendedor herdem dela. Também, é possível criar uma classe abstrata chamada Veículo e fazer com que Carro e Moto herdem dela.

Ao consultar carros, motos, clientes ou vendedores, basta imprimir no terminal a lista com essas informações.

Ao solicitar o cadastro de um cliente, basta pedir as informações pelo terminal ao usuário, e, então, criar um objeto do tipo cliente e armazená-lo em uma lista. O mesmo para vendedor, carro e moto. No caso do carro e da moto, também é preciso perguntar qual é o vendedor responsável por aquele item, podendo ser informado o índice do vendedor na lista de vendedores.

Ao solicitar a venda de um carro ou moto, o programa deve perguntar ao usuário qual é o índice do item que está sendo vendido, e qual é o índice do cliente que está comprando. Também é preciso alterar o registro do carro ou moto, atualizando o cliente informado como comprador.

O programa deve apresentar ao usuário um menu pelo terminal, com opções que permitam que ele execute as funcionalidades solicitadas anteriormente. Não há necessidade de armazenar esses registros em disco, como em algum arquivo. O armazenamento pode ser somente na memória do programa mesmo, não há problema em perder os registros ao reiniciar.
