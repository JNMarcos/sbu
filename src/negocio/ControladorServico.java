/**
 * 
 */
package negocio;

import classes_basicas.ADMBiblioteca;
import classes_basicas.Aluno;
import classes_basicas.Conta;
import classes_basicas.Divida;
import classes_basicas.Professor;
import classes_basicas.Servico;
import classes_basicas.Tecnico;
import dados.IRepositorioDivida;
import dados.RepositorioDivida;
import excecao.DividaNaoEncontradaException;
import excecao.SaldoInsuficenteException;

/**
 * @author JN
 *
 */
public class ControladorServico {
	public IRepositorioDivida repositorioDivida;

	public ControladorServico() {
		this.repositorioDivida = RepositorioDivida.getInstancia();
	} 

	//opção: almoço ou jantar
	public void comprarFicaRu(Conta conta, boolean isAlmoco) throws SaldoInsuficenteException{
		if(conta.getUsuario() instanceof Aluno){
			if (isAlmoco){
				if (conta.getSaldo() >= Servico.getPrecos().get("almocoAlunoRU"))
					Servico.servirAlmocoAluno(conta);
				else
					throw new SaldoInsuficenteException();
			} else {
				if (conta.getSaldo() >= Servico.getPrecos().get("jantaAlunoRU"))
					Servico.servirJantaAluno(conta);
				else
					throw new SaldoInsuficenteException();
			}
		} else{
			if (isAlmoco){
				if (conta.getSaldo() >= Servico.getPrecos().get("almocoFuncionarioRU"))
					Servico.servirAlmocoFuncionario(conta);
				else
					throw new SaldoInsuficenteException();
			} else {
				if (conta.getSaldo() >= Servico.getPrecos().get("jantaFuncionarioRU"))
					Servico.servirJantaFuncionario(conta);
				else
					throw new SaldoInsuficenteException();
			}
		}
	}

	//array que indica ee documento foi solicitado
	//cada posição é um documento
	public void solicitarDocumento(Conta conta, boolean[] isSolicitado)throws SaldoInsuficenteException{
		if(isSolicitado[0]){
			if (conta.getSaldo() >= Servico.getPrecos().get("comprovanteMatricula"))
				Servico.solicitarComprovanteMatricula(conta);
			else
				throw new SaldoInsuficenteException();
		}
		if(isSolicitado[1]){
			if (conta.getSaldo() >= Servico.getPrecos().get("diplomaGraducao"))
				Servico.solicitarDiplomaGraduacao(conta);
			else
				throw new SaldoInsuficenteException();
		}
		if(isSolicitado[2]){
			if (conta.getSaldo() >= Servico.getPrecos().get("diplomaPosGraducao"))
				Servico.solicitarDiplomaPosGraduacao(conta);
			else
				throw new SaldoInsuficenteException();
		}
		if(isSolicitado[3]){
			if (conta.getSaldo() >= Servico.getPrecos().get("historicoCompletoGraducao"))
				Servico.solicitarHistoricoCompletoGraduacao(conta);
			else
				throw new SaldoInsuficenteException();
		}
		if(isSolicitado[4]){
			if (conta.getSaldo() >= Servico.getPrecos().get("historicoCompletoPosGraducao"))
				Servico.solicitarHistoricoCompletoPosGraduacao(conta);
			else
				throw new SaldoInsuficenteException();
		}
		if(isSolicitado[5]){
			if (conta.getSaldo() >= Servico.getPrecos().get("certificadoConclusaoCurso"))
				Servico.solicitarCertificadoConclusaoCurso(conta);
			else
				throw new SaldoInsuficenteException();
		}
		if(isSolicitado[6]){
			if (conta.getSaldo() >= Servico.getPrecos().get("transderenciaInterna"))
				Servico.solicitarTransferenciaInterna(conta);
			else
				throw new SaldoInsuficenteException();
		}
		if(isSolicitado[7]){
			if (conta.getSaldo() >= Servico.getPrecos().get("transderenciaExterna"))
				Servico.solicitarTransferenciaExterna(conta);
			else
				throw new SaldoInsuficenteException();
		}
		if(isSolicitado[8]){
			if (conta.getSaldo() >= Servico.getPrecos().get("transferenciaParaOutraInstituicao"))
				Servico.solicitarTransferenciaParaOutraInstituicao(conta);
			else
				throw new SaldoInsuficenteException();
		}
	}

	public void solicitarCarteira(Conta conta)throws SaldoInsuficenteException{
		if (conta.getUsuario() instanceof Aluno){
			if (conta.getSaldo() >= Servico.getPrecos().get("carteiraEstudante"))
				Servico.solicitarCarteiraEstudante(conta);
			else
				throw new SaldoInsuficenteException();
		} else if (conta.getUsuario() instanceof Professor){
			if (conta.getSaldo() >= Servico.getPrecos().get("carteiraProfessor"))
				Servico.solicitarCarteiraProfessor(conta);
			else
				throw new SaldoInsuficenteException();
		} else if (conta.getUsuario() instanceof Tecnico || 
				conta.getUsuario() instanceof ADMBiblioteca){ //admBiblo tb. é necessariamente
			//um funcionário da universidade
			if (conta.getSaldo() >= Servico.getPrecos().get("carteiraTecnico"))
				Servico.solicitarCarteiraTecnico(conta);
			else
				throw new SaldoInsuficenteException();
		} else {
			//criar a exceção acesso negado????? para o admgeral
		}

	}

	public void pagarDivida(Conta conta, Divida divida)throws SaldoInsuficenteException, DividaNaoEncontradaException{
		if (repositorioDivida.procurarDivida(divida)){
			if (conta.getSaldo() >= divida.getValor())
				Servico.pagarDivida(conta, divida);
			else
				throw new SaldoInsuficenteException();
		} else {
			throw new DividaNaoEncontradaException();
		}
	}
}
