/**
 * 
 */
package negocio;

import classes_basicas.Aluno;
import classes_basicas.Conta;
import classes_basicas.Divida;
import classes_basicas.Movimentacao;
import classes_basicas.Professor;
import classes_basicas.Servico;
import classes_basicas.Tecnico;
import dados.IRepositorioConta;
import dados.IRepositorioDivida;
import dados.RepositorioConta;
import dados.RepositorioDivida;
import excecao.ContaNaoEncontradaException;
import excecao.DividaNaoEncontradaException;
import excecao.FichasInsuficientesException;
import excecao.SaldoInsuficienteException;

/**
 * @author JN
 *
 */
public class ControladorServico {
	public IRepositorioDivida repositorioDivida;
	public IRepositorioConta repositorioConta;

	public ControladorServico() {
		this.repositorioDivida = RepositorioDivida.getInstancia();
		this.repositorioConta = RepositorioConta.getInstancia();
	} 

	//opção: almoço ou jantar
	public void comprarFichaRU(Conta conta, boolean isAlmoco, int quantidadeFichas) throws SaldoInsuficienteException, ContaNaoEncontradaException{
		Movimentacao movimentacao;
		if (repositorioConta.procurarConta(conta)){
			if(conta.getUsuario() instanceof Aluno){
				if (isAlmoco){
					if (conta.getSaldo() >= Servico.getPrecos().get("almocoAlunoRU")){
						Servico.comprarAlmocoAluno(conta, quantidadeFichas);
						movimentacao = new Movimentacao("Almoço RU", "Compra de " + quantidadeFichas + " ficha(s) do tipo almoço.");
						conta.getHistorico().add(movimentacao);
					} else
						throw new SaldoInsuficienteException();
				} else {
					if (conta.getSaldo() >= Servico.getPrecos().get("jantaAlunoRU")){
						Servico.comprarJantaAluno(conta, quantidadeFichas);
						movimentacao = new Movimentacao("Jantar RU", "Compra de " + quantidadeFichas + " ficha(s) do tipo jantar.");
						conta.getHistorico().add(movimentacao);
					} else
						throw new SaldoInsuficienteException();
				}
			} else{
				if (isAlmoco){
					if (conta.getSaldo() >= Servico.getPrecos().get("almocoFuncionarioRU")){
						Servico.comprarAlmocoFuncionario(conta, quantidadeFichas);
						movimentacao = new Movimentacao("Almoço RU", "Compra de " + quantidadeFichas + " ficha(s) do tipo almoço.");
						conta.getHistorico().add(movimentacao);
					} else
						throw new SaldoInsuficienteException();
				} else {
					if (conta.getSaldo() >= Servico.getPrecos().get("jantaFuncionarioRU")){
						Servico.comprarJantaFuncionario(conta, quantidadeFichas);
						movimentacao = new Movimentacao("Jantar RU", "Compra de " + quantidadeFichas + " ficha(s) do tipo jantar.");
						conta.getHistorico().add(movimentacao);
					} else
						throw new SaldoInsuficienteException();
				}
			}
		} else {
			throw new ContaNaoEncontradaException();
		}
	}

	public void simularRU(Conta conta, boolean isAlmoco) throws ContaNaoEncontradaException, FichasInsuficientesException{
		boolean podeEntrar = false;
		if (repositorioConta.procurarConta(conta)){
			if (isAlmoco){
				podeEntrar = Servico.simularEntradaAlmocoRU(conta);
				if (podeEntrar == false){
					throw new FichasInsuficientesException();
				}
			} else {
				podeEntrar = Servico.simularEntradaJantarRU(conta);
				if (podeEntrar == false){
					throw new FichasInsuficientesException();
				}
			}
		} else {
			throw new ContaNaoEncontradaException();
		}

	}

	//array que indica ee documento foi solicitado
	//cada posição é um documento
	public void solicitarDocumento(Conta conta, String isSolicitado)throws SaldoInsuficienteException, ContaNaoEncontradaException{
		Movimentacao movimentacao;
		if (repositorioConta.procurarConta(conta)){
			if(isSolicitado.equals("comprovanteMatricula")){
				if (conta.getSaldo() >= Servico.getPrecos().get("comprovanteMatricula")){
					Servico.solicitarComprovanteMatricula(conta);
					movimentacao = new Movimentacao("Solicitação de documento", "Você solciitou o documento de Comprovante de Matrícula.");
					conta.getHistorico().add(movimentacao);
				} else
					throw new SaldoInsuficienteException();
			}
			if(isSolicitado.equals("diplomaGraducao")){
				if (conta.getSaldo() >= Servico.getPrecos().get("diplomaGraducao")){
					Servico.solicitarDiplomaGraduacao(conta);
					movimentacao = new Movimentacao("Solicitação de documento", "Você solciitou o documento de Diploma de Graduação.");
					conta.getHistorico().add(movimentacao);
				} else
					throw new SaldoInsuficienteException();
			}
			if(isSolicitado.equals("diplomaPosGraducao")){
				if (conta.getSaldo() >= Servico.getPrecos().get("diplomaPosGraducao")){
					Servico.solicitarDiplomaPosGraduacao(conta);
					movimentacao = new Movimentacao("Solicitação de documento", "Você solciitou o documento de Diploma de Pós-graduação.");
					conta.getHistorico().add(movimentacao);
				} else
					throw new SaldoInsuficienteException();
			}
			if(isSolicitado.equals("historicoCompletoGraducao")){
				if (conta.getSaldo() >= Servico.getPrecos().get("historicoCompletoGraducao")){
					Servico.solicitarHistoricoCompletoGraduacao(conta);
					movimentacao = new Movimentacao("Solicitação de documento", "Você solciitou o documento de Histórico Completo da Graducação.");
					conta.getHistorico().add(movimentacao);
				} else
					throw new SaldoInsuficienteException();
			}
			if(isSolicitado.equals("historicoCompletoPosGraducao")){
				if (conta.getSaldo() >= Servico.getPrecos().get("historicoCompletoPosGraducao")){
					Servico.solicitarHistoricoCompletoPosGraduacao(conta);
					movimentacao = new Movimentacao("Solicitação de documento", "Você solciitou o documento de Histórico Completo da Pós-graduação.");
					conta.getHistorico().add(movimentacao);
				} else
					throw new SaldoInsuficienteException();
			}
			if(isSolicitado.equals("certificadoConclusaoCurso")){
				if (conta.getSaldo() >= Servico.getPrecos().get("certificadoConclusaoCurso")){
					Servico.solicitarCertificadoConclusaoCurso(conta);
					movimentacao = new Movimentacao("Solicitação de documento", "Você solciitou o documento de Certificado de Conclusão de Curso.");
					conta.getHistorico().add(movimentacao);
				} else
					throw new SaldoInsuficienteException();
			}
			if(isSolicitado.equals("transderenciaInterna")){
				if (conta.getSaldo() >= Servico.getPrecos().get("transderenciaInterna")){
					Servico.solicitarTransferenciaInterna(conta);
					movimentacao = new Movimentacao("Solicitação de documento", "Você solciitou o documento de Transferência Interna.");
					conta.getHistorico().add(movimentacao);
				} else
					throw new SaldoInsuficienteException();
			}
			if(isSolicitado.equals("transderenciaExterna")){
				if (conta.getSaldo() >= Servico.getPrecos().get("transderenciaExterna")){
					Servico.solicitarTransferenciaExterna(conta);
					movimentacao = new Movimentacao("Solicitação de documento", "Você solciitou o documento de Transferência Externa.");
					conta.getHistorico().add(movimentacao);
				} else
					throw new SaldoInsuficienteException();
			}
			if(isSolicitado.equals("transferenciaParaOutraInstituicao")){
				if (conta.getSaldo() >= Servico.getPrecos().get("transferenciaParaOutraInstituicao")){
					Servico.solicitarTransferenciaParaOutraInstituicao(conta);
					movimentacao = new Movimentacao("Solicitação de documento", "Você solciitou o documento de Transferência para outra Instituição.");
					conta.getHistorico().add(movimentacao);
				} else
					throw new SaldoInsuficienteException();
			}
		} else {
			throw new ContaNaoEncontradaException();
		}
	}
	public void solicitarCarteira(Conta conta)throws SaldoInsuficienteException, ContaNaoEncontradaException{
		Movimentacao movimentacao;
		if (repositorioConta.procurarConta(conta)){
			if (conta.getUsuario() instanceof Aluno){
				if (conta.getSaldo() >= Servico.getPrecos().get("carteiraEstudante")){
					Servico.solicitarCarteiraEstudante(conta);
					movimentacao = new Movimentacao("Solicitação da Carteira de Estudante", "Você solciitou a carteira de estudante.");
					conta.getHistorico().add(movimentacao);
				} else
					throw new SaldoInsuficienteException();
			} else if (conta.getUsuario() instanceof Professor){
				if (conta.getSaldo() >= Servico.getPrecos().get("carteiraProfessor")){
					Servico.solicitarCarteiraProfessor(conta);
					movimentacao = new Movimentacao("Solicitação da Carteira de Professor", "Você solciitou a carteira de professor.");
					conta.getHistorico().add(movimentacao);
				} else
					throw new SaldoInsuficienteException();
			} else if (conta.getUsuario() instanceof Tecnico){ //admBiblo tb. é necessariamente
				//um funcionário da universidade
				if (conta.getSaldo() >= Servico.getPrecos().get("carteiraTecnico")){
					Servico.solicitarCarteiraTecnico(conta);
					movimentacao = new Movimentacao("Solicitação da Carteira de Técnico", "Você solciitou a carteira de técnico.");
					conta.getHistorico().add(movimentacao);
				} else
					throw new SaldoInsuficienteException();
			} else {
				//criar a exceção acesso negado????? para o admgeral
			}
		} else {
			throw new ContaNaoEncontradaException();
		}
	}

	public void pagarDivida(Conta conta, Divida divida)throws SaldoInsuficienteException, DividaNaoEncontradaException, ContaNaoEncontradaException{
		Movimentacao movimentacao;
		if (repositorioConta.procurarConta(conta)){
			if (repositorioDivida.procurarDivida(divida)){
				if (conta.getSaldo() >= divida.getValor()){
					Servico.pagarDivida(conta, divida);
					movimentacao = new Movimentacao("Pagamento de dívida", "Você pagou a dívida no valor de R$ " + divida.getValor() + ".");
					conta.getHistorico().add(movimentacao);
				} else
					throw new SaldoInsuficienteException();
			} else {
				throw new DividaNaoEncontradaException();
			}
		} else {
			throw new ContaNaoEncontradaException();
		}
	}
}
