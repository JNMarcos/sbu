package dados;

/**
 * author @ramicesmoises
 * 
 * 
 */

import java.util.List;


import java.time.LocalTime; 
import java.time.LocalDate;
import classes_basicas.Conta;
import classes_basicas.Divida;

public interface IRepositorioDivida {
	
	public void getInstancia();
	public RepositorioDivida lerArquivo();
	public void gravarArquivo();
	public void cadastrarDivida(Divida divida);
	public void removerDivida(Divida divida);
	public void alterarDadosDivida(Divida divida);
	public Divida exibirDivida (Conta nome, LocalDate data, LocalTime hora);
	public List<Divida> listarDividas();
	
}
