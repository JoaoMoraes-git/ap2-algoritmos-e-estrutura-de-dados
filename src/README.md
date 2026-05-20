## Trabalho AP2 de algorítmos e estruturas de dados feito por: João Guilherme Silva de Moraes

# Introdução

Este trabalho foi importante para o aprendizado das listas ligadas, principalmente sobre o funcionamento dos ponteiros e
da conexão entre as estruturas. A implementação permitiu compreender melhor a manipulação e o armazenamento dos dados, além
do funcionamento de listas simplesmente ligadas, duplamente ligadas e circulares. O projeto foi desenvolvido utilizando Java.

# Implementação

## Nó
As listas não são feitas com array, mas sim usando nós encadeados, em que cada item da lista possui o seu valor/dado junto com ponteiro
que leva para o próximo item, e o último aponta para `Null`.\
Os nós mudam um pouco dependendo do tipo de lista Ligada, em que a lista duplamente ligada também possui um ponteiro que leva
ao elemento anterior, e na lista circular o último ponteiro leva de volta ao primeiro elemento ao invés de `Null`.

## Remoção em lista vazia
Antes de remover algo elemento, é verificado se a listá tem algum elemento, para isso, é pego o valor do nó atual, caso seja um valor nulo,
(que ocorrerá apenas caso não tenha nada na Lista) nada é removido e isso é avisado ao usuário. Caso não, o processo continua
normalmente.

## Inserção em lista
Normalmente, ao adicionar um elemento novo, o ponteiro do elemento que fica antes do inserido passa a apontar para esse novo
elemento, e o ponteiro dessa inserção aponta para o próximo elemento.

Antes da inserção, é pego o valor do dado atual da lista, caso seja `Null`, então a lista está vazia e esse novo item não
vai apontar a nada, (exceto na lista circular, em que o elemento vai apontar para ele mesmo).

Em métodos de adição ao fim, o ponteiro do item novo não aponta a nada.

Em métodos de adição por posição/meio, caso seja adicionado em algum lugar no meio da lista, funciona normalmente, trocando os ponteiros.\
e caso seja colocado na última posição, a inserção funciona que nem uma adição ao fim, (para isso é observado o valor que veria
após o novo, caso seja vazio, ele está no fim).

## Remoção em lista
Ao remover um elemento, alguns ponteiros precisam ser atualizados, trocando o valor do ponteiro que leva ao atual que vai ser removido, para o elemento
que vem após esse removido.

## Prevenção de loops em estruturas circulares

Ao imprimir a lista circular, o percurso começa no primeiro elemento e passa por cada nó normalmente. Porém, como a estrutura
circular não possui um elemento apontando para `null`, foi necessário criar uma condição de parada para evitar repetições infinitas.

A impressão é encerrada quando o percurso retorna novamente ao primeiro elemento da lista, garantindo que todos os itens
sejam exibidos apenas uma vez.


# Evidências de execução

Imagens com o funcionamento do código estão disponíveis na pasta 'imagens'.

# Conclusão

As maiores dificuldades encontradas durante o desenvolvimento do projeto foram relacionadas ao funcionamento dos ponteiros, por ser
um conceito novo e diferente da utilização de arrays tradicionais.

Este trabalho permitiu compreender melhor o funcionamento de listas ligadas simples, duplas e circulares, além da manipulação dos dados
e das conexões entre os nós das estruturas.

