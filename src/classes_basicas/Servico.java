/**
 * 
 */
package classes_basicas;

import java.util.Hashtable;

/**
 * @author JN
 *
 */
public abstract class Servico {
	private static Hashtable<String, Double> precos;

	// private no construtor impede que a classe seja instanciada por fora
	private Servico(){
		//faz nada
	}

	public static Hashtable<String, Double> getPrecos() {
		return precos;
	}
	
	public static void setPrecos() {
		precos = new Hashtable<String, Double>();
		precos.put("almocoAlunoRU", 2.0);
		precos.put("almocoFuncionarioRU", 12.0); //pôr valor aqui
		precos.put("jantaAlunoRU", 1.5);
		precos.put("jantaFuncionarioRU", 11.0); //pôr valor aqui
		precos.put("multaDiáriaBiblioteca", 1.5); //pôr valor correto aqui
		//procurar pelo preços dos documentos existentes e pôr aqui
		// valores por enquanto fantasia
		// nem todos os documentos foram postos
		precos.put("comprovanteMatricula", 10.0);
		precos.put("diplomaGraducao", 12.0);
		precos.put("diplomaPosGraducao", 15.0);
		precos.put("historicoCompletoGraducao", 11.0);
		precos.put("historicoCompletoPosGraducao", 11.5);
		precos.put("certificadoConclusaoCurso", 10.0);
		precos.put("transderenciaInterna", 12.0);
		precos.put("transferenciaExterna", 15.0);
		precos.put("transferenciaParaOutraInstituicao", 11.0);
		//serviços das carteiras de professor, técnico e estudante
		precos.put("carteiraProfessor", 15.0); //verificar valor
		precos.put("carteiraTecnico", 13.0);
		precos.put("carteiraEstudante", 12.0);
	}

	// serviços RU
	public static void comprarAlmocoAluno(Conta conta, int quantidadeFichas){
		conta.setSaldo(conta.getSaldo() - (Servico.getPrecos().get("almocoAlunoRU") * quantidadeFichas));
		conta.setarNPorcoes(conta.getnPorcoes()[0] + quantidadeFichas, 0);
	}

	public static void comprarAlmocoFuncionario(Conta conta, int quantidadeFichas){
		conta.setSaldo(conta.getSaldo() - (Servico.getPrecos().get("almocoFuncionarioRU") * quantidadeFichas));
		conta.setarNPorcoes(conta.getnPorcoes()[0] + quantidadeFichas, 0);
	}

	public static void comprarJantaAluno(Conta conta, int quantidadeFichas){
		conta.setSaldo(conta.getSaldo() - (Servico.getPrecos().get("jantaAlunoRU") * quantidadeFichas));
		conta.setarNPorcoes(conta.getnPorcoes()[1] + quantidadeFichas, 1);
	}

	public static void comprarJantaFuncionario(Conta conta, int quantidadeFichas){
		conta.setSaldo(conta.getSaldo() - (Servico.getPrecos().get("jantaFuncionarioRU") * quantidadeFichas));
		conta.setarNPorcoes(conta.getnPorcoes()[1] + quantidadeFichas, 1);
	}

	public static boolean simularEntradaAlmocoRU(Conta conta){
		boolean podeEntrar = false;
		int novoValor = conta.getnPorcoes()[0] - 1;
		if(conta.getnPorcoes()[0] >= 1){
			conta.setarNPorcoes(novoValor, 0);
			podeEntrar = true;
		}
		return podeEntrar;
	}

	public static boolean simularEntradaJantarRU(Conta conta){
		boolean podeEntrar = false;
		if(conta.getnPorcoes()[1] >= 1){
			conta.setarNPorcoes(conta.getnPorcoes()[1] - 1, 1);
			podeEntrar = true;
		}
		return podeEntrar;
	}

	// serviços dívida (Biblioteca)
	//provavelmente esse método será transferido para ControladorConta
	//pois não é um serviço

	public static void pagarDivida(Conta conta, Divida divida){
		conta.setSaldo(conta.getSaldo() - divida.getValor()); // desconta o valor da dívida da conta do usuário
		divida.setEstaPago(true); // põe como paga
	}

	//métodos documentação
	public static void solicitarComprovanteMatricula(Conta conta){
		conta.setSaldo(conta.getSaldo() - Servico.getPrecos().
				get("comprovanteMatricula"));
	}

	public static void solicitarDiplomaGraduacao(Conta conta){
		conta.setSaldo(conta.getSaldo() - Servico.getPrecos().
				get("diplomaGraducao"));
	}

	public static void solicitarDiplomaPosGraduacao(Conta conta){
		conta.setSaldo(conta.getSaldo() - Servico.getPrecos().
				get("diplomaPosGraducao"));
	}

	public static void solicitarHistoricoCompletoGraduacao(Conta conta){
		conta.setSaldo(conta.getSaldo() - Servico.getPrecos().
				get("historicoCompletoGraducao"));	
	}

	public static void solicitarHistoricoCompletoPosGraduacao(Conta conta){
		conta.setSaldo(conta.getSaldo() - Servico.getPrecos().
				get("historicoCompletoPosGraducao"));
	}

	public static void solicitarCertificadoConclusaoCurso(Conta conta){
		conta.setSaldo(conta.getSaldo() - Servico.getPrecos().
				get("certificadoConclusaoCurso"));
	}

	public static void solicitarTransferenciaInterna(Conta conta){
		conta.setSaldo(conta.getSaldo() - Servico.getPrecos().
				get("transferenciaInterna"));
	}

	//de uma instituição para Rural
	public static void solicitarTransferenciaExterna(Conta conta){
		conta.setSaldo(conta.getSaldo() - Servico.getPrecos().
				get("transferenciaExterna"));
	}

	//da Rural para outra instituição
	public static void solicitarTransferenciaParaOutraInstituicao(Conta conta){
		conta.setSaldo(conta.getSaldo() - Servico.getPrecos().
				get("transferenciaParaOutraInstituicao"));
	}	

	//métodos carteira
	public static void solicitarCarteiraEstudante(Conta conta){
		conta.setSaldo(conta.getSaldo() - Servico.getPrecos().
				get("carteiraEstudante"));
	}

	public static void solicitarCarteiraProfessor(Conta conta){
		conta.setSaldo(conta.getSaldo() - Servico.getPrecos().
				get("carteiraProfessor"));
	}

	public static void solicitarCarteiraTecnico(Conta conta){
		conta.setSaldo(conta.getSaldo() - Servico.getPrecos().
				get("carteiraTecnico"));
	}
}
