import java.util.Scanner;

class CafofoDaGermaLanchonete {
    static Scanner scanner = new Scanner(System.in);
    static int ind = 0;
    static int max = 1;
    static rCadPedido[] vCadPedido = new rCadPedido[10];

    static class rCadPedido {
        int numeropedido;
        int tipoatendimento;
        String nomecliente;
    }

    static void escolher() {
        System.out.println("####### CAFOFO DA GERMA LANCHONETE ########");
        System.out.println("# 1 - Incluir Pedido");
        System.out.println("# 6 - Atender Pedido");
        System.out.println("# 3 - Listar Pedido");
        System.out.println("# 4 - Pesquisar Pedido");
        System.out.println("# 5 - Encerrar");
        System.out.println("###########################################");
    }

    static void incluirPedido() {
        System.out.println("Digite o número do pedido:");
        System.out.println("1 - Pastel");
        System.out.println("2 - Coxinha");
        System.out.println("3 - Lasanha");
        System.out.println("4 - Pizza");
        System.out.println("5 - Rodízio de Massas");

        vCadPedido[max] = new rCadPedido();

        try {
            vCadPedido[max].numeropedido = scanner.nextInt();
            scanner.nextLine();
        } catch (java.util.InputMismatchException e) {
            scanner.next();
            System.out.println("Opção inválida. Pressione Enter para continuar.");
            scanner.nextLine();
            return;
        }

        System.out.println("Digite o tipo de atendimento:");
        System.out.println("1 - Atendimento online");
        System.out.println("2 - Atendimento presencial");

        try {
            vCadPedido[max].tipoatendimento = scanner.nextInt();
            scanner.nextLine(); 
        } catch (java.util.InputMismatchException e) {
            scanner.next(); 
            System.out.println("Opção inválida. Pressione Enter para continuar.");
            scanner.nextLine();
            return;
        }

        System.out.println("Digite o nome do cliente:");
        scanner.nextLine(); 
        vCadPedido[max].nomecliente = scanner.nextLine();
        System.out.println("Recebi seu pedido.");
        System.out.println("--------------------------------");
        System.out.println("PEDIDO");

        switch (vCadPedido[max].numeropedido) {
            case 1:
                System.out.println("Pastel");
                break;
            case 2:
                System.out.println("Coxinha");
                break;
            case 3:
                System.out.println("Lasanha");
                break;
            case 4:
                System.out.println("Pizza");
                break;
            case 5:
                System.out.println("Rodízio de Massas");
                break;
        }
        switch (vCadPedido[max].tipoatendimento) {
            case 1:
                System.out.println("Atendimento online");
                break;
            case 2:
                System.out.println("Atendimento presencial");
                break;
        }
        System.out.println("Nome do Cliente: " + vCadPedido[max].nomecliente);
        System.out.println("--------------------------------");
        max++;
    }

    static void listarPedido() {
        System.out.println("--------------------------------");
        for (int cont = 1; cont < max; cont++) {
            System.out.println("PEDIDO");
            System.out.println("NOME DO CLIENTE: " + vCadPedido[cont].nomecliente);
            switch (vCadPedido[cont].tipoatendimento) {
                case 1:
                    System.out.println("Atendimento online");
                    break;
                case 2:
                    System.out.println("Atendimento presencial");
                    break;
            }
            switch (vCadPedido[cont].numeropedido) {
                case 1:
                    System.out.println("Pastel");
                    break;
                case 2:
                    System.out.println("Coxinha");
                    break;
                case 3:
                    System.out.println("Lasanha");
                    break;
                case 4:
                    System.out.println("Pizza");
                    break;
                case 5:
                    System.out.println("Rodízio de Massas");
                    break;
            }
        }
    }

    static void pesquisarPedido() {
        if (max == 1) {
            System.out.println("Lista Vazia - Não Existem Pedidos.");
            return;
        }

        System.out.println("Digite o número do pedido que deseja pesquisar:");
        int numeroPesquisar = scanner.nextInt();
        scanner.nextLine(); 

        boolean encontrado = false;

        for (int i = 1; i < max; i++) {
            if (vCadPedido[i].numeropedido == numeroPesquisar) {
                System.out.println("Pedido encontrado na posição " + i);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Pedido não encontrado.");
        }
    }

      static void atenderCliente() {
        ind++;
    }

      static void encerrarPrograma() {
        if (ind == 0) {
            System.out.println("Pedido finalizado, volte sempre!");
        } else {
            System.out.println("Não é possível finalizar o programa.");
            System.out.println("Existem pedidos a serem atendidos.");
        }
    }
    
         public static void main(String[] args) {
        int escolher;
        int x = 0;

        do {
            escolher();
            escolher = scanner.nextInt();
            switch (escolher) {
                case 3:
                    listarPedido();
                    break;
                case 1:
                    while (escolher == 1) {
                        incluirPedido();
                        System.out.println("Gostaria de inserir outro pedido? 1 = sim, qualquer tecla = não");
                        try {
                            escolher = scanner.nextInt();
                            scanner.nextLine(); 
                        } catch (java.util.InputMismatchException e) {
                            escolher = 0; 
                            scanner.next();
                        }
                    }
                    break;
                case 4:
                    pesquisarPedido();
                    break;
                case 5:
                    encerrarPrograma();
                    if (ind == 1) {
                        x = 10;
                    }
                    break;
                case 6:
                    atenderCliente();
                    break;
            }
        } while (x != 10);
    }
}
   
