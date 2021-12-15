import java.sql.Date;

public class Despesa {
	
	private int idDespesa;
	private double valor;
	private String data;
	protected TipoDespesa tipoDespesa;
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		if(valor > 0)
			this.valor = valor;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		if(data.length() > 0)
		this.data = data;
	}

	public TipoDespesa getTipoDespesa() {
		return tipoDespesa;
	}
	public void setTipoDespesa(TipoDespesa tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}
	
	public int getIdDespesa() {
		return idDespesa;
	}
	public void setIdDespesa(int idDespesa) {
		this.idDespesa = idDespesa;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" ID despesa: ");
		builder.append(idDespesa);
		builder.append(" -- Valor: R$ ");
		builder.append(valor);
		builder.append(" -- Data: ");
		builder.append(data);
		//builder.append(" -- Tipo de despesa");
		builder.append(tipoDespesa);
		//builder.append(", toString()=");
		//builder.append(super.toString());
		//builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	
	

}
