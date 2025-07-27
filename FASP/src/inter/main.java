package inter;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class main {
   public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Random rm = new Random();
        System.out.println("Vamos realizar um experimento");
        System.out.println("Indique o tamanho do espaço amostral bidimensional a ser utilizado, ele deve conter um valor maior ou igual a 5 e menor ou igual a 15");
        int space = scan.nextInt();
        if (space < 5){
            space = 5;
            System.out.println("Valor abaixo do limite convertentendo para 5 ");
        } else if (space > 15){
            space = 15;
            System.out.println("Valor acima do limite convertentendo para 15 ");
        }
        String[][] plano = new String[space][space];
        for (int i = 0 ; i < space; i++){
            for(int j = 0 ; j < space ; j++){
                plano[i][j] = " ";
            }
        }
        System.out.println("Agora indique em que posição vetorial se encontra a particula em nosso espaço");
        System.out.println("Escreva sua localização em X: ");
        int vectorx = scan.nextInt() - 1;
        if (vectorx >= space){
            vectorx = space  -1;
            System.out.println("Valor de X fora do limite do espaço, convertendo para " + space );
        } else if (vectorx < 0){
            vectorx = 0;
            System.out.println("Valor de X fora do limite do espaço, convertendo para 0" );
        }
        System.out.println("Escreva sua localização em Y: ");    
        int vectory = scan.nextInt() - 1;
        if (vectory >= space){
            vectory = space  -1;
            System.out.println("Valor de Y fora do limite do espaço, convertendo para " + space );
        } else if (vectory < 0){
            vectory = 0;
            System.out.println("Valor de Y fora do limite do espaço, convertendo para 0" );
        }
        System.out.println("A localização de sua particula no plano YX:");
        // Posicionar a particula
        plano[vectory][vectorx] = "O";
        // posicionar a particula


        for (int cabeçario = 0; cabeçario < (space*3) + 2 ; cabeçario++){
            System.out.print("-");
        }
        System.out.println();
        for (int colun = 0; colun < space ; colun++){
            System.out.print("|");
            for (int arresta = 0; arresta < space; arresta++){
                System.out.print(" " + plano[colun][arresta] + " ");
            }
            System.out.println("|");
        }
        for (int fechamento = 0; fechamento < (space*3) + 2  ; fechamento++){
            System.out.print("-");
        }
        System.out.println();
        System.out.println("Indique a direção da força aplicada sobre a particula");
        int directX = 0;
        int directY = 0;
        String menu = """
                | Comando | Direção  |
                |    1    |     UP   |
                |    2    |   RIGHT  |
                |    3    |    DOWN  |
                |    4    |    LEFT  |
                |    5    | LEFT/UP  |
                |    6    | RIGHT/UP |
                |    7    |RIGHT/DOWN|
                |    8    | LEFT/DOWN|
                """;
        System.out.println(menu);
        System.out.print("COMANDO: ");
        int coman = scan.nextInt();
        System.out.println();
        switch (coman) {
            case 1:
                System.out.println("Será aplicada a Força UP");
                directX = 0;
                directY = 1;
                break;
            case 2:
                System.out.println("Será aplicada a Força RIGHT");
                directX = 1;
                directY = 0;
                break;
            case 3:
                System.out.println("Será aplicada a Força DOWN");
                directX = 0;
                directY = -1;
                break;
            case 4:
                System.out.println("Será aplicada a Força LEFT");
                directX = -1;
                directY = 0;
                break;
            case 5:
                System.out.println("Será aplicada a Força LEFT/UP");
                directX = -1;
                directY = 1;
                break;
            case 6:
                System.out.println("Será aplicada a Força RIGHT/UP");
                directX = 1;
                directY = 1;
                break;
            case 7:
                System.out.println("Será aplicada a Força RIGHT/DOWN");
                directX = 1;
                directY = -1;
                break;
            case 8:
                System.out.println("Será aplicada a Força LEFT/DOWN");
                directX = -1;
                directY = -1;
                break;
            default:
                System.out.println("Comando desconhecido será aplicada a Força UP");
                directX = 0;
                directY = 1;
                break;
        }
        System.out.println("Diga agora o numero de movimentos que será realizado pela particula antes dela parar: ");
        long moves = scan.nextLong();
        // criando particulas interativas 1:
        int P1x = vectorx;
        int mov1X = rm.nextInt(-1,2);
        int P1y = vectory;
        int mov1Y = rm.nextInt(-1,2);
        while (P1x == vectorx || P1y == vectory){
            P1x = rm.nextInt(space);
            P1y = rm.nextInt(space);
        }
        plano[P1y][P1x] = "X";
        // criando particulas interativas 2:
        int P2x = vectorx;
        int mov2X = rm.nextInt(-1,2);
        int P2y = vectory;
        int mov2Y = rm.nextInt(-1,2);
        while (P2x == vectorx || P2y == vectory || P2x == P1x || P2y == P1x){
            P2x = rm.nextInt(space);
            P2y = rm.nextInt(space);
        }
        plano[P2y][P2x] = "H";
        // marca de colisao
        int cx= 0;
        int cy= 0;
        // criando particulas interativas:
        for (int m = 0; m <= moves; m++){
             // COLISÃO NA PAREDE DA PARTICULA O
            if (directX + vectorx == space || directX + vectorx == -1){
                directX *= -1; 
            } 
            if (directY + vectory == space || directY + vectory == -1){
                directY *= -1;
            }
            // COLISÃO NA PAREDE DA PARTICULA X 
            if (mov1X + P1x == space || mov1X + P1x == -1){
                mov1X *= -1; 
            } 
            if (mov1Y + P1y == space || mov1Y + P1y == -1){
                mov1Y *= -1;
            }
             // COLISÃO NA PAREDE DA PARTICULA H 
             if (mov2X + P2x == space || mov2X + P2x == -1){
                mov2X *= -1; 
            } 
            if (mov2Y + P2y == space || mov2Y + P2y == -1){
                mov2Y *= -1;
            }
            // colisao perfeita de particulas particula O com X com H
            if (directX + vectorx == P1x + mov1X && directY + vectory == P1y + mov1Y && directX + vectorx == P2x + mov2X && directY + vectory == P2y + mov2Y ){
                // SINAL DE COLISAO
                cx = vectorx + directX;
                cy = directY + vectory;
                plano[cy][cx] = "@";
                directX = 0;
                directY = 0;
                P1x = 0;
                P1y = 0;
                P2x = 0;
                P2y = 0;
            }  else if (directX + vectorx == P1x + mov1X && directY + vectory == P1y + mov1Y){ // colisao perfeita de particulas particula O com X
                // SINAL DE COLISAO
                cx = vectorx + directX;
                cy = directY + vectory;
                plano[cy][cx] = "@";
                // BOUNCE
                if (directX == mov1X && directY != mov1Y){
                    directY *= -1;
                    mov1Y *= -1;
                    if (directY == 0){
                        directY = mov1Y * -1;
                    }
                    if ( mov1Y == 0){
                        mov1Y = directY *-1;
                    }
                    if (directY + vectory == space || directY + vectory == -1){
                        directY = 0;
                    }
                    if (mov1Y + P1y == space || mov1Y + P1y == -1){
                        mov1Y = 0;
                    }
                } else if (directY == mov1Y && directX != mov1X){
                    directX *= -1;
                    mov1X *= -1;
                    if (directX == 0){
                        directX = mov1X * -1;
                    }
                    if ( mov1X == 0){
                        mov1X = directX *-1;
                    }
                    if (directX + vectorx == space || directX + vectorx == -1){
                        directX = 0; 
                    } 
                    if (mov1X + P1x == space || mov1X + P1x == -1){
                        mov1X = 0; 
                    } 
                } else{
                    directX *= -1;
                    mov1X *= -1;
                    if (directX == 0){
                        directX = mov1X * -1;
                    }
                    if ( mov1X == 0){
                        mov1X = directX *-1;
                    }
                    if (directX + vectorx == space || directX + vectorx == -1){
                        directX = 0; 
                    } 
                    if (mov1X + P1x == space || mov1X + P1x == -1){
                        mov1X = 0; 
                    } 
                    directY *= -1;
                    mov1Y *= -1;
                    if (directY == 0){
                        directY = mov1Y * -1;
                    }
                    if ( mov1Y == 0){
                        mov1Y = directY *-1;
                    }
                    if (directY + vectory == space || directY + vectory == -1){
                        directY = 0;
                    }
                    if (mov1Y + P1y == space || mov1Y + P1y == -1){
                        mov1Y = 0;
                    }
                }
            }  else if (directX + vectorx == P2x + mov2X && directY + vectory == P2y + mov2Y){ // colisao perfeita de particulas particula O com H
                // SINAL DE COLISAO
                cx = vectorx + directX;
                cy = directY + vectory;
                plano[cy][cx] = "@";
                // BOUNCE
                if (directX == mov2X && directY != mov2Y){
                    directY *= -1;
                    mov2Y *= -1;
                    if (directY == 0){
                        directY = mov2Y * -1;
                    }
                    if ( mov2Y == 0){
                        mov2Y = directY *-1;
                    }
                    if (directY + vectory == space || directY + vectory == -1){
                        directY = 0;
                    }
                    if (mov2Y + P2y == space || mov2Y + P2y == -1){
                        mov2Y = 0;
                    }
                } else if (directY == mov2Y && directX != mov2X){
                    directX *= -1;
                    mov2X *= -1;
                    if (directX == 0){
                        directX = mov2X * -1;
                    }
                    if ( mov2X == 0){
                        mov2X = directX *-1;
                    }
                    if (directX + vectorx == space || directX + vectorx == -1){
                        directX = 0; 
                    } 
                    if (mov2X + P2x == space || mov2X + P2x == -1){
                        mov2X = 0; 
                    } 
                } else{
                    directX *= -1;
                    mov2X *= -1;
                    if (directX == 0){
                        directX = mov2X * -1;
                    }
                    if ( mov2X == 0){
                        mov2X = directX *-1;
                    }
                    if (directX + vectorx == space || directX + vectorx == -1){
                        directX = 0; 
                    } 
                    if (mov2X + P2x == space || mov2X + P2x == -1){
                        mov2X = 0; 
                    } 
                    directY *= -1;
                    mov2Y *= -1;
                    if (directY == 0){
                        directY = mov2Y * -1;
                    }
                    if ( mov2Y == 0){
                        mov2Y = directY *-1;
                    }
                    if (directY + vectory == space || directY + vectory == -1){
                        directY = 0;
                    }
                    if (mov2Y + P2y == space || mov2Y + P2y == -1){
                        mov2Y = 0;
                    }
                }
            }  else if (P1x + mov1X == P2x + mov2X && P1y + mov1Y == P2y + mov2Y){ // colisao perfeita de particulas particula X com H
                // SINAL DE COLISAO
                cx = P2x + mov2X;
                cy = P2y + mov2Y;
                plano[cy][cx] = "@";
                // BOUNCE
                if (mov1X == mov2X && mov1Y != mov2Y){
                    mov1Y *= -1;
                    mov2Y *= -1;
                    if (mov1Y == 0){
                        mov1Y = mov2Y * -1;
                    }
                    if ( mov2Y == 0){
                        mov2Y = mov1Y *-1;
                    }
                    if (mov1Y + P1y == space || mov1Y + P1y == -1){
                        mov1Y = 0;
                    }
                    if (mov2Y + P2y == space || mov2Y + P2y == -1){
                        mov2Y = 0;
                    }
                } else if (mov1Y == mov2Y && mov1X != mov2X){
                    mov1X*= -1;
                    mov2X *= -1;
                    if (mov1X == 0){
                        mov1X = mov2X * -1;
                    }
                    if ( mov2X == 0){
                        mov2X = mov1X *-1;
                    }
                    if (mov1X + P1x == space || mov1X + P1x == -1){
                        mov1X = 0; 
                    } 
                    if (mov2X + P2x == space || mov2X + P2x == -1){
                        mov2X = 0; 
                    } 
                } else{
                    mov1X *= -1;
                    mov2X *= -1;
                    if (mov1X == 0){
                        mov1X = mov2X * -1;
                    }
                    if ( mov2X == 0){
                        mov2X = mov1X *-1;
                    }
                    if (mov1X + P1x == space || mov1X + P1x == -1){
                        mov1X = 0; 
                    } 
                    if (mov2X + P2x == space || mov2X + P2x == -1){
                        mov2X = 0; 
                    } 
                    mov1Y *= -1;
                    mov2Y *= -1;
                    if (mov1Y == 0){
                        mov1Y = mov2Y * -1;
                    }
                    if ( mov2Y == 0){
                        mov2Y = mov1Y *-1;
                    }
                    if (mov1Y + P1y == space || mov1Y + P1y == -1){
                        directY = 0;
                    }
                    if (mov2Y + P2y == space || mov2Y + P2y == -1){
                        mov2Y = 0;
                    }
                }
            }  
            // Quadro
            for (int cabeçario = 0; cabeçario < (space*3) + 2 ; cabeçario++){
                System.out.print("-");
            }
            System.out.println();
            for (int colun = 0; colun < space ; colun++){
                System.out.print("|");
                for (int arresta = 0; arresta < space; arresta++){
                    System.out.print(" " + plano[colun][arresta] + " ");
                }
                System.out.println("|");
            }
            for (int fechamento = 0; fechamento < (space*3) + 2  ; fechamento++){
                System.out.print("-");
            }
            System.out.println();
            Thread.sleep(600);

            // Retirar sinal de Colisao
            plano[cy][cx] = "~";
            // Retirar a particula antiga O
            plano[vectory][vectorx] = "~";
            // Retirar a particula antiga X
            plano[P1y][P1x] = "~";
            // Retirar a particula antiga H
            plano[P2y][P2x] = "~";
             // Nova particula O
            vectorx += directX;
            vectory += directY;
            plano[vectory][vectorx] = "O";
             // Nova particula X
            P1x += mov1X;
            P1y += mov1Y;
            plano[P1y][P1x] = "X";
             // Nova particula H
             P2x += mov2X;
             P2y += mov2Y;
             plano[P2y][P2x] = "H";
        }
    }
}