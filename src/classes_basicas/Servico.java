/**
 * 
 */
package classes_basicas;

import java.time.LocalDate;
import java.time.Period;
import java.util.Hashtable;

/**
 * @author JN
 *
 */
public abstract class Servico {
	private static Hashtable<String, Double> precos;
	private final static int QUANTIDADE_DIAS_NO_ANO = 365;
	private final static int QUANTIDADE_DIAS_NO_MES = 30;
	
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
	public static void servirAlmocoAluno(Conta conta){
		conta.setSaldo(conta.getSaldo() - Servico.getPrecos().get("almocoAlunoRU"));
	}
	
	public static void servirAlmocoFuncionario(Conta conta){
		conta.setSaldo(conta.getSaldo() - Servico.getPrecos().get("almocoFuncionarioRU"));
	}
	
	public static void servirJantaAluno(Conta conta){
		conta.setSaldo(conta.getSaldo() - Servico.getPrecos().get("jantaAlunoRU"));
	}
	
	public static void servirJantaFuncionario(Conta conta){
		conta.setSaldo(conta.getSaldo() - Servico.getPrecos().get("jantaFuncionarioRU"));
	}
	
	// serviços dívida (Biblioteca)
	//provavelmente esse método será transferido para ControladorConta
	//pois não é um serviço
	public static double valorMultaBiblioteca(Conta conta){
		double valorDivida = 0.0;
		int diasTotal;
		Period p;
		for(Divida d: conta.getDividas()){
			if (d.estaPago() == false){ // se conta não foi paga
				//verifica a diferença entre as datas
				p = Period.between(d.getDataEmissao(), LocalDate.now());
				//transforma a diferença entre as datas apenas para dias 
				diasTotal = p.getYears() * QUANTIDADE_DIAS_NO_ANO
				+ p.getMonths() * QUANTIDADE_DIAS_NO_MES + p.getDays();
				d.setValor(diasTotal * Servico.getPrecos().get("multaDiáriaBiblioteca"));
				//põe o valor da dívida atualizado
				valorDivida = valorDivida + d.getValor();
			}
		}
		return valorDivida;
	}
	
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
	
	public static void solicitarDiplomaPosGraducao(Conta conta){
		conta.setSaldo(conta.getSaldo() - Servico.getPrecos().
				get("diplomaPosGraducao"));
	}
	
	public static void solicitarHistoricoCompletoGraduacao(Conta conta){
		conta.setSaldo(conta.getSaldo() - Servico.getPrecos().
				get("historicoCompletoGraducao"));	
	}
	
	public static void solicitarHistoricoCompletoPosGraducao(Conta conta){
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
