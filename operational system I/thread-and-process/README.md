Semaphore I:

4 pessoas caminham, cada uma em um
corredor diferente. Os 4 corredores terminam
em uma única porta. Apenas 1 pessoa pode
cruzar a porta, por vez. Considere que cada
corredor tem 200m. e cada pessoa anda de 4 a
6 m/s. Cada pessoa leva de 1 a 2 segundos
para abrir e cruzar a porta. Faça uma
aplicação em java que simule essa situação.


---
Thread III:

Fazer uma aplicação de uma corrida de sapos, com 5
Threads, cada Thread controlando 1 sapo. Deve haver um
tamanho máximo para cada pulo do sapo (em metros) e a
distância máxima para que os sapos percorram. A cada salto,
um sapo pode dar uma salto de 0 até o tamanho máximo do
salto (valor aleatório). Após dar um salto, a Thread, para cada
sapo, deve mostrar no console, qual foi o tamanho do salto e
quanto o sapo percorreu. Assim que o sapo percorrer a
distância máxima, a Thread deve apresentar que o sapo
chegou e qual sua colocação.

---
Thread I:

Fazer uma aplicação que rode 5 Threads que
cada uma delas imprima no console o seu
número.

---
Semaphore II:

Para tal, usar uma variável sentido, que será alterado pela Thread que controla
cada carro com a movimentação do carro. Quando a Thread tiver a possibilidade de ser
executada, ela deve imprimir em console o sentido que o carro está passando. Só pode passar um carro
por vez no cruzamento.

---

Semaphore IV:

Um banco deve controlar Saques e Depósitos.
O sistema pode permitir um Saque e um Depósito
Simultâneos, mas nunca 2 Saques ou 2 Depósitos
Simultâneos.
Para calcular a transação (Saque ou Depósito), o método deve
receber o código da conta, o saldo da conta e o valor a ser
transacionado.
Deve-se montar um sistema que deve considerar que 20
transações simultâneas serão enviadas ao sistema
(aleatoriamente essas transações podem ser qualquer uma das
opções) e tratar todas as transações, de acordo com as regras
acima.


---
Thread Bilheteria:

Considere o seguinte cenário:
Um grande show acontecerá no Brasil, em uma casa com capacidade para 100 pessoas.
A venda será feita excluisvamente pelo sistema.
Simultaneamente, 300 pessoas, no primeiro instante acessam o sistema de compra.
As pessoas podem comprar de 1 a 4 ingressos por compra, sendo que isso é uma condição aleatória.
Os passos para a compra são:
1) Login no sistema: Processo que pode demorar de 50 ms a 2 s, sendo que, se o tempo passar de 1s,
ao final do tempo de espera de login, o comprador recebe uma mensagem de timeout e, por não
conseguir fazer o login, não poderá fazer a compra.
2) Processo de compra: Processo que pode demorar de 1 s a 3 s, sendo que, se o tempo passar de
2,5s, ao final do tempo de espera da compra, o comprador recebe uma mensagem de final de tempo
de sessão e, por estourar o tempo de sessão, não poderá fazer a compra.
3) Validação da compra: O sistema deve verificar se há ingressos suficientes para finalizar a
compra. Se houver, faz a compra e subtrai do total de ingressos disponíveis. O sistema comunica a
venda da quantidade de ingressos para o usuário e a quantidade de ingressos ainda disponíveis. Se
não houver a totalidade dos ingressos disponibiliados, o comprador recebe mensagem sobre a
indisponibilidade dos ingressos e, como não é possível fracionar a quantidade pedida, este perde a
possibilidade de compra na sessão.
Simular em Java essa situação
A
A
A
A
A
A
B
B
B
B
B
B
B
B
B
* O processo de validação da compra, apenas 1

---
Semaphore III:

Você foi contratado para automatizar um treino de Fórmula 1.
As regras estabelecidas pela direção da provas são simples:
“No máximo 5 carros das 7 escuderias (14 carros no total)
presentes podem entrar na pista simultaneamente, mas apenas
um carro de cada equipe. O segundo carro deve ficar à espera,
caso um companheiro de equipe já esteja na pista. Cada piloto
deve dar 3 voltas na pista. O tempo de cada volta deverá ser
exibido e a volta mais rápida de cada piloto deve ser
armazenada para, ao final, exibir o grid de largada, ordenado
do menor tempo para o maior.”

---

Thread II:

Fazer uma aplicação que insira números
aleatórios em uma matriz 3 x 5 e tenha 3
Threads, onde cada Thread calcula a soma dos
valores de cada linha, imprimindo a identificação
da linha e o resultado da soma.

---

Thread V:

Fazer, com o Java SWING, uma aplicação de
caça-níquel, conforme figura abaixo. O caça níquel
tem 3 JTextFields, independentes, que giram,
aleatoriamente, de 1 a 150 vezes e apresentará um
número de 1 a 7. Quando iniciado, o botão Jogar
deve desaparecer.

---

Processos I:

Criar em Eclipse, um novo Java Project com uma classe chamada
RedesController.java no package controller e uma classe Main.java no
package view.
A classe RedesController.java deve ter 2 métodos.
O primeiro, chamado ip, que recebe o nome do Sistema Operacional como
parâmetro e, de acordo com o S.O., faz a chamada de configuração de IP e
filtra a saída do processo, retornando um String com o nome do Adaptador
Ethernet e o IPv4 apenas (Não importa o número de adaptadores ethernet,
devem aparecer todos). Os adaptadores que não tiverem IPv4 não devem
ser mostrados.
O segundo, chamado ping, que recebe o nome do Sistema Operacional
como parâmetro e, de acordo com o S.O., faz a chamada de ping com 10
iterações, filtra a saída, pegando apenas o tempo e dá a saída, em ms, do
tempo médio do ping. (O endereço para ping, pode ser o
www.google.com.br)
A Classe Main.java deve ter a possibilidade de o usuário escolher a ação que
quer fazer e, dependendo da escolha, instanciar a Classe
RedesController.java e chamar o método escolhido. A opção de finalizar a
aplicação também deve estar disponível.
* Para filtrar a saída String, considere utilizar contains, Split, substring,
lastIndexOf, trim;

---

Thread Cavaleiros:

4 cavaleiros caminham por um corredor, simultaneamente, de 2 a 4 m por 50 ms. O corredor é
escuro, tem 2 km e em 500 m, há uma única tocha. O cavaleiro que pegar a tocha, aumenta sua
velocidade, somando mais 2 m por 50 ms ao valor que já fazia. Em 1,5 km, existe uma pedra
brilhante. O cavaleiro que pegar a pedra, aumenta sua velocidade, somando mais 2 m por
50 ms ao valor que já fazia. Ao final dos 2 km, os cavaleiros se separam em 4
corredores cada um com uma porta e, um por vez pega uma porta aleatória (que não pode
repetir) e entra nela. Apenas uma porta leva à saída. As outras 3 tem monstros que os
devoram.
Simular a situação em Java.

---

Processos III:

Ex. 3
Utilizando o Framework Window Builder, criar, em Eclipse, um projeto Java
que simula o Executar (Run) do Windows.
No package view, deve ser criado, com auxílio do framework, conforme
figura abaixo, uma tela com um JTextField e 3 botões (OK, Cancelar e
Procurar).
No package controller, devemos ter :
1) Uma classe que receba o JTextField pelo construtor, implementa um
ActionListener para executar a ação do botão Procurar. No método
ActionPerformed, deve ter uma busca de arquivos executáveis
Windows, via JFileChooser, e seleciona o arquivo a ser executado e
escreve seu caminho completo no JTextField.
2) Uma classe que receba o JTextField e o próprio JFrame da tela pelo
construtor, implementa um ActionListener para executar a ação do
botão OK. No método ActionPerformed, deve tentar executar o que
está escrito no JTextField (O usuário pode digitar o caminho por conta
própria, ao invés de procurar). Caso o arquivo seja inválido, dar uma
mensagem de erro. Uma vez executado, sem erro, a tela deverá ser
finalizado pelo método dispose().
3) Uma classe que receba o próprio JFrame da tela pelo construtor,
implementa um ActionListener para executar a ação do botão
Cancelar. O método actionPerformed deve proceder um dispose() da
tela.


---

Processos II:

Fazer, em java, uma aplicação que liste os processos ativos, permita ao
usuário entrar com o nome ou o PID do processo e o mate.
A aplicação deverá funcionar, minimamente em Windows e Linux (Alunos
com Mac podem fazer para os 3 SO).
É notório que cada SO tem comandos diferentes para as ações
supracitadas. Pesquisar os comandos para cada SO.
A aplicação deverá ter, no package view, uma classe que tenha um método
main que dê ao usuário a possibilidade de ver os processos ativos ou matar
os processos (Por Nome ou PID).
No package controller, deverá ter:
1) Uma classe que tenha um método que identifique o SO;
2) Um método que, recebendo o SO, no qual está rodando, como
parâmetro de entrada, selecione o comando para listar os processos
ativos;
3) Um método que, recebendo o SO, no qual está rodando, e o PID do
processo, como parâmetros de entrada, selecione o comando para
matar o processo e o finalize;
4) Um método que, recebendo o SO, no qual está rodando, e o Nome
do processo, como parâmetros de entrada, selecione o comando
para matar o processo e o finalize;
