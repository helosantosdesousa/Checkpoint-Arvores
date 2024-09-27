package objetos;

public class Clientes {

	private int cpf;
	private String nome;
	private int whatsapp;
	private double totalGasto;
	private boolean apto;
	
	public Clientes( String nome, int cpf, int whatsapp, double totalGasto) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.whatsapp = whatsapp;
		this.totalGasto = totalGasto;
	}

	@Override
	public String toString() {
		return "Clientes [cpf=" + cpf + ", nome=" + nome + ", whatsapp=" + whatsapp + ", valorTotal=" + totalGasto
				+ ", apto=" + apto + "]";
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getWhatsapp() {
		return whatsapp; 
	}

	public void setWhatsapp(int whatsapp) {
		this.whatsapp = whatsapp;
	}

	public double getTotalGasto() {
		return totalGasto;
	}

	public void setTotalGasto(double totalGasto) {
		this.totalGasto = totalGasto;
	}

	public boolean isApto() {
		return apto;
	}

	public void setApto(boolean apto) {
		this.apto = apto;
	}
	
	
}
