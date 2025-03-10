STORAGE MANAGER

Descrição:
Este projeto é um sistema de caixa desenvolvido em Java para uma loja de roupas. 
Ele permite o gerenciamento de estoque, vendas e controle de acesso para gerentes e vendedores. 
O sistema foi desenvolvido como parte da disciplina de Programação Orientada a Objetos (POO) e aplica conceitos como herança, interfaces, tratamento de erros e boas práticas de desenvolvimento.

Funcionalidades:

Login e Controle de Acesso:

Dois tipos de usuários: gerentes e vendedores.

Cada tipo de usuário tem um menu específico com funcionalidades diferentes.

Menu do Gerente:

Adicionar, remover, alterar e listar produtos.

Gerenciar o estoque da loja.

Visualizar histórico de vendas.

Menu do Vendedor:

Iniciar uma nova venda.

Listar produtos disponíveis.

Visualizar comissão acumulada (5% do valor total de cada venda).

Tratamento de Erros:

Validação de entradas para evitar erros (por exemplo, letras onde são esperados números).

Prevenção de vendas com estoque insuficiente.

Estrutura do Projeto:
O projeto está organizado no pacote storeManager, com as seguintes classes principais:

Classes de Produtos:

Produto: Classe base para todos os produtos.

Camiseta, Calca, Vestido, Casaco: Subclasses de Produto que representam tipos específicos de roupas.

Desconto: Interface implementada por produtos que possuem desconto.

Classes de Funcionários:

Funcionario: Classe base para gerentes e vendedores.

Gerente: Subclasse de Funcionario com permissões de gerenciamento de estoque.

Vendedor: Subclasse de Funcionario com permissões de vendas.

Classes de Gerenciamento:

GerenciamentoEstoque: Responsável por adicionar, remover, alterar e listar produtos.

GerenciamentoVenda: Responsável por gerenciar vendas e calcular comissões.

Classes de Menus:

MenuGerente: Menu específico para gerentes.

MenuVendedor: Menu específico para vendedores.

Classes de Suporte:

Venda: Representa uma transação de venda.

ItemVenda: Representa um item específico dentro de uma venda.

Estoque: Armazena e gerencia a lista de produtos.

Login: Responsável pela autenticação de usuários.

Como Executar o Projeto:
Pré-requisitos:

Java Development Kit (JDK) 8 ou superior.

Um ambiente de desenvolvimento Java (como IntelliJ IDEA, Eclipse ou VS Code).

Passos para Execução:

Abra o projeto em sua IDE Java.

Compile e execute a classe Main no pacote storeManager.

Exemplo de Uso:

Login:
Gerente:
Usuário: gerente1
Senha: senha

Vendedor:
Usuário: vendedor1
Senha: senha

Menu do Gerente:
Adicionar Produto:
Código: 101
Nome: Camiseta Preta
Preço: 29.90
Quantidade: 50
Tamanho: M
Cor: Preta

Alterar Produto:
Código: 101
Novo Preço: 25.00
Nova Quantidade: 40

Menu do Vendedor:
Iniciar Venda:
Código do Produto: 101
Quantidade: 2

Ver Comissão:
Comissão acumulada: R$ 2.50 (5% do valor total da venda).

Decisões de Design:

Herança:

As classes Camiseta, Calca, Vestido e Casaco herdam da superclasse Produto, permitindo a reutilização de código e a adição de atributos específicos.

Interface Desconto:

Implementada por produtos que possuem desconto, como Calca (10%) e Casaco (15%).

Tratamento de Erros:

O sistema valida entradas do usuário para evitar erros, como letras onde são esperados números.

Melhorias Futuras:

Persistência de Dados: Salvar os dados em arquivos ou banco de dados para que as informações não sejam perdidas ao fechar o programa.

Relatórios: Implementar um sistema de relatórios para gerentes, com gráficos e estatísticas de vendas.

Testes Automatizados: Adicionar testes unitários para garantir a robustez do sistema.

Autor: Diego Alex Maia de Lima