package application;

import entities.Time;
import java.util.Scanner;
public class Program {
	private static final int TAM = 3;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Time[] campeonato = new Time[TAM];
		String[] classificacao = new String[TAM];
		PreencheTime(campeonato,sc);
//		Classificacao(campeonato,classificacao);
		Campeonato(campeonato,sc,classificacao);
		AtualizaClassificacao (campeonato, classificacao);
		sc.close();
	}
	
	private static void PreencheTime(Time campeonato[],Scanner sc) {
		for(int i=0; i<TAM;i++) {
			campeonato[i] = new Time();
			System.out.print("Nome: ");
			campeonato[i].setNome(sc.nextLine());
			System.out.print("Inscrição(nº): ");
			campeonato[i].setInscricao(sc.nextInt());
			System.out.print("Pontuação(digite 0 caso não tenha): ");
			while(sc.nextInt()<0) {
				System.out.print("Número negativo! Digite novamente: ");
			}
			sc.nextLine();
			System.out.println();
			
		}
	}
	
	private static void JogosEmCasa (Time campeonato[],int inscricao, Scanner sc) {
		int aux = ProcuraTime(campeonato,inscricao);
		for(int i=0;i<TAM;i++) {
			if(campeonato[i].getInscricao()!=inscricao) {
				System.out.print("Digite 1 se o time "+campeonato[aux].getNome()+" ganhou, ou 2 se o time "+campeonato[i].getNome()+" ganhou.(Qualquer outro número digitado significará que o jogo terminou empatado) ");
				int vencedor = sc.nextInt();
				Jogo(inscricao,campeonato[i].getInscricao(),vencedor,campeonato);
				System.out.println();
			}
		}
	}
	
	private static void Campeonato(Time campeonato[],Scanner sc,String classificacao[]) {
		for(int i=0;i<TAM;i++) {
			JogosEmCasa(campeonato,campeonato[i].getInscricao(),sc);
		}
		AtualizaClassificacao (campeonato,classificacao);
	}
	
	private static void Jogo(int inscricao_1,int inscricao_2,int vencedor,Time campeonato[]) {
		int aux;
		if(vencedor==1) {
			aux = ProcuraTime(campeonato,inscricao_1);
			campeonato[aux].setPontos(campeonato[aux].getPontos()+3);
		}else if(vencedor==2) {
			aux = ProcuraTime(campeonato,inscricao_2);
			campeonato[aux].setPontos(campeonato[aux].getPontos()+3);
		}else {
			aux = ProcuraTime(campeonato,inscricao_1);
			campeonato[aux].setPontos(campeonato[aux].getPontos()+1);
			aux = ProcuraTime(campeonato,inscricao_2);
			campeonato[aux].setPontos(campeonato[aux].getPontos()+1);
		}
	}
	
	
	private static int ProcuraTime(Time campeonato[], int inscricao) {
		for(int i = 0;i<TAM;i++) {
			if(campeonato[i].getInscricao() == inscricao) {
				return i;
			}
		}
		return -1;
	}

	private static void AtualizaClassificacao (Time campeonato[], String classificacao[]) {
		for(int i = 0; i<TAM;i++) {
			for(int j = 0;j<TAM;i++) {
				if((campeonato[j].getPontos()>campeonato[i].getPontos()) && (ProcuraTime(campeonato,campeonato[j].getInscricao())==-1)) {
//					classificacao[i] = campeonato[j].getInscricao();
					campeonato[j].setPosicao(i+1);
					classificacao[i]=campeonato[j].getNome();				}
			}
		}
	}
	
	private static void MostraClassificacao(Time campeonato[],String classificacao[]) {
		System.out.println("-----Classificação-----");
		for(int i=0;i<TAM;i++) {
			int pontos=-1;
			int j = 0;
			do {
				if(campeonato[j].getNome()==classificacao[i]) {
					j++;
				}
			}while(j==-1);
			System.out.println((i+1)+"º - "+classificacao[i]+" - "+campeonato[j].getPontos());
		}
	}
}
